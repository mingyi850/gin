package gin.util;

import com.opencsv.CSVWriter;
import com.sampullara.cli.Argument;
import com.sampullara.cli.Args;

import gin.LocalSearch;
import gin.Patch;
import gin.PatchAnalyser;
import org.apache.commons.lang3.ObjectUtils;
import org.pmw.tinylog.Logger;

import java.io.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeoutException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;

import java.lang.InterruptedException;

import org.zeroturnaround.exec.stream.slf4j.Slf4jStream;
import org.zeroturnaround.exec.ProcessExecutor;
import org.zeroturnaround.exec.ProcessResult;
import org.zeroturnaround.exec.stream.LogOutputStream;

import org.apache.maven.model.Build;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.model.io.xpp3.MavenXpp3Writer;
import org.apache.maven.model.Dependency;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

import gin.edit.Edit;
import gin.test.UnitTestResult;
import gin.test.UnitTestResultSet;
import gin.test.InternalTestRunner;
import org.apache.commons.io.FilenameUtils;
import org.pmw.tinylog.Logger;

public class Experiment {
    @Argument(alias = "d", description = "Project directory: required", required=true)
    protected File projectDir;

    @Argument(alias = "p", description = "Project name: required", required=true)
    protected String projectName;

    @Argument(alias = "h", description = "Path to maven bin directory e.g. /usr/local/")
    protected File mavenHome = new File("/usr/local/");  // default on OS X

    @Argument(alias = "v", description = "Set Gradle version")
    protected String gradleVersion;

    @Argument(alias = "evosuiteCP", description = "Path to evosuite jar, set to testgeneration/evosuite-1.0.6.jar by default")
    protected File evosuiteCP = new File("testgeneration/evosuite-1.0.6.jar");

    @Argument(alias = "classNames", description = "List of classes for which to generate tests")
    protected String[] classNames;

    @Argument(alias = "projectTarget", description = "Directory for project class files or jar file of the project; ignored if classNames parameter is set")
    protected File projectTarget;

    @Argument(alias = "outputDir", description = "Output directory for generated tests; for maven projects the pom file will be updated automatically")
    protected File outputDir;

    @Argument(alias = "removeTests", description = "Remove existing tests from outputDir, set to projectDir/src/java/test if outputDir not specified")
    protected boolean removeTests = false;

    @Argument(alias = "generateTests", description = "Generate tests for classNames or projectTarget")
    protected boolean generateTests = false;

    @Argument(alias = "test", description = "Run all tests in outputDir, set to projectDir/src/test/java if outputDir not specified")
    protected boolean test = false;

    @Argument(alias = "classNumber", description = "Number of classes to generate EvoSuite tests for, used for debugging purposes")
    protected Integer classNumber = 0;

    @Argument(alias = "seed", description = "Random seed for test case generation, set to 88 by default")
    protected String evo_seed = "88"; // random seed, need this to get deterministic results

    @Argument(alias = "maxStatements", description = "Search budget for test case generation, set to 50000 statements by default")
    protected String search_budget = "50000"; // search budget for MaxStatements stopping condition

    @Argument(alias = "criterion", description = "Criterion for test generation. Set to line by default")
    protected String criterion = "line"; // coverage goal for test generation

    @Argument(alias = "criterionList", description = "Criterion list for test generation.")
    protected String[]  criterion_list = {};

    @Argument(alias = "output_variables", description = "Output variables for test report")
    protected String output_variables = "TARGET_CLASS,criterion,Size,Length,Coverage,Fitness,Total_Time"; // coverage goal for test generation

    // Local Search Variables
    @Argument(alias = "f", description = "Required: Source filename", required=true)
    protected File filename = null;

    @Argument(alias = "m", description = "Required: Method signature including arguments." +
            "For example, \"classifyTriangle(int,int,int)\"", required=true)
    protected String methodSignature = "";

    @Argument(alias = "s", description = "Seed")
    protected Integer seed = 123;

    @Argument(alias = "n", description = "Number of steps")
    protected Integer numSteps = 100;

    @Argument(alias = "c", description = "Class name")
    protected String className;

    @Argument(alias = "cp", description = "Classpath")
    protected String classPath;

    //Exclusive parameter for patchAnalyser. Also requires Patch
    @Argument(alias = "t", description = "Test class name")
    protected String testClassName;

    @Argument(alias = "oracle", description = "Oracle test class name. Test Class used to compare patch")
    protected String oracleTestClassName;

    @Argument(alias = "iter", description = "Number of iterations of experiment")
    protected Integer iterations = 1;

    protected int totalIterations = 1;

    protected String patchText = "|";

    @Argument(alias = "of", description = "Output File")
    protected File outputFile;

    //Utility Variables
    protected String[] EXPERIMENT_HEADER = {"Index", "target class",
            "criterion", "test_size",
            "test_length", "coverage", "fitness",
            "total_testgen_time", "evo_seed",
            "gin_seed", "patch_text",
            "valid_patch", "all_tests_passed",
            "execution_time", "speedup(%)"
    };





    //we want to first take in all CLI arguments into a single call for all 3 programs.
    // we then want to format strings to be passed into TestGeneration, LocalSearch and PatchAnalyser as though they were command lines trings
    // With this, we can create wrappers around each argument to return some value to be passed forward in the pipeline.
    //Finally, append the combined results of each run of the experiment into a CSV file. This ensures line integrity.

    Experiment(String[] args) {
        Args.parseOrExit(this, args);
        if (this.criterion_list.length == 0) {
            System.out.println("no criterion list");
            this.criterion_list = new String[]{criterion};

        }
        for (int x =0;x<criterion_list.length;x++) {
            System.out.println("Criterion list: " + criterion_list[x]);
        }
        this.totalIterations = iterations * this.criterion_list.length;

        if (outputFile == null) {
            String datestring = new SimpleDateFormat("dd-MM-yy-hhmm").format(new Date());
            outputFile = new File(String.format("experiment-results/experiment_results_%s_%d_iter_%s.csv", this.projectName, iterations, datestring));
        }




    }

    private void generateEvosuiteTests(String currentCriterion, int currentSeed) {
        String cSeed = Integer.toString(currentSeed);

        TestCaseGenerator testCaseGen = new TestCaseGenerator(this.projectDir, this.projectName, this.mavenHome, gradleVersion,
                this.evosuiteCP, this.classNames, this.projectTarget, this.outputDir,
                this.removeTests,  this.generateTests, this.test, this.classNumber,
                cSeed, this.search_budget, currentCriterion, this.output_variables);
    }

    private String getLocalSearchPatch(Integer currentSeed, Boolean oracleTest) {
        System.out.println(this.className);
        LocalSearch simpleLocalSearch;
        if (oracleTest == false) {
            simpleLocalSearch = new LocalSearch(filename, methodSignature, currentSeed, numSteps, projectDir, className, classPath, testClassName);
        }
        else {
            simpleLocalSearch = new LocalSearch(filename, methodSignature, currentSeed, numSteps, projectDir, className, classPath, oracleTestClassName);
        }
        String patchText = simpleLocalSearch.getPatchFromSearch();


        return patchText;
    }

    private List<String> getBestLocalSearchPatch(Integer currentSeed, Integer iterations, Boolean oracleTest) {

        List<HashMap<String,String>> patchResults = new ArrayList<HashMap<String,String>>();
        HashMap<String, String> patchAnalysisResult;
        for (int iter=0;iter<iterations;iter++) {
            this.patchText = getLocalSearchPatch(currentSeed + iter, false);

             patchAnalysisResult = getPatchAnalysis();
             patchResults.add(patchAnalysisResult);



        }

        int bestSpeedupIndex = 0;
        Float bestSpeedupTime = 0.0f;
        Float speeduptime;
        Boolean validity;
        Boolean success;
        for (int x = 0; x < iterations; x++) {
            speeduptime = Float.parseFloat(patchResults.get(x).get("speedup"));
            validity = Boolean.parseBoolean(patchResults.get(x).get("validpatch"));
            success = Boolean.parseBoolean(patchResults.get(x).get("success"));
            if (speeduptime > bestSpeedupTime && validity && success) {
                bestSpeedupTime = speeduptime;
                bestSpeedupIndex = x;
            }
        }
        HashMap<String, String> bestPatch = patchResults.get(bestSpeedupIndex);
        return parsePatchResult(bestPatch);

    }

    private List<String> parsePatchResult(HashMap<String, String> bestPatch) {
        List<String> finalResults = new ArrayList<String>();
        finalResults.add(bestPatch.get("patch"));
        finalResults.add(bestPatch.get("validpatch"));
        finalResults.add(bestPatch.get("success"));
        finalResults.add(bestPatch.get("avgtime"));
        finalResults.add(bestPatch.get("speedup"));
        return finalResults;

    }



    public HashMap<String, String> getPatchAnalysis() {
        String patchTrim = patchText.trim();
        System.out.println("PatchTrim: " + patchTrim);
        System.out.println("PatchTrimLength: " + patchTrim.length());
        if (patchTrim.length() > 1) {
            System.out.println("Patch trim is legit");
            PatchAnalyser analyser = new PatchAnalyser(filename, patchText, projectDir, className, classPath, oracleTestClassName);
            return analyser.getAnalysisResults();
        }
        else {
            System.out.println("Returning empty patch analysis");
            HashMap<String, String> nullPatchList = new HashMap<String, String>();
            nullPatchList.put("patch", patchText);
            nullPatchList.put("validpatch", Boolean.toString(false));
            nullPatchList.put("success", Boolean.toString(true));
            nullPatchList.put("avgtime", Long.toString(0));
            nullPatchList.put("speedup", Float.toString(0));
            return nullPatchList;
        }

    }

    public static List<String> readLastLine(File filename) {

        String last, line;
        last = "";
        BufferedReader input = null;
        try {
            input = new BufferedReader(new FileReader(filename));
            while ((line = input.readLine()) != null) {
                last = line;
            }
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("Unable to get line, terminating program for file safety");
            System.exit(1);
        }
        finally {
            try {
                if (input != null) {
                    input.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }

        }

        String[] output = last.split(",");
        ArrayList<String> outputList = new ArrayList<String>();
        for (int i=0; i<output.length; i++) {
            outputList.add(output[i]);
        }
        return outputList;
    }

    protected void writeExperimentHeader() { //stolen code from Sampler Class

        String parentDirName = outputFile.getParent();
        System.out.println("Parent dir: " + parentDirName);
        if (parentDirName == null) {
            parentDirName = "."; // assume outputFile is in the current directory
        }
        File parentDir = new File(parentDirName);
        if (!parentDir.exists()) {
            parentDir.mkdirs();
        }

        try {
            CSVWriter writer = new CSVWriter(new FileWriter(outputFile));
            writer.writeNext(EXPERIMENT_HEADER);
            writer.close();
        } catch (IOException e) {
            Logger.error(e, "Exception writing header to the output file: " + outputFile.getAbsolutePath());
            Logger.trace(e);
            System.exit(-1);
        }
    }

    private void writeResult(List<String> entries) { //also taken from Sampler class and simplified to take in an array instead
        int resultLength = entries.size();
        String[] entry = new String[resultLength];
        for (int x=0; x<resultLength; x++) {
            entry[x] = entries.get(x);
        }

        try {

            CSVWriter writer = new CSVWriter(new FileWriter(outputFile, true));
            writer.writeNext(entry);
            writer.close();

        } catch (IOException e) {

            Logger.error(e, "Exception writing to the output file: " + outputFile.getAbsolutePath());
            Logger.trace(e);
            System.exit(-1);

        }
    }

    public List<String> generateManualTestStatistics() {
        List<String> testStatistics = new ArrayList<String>();
        testStatistics.add(this.classNames[0]);
        testStatistics.add("MANUAL");
        testStatistics.add("");
        testStatistics.add("");
        testStatistics.add("");
        testStatistics.add("");
        testStatistics.add("0");
        return testStatistics;
    }

    public static void main(String[] args) {

        Random seedGen = new Random();
        Experiment this_experiment = new Experiment(args);
        System.out.println("Total iterations: " +this_experiment.totalIterations);
        this_experiment.writeExperimentHeader();
        int currentEvoSeed=88;
        int currentGinSeed=12;
        String currentCriterion;
        int currentIteration=0;
        for (int iteration=0; iteration < this_experiment.totalIterations; iteration++) {
            currentEvoSeed = seedGen.nextInt(100);
            seedGen.setSeed(currentEvoSeed);
            currentGinSeed = seedGen.nextInt(100);

            currentCriterion = this_experiment.criterion_list[Math.floorDiv(iteration, this_experiment.iterations)];
            System.out.println("current Iteration is " + iteration);
            System.out.println("current Criterion is " + currentCriterion);

            this_experiment.generateEvosuiteTests(currentCriterion, currentEvoSeed);
            File testStatisticsFile = new File("evosuite-report/statistics.csv");
            List<String> testStatistics = readLastLine(testStatisticsFile);

            List<String> patchAnalysisResults = this_experiment.getBestLocalSearchPatch(currentGinSeed, 3, false);


            ArrayList<String> dataEntry = new ArrayList<String>();
            dataEntry.add(Integer.toString(iteration + 1));
            for (int t=0;t<testStatistics.size();t++) {
                dataEntry.add(testStatistics.get(t));
            }
            dataEntry.add(Integer.toString(currentEvoSeed));
            dataEntry.add(Integer.toString(currentGinSeed));
            for (int p=0;p<patchAnalysisResults.size();p++) {
                dataEntry.add(patchAnalysisResults.get(p));
            }
            this_experiment.writeResult(dataEntry);
            currentIteration++; //global counter for iterations

        }
        //Additional Patch using manually written Test (oracle)
        List<String> manualTestStatistics = this_experiment.generateManualTestStatistics();

        this_experiment.patchText = this_experiment.getLocalSearchPatch(currentGinSeed, true);
        System.out.println(this_experiment.patchText);

        List<String> patchAnalysisResults = this_experiment.getBestLocalSearchPatch(currentGinSeed, 3, true);

        ArrayList<String> dataEntry = new ArrayList<String>();
        dataEntry.add(Integer.toString(currentIteration + 1));
        for (int t=0;t<manualTestStatistics.size();t++) {
            dataEntry.add(manualTestStatistics.get(t));
        }
        dataEntry.add(Integer.toString(0));
        dataEntry.add(Integer.toString(currentGinSeed));
        for (int p=0;p<patchAnalysisResults.size();p++) {
            dataEntry.add(patchAnalysisResults.get(p));
        }
        this_experiment.writeResult(dataEntry);




    }



}


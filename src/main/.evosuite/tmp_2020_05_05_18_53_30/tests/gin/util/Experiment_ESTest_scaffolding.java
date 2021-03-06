/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Tue May 05 10:55:49 GMT 2020
 */

package gin.util;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.evosuite.runtime.sandbox.Sandbox;
import org.evosuite.runtime.sandbox.Sandbox.SandboxMode;

@EvoSuiteClassExclude
public class Experiment_ESTest_scaffolding {

  @org.junit.Rule 
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) java.lang.System.getProperties().clone(); 

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "gin.util.Experiment"; 
    org.evosuite.runtime.GuiSupport.initialize(); 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfThreads = 100; 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfIterationsPerLoop = 10000; 
    org.evosuite.runtime.RuntimeSettings.mockSystemIn = true; 
    org.evosuite.runtime.RuntimeSettings.sandboxMode = org.evosuite.runtime.sandbox.Sandbox.SandboxMode.RECOMMENDED; 
    org.evosuite.runtime.sandbox.Sandbox.initializeSecurityManagerForSUT(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.init();
    setSystemProperties();
    initializeClasses();
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
  } 

  @AfterClass 
  public static void clearEvoSuiteFramework(){ 
    Sandbox.resetDefaultSecurityManager(); 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
  } 

  @Before 
  public void initTestCase(){ 
    threadStopper.storeCurrentThreads();
    threadStopper.startRecordingTime();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().initHandler(); 
    org.evosuite.runtime.sandbox.Sandbox.goingToExecuteSUTCode(); 
    setSystemProperties(); 
    org.evosuite.runtime.GuiSupport.setHeadless(); 
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
    org.evosuite.runtime.agent.InstrumentingAgent.activate(); 
  } 

  @After 
  public void doneWithTestCase(){ 
    threadStopper.killAndJoinClientThreads();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().safeExecuteAddedHooks(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.reset(); 
    resetClasses(); 
    org.evosuite.runtime.sandbox.Sandbox.doneWithExecutingSUTCode(); 
    org.evosuite.runtime.agent.InstrumentingAgent.deactivate(); 
    org.evosuite.runtime.GuiSupport.restoreHeadlessMode(); 
  } 

  public static void setSystemProperties() {
 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
    java.lang.System.setProperty("file.encoding", "Cp1252"); 
    java.lang.System.setProperty("java.awt.headless", "true"); 
    java.lang.System.setProperty("java.io.tmpdir", "C:\\Users\\Admin\\AppData\\Local\\Temp\\"); 
    java.lang.System.setProperty("user.country", "SG"); 
    java.lang.System.setProperty("user.dir", "C:\\Users\\Admin\\Documents\\Computer Science\\Y3\\Final Year Project\\gin-fork\\src\\main"); 
    java.lang.System.setProperty("user.home", "C:\\Users\\Admin"); 
    java.lang.System.setProperty("user.language", "en"); 
    java.lang.System.setProperty("user.name", "Admin"); 
    java.lang.System.setProperty("user.timezone", ""); 
  }

  private static void initializeClasses() {
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(Experiment_ESTest_scaffolding.class.getClassLoader() ,
      "org.pmw.tinylog.labelers.Labeler",
      "org.pmw.tinylog.LoggingContext$1",
      "gin.util.Experiment",
      "org.pmw.tinylog.Tokenizer$LevelToken",
      "gin.test.TestSampler",
      "org.pmw.tinylog.Logger$1",
      "org.pmw.tinylog.Tokenizer$ContextToken",
      "org.pmw.tinylog.Tokenizer$PreciseDateToken",
      "org.pmw.tinylog.labelers.ProcessIdLabeler",
      "org.pmw.tinylog.labelers.TimestampLabeler$LegacyTimestampFormatter",
      "org.pmw.tinylog.PreciseLogEntry",
      "org.pmw.tinylog.runtime.LegacyJavaRuntime",
      "gin.util.TestCaseGenerator",
      "org.pmw.tinylog.Tokenizer$LegacyDateToken",
      "com.sampullara.cli.Argument$DummyCallable",
      "org.pmw.tinylog.writers.Writer",
      "org.pmw.tinylog.policies.Policy",
      "org.pmw.tinylog.Tokenizer$MessageToken",
      "org.pmw.tinylog.labelers.LogFileComparator",
      "com.sampullara.cli.Argument",
      "gin.util.FailedToExecuteTestException",
      "org.pmw.tinylog.Tokenizer$ThreadNameToken",
      "gin.util.TestCaseGenerator$1",
      "org.codehaus.plexus.util.xml.pull.XmlPullParserException",
      "org.pmw.tinylog.Tokenizer$MethodToken",
      "org.pmw.tinylog.LoggingContext",
      "com.sampullara.cli.Args$ValueCreator",
      "org.pmw.tinylog.Tokenizer$LineToken",
      "org.unix4j.option.OptionSet",
      "org.pmw.tinylog.StackTraceInformation",
      "org.pmw.tinylog.writers.Property",
      "org.pmw.tinylog.writers.PropertiesSupport",
      "org.pmw.tinylog.Configuration",
      "org.pmw.tinylog.InternalLogger",
      "gin.util.Project$BuildType",
      "org.pmw.tinylog.labelers.TimestampLabeler$PreciseTimestampFormatter",
      "org.pmw.tinylog.MessageFormatter",
      "org.pmw.tinylog.WritingThread",
      "com.sampullara.cli.Help",
      "org.pmw.tinylog.PropertiesLoader",
      "org.pmw.tinylog.LogEntry",
      "org.pmw.tinylog.Logger",
      "org.unix4j.unix.grep.GrepOptions",
      "org.pmw.tinylog.Tokenizer$ClassNameToken",
      "org.gradle.tooling.TestExecutionException",
      "org.pmw.tinylog.Token",
      "org.pmw.tinylog.Tokenizer$PackageToken",
      "org.gradle.tooling.GradleConnectionException",
      "org.pmw.tinylog.ClassLoaderResolver",
      "org.pmw.tinylog.Supplier",
      "org.zeroturnaround.exec.stream.slf4j.Slf4jOutputStream",
      "org.pmw.tinylog.Configurator",
      "org.pmw.tinylog.Tokenizer$PlainTextToken",
      "org.pmw.tinylog.Tokenizer$FileToken",
      "org.pmw.tinylog.Tokenizer",
      "org.pmw.tinylog.runtime.RuntimeDialect",
      "org.pmw.tinylog.labelers.TimestampLabeler",
      "org.pmw.tinylog.writers.ConsoleWriter",
      "com.sampullara.cli.Args",
      "org.pmw.tinylog.writers.LogEntryValue",
      "org.pmw.tinylog.WriterDefinition",
      "org.pmw.tinylog.LegacyLogEntry",
      "org.pmw.tinylog.UndatedLogEntry",
      "gin.test.UnitTest",
      "org.pmw.tinylog.Tokenizer$ThreadIdToken",
      "org.pmw.tinylog.EnvironmentHelper",
      "org.pmw.tinylog.labelers.PropertiesSupport",
      "org.pmw.tinylog.labelers.LogFileFilter",
      "org.gradle.tooling.BuildException",
      "org.pmw.tinylog.Level",
      "org.zeroturnaround.exec.stream.LogOutputStream",
      "org.pmw.tinylog.labelers.TimestampLabeler$TimestampFormatter",
      "org.pmw.tinylog.labelers.CountLabeler",
      "gin.util.Project",
      "com.sampullara.cli.Args$2",
      "org.pmw.tinylog.Tokenizer$ClassToken",
      "com.sampullara.cli.Args$3"
    );
  } 

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(Experiment_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "gin.util.Experiment",
      "com.sampullara.cli.Args$2",
      "com.sampullara.cli.Args$3",
      "com.sampullara.cli.Args",
      "org.pmw.tinylog.runtime.LegacyJavaRuntime",
      "org.pmw.tinylog.EnvironmentHelper",
      "org.pmw.tinylog.Configurator",
      "org.pmw.tinylog.MessageFormatter",
      "org.pmw.tinylog.InternalLogger",
      "org.pmw.tinylog.Level",
      "org.pmw.tinylog.WriterDefinition",
      "org.pmw.tinylog.writers.ConsoleWriter",
      "org.pmw.tinylog.Configuration",
      "org.pmw.tinylog.Tokenizer",
      "org.pmw.tinylog.writers.LogEntryValue",
      "org.pmw.tinylog.Tokenizer$LegacyDateToken",
      "org.pmw.tinylog.Tokenizer$PlainTextToken",
      "org.pmw.tinylog.Tokenizer$ThreadNameToken",
      "org.pmw.tinylog.Tokenizer$ClassToken",
      "org.pmw.tinylog.Tokenizer$MethodToken",
      "org.pmw.tinylog.Tokenizer$LevelToken",
      "org.pmw.tinylog.Tokenizer$MessageToken",
      "org.pmw.tinylog.StackTraceInformation",
      "org.pmw.tinylog.ClassLoaderResolver",
      "org.pmw.tinylog.PropertiesLoader",
      "org.pmw.tinylog.Logger",
      "org.pmw.tinylog.Logger$1",
      "org.pmw.tinylog.LoggingContext$1",
      "org.pmw.tinylog.LoggingContext",
      "com.sampullara.cli.Argument$DummyCallable",
      "org.pmw.tinylog.labelers.TimestampLabeler",
      "gin.util.TestCaseGenerator",
      "org.pmw.tinylog.labelers.ProcessIdLabeler",
      "org.pmw.tinylog.labelers.CountLabeler",
      "org.pmw.tinylog.labelers.LogFileComparator",
      "gin.test.TestSampler",
      "org.pmw.tinylog.labelers.LogFileFilter",
      "org.pmw.tinylog.labelers.TimestampLabeler$LegacyTimestampFormatter",
      "gin.util.Project",
      "org.pmw.tinylog.LogEntry",
      "org.pmw.tinylog.LegacyLogEntry"
    );
  }
}

import os
import shutil

sep = os.path.sep
#Create experiments file
try:
    os.mkdir("experiments")
except FileExistsError:
    shutil.rmtree("experiments")
    os.mkdir("experiments")


mavenhome = "{MAVEN HOME HERE}"
projectdir = sep.join(["..","examples","locoGP"])
projectname = "locogp"
evosuitecp = sep.join(["..","testgeneration","evosuite-1.0.6.jar"])
classnamesBASE = "locogp."
criterion="branch"
filepathBASE = projectdir + sep + sep.join(["src", "main", "java", "locogp"]) +sep
methodsignature = "\"sort(Integer[], Integer)\""
classpath= projectdir + sep + sep.join(["target", "classes"])
testclasspath= projectdir + sep + sep.join(["target", "test-classes"])
evosuitetestBASE = "locogp."
oracletestBASE = "locogp."
criterionlist="branch,line,weakmutation,cbranch"
iterations = "2"
evotestsourceBASE = projectdir + sep + sep.join(["src", "test", "java", "locogp"]) + sep
edittype = "STATEMENT"

ginpath = sep.join(["..", "build", "gin.jar"])

#sourcpath is path of source files relative to experiment directory
sourcepath = sep.join(["examples", "locoGP", "src", "main", "java", "locogp"])
javafiles = [f for f in os.listdir(sourcepath) if f[-5:]==".java"]
print(javafiles)

for javafile in javafiles:
    classname = javafile[:-5]
    classnames = classnamesBASE + classname
    oracletest = oracletestBASE + classname + "Test"
    evosuitetest = evosuitetestBASE + classname + "_ESTest"
    evotestsource = evotestsourceBASE + classname + classname + "_ESTest.java"
    filepath = filepathBASE + javafile

    expCommand = " ".join(["java", "-cp", ginpath + os.pathsep + evosuitecp, "gin.util.Experiment", \
                            "-d", projectdir, "-p" , projectname, "-mavenHome", mavenhome, "-evosuiteCP", evosuitecp, \
                            "-classNames", classnames, "-generateTests", "-criterion", criterion, "-f", filepath, \
                           "-m", methodsignature, "-cp", classpath + os.pathsep + testclasspath, "-t", evosuitetest, \
                           "-evoTestSource", evotestsource, "-oracle", oracletest, "-criterionList", criterionlist, \
                           "-iter", iterations, "-et", edittype])
    print(expCommand)
    scriptName = classname + "Exp.sh"

    with open("experiments" + sep + scriptName, "w+") as f:
        f.write("#!/bin/bash\n")
        f.write("# " + scriptName + "\n\n")
        f.write(expCommand + "\n")








TITLE "Experiment"

ECHO Starting experiment... Loading Variables

SET directory=examples/locoGP/
SET projectname=locogp
SET mavenhome=C:/apache-maven-3.6.2
SET evosuitecp=testgeneration/evosuite-1.0.6.jar
SET classnames=locogp.SortBubble
SET criterion=branch
SET filepath=examples/locoGP/src/main/java/locogp/SortBubble.java
SET methodsignature="sort(Integer[], Integer)"
SET classpath=examples/locoGP/target/classes/
SET testclasspath=examples/locoGP/target/test-classes
SET evosuitetest=locogp.SortBubble_ESTest
SET oracletest=locogp.SortBubbleTest
SET criterionlist=weakmutation,branch,line,cbranch
SET iterations=2
SET evoTestSource=examples/locoGP/src/test/java/locogp/SortBubble_ESTest.java
SET editType="STATEMENT"


java -cp build/gin.jar;testgeneration/evosuite-1.0.6.jar gin.util.Experiment -d %directory% -p %projectname% -mavenHome %mavenhome% -evosuiteCP %evosuitecp% -classNames %classnames% -generateTests -criterion %criterion% -f %filepath% -m %methodsignature% -cp %classpath%;%testclasspath% -t %evosuitetest% -evoTestSource %evoTestSource% -oracle %oracletest% -criterionList %criterionlist% -iter %iterations% -et %editType%

ECHO Experiment Complete


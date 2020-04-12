TITLE: SortSelection2Exp.bat
#!/bin/bash
# SortSelection2Exp.bat

java -cp ..\build\gin.jar;..\testgeneration\evosuite-1.0.6.jar gin.util.Experiment -d ..\examples\locoGP -p locogp -mavenHome {MAVEN HOME HERE} -evosuiteCP ..\testgeneration\evosuite-1.0.6.jar -classNames locogp.SortSelection2 -generateTests -criterion branch -f ..\examples\locoGP\src\main\java\locogp\SortSelection2.java -m "sort(Integer[], Integer)" -cp ..\examples\locoGP\target\classes;..\examples\locoGP\target\test-classes -t locogp.SortSelection2_ESTest -evoTestSource ..\examples\locoGP\src\test\java\locogp\SortSelection2_ESTest.java -oracle locogp.SortSelection2Test -criterionList branch,line,weakmutation,cbranch -iter 2 -et STATEMENT

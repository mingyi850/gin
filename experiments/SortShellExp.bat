TITLE: SortShellExp.bat
#!/bin/bash
# SortShellExp.bat

java -cp ..\build\gin.jar;..\testgeneration\evosuite-1.0.6.jar gin.util.Experiment -d ..\examples\locoGP -p locogp -mavenHome C:/apache-maven-3.6.2 -evosuiteCP ..\testgeneration\evosuite-1.0.6.jar -classNames locogp.SortShell -generateTests -criterion branch -f ..\examples\locoGP\src\main\java\locogp\SortShell.java -m "sort(Integer[], Integer)" -cp ..\examples\locoGP\target\classes;..\examples\locoGP\target\test-classes -t locogp.SortShell_ESTest -evoTestSource ..\examples\locoGP\src\test\java\locogp\SortShell_ESTest.java -oracle locogp.SortShellTest -criterionList branch,line,weakmutation,cbranch -iter 2 -et STATEMENT

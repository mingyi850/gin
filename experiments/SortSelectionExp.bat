TITLE: SortSelectionExp.bat
#!/bin/bash
# SortSelectionExp.bat

java -cp ..\build\gin.jar;..\testgeneration\evosuite-1.0.6.jar gin.util.Experiment -d ..\examples\locoGP -p locogp -mavenHome C:/apache-maven-3.6.2 -evosuiteCP ..\testgeneration\evosuite-1.0.6.jar -classNames locogp.SortSelection -generateTests -criterion branch -f ..\examples\locoGP\src\main\java\locogp\SortSelection.java -m "sort(Integer[], Integer)" -cp ..\examples\locoGP\target\classes;..\examples\locoGP\target\test-classes -t locogp.SortSelection_ESTest -evoTestSource ..\examples\locoGP\src\test\java\locogp\SortSelection_ESTest.java -oracle locogp.SortSelectionTest -criterionList branch,line,weakmutation,cbranch -iter 2 -et STATEMENT

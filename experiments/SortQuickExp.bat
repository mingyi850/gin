TITLE: SortQuickExp.bat
#!/bin/bash
# SortQuickExp.bat

java -cp ..\build\gin.jar;..\testgeneration\evosuite-1.0.6.jar gin.util.Experiment -d ..\examples\locoGP -p locogp -mavenHome {MAVEN HOME HERE} -evosuiteCP ..\testgeneration\evosuite-1.0.6.jar -classNames locogp.SortQuick -generateTests -criterion branch -f ..\examples\locoGP\src\main\java\locogp\SortQuick.java -m "sort(Integer[], Integer)" -cp ..\examples\locoGP\target\classes;..\examples\locoGP\target\test-classes -t locogp.SortQuick_ESTest -evoTestSource ..\examples\locoGP\src\test\java\locogp\SortQuick_ESTest.java -oracle locogp.SortQuickTest -criterionList branch,line,weakmutation,cbranch -iter 2 -et STATEMENT

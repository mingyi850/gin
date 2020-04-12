TITLE: SortMergeExp.bat
#!/bin/bash
# SortMergeExp.bat

java -cp ..\build\gin.jar;..\testgeneration\evosuite-1.0.6.jar gin.util.Experiment -d ..\examples\locoGP -p locogp -mavenHome {MAVEN HOME HERE} -evosuiteCP ..\testgeneration\evosuite-1.0.6.jar -classNames locogp.SortMerge -generateTests -criterion branch -f ..\examples\locoGP\src\main\java\locogp\SortMerge.java -m "sort(Integer[], Integer)" -cp ..\examples\locoGP\target\classes;..\examples\locoGP\target\test-classes -t locogp.SortMerge_ESTest -evoTestSource ..\examples\locoGP\src\test\java\locogp\SortMerge_ESTest.java -oracle locogp.SortMergeTest -criterionList branch,line,weakmutation,cbranch -iter 2 -et STATEMENT

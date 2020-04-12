TITLE: SortInsertionExp.bat
#!/bin/bash
# SortInsertionExp.bat

java -cp ..\build\gin.jar;..\testgeneration\evosuite-1.0.6.jar gin.util.Experiment -d ..\examples\locoGP -p locogp -mavenHome {MAVEN HOME HERE} -evosuiteCP ..\testgeneration\evosuite-1.0.6.jar -classNames locogp.SortInsertion -generateTests -criterion branch -f ..\examples\locoGP\src\main\java\locogp\SortInsertion.java -m "sort(Integer[], Integer)" -cp ..\examples\locoGP\target\classes;..\examples\locoGP\target\test-classes -t locogp.SortInsertion_ESTest -evoTestSource ..\examples\locoGP\src\test\java\locogp\SortInsertion_ESTest.java -oracle locogp.SortInsertionTest -criterionList branch,line,weakmutation,cbranch -iter 2 -et STATEMENT

TITLE: SortHeapExp.bat
#!/bin/bash
# SortHeapExp.bat

java -cp ..\build\gin.jar;..\testgeneration\evosuite-1.0.6.jar gin.util.Experiment -d ..\examples\locoGP -p locogp -mavenHome C:/apache-maven-3.6.2 -evosuiteCP ..\testgeneration\evosuite-1.0.6.jar -classNames locogp.SortHeap -generateTests -criterion branch -f ..\examples\locoGP\src\main\java\locogp\SortHeap.java -m "sort(Integer[], Integer)" -cp ..\examples\locoGP\target\classes;..\examples\locoGP\target\test-classes -t locogp.SortHeap_ESTest -evoTestSource ..\examples\locoGP\src\test\java\locogp\SortHeap_ESTest.java -oracle locogp.SortHeapTest -criterionList branch,line -iter 1 -et STATEMENT

TITLE: SortBubbleExp.bat
#!/bin/bash
# SortBubbleExp.bat

java -cp ..\build\gin.jar;..\testgeneration\evosuite-1.0.6.jar gin.util.Experiment -d ..\examples\locoGP -p locogp -mavenHome {MAVEN HOME HERE} -evosuiteCP ..\testgeneration\evosuite-1.0.6.jar -classNames locogp.SortBubble -generateTests -criterion branch -f ..\examples\locoGP\src\main\java\locogp\SortBubble.java -m "sort(Integer[], Integer)" -cp ..\examples\locoGP\target\classes;..\examples\locoGP\target\test-classes -t locogp.SortBubble_ESTest -evoTestSource ..\examples\locoGP\src\test\java\locogp\SortBubble_ESTest.java -oracle locogp.SortBubbleTest -criterionList branch,line,weakmutation,cbranch -iter 2 -et STATEMENT

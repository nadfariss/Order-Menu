@ECHO OFF
ECHO Running the program.....

java -jar result\evive.jar

ECHO Done
ECHO Running test now .....

ECHO %time%
timeout 5 > NUL
ECHO maven need to be installed and configured

ECHO %time%
 
ECHO Running the test now...

mvn test



set ProjectPath=%~dp0
cd %ProjectPath%
echo %ProjectPath%
set p=%PATH%
java -javaagent:"%ProjectPath%libAllure\aspectjweaver-1.9.8.jar" -classpath "%ProjectPath%bin;%ProjectPath%libAllure\*;%ProjectPath%libAllure\*;%ProjectPath%libExtentVersion5\*;%ProjectPath%libLog4J\*;%ProjectPath%libSelenium\*;%ProjectPath%libReportNG\*;%ProjectPath%libWebDriverManager5\*" org.testng.TestNG "%ProjectPath%bin\runLiveGuruTest.xml"
pause
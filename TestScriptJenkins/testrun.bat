set projectpath=C:\AutomationTesting\TestScriptJenkins
cd %projectpath%
set classpath=%projectpath%\bin;%projectpath%\libs\*
java org.testng.TestNG %projectpath%\testng.xml
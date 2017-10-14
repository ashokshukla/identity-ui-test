- PRE-REQUISITES - At the moment input file is hard-coded and it's referring directory = "C:\\Temp\\Input".
 
- Go to project directory
 
- To clean and compile the build
mvn clean install
 
- To run test suite
- Open a command window and run
mvn test
- This runs TestNG XML file "RunIDTestSuit.xml" which will read Cucumber features " CucumberHooks" file to kick off test. 
- Preety Cucumber-Html Report will be generated at /target/cucumber-report/cucumber-html-reports/feature-overview.html

selenium-cucumber-java For Angular Application :
This POC named AngularTest is a Maven project that demonstrate how to use the tool and develop automation script with POM(Page Object Model) structure using the Cucumber BDD framework with Java as programming language for Angular application using NDWebDriver of Selenium. It generate Cucumber HTML, xml and JSON reports and Extent Report (json , html (Spark Report) , pdf) as well. It also includes log infos on every step and attach screen shots for failed test cases as well. Utilities added For comparison of DB values with Json data  and Db values with excel data.


Installation (pre-requisites)
JDK  (set Java class path )
Maven (set .m2 class path )
Eclipse
Eclipse Plugins for Maven Cucumber TestNG

Framework set up
Download zip and set it up in your local workspace

Project Overview: 
Angular application : https://www.way2automation.com/angularjs-protractor/banking/#/login

automation scripts using BDD approach  :
Feature files:
src/test/resources > Features > CustomerLogin.feature and BankManagerLogin.feature
Step Definations : 
src/test/java/StepDefinitions > CustomerLoginSteps.java and BankManagerSteps.java

Run Tests :
src/test/java > MyRunner > TestRunner.java   for Run as junit test
src/test/java > MyRunner > TestNGTestRunner.java for Run as TestNG test

Reports :
CucumberExtentReports : Extent Reports in Json , PDF , Spark html  format
target > cucumber-reports : in json , xml , html format


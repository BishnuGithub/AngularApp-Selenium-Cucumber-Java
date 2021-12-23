package MyRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = "StepDefinitions",
		tags="@BankManager or @Customer",
		plugin = { "pretty",				
				"html:target/cucumber-reports/cucumber-html-report.html",
				"json:target/cucumber-reports/json-report.json",
				"junit:target/cucumber-reports/CucumberTestReport.xml" ,
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},

		dryRun=false,
		monochrome = true

		)
public class TestRunner { }
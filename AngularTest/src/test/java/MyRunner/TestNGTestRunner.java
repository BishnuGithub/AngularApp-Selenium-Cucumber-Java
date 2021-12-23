package MyRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features",
		glue = "StepDefinitions",
		tags="@BankManager",
		plugin = { "pretty", "json:target/cucumber-reports/json-report.json",
	"html:target/cucumber-reports/cucumber-html-report.html"},

dryRun=false,
monochrome = true

		)
public class TestNGTestRunner extends AbstractTestNGCucumberTests{ }
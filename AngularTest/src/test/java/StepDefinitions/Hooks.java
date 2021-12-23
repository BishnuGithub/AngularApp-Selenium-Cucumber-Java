package StepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import Utilities.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass{

	public  WebDriver driver;
	public static Scenario scenario;


	@Before
	public void openBrowser(Scenario scenario) throws Exception {
		Hooks.scenario=scenario;
		scenario.log("Test started : "+scenario.getName());
		driver=BaseClass.getDriver();


	}

	@After
	public void embedScreenshot(Scenario scenario)throws IllegalAccessException {


		if(scenario.isFailed()) { 
			try { 
				byte[] screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", null);

			} catch (WebDriverException
					noSupportScreenshot) { System.err.println(noSupportScreenshot.getMessage());
			} }

		driver.quit();

		scenario.log("Test ended :"+scenario.getName());
	}
}

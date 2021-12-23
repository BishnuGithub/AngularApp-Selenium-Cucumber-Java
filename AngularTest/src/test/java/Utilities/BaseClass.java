package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.paulhammant.ngwebdriver.NgWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static NgWebDriver ngWebDriver;
	public static JavascriptExecutor jsDriver;
	public static WebDriverWait wait;
	public static PropertyReader prop;


	public static WebDriver getDriver() throws Exception {


		String browserName = PropertyReader.getValue("browser");
		System.out.println(browserName);
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();

			options.addArguments("--headless", "--window-size=1440,768",
					"--disable-gpu");

			driver = new ChromeDriver(options);
		}
		jsDriver = (JavascriptExecutor) driver;
		ngWebDriver = new NgWebDriver(jsDriver);
		// driver.manage().timeouts().implicitlyWait(propertiesReader.getTimeout(),
		// TimeUnit.SECONDS);
		// driver.manage().timeouts().setScriptTimeout(propertiesReader.getTimeout(),
		// TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(PropertyReader.getValue("url"));
		ngWebDriver.waitForAngularRequestsToFinish();
		return driver;
	}

	protected void WaitUntilElementVisible(WebElement element) throws Exception {
		prop=new PropertyReader();
		wait = new WebDriverWait(driver, prop.getTimeout());
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void WaitUntilElementClickable(WebElement element) throws Exception {

		prop=new PropertyReader();
		wait = new WebDriverWait(driver, prop.getTimeout());
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
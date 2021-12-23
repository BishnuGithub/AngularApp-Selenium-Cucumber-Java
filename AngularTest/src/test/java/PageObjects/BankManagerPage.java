package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.paulhammant.ngwebdriver.ByAngularPartialButtonText;

import StepDefinitions.Hooks;
import Utilities.BaseClass;

public class BankManagerPage extends BaseClass{


	//Initializing the Page Objects :
	public BankManagerPage() {
		PageFactory.initElements(driver, this);

	}

	//Page Factory

	@ByAngularPartialButtonText.FindBy( partialButtonText = "Add Customer")
	public WebElement AddCustomer;

	@ByAngularPartialButtonText.FindBy( partialButtonText = "Open Account")
	public WebElement OpenAccount;

	@ByAngularPartialButtonText.FindBy( partialButtonText = "Customer")
	public WebElement Customer;


	public boolean bankManagerLandingPage() throws Exception {

		Hooks.scenario.log("Landed on Bank Manager Page");
		WaitUntilElementClickable(AddCustomer);
		AddCustomer.isDisplayed();
		Hooks.scenario.log(" Bank Manager Page : Add Customer Button is displaying");
		WaitUntilElementClickable(OpenAccount);
		AddCustomer.isDisplayed();
		Hooks.scenario.log(" Bank Manager Page : Open Account Button is displaying ");
		WaitUntilElementClickable(Customer);
		AddCustomer.isDisplayed();
		Hooks.scenario.log(" Bank Manager Page : Customer Button is displaying ");
		return true;

	}



}

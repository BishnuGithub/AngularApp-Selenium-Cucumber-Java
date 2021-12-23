package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.paulhammant.ngwebdriver.ByAngularButtonText;

import StepDefinitions.Hooks;
import Utilities.BaseClass;

public class HomePage extends BaseClass {

	@ByAngularButtonText.FindBy( buttonText = "Home")
	public WebElement Home;

	@ByAngularButtonText.FindBy( buttonText = "Customer Login")
	public WebElement Customer_Login;

	@ByAngularButtonText.FindBy( buttonText = "Bank Manager Login")
	public WebElement BankManager_Login;



	public HomePage() {
		PageFactory.initElements(driver, this);

	}

	public boolean homePageIsDisplayed() throws Exception {

		Hooks.scenario.log("Landed on Home Page");
		WaitUntilElementVisible(Customer_Login);
		Customer_Login.isDisplayed();
		Hooks.scenario.log(" Home Page : Customer Login Button is displaying");
		WaitUntilElementVisible(BankManager_Login);
		BankManager_Login.isDisplayed();
		Hooks.scenario.log(" Home Page : BankManager Login Button is displaying");

		return true;
	}

	public void clickCustomerLoginButton() throws Exception {

		WaitUntilElementVisible(Customer_Login);
		Customer_Login.isEnabled();
		Customer_Login.click();
		Hooks.scenario.log(" Customer Login Button is clicked");

	}

	public void clickBankManagerLoginButton() throws Exception {

		WaitUntilElementVisible(BankManager_Login);
		BankManager_Login.isEnabled();
		BankManager_Login.click();
		Hooks.scenario.log(" Bank Manager Login Button is clicked");

	}

	public boolean backToHomePage() throws Exception {

		WaitUntilElementVisible(Home);
		Home.isEnabled();
		Home.click();
		Hooks.scenario.log(" Home Button is clicked");

		return true;
	}

}
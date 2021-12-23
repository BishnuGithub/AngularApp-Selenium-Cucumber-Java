package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.paulhammant.ngwebdriver.ByAngularButtonText;
import com.paulhammant.ngwebdriver.ByAngularModel;

import StepDefinitions.Hooks;
import Utilities.BaseClass;

public class CustomerPage extends BaseClass {


	//Initializing the Page Objects :
	public CustomerPage() {
		PageFactory.initElements(driver, this);

	}

	//Page Factory
	@ByAngularModel.FindBy( model = "custId") 
	public WebElement Customer_Dropdown;


	@ByAngularButtonText.FindBy( buttonText = "Login")
	public WebElement Login;

	@ByAngularButtonText.FindBy( buttonText = "Transactions")
	public WebElement Transactions;

	@ByAngularButtonText.FindBy( buttonText = "Deposit")
	public WebElement Deposit;

	@ByAngularButtonText.FindBy( buttonText = "Withdrawl")
	public WebElement Withdrawl;

	@ByAngularButtonText.FindBy( buttonText = "Logout")
	public WebElement Logout;



	public void cutomerLogin(String name) throws Exception {
		Hooks.scenario.log("Landed on Customer Page");
		WaitUntilElementClickable(Customer_Dropdown);
		Customer_Dropdown.isDisplayed();
		Hooks.scenario.log(" Customer Page : Customer select Dropdown  is displaying");
		Select select=new Select(Customer_Dropdown);
		select.selectByVisibleText(name);
		Hooks.scenario.log("Customer Name is selected from dropdown");
		WaitUntilElementVisible(Login);
		Login.isDisplayed();
		Hooks.scenario.log(" Login button  is displaying");
		Login.isEnabled();
		Login.click();
		Hooks.scenario.log(" Login Button is clicked");

	}


	public boolean loginPageIsDisplayed() throws Exception {
		Hooks.scenario.log("Customer Logged in ----- ");
		WaitUntilElementVisible(Transactions);
		Transactions.isDisplayed();
		Hooks.scenario.log(" Customer Login Page : Transactions Button is displaying");
		WaitUntilElementVisible(Deposit);
		Deposit.isDisplayed();
		Hooks.scenario.log(" Customer Login Page : Deposit Button  is displaying");
		WaitUntilElementVisible(Withdrawl);
		Withdrawl.isDisplayed();
		Hooks.scenario.log(" Customer Login Page : Withdrawl Button is displaying");
		WaitUntilElementVisible(Logout);
		Logout.isDisplayed();
		Hooks.scenario.log(" Customer Login Page : Logout Button  is displaying");

		return true;
	}

	public void logout() throws Exception {

		WaitUntilElementVisible(Logout);
		Logout.isEnabled();
		Logout.click();
		Hooks.scenario.log(" Logout Button  is clicked");


	}


	public boolean afterLogout() throws Exception {
		WaitUntilElementClickable(Customer_Dropdown);
		WaitUntilElementVisible(Customer_Dropdown);
		Customer_Dropdown.isDisplayed();
		return true;
	}


}
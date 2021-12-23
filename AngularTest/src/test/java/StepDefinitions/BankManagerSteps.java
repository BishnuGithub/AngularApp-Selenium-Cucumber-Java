package StepDefinitions;


//import org.junit.runner.RunWith;

import PageObjects.BankManagerPage;
import PageObjects.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//@RunWith(Cucumber.class)
public class BankManagerSteps{

	HomePage home;
	BankManagerPage bm;

	@Given("^User is on Home Page$")
	public void user_is_on_home_page()throws Throwable {
		home = new HomePage();
		home.homePageIsDisplayed();
		
	}
	@When("^User clicks on Bank manager Login$")
	public void user_clicks_on_bank_manager_login()throws Throwable {
		home.clickBankManagerLoginButton();
	}
	@Then("^User lands on bank manager Page with Add Customer , Open Account , Customers buttons available$")
	public void user_lands_on_bank_manager_page()throws Throwable {
		bm=new BankManagerPage();
		bm.bankManagerLandingPage();
	}

	@When("^User clicks on home and will land on Home Page$")
	public void user_clicks_home()throws Throwable {
		home.backToHomePage();
	}



}

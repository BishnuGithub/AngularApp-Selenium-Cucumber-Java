package StepDefinitions;

import PageObjects.CustomerPage;
import PageObjects.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

//@RunWith(Cucumber.class)
public class CustomerLoginSteps  {

	HomePage home;
	CustomerPage cust;


	@Given("^User is on home Page$")
	public void homePage() throws Throwable {

		home = new HomePage();
		home.homePageIsDisplayed();

	}

	@When("^User clicks on Customer Login$")
	public void clickLogin() throws Throwable {

		home.clickCustomerLoginButton();
	}


	//	  \"([^\"]*)\"
	//	\"(.*)\"

	@Then("^User Selects \"(.*)\" and clicks Login$") 
	public void user_Selects_Name_and_clicks_Login(String userName) throws Throwable {

		cust=new CustomerPage();
		cust.cutomerLogin(userName);
	}


	@Then("^It will \"(.*)\" User Name and Account Details$")
	public void successLogin(String display)throws Throwable  {

		Assert.assertTrue(cust.loginPageIsDisplayed());
	}



	@When("User clicks Logout")
	public void user_clicks_logout()throws Throwable {
		cust.logout();
	}
	@Then("It will go back to user select page")
	public void it_will_go_back_to_user_select_page()throws Throwable {
		cust.afterLogout();
	}
	@Then("User clicks on home and land on Home Page")
	public void user_clicks_on_home()throws Throwable {
		home.backToHomePage();
	}



}
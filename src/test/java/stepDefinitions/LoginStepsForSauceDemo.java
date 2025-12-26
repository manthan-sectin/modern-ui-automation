package stepDefinitions;//stepDefinitions

import io.cucumber.java.en.*;
import pageObjects.LoginPageSauceDemoForBDD;
import utilities.ConfigReader;
import utilities.DriverManager;
import utilities.DriverManager2;

import static org.testng.Assert.*;
public class LoginStepsForSauceDemo {





	LoginPageSauceDemoForBDD loginPage;

	    @Given("the user navigates to the Sauce Demo login page")
	    public void the_user_navigates_to_the_sauce_demo_login_page() {
	    	ConfigReader configReader = new ConfigReader();
	        DriverManager.getDriver().get(configReader.getBaseUrl());
	        loginPage = new LoginPageSauceDemoForBDD();
	    }

	    @Given("the user enters {string} in the username field")
	    public void the_user_enters_in_the_username_field(String username) {
	        loginPage.enterUsername(username);
	    }

	    @Given("the user enters {string} in the password field")
	    public void the_user_enters_in_the_password_field(String password) {
	        loginPage.enterPassword(password);
	    }

	    @When("the user clicks the login button")
	    public void the_user_clicks_the_login_button() {
	        loginPage.clickLogin();
	    }

	    @Then("the login result should be {string}")
	    public void the_login_result_should_be(String expectedResult) {
	        if (expectedResult.equalsIgnoreCase("success")) {
	            assertTrue(loginPage.isProductsPageVisible(),
	                    "Expected success but Products page not visible.");
	        } else {
	            assertFalse(loginPage.isProductsPageVisible(),
	                    "Expected failure but login succeeded.");
	        }
	    }

	    @Then("the user should see {string}")
	    public void the_user_should_see(String expectedOutcome) {
	        if (expectedOutcome.contains("Products page")) {
	            assertTrue(loginPage.isProductsPageVisible());
	        } else {
	            String actualError = loginPage.getErrorMessage();
	            assertTrue(actualError.contains(expectedOutcome),
	                    "Expected error not found. Actual: " + actualError);
	        }
	    }
	}

	
	
	


package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import utilities.DriverManager;

public class LoginSteps {
    private LoginPage loginPage;
    private ProductsPage productsPage;
    
    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        loginPage = new LoginPage();
    }
    
    @When("User enters {string} and {string}")
    public void user_enters_and(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }
    
    @When("Clicks on the login button")
    public void clicks_on_the_login_button() {
        loginPage.clickLogin();
    }
    
    @Then("User should be successfully logged in")
    public void user_should_be_successfully_logged_in() {
        productsPage = new ProductsPage();
        Assert.assertTrue(productsPage.getInventoryItemsCount() > 0, 
                "Login was not successful, products not displayed");
    }
    
    @Then("User should see an error message {string}")
    public void user_should_see_an_error_message(String expectedErrorMessage) {
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
                "Expected error message: " + expectedErrorMessage + 
                ", but got: " + actualErrorMessage);
    }
}
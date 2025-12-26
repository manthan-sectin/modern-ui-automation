package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.DriverManager;

public class LoginPageSauceDemoForBDD {

	


	

	    WebDriver driver;

	    // Locators
	    private By usernameField = By.id("user-name");
	    private By passwordField = By.id("password");
	    private By loginBtn = By.id("login-button");
	    private By productsTitle = By.xpath("//span[text()='Products']");
	    private By errorMsg = By.cssSelector("h3[data-test='error']");

	    public LoginPageSauceDemoForBDD() {
	        this.driver = DriverManager.getDriver();
	    }

	    public void enterUsername(String username) {
	        driver.findElement(usernameField).clear();
	        driver.findElement(usernameField).sendKeys(username);
	    }

	    public void enterPassword(String password) {
	        driver.findElement(passwordField).clear();
	        driver.findElement(passwordField).sendKeys(password);
	    }

	    public void clickLogin() {
	        driver.findElement(loginBtn).click();
	    }

	    public boolean isProductsPageVisible() {
	        return driver.findElements(productsTitle).size() > 0;
	    }

	    public String getErrorMessage() {
	        if (driver.findElements(errorMsg).size() > 0) {
	            return driver.findElement(errorMsg).getText();
	        }
	        return "";
	    }
	}

	
	


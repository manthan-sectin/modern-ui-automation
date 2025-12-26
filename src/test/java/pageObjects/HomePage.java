package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    
    // Page locators
    @FindBy(name = "q")
    private WebElement searchBox;
    
    @FindBy(name = "btnK")
    private WebElement searchButton;
    
    @FindBy(id = "hplogo")
    private WebElement logo;
    
    @FindBy(linkText = "Sign in")
    private WebElement signInButton;
    
    // Constructor
    public HomePage(WebDriver driver) {
        super(driver); // Call parent constructor
    }
    
    // Page-specific methods
    
    /**
     * Open the home page
     * @param url URL of the home page
     * @return HomePage instance
     */
    public HomePage open(String url) {
        navigateTo(url);
        return this;
    }
    
    /**
     * Search for the given text
     * @param text Text to search for
     * @return HomePage instance
     */
    public HomePage searchFor(String text) {
        sendKeys(searchBox, text);
        click(searchBox);
        return this;
    }
    
    /**
     * Check if the logo is visible
     * @return true if logo is visible
     */
    public boolean isLogoVisible() {
        return isElementVisible(logo);
    }
    
    /**
     * Click the sign in button
     * @return HomePage instance
     */
    public HomePage clickSignIn() {
        click(signInButton);
        return this;
    }
    
    /**
     * Get the placeholder text of the search box
     * @return Placeholder text
     */
    public String getSearchBoxPlaceholder() {
        return searchBox.getAttribute("placeholder");
    }
}
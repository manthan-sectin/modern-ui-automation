package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;
import java.util.List;

public class ProductsPage {
    WebDriver driver;
    
    public ProductsPage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }
    
    // Web Elements
    @FindBy(className = "inventory_item")
    private List<WebElement> inventoryItems;
    
    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;
    
    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;
    
    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;
    
    // Page Actions
    public int getInventoryItemsCount() {
        return inventoryItems.size();
    }
    
    public void clickCartIcon() {
        cartIcon.click();
    }
    
    public void logout() {
        menuButton.click();
        // Wait for the logout link to be clickable (would use WebDriverWait in real implementation)
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logoutLink.click();
    }
}
package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SauceDemoLoginPage {
	protected WebDriver driver;
	protected WebDriverWait wait;

	@FindBy(id = "user-name")
	private WebElement UserName;

	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement Password;

	//: Use XPath for multiple classes
	@FindBy(xpath = "//input[contains(@class, 'submit-button') and contains(@class, 'btn_action')]")
	private WebElement Submit;

	public SauceDemoLoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}

	public void SetUserName(String User) {
		wait.until(ExpectedConditions.elementToBeClickable(UserName));
		UserName.clear();
		UserName.sendKeys(User);
	}

	public void SetPassword(String Pass) {
		wait.until(ExpectedConditions.elementToBeClickable(Password));
		Password.clear();
		Password.sendKeys(Pass);
	}
	
	public void ClickOnSubmit() {
		wait.until(ExpectedConditions.visibilityOf(Submit));
		Submit.click();
	}
}

package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import ExcelUtility.ExcelReader;
import base.BaseTest;
//import javaProgramiz.ExcelUtility;
import pageObjects.SauceDemoLoginPage;
import utilities.ExcelReader;
import utilities.ExcelUtility;

public class LoginTest extends BaseTest {

    
    @DataProvider(name = "loginDataProvider")
    public Object[][] getLoginData() {
        // Calls the static method in the utility class
        // "LoginData" is the name of the sheet in TestData.xlsx
        return ExcelReader.getTestData("LoginData");
    }


    @Test(priority=1)
    public void LoginTest() {
    	String xlPath="D:\\BDDWithDDT\\src\\test\\resources\\testData\\ExcelReader.xlsx";
		String username=ExcelUtility.getCellValue(xlPath, "Groups", 2, 0);
		String Password=ExcelUtility.getCellValue(xlPath, "Groups", 2, 1);
		   SauceDemoLoginPage login = new SauceDemoLoginPage(driver);
	         logger=extent.createTest("To Verify Login with Valid inputs");
	         login.SetUserName(username);
	         logger.createNode("Username entered");
	         login.SetPassword(Password);
	         logger.createNode("Password entered");
	         login.ClickOnSubmit();
	         logger.createNode("Click on submit button");
    }
}
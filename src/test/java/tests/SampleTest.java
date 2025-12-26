package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Lib;

public class SampleTest extends BaseTest {
	@Test(priority=0)
	public void GetUrl() {
		String SL1 = Lib.getCellValue(XLPATH, "Groups", 2, 0);	
		System.out.println(SL1);
		//test.get().log(Status.INFO, "Captured title: ");
		// test.get().log(Status.INFO, "Captured title: ");
		logger.info("clicked on ligin button..");
	}
	
	@Test(priority=1)
	public void FailUrl() {
		 Assert.fail("Deliberately failing the test");	
	}

	@Test(priority=2)
	public void SkipUrl() {
		throw new SkipException("Skip this test deliberately");
		
	}


}

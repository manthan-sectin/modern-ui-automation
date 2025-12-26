package utilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager2 {
/*
	static WebDriver driver;
	static Capabilities capabilities;

	public static WebDriver setDriver(String browserName) throws MalformedURLException {
		if (browserName.equals("Chrome")) {

			capabilities = new ChromeOptions();
		} else {
			capabilities = new FirefoxOptions();
		}
		                                           //192.168.31.155
		driver = new RemoteWebDriver(new URL("http://192.168.31.155:4444/wd/hub"), capabilities);

		return driver;

	}

	public static WebDriver getDriver() {
		return driver;
	}
	

//	public static void quitDriver() {
	//	driver.close();
	//	}
	*/
	
	  private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	    public static WebDriver setDriver(String browserName) throws MalformedURLException {

	        if (browserName.equalsIgnoreCase("Chrome")) {

	            ChromeOptions options = new ChromeOptions();
	            options.addArguments("--disable-dev-shm-usage");
	            options.addArguments("--no-sandbox");

	            driver.set(new RemoteWebDriver(
	                    new URL("http://selenium-hub:4444/wd/hub"),
	                    options));

	        } else if (browserName.equalsIgnoreCase("Firefox")) {

	            FirefoxOptions options = new FirefoxOptions();
	            options.addArguments("--disable-dev-shm-usage");

	            driver.set(new RemoteWebDriver(
	                    new URL("http://selenium-hub:4444/wd/hub"),
	                    options));
	        }

	        return driver.get();
	    }

	    public static WebDriver getDriver() {
	        return driver.get();
	    }

	    public static void quitDriver() {
	        if (driver.get() != null) {
	            driver.get().quit();
	            driver.remove();
	        }
	    }
	
}

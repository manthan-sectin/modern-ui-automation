package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utilities.DriverManager;
import utilities.DriverManager2;
import utilities.IAutocanstant;
import utilities.Lib;
import utilities.ConfigReader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger; //log4j

//@Listeners(listeners.TestListener.class) 
public class BaseTest implements IAutocanstant {

	public WebDriver driver;
	public ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;

	@BeforeSuite
	public void startTest() {
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/index.html");
		// Create an object of extent rport
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Host Name", "Manthan M");
		extent.setSystemInfo("Environment", "Production");
		extent.setSystemInfo("User name", "Manthan mali");
		sparkReporter.config().setDocumentTitle("UI Automation");
		sparkReporter.config().setReportName("UI Automation report");
		sparkReporter.config().setTheme(Theme.DARK);

	}

	public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;

	}

	@BeforeClass(alwaysRun = true)
	@Parameters("browser")
	public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
		// loading log4j
		// logger = LogManager.getLogger(this.getClass());// Log4j
		// Initialize driver
		DriverManager2.setDriver(browser);
		driver = DriverManager2.getDriver();

	//	String url = Lib.getProperty(CONFIG_PATH, "URL");
	//	String url = System.getenv("APP_URL");
		driver.get("https://www.saucedemo.com");

	}
	
//	@BeforeMethod
//	public void createTest(Method method) {
//	    logger = extent.createTest(method.getName());
//	}


	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			// MarkupHelper is used to display the output in different colors
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));

			String screenshotPath = getScreenShot(driver, result.getName());
			// To add it in the extent report
			logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		}

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		//changes done here
		DriverManager2.getDriver().quit();
	}

	@AfterSuite
	public void endReport() {
		extent.flush();
	}

	public WebDriver getDriver() {
		return driver;
	}
}
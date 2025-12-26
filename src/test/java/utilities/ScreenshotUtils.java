package utilities;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.common.io.Files;

public class ScreenshotUtils {

    public static String captureScreenshot(WebDriver driver, String testName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String path = "reports/screenshots/" + testName + "_" + timestamp + ".png";
        try {
            Files.copy(src, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}
package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshots {
	 
    public static String takeScreenshot(WebDriver driver, String testName) {
 
        if (driver == null) {
            System.out.println("Driver is NULL. Screenshot skipped.");
            return null;
        }
 
        try {
            String timestamp =
                new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
 
            String filePath = System.getProperty("user.dir")
                    + "/Screenshots/" + testName + "_" + timestamp + ".png";
 
            File src = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);
 
            File dest = new File(filePath);
            FileHandler.copy(src, dest);
 
            System.out.println("Screenshot saved: " + filePath);
            return filePath;
 
        } catch (Exception e) {
            System.out.println("Screenshot failed: " + e.getMessage());
            return null;
        }
    }
}
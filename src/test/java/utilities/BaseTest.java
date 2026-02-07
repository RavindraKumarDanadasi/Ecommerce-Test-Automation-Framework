package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
 
    protected WebDriver driver;
 
    @BeforeClass
    public void setUp() {
        driver = DriverSetup.getDriver();
    }
 
    @AfterClass
    public void tearDown() {
        DriverSetup.quitDriver();
    }
}
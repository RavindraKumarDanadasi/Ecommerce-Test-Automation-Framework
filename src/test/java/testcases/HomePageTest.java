package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.HomePage;
import utilities.BaseTest;
import utilities.DriverSetup;
import utilities.Screenshots;

@Listeners(utilities.TestListener.class)

public class HomePageTest extends BaseTest {
	public WebDriver driver;
    HomePage home;
    @BeforeClass
    public void setup() {
        driver = DriverSetup.getDriver();
        home = new HomePage(driver);
        home.openHome();
        Reporter.getCurrentTestResult().getTestContext().setAttribute("driver", driver);
    }
    @Test(priority = 1)
    public void computersScreenshot() {
        Assert.assertTrue(home.computersClickable(), "Computers NOT clickable");
 
        home.clickComputers();
        waitForHeader("Computers");
        Screenshots.takeScreenshot(driver, "Computers");
    }
 
    @Test(priority = 2)
    public void electronicsScreenshot() {
        Assert.assertTrue(home.electronicsClickable(), "Electronics NOT clickable");
 
        home.clickElectronics();
        waitForHeader("Electronics");
        Screenshots.takeScreenshot(driver, "Electronics");
    }
 
    @Test(priority = 3)
    public void apparelScreenshot() {
        Assert.assertTrue(home.apparelClickable(), "Apparel NOT clickable");
 
        home.clickApparel();
        waitForHeader("Apparel");
        Screenshots.takeScreenshot(driver, "Apparel");
    }
 
    @Test(priority = 4)
    public void digitalDownloadsScreenshot() {
        Assert.assertTrue(home.digitalDownloadsClickable(), "Digital Downloads NOT clickable");
 
        home.clickDigitalDownloads();
        waitForHeader("Digital downloads");
        Screenshots.takeScreenshot(driver, "DigitalDownloads");
    }
 
    @Test(priority = 5)
    public void booksScreenshot() {
        Assert.assertTrue(home.booksClickable(), "Books NOT clickable");
 
        home.clickBooks();
        waitForHeader("Books");
        Screenshots.takeScreenshot(driver, "Books");
    }
 
    @Test(priority = 6)
    public void jewelryScreenshot() {
        Assert.assertTrue(home.jewelryClickable(), "Jewelry NOT clickable");
 
        home.clickJewelry();
        waitForHeader("Jewelry");
        Screenshots.takeScreenshot(driver, "Jewelry");
    }
 
    @Test(priority = 7)
    public void giftCardsScreenshot() {
        Assert.assertTrue(home.giftCardsClickable(), "Gift Cards NOT clickable");
 
        home.clickGiftCards();
        waitForHeader("Gift Cards");
        Screenshots.takeScreenshot(driver, "GiftCards");
    }
    private void waitForHeader(String header) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[text()='" + header + "']")
        ));
    }
 
    @AfterClass
    public void tearDown() {
        DriverSetup.quitDriver();
    }
}
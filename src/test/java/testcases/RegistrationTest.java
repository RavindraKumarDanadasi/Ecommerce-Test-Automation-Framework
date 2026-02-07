package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.RegistrationPage;
import utilities.BaseTest;
import utilities.DriverSetup;

@Listeners(utilities.TestListener.class)

public class RegistrationTest extends BaseTest {

public WebDriver driver;
RegistrationPage reg;
   @BeforeClass
   public void openBrowser() {
	   driver = DriverSetup.getDriver();
	   reg = new RegistrationPage(driver);
	   Reporter.getCurrentTestResult().getTestContext().setAttribute("driver", driver);
   }
   @Test
    public void registerUser() {
                reg.openRegistration();
        reg.selectGender("male");
        reg.enterFirstName("Ravindra");
        reg.enterLastName("Kumar");
        reg.enterEmail("ravindrakumardandasi@gmail.com");
        reg.enterCompanyName("wipro");
        reg.setNewsletter(true);
        reg.enterPassword("Test@1234");
        reg.enterConfirmPassword("Test@1234");
        reg.clickRegister();
        if (reg.isRegistrationSuccess()) {
        	System.out.println("Registration completed: TEST PASS");
        } else {
        	System.out.println("Registration Not completed: TEST FAIL");
        }
    }
   @AfterClass
   public void closeBrowser() {
	   DriverSetup.quitDriver();
   }

    }

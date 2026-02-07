package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.BaseTest;
import utilities.DriverSetup;

@Listeners(utilities.TestListener.class)

public class LoginTest extends BaseTest {
	public WebDriver driver;
    LoginPage login;
 
    @BeforeClass
    public void setup() {
        driver = DriverSetup.getDriver();
        login = new LoginPage(driver);
        login.open();
        Reporter.getCurrentTestResult().getTestContext().setAttribute("driver", driver);
    }
 
    @Test(priority = 1)
    public void testRememberMeSelection() {
        login.selectRememberMe();
 
        boolean status = login.isRememberMeSelected();
        Assert.assertTrue(status, "Remember Me checkbox NOT selected!");
 
        System.out.println(status ? "Remember Me selected: TEST PASS"
                                  : "Remember Me not selected: TEST FAIL");
    }
 
    @Test(priority = 2)
    public void testForgotPasswordLink() {
 
        boolean status = login.isForgotPasswordPresent();
        Assert.assertTrue(status, "Forgot Password link NOT visible!");
 
        System.out.println(status ? "Forgot Password link visible: TEST PASS"
                                  : "Forgot Password link NOT visible: TEST FAIL");
 
        login.clickForgotPassword();
        System.out.println("Forgot Password clicked: Navigation triggered");
        
        driver.navigate().back();
    }
 
    @Test(priority = 3)
    public void loginUser() {
 
        login.enterEmail("ravindrakumardandasi@gmail.com");
        login.enterPassword("Test@1234");
        login.clickLogin();
 
        boolean loginStatus = login.isLoginSuccess();
        Assert.assertTrue(loginStatus, "loginStatus");
 
        System.out.println(loginStatus ? "Login successful: TEST PASS"
                                       : "Login failed: TEST FAIL");
    }
 
    @AfterClass
    public void tearDown() {
        DriverSetup.quitDriver();
    }
}

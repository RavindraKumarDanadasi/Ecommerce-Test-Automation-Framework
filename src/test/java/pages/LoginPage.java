package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	public WebDriver driver;
    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");
    private By loginBtn = By.cssSelector("button.login-button");
    private By rememberMe = By.id("RememberMe");
    private By forgotPassword = By.linkText("Forgot password?");
    private By myAccountLink = By.linkText("My account");
 
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
 
    public void open() {
        driver.get("https://demo.nopcommerce.com/login");
    }
 
    public void enterEmail(String mail) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(mail);
    }
 
    public void enterPassword(String pass) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(pass);
    }
 
    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }
    public void selectRememberMe() {
        if (!driver.findElement(rememberMe).isSelected()) {
            driver.findElement(rememberMe).click();
        }
    }
 
    public boolean isRememberMeSelected() {
        return driver.findElement(rememberMe).isSelected();
    }
 
    public void clickForgotPassword() {
        driver.findElement(forgotPassword).click();
    }
 
    public boolean isForgotPasswordPresent() {
        try {
            return driver.findElement(forgotPassword).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isLoginSuccess() {
        try {
            return driver.findElement(myAccountLink).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

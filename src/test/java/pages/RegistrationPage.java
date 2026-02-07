package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
	public WebDriver driver;
	 
	    By genderMale = By.xpath("//input[@type=\"radio\" or @value=\"M\" or @id=\"gender-male\" or @name=\"Gender\"]");
	    By genderFemale = By.id("gender-female");
	 
	    By firstName = By.id("FirstName");
	    By lastName = By.id("LastName");
	    By email = By.id("Email");
	 
	    By companyName = By.id("Company");
	    By newsletter = By.xpath("//input[@id='NewsLetterSubscriptions_0__IsActive' or @type='checkbox']");
	 
	    By password = By.id("Password");
	    By confirmPassword = By.id("ConfirmPassword");
	 
	    By registerBtn = By.id("register-button");
	 By successMessage=By.xpath("//div[@class='result' or contains(text(), 'Your registration completed')]");
	    public RegistrationPage(WebDriver driver) {
	        this.driver = driver;
	    }
	    public void openRegistration() {
	    	driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");

	    }
	 
	    public void selectGender(String gender) {
	        if (gender.equalsIgnoreCase("male")) {
	            driver.findElement(genderMale).click();
	        } else {
	            driver.findElement(genderFemale).click();
	        }
	    }
	 
	    public void enterFirstName(String fname) {
	        driver.findElement(firstName).sendKeys(fname);
	    }
	 
	    public void enterLastName(String lname) {
	        driver.findElement(lastName).sendKeys(lname);
	    }
	 
	    public void enterEmail(String mail) {
	        driver.findElement(email).sendKeys(mail);
	    }
	 
	    public void enterCompanyName(String cname) {
	        driver.findElement(companyName).sendKeys(cname);
	    }
	 
	    public void setNewsletter(boolean subscribe) {
	        boolean isChecked = driver.findElement(newsletter).isSelected();
	 
	        if (subscribe && !isChecked) {
	            driver.findElement(newsletter).click();
	        }
	        else if (!subscribe && isChecked) {
	            driver.findElement(newsletter).click();
	        }
	    }
	 
	    public void enterPassword(String pass) {
	        driver.findElement(password).sendKeys(pass);
	    }
	 
	    public void enterConfirmPassword(String cpass) {
	        driver.findElement(confirmPassword).sendKeys(cpass);
	    }
	 
	    public void clickRegister() {
	        driver.findElement(registerBtn).click();

	    }
	   public boolean isRegistrationSuccess() {
		   try {
			   return driver.findElement(successMessage).isDisplayed();
		   }
		   catch(Exception e) {
			   return false;
		   }
	   }
}

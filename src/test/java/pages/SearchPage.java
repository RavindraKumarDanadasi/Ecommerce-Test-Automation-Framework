package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class SearchPage {
	 public WebDriver driver;
	    private By searchBox = By.id("small-searchterms");
	    private By searchButton = By.cssSelector("button[type='submit']");
	    private By iphoneLink = By.linkText("Apple iPhone 16 128GB");
	    private By addToCartBtn = By.xpath("(//button[@id='add-to-cart-button-21'])[1]");
	    private By shoppingCartIcon = By.cssSelector("span.cart-label");
	    private By continueShoppingBtn = By.xpath("//button[@type=\"submit\" or @name=\"continueshopping\" or @class=\"button-2 continue-shopping-button\"]");
	    private By estimateShippingBtn = By.xpath("//a[@id='open-estimate-shipping-popup']");
	    private By countryDropdown = By.id("CountryId");
	    private By stateDropdown = By.id("StateProvinceId");
	    private By zipCodeField = By.id("ZipPostalCode");
	    private By applyShippingBtn = By.xpath("//button[normalize-space()='Apply']");
	 
	      private By checkoutBtn = By.xpath("//button[@id=\"checkout\" or @name=\"checkout\"]");
	      private By termsservice = By.xpath("//input[@name=\"termsofservice\"]");
	    public SearchPage(WebDriver driver) {
	        this.driver = driver;
	    }
	 
	    public void open() {
	        driver.get("https://demo.nopcommerce.com/");
	    }
	 
	    public boolean isSearchBoxEnabled() {
	        return driver.findElement(searchBox).isEnabled();
	    }
	 
	    public void searchProduct(String product) {
	        driver.findElement(searchBox).clear();
	        driver.findElement(searchBox).sendKeys(product);
	        driver.findElement(searchButton).click();
	    }
	 
	    public void clickProduct() {
	        driver.findElement(iphoneLink).click();
	    }
	 
	    public void addToCart() {
	        driver.findElement(addToCartBtn).click();
	    }
	 
	    public void openCart() {
	        driver.findElement(shoppingCartIcon).click();
	    }
	 
	    public void clickContinueShopping() {
	        driver.findElement(continueShoppingBtn).click();
	    }
	 
	    public void clickEstimateShipping() {
	        driver.findElement(estimateShippingBtn).click();
	    }
	    public void selectCountry(String country) {
	        Select selectCountry = new Select(driver.findElement(countryDropdown));
	        selectCountry.selectByVisibleText(country);
	    }
	 
	    public void selectState(String state) {
	        Select stateSelect = new Select(driver.findElement(stateDropdown));
	        for (int i = 0; i < 10; i++) {
	            if (stateSelect.getOptions().size() > 1) {
	                break;
	            }
	            try { Thread.sleep(500); } catch (Exception e) {}
	            stateSelect = new Select(driver.findElement(stateDropdown));
	        }
	     
	        stateSelect.selectByVisibleText(state);
	    }
	 
	    public void enterZipCode(String zip) {
	        driver.findElement(zipCodeField).clear();
	        driver.findElement(zipCodeField).sendKeys(zip);
	    }
	    public void applyShipping() {
	    	driver.findElement(applyShippingBtn).click();
	    }
	 
	    public void fillShippingDetails(String country, String state, String zip) {
	        driver.findElement(countryDropdown).sendKeys(country);
	        driver.findElement(stateDropdown).sendKeys(state);
	        driver.findElement(zipCodeField).sendKeys(zip);
	        driver.findElement(applyShippingBtn).click();
	    }
	    public boolean isOnHomePage() {
	        try {
	            return driver.findElement(By.id("small-searchterms")).isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }
	    public boolean selectTermsOfService() {
	        try {
	            WebElement checkbox = driver.findElement(termsservice);
	     
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
	            Thread.sleep(500);
	     
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
	     
	            return checkbox.isSelected();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	    
	    public void clickCheckout() {
	        try {
	            WebElement checkout = driver.findElement(checkoutBtn);
	     
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkout);
	            Thread.sleep(700);
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkout);
	     
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }     
	}
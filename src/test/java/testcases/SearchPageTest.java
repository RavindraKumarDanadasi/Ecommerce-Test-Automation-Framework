package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.SearchPage;
import utilities.BaseTest;
import utilities.DriverSetup;

@Listeners(utilities.TestListener.class)

public class SearchPageTest extends BaseTest{
	public  WebDriver driver;
	    SearchPage search;
	 
	    @BeforeClass
	    public void setup() {
	        driver = DriverSetup.getDriver();
	        search = new SearchPage(driver);
	        search.open();
	        Reporter.getCurrentTestResult().getTestContext().setAttribute("driver", driver);
	    }
	 
	    @Test(priority = 1)
	    public void testSearchBoxEnabled() {
	        boolean status = search.isSearchBoxEnabled();
	        Assert.assertTrue(status, "Search box is NOT enabled!");
	 
	        System.out.println(status ? "Search Box Enabled: TEST PASS"
	                                  : "Search Box NOT Enabled: TEST FAIL");
	    }
	 
	    @Test(priority = 2)
	    public void testSearchProduct() {
	        search.searchProduct("Apple iPhone 16 128GB");
	        search.clickProduct();
	        System.out.println("Product page opened: TEST PASS");
	    }
	 
	    @Test(priority = 3)
	    public void testAddToCart() {
	        search.addToCart();
	        search.openCart();
	 
	        System.out.println("Product added to cart: TEST PASS");
	    }
	 
	   
	    @Test(priority = 4)
	    public void testContinueShopping() {
	        search.openCart();
	        search.clickContinueShopping();
	     
	        boolean status = search.isOnHomePage();
	     
	        Assert.assertTrue(status, "Continue shopping did NOT return to home page");
	     
	        if (status) {
	            System.out.println("Continue Shopping working: TEST PASS");
	        } else {
	            System.out.println("Continue Shopping failed: TEST FAIL");
	        }
	    }
	    @Test(priority = 5)
	    public void testEstimateShipping() {
	 
	        search.openCart();
	        search.clickEstimateShipping();
	 
	        search.selectCountry("India");
	        search.selectState("Andhra Pradesh");
	        search.enterZipCode("512461");
	        search.applyShipping();
	 
	        System.out.println("Estimate Shipping Applied:TEST PASS");
	    }
	   	     @Test(priority = 6)
	     public void isTermsOfServiceSelected() {
	         boolean status = search.selectTermsOfService();
	         Assert.assertTrue(status, "Terms & Services checkbox NOT selected!");
	         System.out.println(status
	                 ? "Terms & Services checkbox selected: TEST PASS"
	                 : "Terms & Services checkbox NOT selected: TEST FAIL");
	     }
	   	  @Test(priority = 7)
	   	public void testCheckout() {
	   	 
	   	    search.clickCheckout();
	   	 
	   	    boolean checkoutPage = driver.getCurrentUrl().contains("checkout");
	   	    Assert.assertTrue(checkoutPage, "Checkout Page NOT opened!");
	   	 
	   	    System.out.println(
	   	            checkoutPage ? "Checkout Page Opened: TEST PASS"
	   	                         : "Checkout Page Failed: TEST FAIL"
	   	    );
	   	}
	    @AfterClass
	    public void tearDown() {
	        DriverSetup.quitDriver();
	    }
	}
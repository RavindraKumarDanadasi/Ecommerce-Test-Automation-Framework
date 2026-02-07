package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class HomePage {
	private WebDriver driver;
    private By computers = By.linkText("Computers");
    private By electronics = By.linkText("Electronics");
    private By apparel = By.linkText("Apparel");
    private By digitalDownloads = By.linkText("Digital downloads");
    private By books = By.linkText("Books");
    private By jewelry = By.linkText("Jewelry");
    private By giftCards = By.linkText("Gift Cards");
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void openHome() {
        driver.get("https://demo.nopcommerce.com/"); }
    private boolean isClickable(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element.isDisplayed() && element.isEnabled();
        } catch (Exception e) {
            return false;
        }
        }
    public boolean computersClickable() {
        return isClickable(computers);
    }
 
    public boolean electronicsClickable() {
        return isClickable(electronics);
    }
 
    public boolean apparelClickable() {
        return isClickable(apparel);
    }
 
    public boolean digitalDownloadsClickable() {
        return isClickable(digitalDownloads);
    }
 
    public boolean booksClickable() {
        return isClickable(books);
    }
 
    public boolean jewelryClickable() {
        return isClickable(jewelry);
    }
 
    public boolean giftCardsClickable() {
        return isClickable(giftCards);
    }
    public void clickComputers() {
        driver.findElement(computers).click();
    }
 
    public void clickElectronics() {
        driver.findElement(electronics).click();
    }
 
    public void clickApparel() {
        driver.findElement(apparel).click();
    }
 
    public void clickDigitalDownloads() {
        driver.findElement(digitalDownloads).click();
    }
 
    public void clickBooks() {
        driver.findElement(books).click();
    }
 
    public void clickJewelry() {
        driver.findElement(jewelry).click();
    }
 
    public void clickGiftCards() {
        driver.findElement(giftCards).click();
    }

}
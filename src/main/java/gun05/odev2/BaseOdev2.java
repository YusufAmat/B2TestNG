package gun05.odev2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.Driver;

import java.time.Duration;

import static gun05.odev1.Locators.NOTIFICATION;


public class BaseOdev2 {
    WebDriver driver;
    WebDriverWait wait;



    @BeforeSuite
    public void setup() {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterSuite
    public void tearDown() {
        Driver.quitDriver();
    }

    public void click(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        click(element);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void clickByAction(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        clickByAction(element);
    }
    public void clickByAction(WebElement element) {
        new Actions(driver).moveToElement(element).click().perform();
    }

    public void sendKeys(By locator, CharSequence...text) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        sendKeys(element, text);
    }

    public void sendKeys(WebElement element, CharSequence...text) {
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(element));
        element1.sendKeys(text);
    }

    public WebElement element(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public By xpath(String xpathString, String label) {
        return By.xpath(String.format(xpathString, label));
    }

    public void notificationIsShownWithText(String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath(NOTIFICATION, text)));
    }

    public void valueToBe(By locator, String text){
        wait.until(ExpectedConditions.attributeToBe(locator,"value", text));
    }
    public void valueToBe(WebElement element, String text){
        wait.until(ExpectedConditions.attributeToBe(element,"value", text));
    }

    public void textToBe(By locator, String text){
        wait.until(ExpectedConditions.attributeToBe(locator,"value", text));
    }

    public void textToBe(WebElement element, String text){
        wait.until(ExpectedConditions.attributeToBe(element,"value", text));
    }

    public void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

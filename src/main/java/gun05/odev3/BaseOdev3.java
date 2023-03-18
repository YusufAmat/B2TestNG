package gun05.odev3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.Driver;

import java.time.Duration;

import static gun05.odev1.Locators.NOTIFICATION;


public class BaseOdev3 {
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

    public By xpath(String xpathString, String label) {
        return By.xpath(String.format(xpathString, label));
    }

    public void notificationIsShownWithText(String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath(NOTIFICATION, text)));
    }

    public void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

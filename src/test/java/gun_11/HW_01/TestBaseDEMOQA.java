package gun_11.HW_01;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.Driver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TestBaseDEMOQA {
    WebDriver driver;
    WebDriverWait wait;


    @BeforeTest
    public void beforeTest() {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterTest
    public void afterTest() {
        Driver.quitDriver();
    }


    public void sendKeys(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        sendKeys(element, text);
    }

    public void sendKeys(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).clear();
        element.sendKeys(text);
    }

    public void click(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        click(element);
    }

    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForPresence(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void sleep(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public By xpath(String xpathStr, int label) {
        return By.xpath(String.format(xpathStr, label));
    }

    public void tScreenShoot(String name) {
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File target = new File("_screenshots/" + name + ".png");
        try {
            FileUtils.copyFile(source,target);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

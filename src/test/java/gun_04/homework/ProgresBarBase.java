package gun_04.homework;

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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProgresBarBase {
    protected WebDriver driver;
    protected WebDriverWait wait;


    @BeforeTest
    public void beforeTest() {
        driver = Driver.getDriver();
        //wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(10));
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

    public void waitForVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForPresence(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitTextToBe(By locator, String text) {
        wait.until(ExpectedConditions.textToBe(locator, text));
    }

    public void getScreenShot() {
        String name = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd H_m_s"));
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        File target = new File("_screenshots/" + name + ".png");
        try {
            FileUtils.copyFile(source, target);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

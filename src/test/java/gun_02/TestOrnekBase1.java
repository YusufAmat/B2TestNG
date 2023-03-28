package gun_02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import utils.Driver;

import java.time.Duration;

public class TestOrnekBase1 {
    WebDriver driver;
    WebDriverWait wait;


    @BeforeSuite
    public void bbb() {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @BeforeTest
    public void aa() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        wait.until(ExpectedConditions.titleIs("OrangeHRM"));
    }
    @AfterSuite
    public void tearDown() {
        Driver.quitDriver();
    }

    public void sendKeys(By locator, String text){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(text);
    }
    public void click(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }
}

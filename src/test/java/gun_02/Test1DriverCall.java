package gun_02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Driver;

import java.time.Duration;

public class Test1DriverCall {
    WebDriver driver;
    WebDriverWait wait;


    By lUserName = By.cssSelector("input[name='username']");
    By lPassword = By.cssSelector("input[name='password']");
    By lSubmitButton = By.cssSelector("button[type='submit']");
    By lSidePannel = By.cssSelector(".oxd-sidepanel");

    @Test
    public void gotoUrl() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        wait.until(ExpectedConditions.titleIs("OrangeHRM"));
    }

    @Test(dependsOnMethods = "gotoUrl")
    public void login(){
        wait.until(ExpectedConditions.presenceOfElementLocated(lUserName)).sendKeys("Admin");
        driver.findElement(lPassword).sendKeys("admin123");
        driver.findElement(lSubmitButton).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(lSidePannel));

    }


    @BeforeClass
    public void setup() {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown() {
        Driver.quitDriver();
    }
}

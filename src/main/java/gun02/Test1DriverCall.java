package gun02;

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


    @Test
    public void gotoUrl(){
        driver.get("https://opensource-demo.orangehrmlive.com/");
        wait.until(ExpectedConditions.titleIs("OrangeHRM"));
    }

    @BeforeClass
    public void setup(){
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

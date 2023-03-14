package gun02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import utils.Driver;

import java.time.Duration;

public class TestMail {
    WebDriver driver;
    WebDriverWait wait;


    By lUsername = By.xpath("//input[@name='identifier']");


    @Test
    public void loginToMail(){
        driver.get("https://mail.google.com/");
        //wait.until(ExpectedConditions.visibilityOfElementLocated(lUsername)).sendKeys("aaa@gmail.com", Keys.ENTER);


        /*
        driver.get("");
        wait.until(ExpectedConditions.visibilityOfElementLocated()).sendKeys();
        wait.until(ExpectedConditions.visibilityOfElementLocated()).sendKeys("pass", Keys.ENTER);

         */

    }


    @BeforeTest
    public void setup(){
        driver = Driver.getDriver();
        //driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @AfterTest
    public void tearDown(){
        //driver.quit();
    }


}

package gun_09;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.Browsers;
import utils.Driver;

import java.time.Duration;

public class TaskBase {

    WebDriver driver;
    WebDriverWait wait;


    @BeforeTest
    @Parameters({"browser", "size"})
    public void beforeTest(@Optional("CHROME") String browser, @Optional("max") String size) {
        driver = Driver.getDriver(Browsers.valueOf(browser.toUpperCase()));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        if (size.equalsIgnoreCase("max")) {
            driver.manage().window().maximize();
        } else {
            driver.manage().window().setSize(new Dimension(700, 800));
        }
    }


    @AfterTest
    public void afterTest() {
        Driver.quitDriver();
    }

    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void click(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        click(element);
    }

    public void waitUntilVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }
}

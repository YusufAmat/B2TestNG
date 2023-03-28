package gun_05.homework;

import org.openqa.selenium.By;
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

import static gun_05.homework.OdevLocators.lSearchMenuSearchButton;
import static gun_05.homework.OdevLocators.lSearchMenuUserNameBox;

public class OdevBase {
    WebDriver driver;
    WebDriverWait wait;



    @Parameters("browser")
    @BeforeTest
    public void beforeTest(@Optional("chrome") String browser) {
        driver = Driver.getDriver(Browsers.valueOf(browser.toUpperCase()));
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

    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForPresence(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void searchUser(String name) {
        sendKeys(lSearchMenuUserNameBox, name);
        click(lSearchMenuSearchButton);
        waitForVisibility(By.xpath("//div[@class='oxd-table-row oxd-table-row--with-border' and .//.='" + name + "']"));
    }
}

package gun_03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import utils.Driver;

import java.time.Duration;

public class TestDataProvider01{

    WebDriver driver;
    WebDriverWait wait;

    By lUserName = By.cssSelector("input[name='username']");
    By lPassword = By.cssSelector("input[name='password']");
    By lSubmitButton = By.cssSelector("button[type='submit']");
    By lFailNotification = By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");
    By lSidePanel = By.cssSelector(".oxd-sidepanel");
    By lUserDropDown = By.cssSelector(".oxd-userdropdown");
    By lUserDropDownLogout = By.xpath(".//a[text()='Logout']");


    @Test(dataProvider = "getUsers")
    public void test1(String username, String password, boolean pass) {

        sendKeys(lUserName, username);
        sendKeys(lPassword, password);
        click(lSubmitButton);

        if (pass) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(lSidePanel));
            click(lUserDropDown);
            click(lUserDropDownLogout);
            wait.until(ExpectedConditions.visibilityOfElementLocated(lUserName));

        } else {
            wait.until(ExpectedConditions.visibilityOfElementLocated(lFailNotification));
        }
    }


    @DataProvider
    public Object[][] getUsers() {
        return new Object[][]
                {
                        {"Admin", "admin124", false},
                        {"Admin1", "admin12412", false},
                        {"Admin2", "admin124234332", false},
                        {"Admin3", "admin124234212", false},
                        {"Admin4", "admin124234121", false},
                        {"Admin5", "admin124234121", false},
                        {"Admin6", "admin124234121", false},
                        {"Admin7", "admin12423421", false},
                        {"Admin8", "admin12423412", false},
                        {"Admin9", "admin12423421", false},
                        {"Admin", "admin123", true},
                };
    }

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

    @BeforeMethod
    public void clearForm(){
        clear(lUserName);
        clear(lPassword);
    }

    public void sendKeys(By locator, String text){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(text);
    }
    public void click(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }

    public void clear(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).clear();
    }
}

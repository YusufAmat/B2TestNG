package gun_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;


public class Test1 {

    String url = "https://demowebshop.tricentis.com/";
    String myUsername = "abc123@aa.com";
    String myPassword = "123456";
    By lLoginFormUsername = By.id("Email");
    By lLoginFormPassword = By.id("Password");
    By lLoginFormSubmitButton = By.xpath("//input[@value='Log in']");
    By lLogout = By.xpath("//a[text()='Log out']");
    By lLogin = By.xpath("//a[text()='Log in']");
    WebDriver driver;
    WebDriverWait wait;


    @Test(priority = 0)
    public void gotoUrl() {
        // driver.get
        // title assert edilecek
        driver.get("https://demowebshop.tricentis.com/");
        wait.until(ExpectedConditions.titleContains("Demo"));
    }

    @Test(priority = 1)
    public void clickLinkLogin() {
        // log in linkine tiklanacak
        driver.findElement(lLogin).click();
    }

    @Test(priority = 2)
    public void fulfillloginForm() {
        // loginform dolduruacak
        driver.findElement(lLoginFormUsername).sendKeys(myUsername);
        driver.findElement(lLoginFormPassword).sendKeys(myPassword);

    }

    @Test(priority = 3)
    public void loginSubmitClick() {
        // loginform click butonuna tiklanacak
        driver.findElement(lLoginFormSubmitButton).click();
    }

    @Test(priority = 4)
    public void loginAssert() {
        // login olundugu assert edilecek
        wait.until(ExpectedConditions.presenceOfElementLocated(lLogout));
    }


    @BeforeClass
    public void setDrive() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterClass
    public void quitDriver() {
        driver.quit();
    }


}

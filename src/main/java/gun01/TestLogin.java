package gun01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;


public class TestLogin {

    String url = "https://demowebshop.tricentis.com/";
    String myUsername = "abc123@aa.com";
    String myPassword = "123456";
    By lLoginformUsername = By.id("Email");
    By lLoginformPassword = By.id("Password");
    By lLoginformSubmitButton = By.xpath("//input[@value='Log in']");
    By lLogout = By.xpath("//a[text()='Log out']");
    By lLogin = By.xpath("//a[text()='Log in']");
    WebDriver driver;
    WebDriverWait wait;

    @Test
    public void gotoUrl(){
        // driver.get
        // title assert edilecek
        driver.get(url);
    }

    @Test(dependsOnMethods = {"gotoUrl"})
    public void clickLinkLogin(){
        // log in linkine tiklanacak
        driver.findElement(lLogin).click();
    }

    @Test(priority = 2)
    public void fulfillloginForm(){
        // loginform dolduruacak
        driver.findElement(lLoginformUsername).sendKeys(myUsername);
        driver.findElement(lLoginformPassword).sendKeys(myPassword);
    }

    @Test(priority = 3)
    public void loginSubmitClick(){
        // loginform click butonuna tiklanacak
        driver.findElement(lLoginformSubmitButton).click();
    }

    @Test(priority = 4)
    public void loginAssert(){
        // login olundugu assert edilecek
        driver.findElement(lLogout);
    }


    @BeforeTest
    public void beforeTest(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }

}

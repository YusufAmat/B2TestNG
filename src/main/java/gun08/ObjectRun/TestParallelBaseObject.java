package gun08.ObjectRun;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import utils.Browsers;
import utils.Driver;

public class TestParallelBaseObject {

    protected WebDriver driver;
    protected WebDriverWait wait;


    @BeforeTest
    @Parameters("browser")
    public void beforeTest(String browser){
        switch (browser){

            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
        }
        driver.manage().window().maximize();
    }

    @AfterTest
    public void afterTest(){
        Driver.quitDriver();
    }



}

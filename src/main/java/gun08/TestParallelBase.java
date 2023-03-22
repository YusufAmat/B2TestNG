package gun08;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import utils.Browsers;
import utils.Driver;

public class TestParallelBase {

    protected WebDriver driver;
    protected WebDriverWait wait;


    @BeforeTest
    @Parameters("browser")
    public void beforeTest(String browser){

        driver = Driver.getDriver(Browsers.valueOf(browser));
        driver.manage().window().maximize();
    }

    @AfterTest
    public void afterTest(){
        Driver.quitDriver();
    }



}

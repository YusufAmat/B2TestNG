package gun08;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.Driver;

public class TestParallelBase {

    protected WebDriver driver;
    protected WebDriverWait wait;


    @BeforeTest
    public void beforeTest(){

        driver = Driver.getDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void afterTest(){
        Driver.quitDriver();
    }



}

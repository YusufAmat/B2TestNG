package gun08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        /*
            driver
            wait tanimla
         */
    }

    @AfterTest
    public void afterTest(){
        // quit
    }



}

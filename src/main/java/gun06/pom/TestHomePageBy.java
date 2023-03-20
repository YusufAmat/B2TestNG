package gun06.pom;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import utils.Driver;

public class TestHomePageBy {

    //WebDriver driver;

    HomePageBy homePage;

    @Test
    public void testSearch(){

        homePage = new HomePageBy();

        homePage.gotoUrl();
        homePage.search("mac");
        homePage.clickSearchButton();
        int num = homePage.getNumberOfListedProducts();
        System.out.println(num);


    }

    @AfterTest
    public void tearDown(){
        Driver.quitDriver();
    }


}

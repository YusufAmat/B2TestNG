package gun06.pom;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestHomePageBy {

    WebDriver driver;

    HomePageBy homePage;

    @Test
    public void testSearch(){

        homePage = new HomePageBy();

        homePage.gotoUrl();

    }



}

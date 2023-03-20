package gun06.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Driver;

public class HomePageBy {

    WebDriver driver;
    String url = "http://opencart.abstracta.us/";

    By lSearchBox = By.cssSelector("#search input");

    By lSearchButton = By.cssSelector("#search button");

    By lsearchedProducts = By.cssSelector(".product-layout");


    public HomePageBy(){
        driver = Driver.getDriver();
    }

    public void gotoUrl(){
        driver.get(url);
    }


}

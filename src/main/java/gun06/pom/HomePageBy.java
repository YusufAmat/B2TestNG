package gun06.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Driver;

import java.time.Duration;

public class HomePageBy {

    WebDriver driver;
    String url = "http://opencart.abstracta.us/";

    By lSearchBox = By.cssSelector("#search input");

    By lSearchButton = By.cssSelector("#search button");

    By lsearchedProducts = By.cssSelector(".product-layout");


    public HomePageBy(){
        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void gotoUrl(){
        driver.get(url);
    }

    public void search(String text){
        driver.findElement(lSearchBox).sendKeys(text);
    }

    public void clickSearchButton(){
        driver.findElement(lSearchButton).click();
    }

    public int getNumberOfListedProducts(){
        return driver.findElements(lsearchedProducts).size();
    }



}

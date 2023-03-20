package gun06.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class HomePage {

    WebDriver driver;

    String url = "http://opencart.abstracta.us/";

    @FindBy(css = "#search input")
    public WebElement searchBox;

    @FindBy(how = How.CSS, using = "#search button")
    public WebElement searchButton;

    @FindBy(css = ".product-layout")
    public List<WebElement> searhedProducts;

    public HomePage(){
        driver = Driver.getDriver();
        // @FindBy annotation ile tanimli elementleri initialize eder.
        PageFactory.initElements(driver, this);
    }

    public void gotoUrl(){
        driver.get(url);
    }

    public void search(String text){
        searchBox.sendKeys(text);
    }

    public void clickSearchButton(){
        searchButton.click();
    }

    public int getNumberOfListedProducts(){
        return searhedProducts.size();
    }





}

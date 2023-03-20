package gun06.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class HomePage {

    String url = "http://opencart.abstracta.us/";

    @FindBy(css = "#search input")
    public WebElement searchBox;

    @FindBy(how = How.CSS, using = "#search button")
    public WebElement searchButton;

    @FindBy(css = ".product-layout")
    public List<WebElement> searhedProducts;





}

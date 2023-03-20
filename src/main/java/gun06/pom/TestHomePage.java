package gun06.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utils.Driver;

public class TestHomePage {




    @Test
    public void search(){
        HomePage homePage;
        homePage = new HomePage();

        homePage.gotoUrl();
        homePage.search("mac");
        //homePage.clickSearchButton();
        homePage.searchButton.click();
        int num = homePage.getNumberOfListedProducts();
        System.out.println(num);

        Driver.quitDriver();
    }

    @Test
    public void search1(){
        HomePage homePage1 = PageFactory.initElements(Driver.getDriver(), HomePage.class);
        homePage1.gotoUrl();
        homePage1.searchBox.sendKeys("mac");
        homePage1.searchButton.click();
        int num = homePage1.searhedProducts.size();
        System.out.println(num);

        for (WebElement prod : homePage1.searhedProducts) {
            System.out.println(prod.getText());
        }

        String name = homePage1.searhedProducts.get(0)
                .findElement(By.cssSelector(".caption"))
                .findElement(By.cssSelector("h4"))
                .getText();
        System.out.println("::::: " + name);
        Driver.quitDriver();
    }


}

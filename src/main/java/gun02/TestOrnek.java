package gun02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TestOrnek extends TestOrnekBase{


    By lUsername = By.cssSelector("input[name='username']");
    By lPassword = By.cssSelector("input[name='password']");
    By lSubmitButton = By.cssSelector("button[type='submit']");
    By lSidePanel = By.cssSelector(".oxd-sidepanel");
    By lSidePanemAdmin = By.xpath(".//a[.='Admin']");
    By lDropdownRole = By.xpath(".//label[.='User Role']/ancestor::div[contains(@class,'oxd-grid-item')]");

    By lOptionAdmin = By.xpath(".//div[@role='option' and .='Admin']");
    By lSearchButton = By.xpath("//button[@type='submit' and contains(., 'Search')]");
    By lTableCell3 = By.xpath("//div[@role='table']//div[contains(@class,'oxd-table-cell')][3]");

    String url = "https://opensource-demo.orangehrmlive.com/";

    @BeforeTest
    public void gotoUrl(){
        driver.get(url);
    }

    @Test
    public void login(){
        sendKeys(lUsername, "Admin");
        sendKeys(lPassword, "admin123");
        click(lSubmitButton);

    }

    @Test(dependsOnMethods = {"login"})
    public void Test2(){
        click(lSidePanemAdmin);
        click(lDropdownRole);
        click(lOptionAdmin);
        click(lSearchButton);
        List<WebElement> list = driver.findElements(lTableCell3);
        long num = list.stream().filter(e->!e.getText().contains("Admin")).count();
        Assert.assertEquals(num, 0);
    }


    /*
        BeforeSuite
            driver, wait set edin
        BeforeTest
            https://opensource-demo.orangehrmlive.com/  gidin

        Test 1
            login :
        Test 2
            Menüden admin'e tikla
            User Role -> Admin  secin
            Search edilecek
            Listelenen kullanicilarin tümünün User Rolü'nünü Admin oldugu assert edilecek


        AfterSuite
            TearDown
     */


}

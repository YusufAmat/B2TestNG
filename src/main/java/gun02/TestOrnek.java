package gun02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static gun02.Locators.*;

public class TestOrnek extends TestOrnekBase{



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

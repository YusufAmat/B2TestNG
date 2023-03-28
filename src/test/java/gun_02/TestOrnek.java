package gun_02;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static gun_02.Locator.*;

import java.util.List;

public class TestOrnek extends TestOrnekBase1 {

    //login:
    @Test
    public void test1() {
        sendKeys(lUserName, "Admin");
        sendKeys(lPassword, "admin123");
        click(lSubmitButton);
        wait.until(ExpectedConditions.presenceOfElementLocated(lSidePanel));
    }

    /*
            Menüden admin'e tikla
            User Role -> Admin  secin
            Search edilecek
            Listelenen kullanicilarin tümünün User Rolü'nünü Admin oldugu assert edilecek
    */
    @Test
    public void test2() {
        click(lLeftMenuAdmin);
        click(lUserRoleSelect);
        click(lUserRoleSelectAdmin);
        click(lSearchButton);
        List<WebElement> userRoleAdmin = driver.findElements(lUserRoleAdmin);
        for (WebElement element : userRoleAdmin) {
            Assert.assertEquals(element.getText(), "Admin");
        }
    }
}

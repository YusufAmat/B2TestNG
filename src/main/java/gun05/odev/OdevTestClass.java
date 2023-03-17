package gun05.odev;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static gun05.odev.Locators.*;

public class OdevTestClass extends OdevBaseClass{

    String url = "https://opensource-demo.orangehrmlive.com/";


    @Test
    public void testLogin(){


        driver.get(url);
        sendKeys(xpath(INPUT, "Username"), "admin");
        sendKeys(xpath(INPUT, "Password"), "admin123");
        click(xpath(BUTTON, "Login"));

        click(xpath(MENU_LINK, "Admin"));

        click(xpath(BUTTON, "Add"));

        click(xpath(DROPDOWN, "User Role"));
        click(xpath(DROPDOWN_OPTION, "ESS"));

        click(xpath(DROPDOWN, "Status"));
        click(xpath(DROPDOWN_OPTION, "Enabled"));

        sendKeys(xpath(INPUT, "Employee Name"),"cecil");
        click(xpath(DROPDOWN_OPTION, "Cecil"));

        sendKeys(xpath(INPUT, "Username"), "Ahmet" + RandomStringUtils.randomAlphabetic(3));
        sendKeys(xpath(INPUT, "Password"), "UserAhmet.123");
        sendKeys(xpath(INPUT, "Confirm Password"), "UserAhmet.123");

        wait.until(ExpectedConditions.numberOfElementsToBe(erroMessages, 0));
        click(xpath(BUTTON, "Save"));
    }


}

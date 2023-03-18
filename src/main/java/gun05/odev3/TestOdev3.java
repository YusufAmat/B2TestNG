package gun05.odev3;

import gun05.odev3.controls.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static gun05.odev3.controls.Statics.*;

public class TestOdev3 extends BaseOdev3 {

    String newUsername;
    String newPassword;

    @Test
    public void gotoURL() {
        driver.get(url);
        wait.until(ExpectedConditions.titleIs(siteTitle));
    }

    @Test(dependsOnMethods = {"gotoURL"})
    public void testLogin() {
        InputActions.sensKeys("Username", myUsername);
        InputActions.sensKeys("Password", myPassword);
        ButtonActions.click("Login");
    }

    @Test(dependsOnMethods = {"testLogin"}, priority = 1)
    public void addUser() {
        MenuActions.click("Admin");
        ButtonActions.click("Add");
        DropDownActions.click("User Role");
        DropDownOptionActions.click("ESS");
        DropDownActions.click("Status");
        DropDownOptionActions.click("Enabled");

        InputActions.sensKeys("Employee Name", "cecil");
        DropDownOptionActions.click("Cecil");

        newUsername = "Ahmet" + RandomStringUtils.randomAlphabetic(3);
        newPassword = "Aa123." + RandomStringUtils.randomAlphabetic(5);

        InputActions.sensKeys("Username", newUsername);
        InputActions.sensKeys("Password", newPassword);
        InputActions.sensKeys("Confirm Password", newPassword);

        wait.until(ExpectedConditions.numberOfElementsToBe(erroMessages, 0));
        ButtonActions.click("Save");
        notificationIsShownWithText("Successfull");
    }

    @Test(dependsOnMethods = {"addUser"}, priority = 2)
    public void updateUser() {
        MenuActions.click("Admin");
        InputActions.sensKeys("Username", newUsername);
        ButtonActions.click("Search");
        TableActions.clickEdit(newUsername);
        newUsername+="1";
        InputActions.sensKeys("Username", "1");
        sleep(1000);
        ButtonActions.click("Save");
        notificationIsShownWithText("Successfull");
    }

    @Test(dependsOnMethods = {"addUser"}, priority = 3)
    public void deleteUser() {
        MenuActions.click("Admin");
        InputActions.sensKeys("Username", newUsername);
        ButtonActions.click("Search");
        TableActions.clickDelete(newUsername);
        ButtonActions.click("No, Cancel");
        TableActions.clickDelete(newUsername);
        ButtonActions.click("Yes, Delete");
        notificationIsShownWithText("Successfull");
    }


}

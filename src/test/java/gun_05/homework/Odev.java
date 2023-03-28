package gun_05.homework;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static gun_05.homework.OdevLocators.*;

public class Odev extends OdevBase {
    @Test(priority = 0)
    public void gotoUrl() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        wait.until(ExpectedConditions.titleIs("OrangeHRM"));
    }

    @Test(dependsOnMethods = "gotoUrl")
    public void login() {
        sendKeys(lUsername, "Admin");
        sendKeys(lPassword, "admin123");
        click(lSubmitButton);
        waitForVisibility(lSidePanelAdmin);
    }

    @Test(dependsOnMethods = "login")
    public void addUser() {
        click(lSidePanelAdmin);
        click(lAddButton);

        click(lSelectUserRole);
        click(lSelectUserRoleAdmin);
        click(lInputEmployeeName);
        sendKeys(lInputEmployeeName, "p");
        waitForVisibility(lEmployeeListBox);
        click(lEmployeeCecil);
        click(lSelectStatus);
        click(lSelectStatusEnabled);
        sendKeys(lNewUserName, "Yusuf");
        new Actions(driver).sendKeys(Keys.TAB).sendKeys("Deneme.1")
                .sendKeys(Keys.TAB).sendKeys("Deneme.1")
                .pause(2000).build().perform();
        click(lSaveButton);
        waitForVisibility(lAddButton);
        searchUser("Yusuf");
    }

    @Test(dependsOnMethods = "addUser")
    public void editUserName() {
        waitForVisibility(lEditButton);
        click(lEditButton);
        WebElement editUserName = waitForPresence(lEditUserName);
        sleep(2000);
        new Actions(driver).click(editUserName).pause(2000)
                .sendKeys("1").pause(2000).build().perform();
        click(lSaveButton);

    }

    @Test(dependsOnMethods = "editUserName")
    public void deleteNewUser() {
        waitForVisibility(lAddButton);
        sleep(2000);
        searchUser("Yusuf1");
        click(lDeleteButton);
        click(lYesDeleteButton);
        waitForPresence(lNoRecordsFound);
    }

}

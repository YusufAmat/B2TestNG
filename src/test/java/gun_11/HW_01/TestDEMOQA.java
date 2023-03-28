package gun_11.HW_01;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static gun_11.HW_01.LocatorsDEMOQA.*;
 /*
    https://demoqa.com/webtables

    1.  https://demoqa.com/webtables
    2.  Tablodaki tüm verileri siliyoruz
    3.  3 adet yeni veri giriyoruz (DataProvider ile)
    4.  FirstName e göre siraliyoruz ve screenschot aliyoruz.
     */

public class TestDEMOQA extends TestBaseDEMOQA {

    @Test
    public void gotoUrl() {
        driver.get(url);
        wait.until(ExpectedConditions.titleIs("DEMOQA"));

    }

    @Test(dependsOnMethods = "gotoUrl")
    public void deleteData() {
        int size = driver.findElements(lDeleteButtons).size();
        for (int i = 0; i < size; i++) {
            click((xpath(DELETE, i+1)));
        }
    }


    @Test(dependsOnMethods = "deleteData", dataProvider = "getData")
    public void addNewData(String firstName, String lastName, String eMail, String age, String salary, String department) {
        click(lAddNewRecordButton);
        sendKeys(lFirstName, firstName);
        sendKeys(lLastName, lastName);
        sendKeys(lEMail, eMail);
        sendKeys(lAge, age);
        sendKeys(lSalary, salary);
        sendKeys(lDepartment, department);
        click(lRegistrationFormSubmitButton);

    }

    @Test(dependsOnMethods = "addNewData")
    public void sortByName(){
        click(lSortByName);
        sleep(2000);
    }

    @Test(dependsOnMethods = "sortByName")
    public void takeScreenShot(){
        tScreenShoot("DEMOQA");
    }


    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {"Saba", "Gitsin", "sgitsin@gmail.com", "55", "20000", "Department2"},
                {"Ahmet", "Dursun", "adursun@gmail.com", "50", "10000", "Department1"},
                {"Yilmaz", "Vural", "yvural@gmail.com", "60", "30000", "Department3"}

        };
    }
}

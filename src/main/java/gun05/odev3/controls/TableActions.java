package gun05.odev3.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

public class TableActions {

    private static final String XPATH_DELETE_BUTTON = "//div[@class='oxd-table-card' and .//div[contains(@class,'oxd-table-cell') and contains(., '%s')]]//button[1]";
    private static final String XPATH_EDIT_BUTTON = "//div[@class='oxd-table-card' and .//div[contains(@class,'oxd-table-cell') and contains(., '%s')]]//button[2]";

    private static By locatorEdit(String text){
        return By.xpath(String.format(XPATH_EDIT_BUTTON, text));
    }

    private static By locatorDelete(String text){
        return By.xpath(String.format(XPATH_DELETE_BUTTON, text));
    }

    public static void clickEdit(String text) {
        clickEdit(locatorEdit(text), 10);
    }

    public static void clickEdit(By locator, int waitSeconds) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(waitSeconds))
                .until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public static void clickDelete(String text) {
        clickDelete(locatorDelete(text), 10);
    }

    public static void clickDelete(By locator, int waitSeconds) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(waitSeconds))
                .until(ExpectedConditions.elementToBeClickable(locator)).click();
    }


}

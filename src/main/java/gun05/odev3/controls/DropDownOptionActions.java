package gun05.odev3.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

public class DropDownOptionActions {

    private static final String XPATH = "//div[@role='option' and .//*[contains(.,'%s')]]";


    private static By locator(String text){
        return By.xpath(String.format(XPATH, text));
    }

    public static void click(String text) {
        click(locator(text), 10);
    }

    public static void click(By locator, int waitSeconds) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(waitSeconds))
                .until(ExpectedConditions.elementToBeClickable(locator)).click();
    }


}

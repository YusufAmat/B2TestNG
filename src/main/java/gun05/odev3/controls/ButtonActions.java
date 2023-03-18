package gun05.odev3.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.text.MessageFormat;
import java.time.Duration;

public class ButtonActions {

    private static final String XPATH = "//button[contains(., '%s')]";


    private static By locator(String text){
        return By.xpath(String.format(XPATH, text));
    }

    public static void click(String text) {
        click(locator(text));
    }

    public static void click(By locator) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(locator)).click();
    }


}

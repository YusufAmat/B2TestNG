package gun05.odev;

import org.openqa.selenium.By;

public class Locators {
    public static final String INPUT = "//label[contains(text(),'%s')]/ancestor::div[starts-with(@class,'oxd-input-group')]//input";
    public static final String DROPDOWN = "//label[contains(text(),'%s')]/ancestor::div[starts-with(@class,'oxd-grid-item')]//div[@class='oxd-select-wrapper']";
    public static final String DROPDOWN_OPTION = "//div[@role='option' and .//*[contains(.,'%s')]]";
    public static final String BUTTON = "//button[contains(., '%s')]";
    public static final String MENU_LINK = "//aside//a[contains(., '%s')]";

    public static final By erroMessages = By.cssSelector(".oxd-input-field-error-message");
}

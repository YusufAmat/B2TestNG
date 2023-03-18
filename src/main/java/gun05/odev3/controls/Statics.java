package gun05.odev3.controls;

import org.openqa.selenium.By;

public class Statics {
    public static final String url = "https://opensource-demo.orangehrmlive.com/";
    public static final String siteTitle = "OrangeHRM";
    public static final String myUsername = "admin";
    public static final String myPassword = "admin123";
    public static final By erroMessages = By.cssSelector(".oxd-input-field-error-message");
    public static final String NOTIFICATION = "//div[contains(@class,'oxd-toast-container') and ./*[contains(.,'%s')]]";

}

package gun_02;

import org.openqa.selenium.By;

public class Locator {
    public static final By lUserName = By.cssSelector("input[name='username']");
    public static final By lPassword = By.cssSelector("input[name='password']");
    public static final By lSubmitButton = By.cssSelector("button[type='submit']");
    public static final By lSidePanel = By.cssSelector(".oxd-sidepanel");
    public static final By lLeftMenuAdmin = By.xpath("//span[text()='Admin']");
    public static final By lUserRoleSelect = By.xpath("(//div[text()='-- Select --'])[1]");
    public static final By lUserRoleSelectAdmin = By.xpath("//div[@class='oxd-select-option']//span[.='Admin']");
    public static final By lSearchButton = By.xpath("//button[@type='submit']");
    public static final By lUserRoleAdmin = By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-cell oxd-padding-cell'][3]");
}

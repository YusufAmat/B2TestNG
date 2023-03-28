package gun_08;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

public class Homepage01 {

    private WebDriver driver;
    private WebDriverWait wait;

    public Homepage01() {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public Homepage01(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    String url = "http://opencart.abstracta.us/";

    @FindBy(xpath = "//div[@id = 'top-links']//a[contains(., 'My Account' )]")
    public WebElement eMyAccountLink;

    @FindBy(xpath = "//div[@id = 'top-links']//a[contains(., 'Login' )]")
    public WebElement eMyAccountLoginLink;

    @FindBy(id = "input-email")
    public WebElement eLoginFormUserName;

    @FindBy(name = "password")
    public WebElement eLoginFormPassword;

    @FindBy(xpath = "//input[@value = 'Login']")
    public WebElement eLoginFormLoginButton;

    @FindBy(xpath = "//aside[@id = 'column-right']//a[contains(., 'Logout' )]")
    public WebElement eSideMenuLogout;

    @FindBy(xpath = "//aside[@id = 'column-right']//a[contains(., 'Login' )]")
    public WebElement eSideMenuLogin;


    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void sendKeys(WebElement element, String text) {
        waitUntilVisible(element).sendKeys(text);
    }

    public WebElement waitUntilVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void gotoUrl() {
        driver.get(url);
    }

    public void login() {
        waitUntilVisible(eMyAccountLink);
        click(eMyAccountLink);
        waitUntilVisible(eMyAccountLoginLink);
        click(eMyAccountLoginLink);
        sendKeys(eLoginFormUserName, "deneme@deneme.com");
        sendKeys(eLoginFormPassword, "deneme");
        click(eLoginFormLoginButton);
        waitUntilVisible(eSideMenuLogout);

    }

    public void logout() {
        click(eSideMenuLogout);
        waitUntilVisible(eSideMenuLogin);
    }
}

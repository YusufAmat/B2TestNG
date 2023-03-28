package gun_11.HW_02;

import org.openqa.selenium.By;

public class LocatorsCalculator {
    public static final String url = "https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html";
    public static final String NUMBER = "//div[@class='keys']//span[text()='%d']";
    public static final String OPERATOR = "//div[@class='keys']//span[text()='%s']";
    public static final By lWait = By.id("delay");
    public static final By lClear = By.cssSelector(".clear");
    public static final By lWaitResult = By.cssSelector("//span[@style ='display: none;']");
}

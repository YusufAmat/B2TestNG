package gun_11.HW_01;

import org.openqa.selenium.By;

public class LocatorsDEMOQA {
    public static final String url = "https://demoqa.com/webtables";
    public static final String DELETE = "//span[@id='delete-record-%d']";
    public static final By lDeleteButtons = By.xpath("//div[@class='rt-tr-group']//span[2]");
    public static final By lAddNewRecordButton = By.id("addNewRecordButton");
    public static final By lFirstName = By.cssSelector("#firstName-wrapper input");
    public static final By lLastName = By.cssSelector("#lastName-wrapper input");
    public static final By lEMail = By.cssSelector("#userEmail-wrapper input");
    public static final By lAge = By.cssSelector("#age-wrapper input");
    public static final By lSalary = By.cssSelector("#salary-wrapper input");
    public static final By lDepartment = By.cssSelector("#department-wrapper input");
    public static final By lRegistrationFormSubmitButton = By.cssSelector("#submit");
    public static final By lSortByName = By.xpath("//div[text()='First Name']");
}

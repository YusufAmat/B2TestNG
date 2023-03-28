package gun_05.homework;

import org.openqa.selenium.By;

public class OdevLocators {
    public static final String url = "https://opensource-demo.orangehrmlive.com/";
    public static final By lUsername = By.cssSelector("input[name='username']");
    public static final By lPassword = By.cssSelector("input[name='password']");
    public static final By lSubmitButton = By.cssSelector("button[type='submit']");
    public static final By lSidePanelAdmin = By.xpath(".//aside//a[.='Admin']");
    public static final By lAddButton = By.xpath("//button[.=' Add ']");
    public static final By lSelectUserRole = By.xpath("(//div[@class='oxd-select-text--after'])[1]");
    public static final By lSelectUserRoleAdmin = By.xpath("//div[@role='option']/span[text()='Admin']");
    public static final By lInputEmployeeName = By.xpath("//input[@placeholder='Type for hints...']");
    public static final By lEmployeeListBox = By.xpath("//div[@role='listbox']");
    public static final By lEmployeeCecil = By.xpath("//div[@role='listbox']//span[text()='Peter Mac Anderson']");
    public static final By lSelectStatus = By.xpath("(//div[@class='oxd-select-text--after'])[2]");
    public static final By lSelectStatusEnabled = By.xpath("//div[@role='option']/span[text()='Enabled']");
    public static final By lNewUserName = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    public static final By lSaveButton = By.xpath("//button[@type='submit']");
    public static final By lSearchMenuUserNameBox = By.cssSelector(".oxd-form-row .oxd-input");
    public static final By lSearchMenuSearchButton = By.xpath("//button[@type='submit']");
    public static final By lEditButton = By.xpath("//button[@class='oxd-icon-button oxd-table-cell-action-space' and .//i[@class='oxd-icon bi-pencil-fill']]");
    public static final By lDeleteButton = By.xpath("//button[@class='oxd-icon-button oxd-table-cell-action-space' and .//i[@class='oxd-icon bi-trash']]");
    public static final By lEditUserName = By.cssSelector(".oxd-form-row .oxd-input");
    public static final By lYesDeleteButton = By.xpath("//button[@type='button' and .//.=' Yes, Delete '] ");
    public static final By lNoRecordsFound = By.xpath("//span[text()='No Records Found'] ");


}

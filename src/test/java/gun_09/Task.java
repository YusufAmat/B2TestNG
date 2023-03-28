package gun_09;


import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task extends TaskBase {

    By lHeaderShop = By.xpath("//h1[text()='Shop']");
    By lFirstProduct = By.xpath("//ul[@class='products columns-4']//h2[contains(.,'Falcon 9')]");
    By lConfirm = By.xpath("//h1[contains(.,'Falcon 9')]");
    By lHome = By.xpath("(//a[contains(.,'Home')])[1]");

    @Test
    public void gotoUrl() {
        driver.get("https://demos.bellatrix.solutions/");
    }

    @Test(dependsOnMethods = {"gotoUrl"})
    public void test1() {
        waitUntilVisibility(lHeaderShop);
        String firstProductName = driver.findElement(lFirstProduct).getText();
        new Actions(driver).scrollByAmount(0,300).pause(1000).build().perform();
        click(lFirstProduct);
        waitUntilVisibility(lConfirm);
        String confirmFirstProductName = driver.findElement(lConfirm).getText();
        Assert.assertEquals(firstProductName, confirmFirstProductName);


    }
}

package gun_11.HW_02;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Random;

import static gun_11.HW_02.LocatorsCalculator.*;

/*
  https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html
  4 islem yapilacak
  Her islemde 5 ile 25 arasi random bekleme degeri siteye send edilecek
  Her islemde en az bu random bekleme süreki kadar wait olacak.
  Data provider kullaniniz (düzenlendi).
   */
public class TestCalculator extends TestBaseCalculator {

    @Test
    public void gotoUrl() {
        driver.get(url);
        wait.until(ExpectedConditions.titleContains("Hands"));

    }

    @Test(dependsOnMethods = "gotoUrl", dataProvider = "getDataCalculator")
    public void calculator(int num1, int num2, String operation) {
        switch (operation) {
            case "+":
                calculate(num1, num2, "+");
                break;
            case "-":
                calculate(num1, num2, "-");
                break;
            case "x":
                calculate(num1, num2, "x");
                break;
            case "÷":
                calculate(num1, num2, "÷");
                break;
        }
    }

    @DataProvider
    public Object[][] getDataCalculator() {
        return new Object[][]{
                {8, 7, "+"},
                {5, 3, "-"},
                {4, 2, "x"},
                {8, 2, "÷"}
        };
    }

    public void calculate(int num1, int num2, String operation) {
        int wait = new Random().nextInt(20)+5;
        sendKeys(lWait, Integer.toString(wait));
        click(xpath(NUMBER, num1));
        click(xpath(OPERATOR, operation));
        click(xpath(NUMBER, num2));
        click(xpath(OPERATOR, "="));
        sleep(wait*1000+2000);
        click(lClear);


    }
}

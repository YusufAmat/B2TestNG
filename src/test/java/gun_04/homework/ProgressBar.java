package gun_04.homework;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static gun_04.homework.ProgressBarLocator.*;

public class ProgressBar extends ProgresBarBase {

    @Test
    public void test0() {
        driver.get("https://demoqa.com/progress-bar");
        wait.until(ExpectedConditions.titleIs("DEMOQA"));
    }

    @Test
    public void test1(){
        click(lStartStopButton);
        //wait.pollingEvery(Duration.ofMillis(100));
        waitTextToBe(lProgressBar, "61%");
        click(lStartStopButton);
        new Actions(driver).pause(1000).build().perform();
        getScreenShot();
    }

    @Test
    public void test2(){
        click(lStartStopButton);
        waitForVisibility(lResetButton);
        new Actions(driver).pause(1000).build().perform();
        getScreenShot();
    }

    @Test()
    public void test3(){
        click(lResetButton);
        waitTextToBe(lProgressBar, "0%");
        new Actions(driver).pause(1000).build().perform();
        getScreenShot();
    }
}

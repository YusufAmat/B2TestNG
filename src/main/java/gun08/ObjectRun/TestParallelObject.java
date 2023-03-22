package gun08.ObjectRun;

import gun08.ThreadLocalRun.HomePage1;
import gun08.ThreadLocalRun.TestParallelBase;
import org.testng.annotations.Test;
import utils.Driver;


public class TestParallelObject extends TestParallelBase {

    HomePage2 hp;
    @Test
    public void test1(){
        hp = new HomePage2(driver);
        Driver.getDriver().get(hp.url);
    }

    @Test(dependsOnMethods = "test1")
    public void test2(){
        hp.login();
    }

    @Test(dependsOnMethods = "test2")
    public void test3(){
        hp.logout();
    }


}

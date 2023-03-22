package gun08;

import org.testng.annotations.Test;
import utils.Driver;


public class TestParallel extends TestParallelBase {

    HomePage1 hp;
    @Test
    public void test1(){
        hp = new HomePage1();
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

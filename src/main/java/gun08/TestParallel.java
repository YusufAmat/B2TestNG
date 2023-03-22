package gun08;

import org.testng.annotations.Test;

public class TestParallel extends TestParallelBase {

    HomePage hp = new HomePage();

    @Test
    public void test1(){
        hp.gotoUrl();
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

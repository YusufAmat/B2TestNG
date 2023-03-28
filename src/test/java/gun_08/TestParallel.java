package gun_08;

import org.testng.annotations.Test;

public class TestParallel extends TestParallelBase {
    Homepage01 hp;

    @Test
    public void Test1(){
        hp = new Homepage01();
        hp.gotoUrl();

    }

    @Test
    public void Test2(){
        hp.login();

    }

    @Test
    public void Test3(){
        hp.logout();

    }
}

package gun01;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Test1 {

    @Test
    public void test1(){
        int num = 1;
        Assert.assertEquals(num,1);
    }
}

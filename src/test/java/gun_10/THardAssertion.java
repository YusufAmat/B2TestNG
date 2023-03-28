package gun_10;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class THardAssertion {

    int i;

    @Test
    public void test1(){
        Assert.assertEquals(1,1, "Test1");
    }

    @Test
    public void test2(){
        Assert.assertEquals(1,2, "Test2");
        i++;
    }

    @Test
    public void test3(){
        Assert.assertEquals(2,1, "Test3");
    }

    @Test(dependsOnMethods = "test3")
    public void test4(){
        Assert.assertEquals(4,4, "Test4");
    }

    @Test
    public void test5(){
        Assert.assertEquals(5,5, "Test5");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("int i : " + i);
    }
}

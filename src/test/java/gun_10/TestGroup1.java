package gun_10;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TestGroup1 {

    int i;

    @Test(groups = "A")
    public void test1(){
        Assert.assertEquals(1,1, "Test1");
    }

    @Test(groups = "B")
    public void test2(){
        Assert.assertEquals(2,2, "Test2");
        i++;
    }

    @Test(groups = {"A", "B"})
    public void test3(){
        Assert.assertEquals(3,3, "Test3");
    }

    @Test(groups = "C")
    public void test4(){
        Assert.assertEquals(4,4, "Test4");
    }

    @Test(groups = "A")
    public void test5(){
        Assert.assertEquals(5,5, "Test5");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("int i : " + i);
    }
}

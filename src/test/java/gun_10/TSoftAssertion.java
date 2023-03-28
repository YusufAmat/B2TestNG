package gun_10;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class TSoftAssertion {

    SoftAssert softAssert = new SoftAssert();


    int i;

    @Test
    public void test1(){
        softAssert.assertEquals(1,1, "Test1");
    }

    @Test
    public void test2(){
        softAssert.assertEquals(1,2, "Test2");
        i++;
    }

    @Test
    public void test3(){
        softAssert.assertEquals(2,1, "Test3");
    }

    @Test(dependsOnMethods = "test3")
    public void test4(){
        softAssert.assertEquals(4,4, "Test4");
    }

    @Test
    public void test5(){
        softAssert.assertEquals(5,5, "Test5");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("int i : " + i);
        softAssert.assertAll();
    }
}

package gun01;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Test1Giris extends BaseClass{

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite");
    }

    @Test
    public void test3(){
        System.out.println("Test3");
    }


    @Test
    public void test1(){
        System.out.println("Test1");
    }

    @Test
    public void test2(){
        System.out.println("Test2");
    }


    // TestNG, bir öncelik ya da bagimlilik yoksa isim siralamasina göre run eder.
}

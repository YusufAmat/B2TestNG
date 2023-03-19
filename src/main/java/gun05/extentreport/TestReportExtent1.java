package gun05.extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestReportExtent1 {

    ExtentSparkReporter html;
    ExtentReports extentReport;
    ExtentTest test1;
    ExtentTest test2;
    ExtentTest test3;

    @BeforeTest
    public void setup(){
        html = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");
        extentReport = new ExtentReports();
        extentReport.attachReporter(html);
        test1 = extentReport.createTest("Test 1","Test Tanimi-1");
        test2 = extentReport.createTest("Test 2","Test Tanimi-2");
        test3 = extentReport.createTest("Test 3","Test Tanimi-3");
    }

    @AfterTest
    public void tearDown(){
        extentReport.setSystemInfo("Tester", "Ahmet");
        extentReport.setSystemInfo("OS", System.getProperty("os.name"));
        extentReport.setSystemInfo("Project Dir", System.getProperty("user.dir"));
        extentReport.flush();
    }


    @Test
    public void test1(){
        test1.info("Test1 basladi");
        try {
            Assert.assertEquals(1,1);
            test1.pass("Test 1 Passed");
        }catch (AssertionError e){
            test1.fail("Test1 failled, " + e.getMessage());
            Assert.fail(e.getMessage());
        }
        test1.info("Test 1 bitti");
    }

    @Test
    public void test2(){
        test2.info("Test 2 basladi");
        try {
            Assert.assertEquals(1,2);
            test2.pass("Test 2 Passed");
        }catch (AssertionError e){
            test2.fail("Test2 failled, " + e.getMessage());
            Assert.fail(e.getMessage());
        }
        test2.info("Test 2 bitti");
    }

    @Test
    public void test3(){
        test3.info("Test 3 basladi");
        try {
            Assert.assertEquals(1,1);
            test3.pass("Test 3 passed");
        }catch (AssertionError e){
            test3.fail("Test3 failled, " + e.getMessage());
            Assert.fail(e.getMessage());
        }
        test3.info("Test 3 bitti");
    }

}

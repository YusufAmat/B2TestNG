package gun_05;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestReportExtent_01 {

    ExtentSparkReporter html;
    ExtentReports extentReport;
    ExtentTest test1;

    @BeforeTest
    public void setup() {
        html = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");
        extentReport = new ExtentReports();
        extentReport.attachReporter(html);
        test1 = extentReport.createTest("Test 1");

    }

    @AfterTest
    public void tearDown() {
        extentReport.setSystemInfo("Tester", "Yusuf");
        extentReport.setSystemInfo("OS", System.getProperty("os.name"));
        extentReport.setSystemInfo("Project dir ", System.getProperty("user.dir"));
        extentReport.flush(); // Dosyayi kapattik. Acik lainca report olusmuyor.
    }


    @Test
    public void test1() {
        test1.info("Test 1 basladi");
        try {
            Assert.assertEquals(1, 1);
            test1.pass("Test 1 passed");
        } catch (AssertionError e) {
            test1.fail("Test 1 failed" + e.getMessage());
            Assert.fail(e.getMessage());
        }
        test1.info("Test 1 bitti");
    }


    @Test
    public void test2() {
        test1.info("Test 2 basladi");
        try {
            Assert.assertEquals(1, 2);
            test1.pass("Test 2 passed");
        } catch (AssertionError e) {
            test1.fail("Test 2 failed" + e.getMessage());
            Assert.fail(e.getMessage());
        }
        test1.info("Test 2 bitti");
    }


    @Test
    public void test3() {
        test1.info("Test 3 basladi");
        try {
            Assert.assertEquals(1, 1);
            test1.pass("Test 3 passed");
        } catch (AssertionError e) {
            test1.fail("Test 3 failed" + e.getMessage());
            Assert.fail(e.getMessage());
        }
        test1.info("Test 3 bitti");
    }
}

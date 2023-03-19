package gun05.extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReport1 {

    ExtentSparkReporter html;   // raporu html olarak kaydetmek icin
    ExtentReports extentReport; // rapor olusturmak icin
    ExtentTest test1;           // Test - 1
    ExtentTest test2;           // Test - 2
    ExtentTest test3;           // Test - 3
    // test :   bir veya daha fazla method'dan ya da
    //          bir veya daha fazla class'dan olusabilir

    @BeforeTest
    public void setup(){
        //  html kaydetme yeri belirtilir
        html = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/report.html");

        //  ExtentReports nesnesi olusturulur
        extentReport = new ExtentReports();

        //  html extentreport'a attach edilir. ExtentReports sonuclari bu html'e yazar
        extentReport.attachReporter(html);

        // raporu alinacak testler create edilir.
        test1 = extentReport.createTest("Test Suite 1", "Deneme-1 Testi");
        test2 = extentReport.createTest("Test Suite 2", "Deneme-2 Testi");
        test3 = extentReport.createTest("Test Suite 3", "Deneme-3 Testi");
    }

    @AfterTest
    public void teardown(){
        // setSystemInfo ile rapora istenilen bilgiler eklenir
        extentReport.setSystemInfo("QA Team", "GuiderSoft QA");
        extentReport.setSystemInfo("Isletim Systemi", System.getProperty("os.name"));
        extentReport.setSystemInfo("Isletim Systemi V", System.getProperty("os.version"));

        // rapor katatilir ve html olusturulur.
        extentReport.flush();
    }



    @Test
    public void test1(){
        // test1 icin rapora eklenecek log'lar asagidaki gibi eklenir
        test1.info("Test 1 started");
        test1.log(Status.INFO, "Status detail");
        try {
            Assert.assertEquals(1,1);
        }catch (AssertionError e){
            test1.fail(e.getMessage());
            Assert.fail();
        }
        test1.pass("passed");

    }

    @Test
    public void test2(){
        test2.info("Test 2 started");
        try {
            Assert.assertEquals(1,2);
        }catch (AssertionError e){
            test2.fail(e.getMessage());
            Assert.fail();
        }
        test2.pass("Passed");

    }

    @Test
    public void test3(){
        test3.info("Test 3 started");
        try {
            Assert.assertEquals(1,1);
        }catch (AssertionError e){
            test3.fail(e.getMessage());
            Assert.fail();
        }
        test3.pass("passed");
    }


}

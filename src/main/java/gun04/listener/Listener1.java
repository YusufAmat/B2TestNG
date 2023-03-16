package gun04.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener1 implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("test basladi");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Basarili, " + result.getName() + ", " + result.getStatus());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Basarisiz, " + result.getName() + ", " + result.getStatus());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Pas gecildi, " + result.getName() + ", " + result.getStatus());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Basladi, " + context.getName());

    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Bitti, " + context.getName());
    }
}

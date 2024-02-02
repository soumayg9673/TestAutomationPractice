package inittest;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest extends BaseClassTest implements ITestListener {
    @Override
    public void onFinish(ITestContext contextFinish) {
        System.out.println("onFinish method finished");
        driver.quit();

    }

    @Override
    public void onStart(ITestContext contextStart) {
        System.out.println("onStart method started");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Method failed with certain success percentage"+ result.getName());
        driver.quit();

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Method failed"+ result.getName());
        driver.quit();

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Method skipped"+ result.getName());

    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Method started"+ result.getName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Method passed"+ result.getName());

    }
}

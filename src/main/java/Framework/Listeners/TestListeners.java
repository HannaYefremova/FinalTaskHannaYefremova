package Framework.Listeners;

import Framework.Helpers.Helpers;
import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Log4j2
public class TestListeners implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("******************** The best test ever ********************");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Helpers.makeScreenShot(iTestResult.getName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext context) {

    }


    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}

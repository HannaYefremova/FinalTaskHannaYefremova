package framework.listeners;

import framework.helpers.Helpers;
import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Log4j2
public class TestListeners implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.info("Test " + iTestResult.getName() + "started.");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("Test " + iTestResult.getName() + "completed successfully.");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.info("Test " + iTestResult.getName() + "failed.");
        Helpers.makeScreenShot(iTestResult.getName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log.info("Test " + iTestResult.getName() + "was skipped.");
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
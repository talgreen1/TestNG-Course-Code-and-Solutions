package testng.samples._11_listeners._2_with;

import org.testng.*;

public class TestManager implements ISuiteListener, ITestListener {

//    @BeforeSuite
//    public void globalInit(){
//        System.out.println("Global Init");
//    }

    @Override
    public void onStart(ISuite suite) {
        System.out.println("On suite start");
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("On suite finish");
    }

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("On test failure");
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}

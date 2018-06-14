package testng.samples._13_iretryanalyzer.with_annotation;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry3Times implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int maxRetryCount = 3;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }

}

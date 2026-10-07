package com.pm.framework.Listener;
import com.microsoft.playwright.Page;
import com.pm.framework.diagonstics.TestExecutionState;
import com.pm.framework.driver.DriverManager;
import com.pm.framework.utils.TestNameUtil;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.pm.framework.diagonstics.diagonisticManager;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestListener implements  ITestListener{
    @Override
    public void onTestStart(ITestResult result) {

        String testName =
                TestNameUtil.getTestName(result);

        TestExecutionState.setTestName(testName);

        System.out.println(
                "TEST STARTED: " + testName
        );
    }

    @Override
    public void onTestFailure(ITestResult result) {

        TestExecutionState.markFailed();

        String testName =
                TestExecutionState.getTestName();

        System.out.println(
                "TEST FAILED: " + testName
        );

        diagonisticManager.captureScreenshot(
                testName
        );

        diagonisticManager.captureFailureDetails(
                testName,
                result.getThrowable()
        );
    }
}



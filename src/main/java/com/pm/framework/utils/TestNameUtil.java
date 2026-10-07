package com.pm.framework.utils;

import org.testng.ITestResult;

public class TestNameUtil {

    private TestNameUtil() {
        // Prevent object creation
    }

    public static String getTestName(
            ITestResult result) {

        String className =
                result.getTestClass()
                        .getRealClass()
                        .getSimpleName();

        String methodName =
                result.getMethod()
                        .getMethodName();

        String threadName =
                Thread.currentThread()
                        .getName();

        return className
                + "_"
                + methodName
                + "_"
                + threadName;
    }
}

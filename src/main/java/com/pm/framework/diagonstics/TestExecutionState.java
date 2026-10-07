package com.pm.framework.diagonstics;

public class TestExecutionState {

private static final ThreadLocal<Boolean> FAILED =
        ThreadLocal.withInitial(() -> false);

private static final ThreadLocal<String> TEST_NAME =
        new ThreadLocal<>();

private TestExecutionState() {
    // Prevent object creation
}

public static void markFailed() {
    FAILED.set(true);
}

public static boolean hasFailed() {
    return FAILED.get();
}

public static void setTestName(String testName) {
    TEST_NAME.set(testName);
}

public static String getTestName() {
    return TEST_NAME.get();
}

public static void clear() {
    FAILED.remove();
    TEST_NAME.remove();
}
}

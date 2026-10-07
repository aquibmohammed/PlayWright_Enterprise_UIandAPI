package com.pm.framework.diagonstics;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Tracing;
import com.pm.framework.driver.DriverManager;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class diagonisticManager {

    private static final String ARTIFACT_ROOT =
            "src/test/resources/test-artifacts";

    private diagonisticManager() {
        // Prevent object creation
    }

    public static void captureScreenshot(String testName) {

        Page page = DriverManager.getPage();

        if (page == null) {
            System.out.println(
                    "Screenshot skipped: Page is null"
            );
            return;
        }

        try {

            Path directory =
                    Paths.get(
                            ARTIFACT_ROOT,
                            "screenshots"
                    );

            Files.createDirectories(directory);

            Path screenshotPath =
                    directory.resolve(
                            testName + ".png"
                    );

            page.screenshot(
                    new Page.ScreenshotOptions()
                            .setPath(screenshotPath)
                            .setFullPage(true)
            );

            System.out.println(
                    "Screenshot saved: "
                            + screenshotPath
            );

        } catch (Exception e) {

            System.out.println(
                    "Screenshot capture failed: "
                            + e.getMessage()
            );
        }
    }

    public static void captureTrace(
            String testName) {

        if (DriverManager.getBrowserContext()== null) {
            System.out.println(
                    "Trace skipped: BrowserContext is null"
            );
            return;
        }

        try {

            Path directory =
                    Paths.get(
                            ARTIFACT_ROOT,
                            "traces"
                    );

            Files.createDirectories(directory);

            Path tracePath =
                    directory.resolve(
                            testName + ".zip"
                    );

            DriverManager.getBrowserContext()
                    .tracing()
                    .stop(
                            new Tracing.StopOptions()
                                    .setPath(tracePath)
                    );

            System.out.println(
                    "Trace saved: "
                            + tracePath
            );

        } catch (Exception e) {

            System.out.println(
                    "Trace capture failed: "
                            + e.getMessage()
            );
        }
    }

    public static void captureFailureDetails(
            String testName, Throwable throwable) {

        Page page = DriverManager.getPage();

        if (page == null) {
            return;
        }

        System.out.println(
                "Failed test: " + testName
        );

        System.out.println(
                "Current URL: " + page.url()
        );
    }
}

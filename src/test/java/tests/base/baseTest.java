package tests.base;

import com.microsoft.playwright.*;
import com.pm.framework.api.client.ApiClientManager;
import com.pm.framework.diagonstics.TestExecutionState;
import com.pm.framework.driver.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class baseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected APIRequestContext apiRequestContext;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {

        playwright = PlaywrightManager.createPlayWright();
        DriverManager.setPlaywright(playwright);

        browser = BrowserManager.launchBrowser(playwright);
        DriverManager.setBrowser(browser);

        context = BrowserContextManager.createBrowserContext(browser);
        DriverManager.setBrowserContext(context);

        page = PageManager.createPage(context);
        DriverManager.setPage(page);

        apiRequestContext =
                ApiClientManager.createApiContext(playwright);
        DriverManager.setApiRequestContext(apiRequestContext);

        System.out.println(
                "SETUP - Thread: "
                        + Thread.currentThread().getName()
        );
    }

    protected Page getPage() {
        return DriverManager.getPage();
    }

    protected APIRequestContext getApiRequestContext() {
        return DriverManager.getAPIRequestContext();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        BrowserContext context =
                DriverManager.getBrowserContext();

        Browser browser =
                DriverManager.getBrowser();

        Playwright playwright =
                DriverManager.getPlaywright();

        APIRequestContext apiRequestContext =
                DriverManager.getAPIRequestContext();

        try {

            /*
             * Stop Playwright tracing exactly once.
             */
            if (context != null) {

                String testName =
                        TestExecutionState.getTestName();

                if (testName == null || testName.isBlank()) {
                    testName =
                            getClass().getSimpleName();
                }

                Path traceDirectory =
                        Paths.get(
                                "target/test-artifacts/traces"
                        );

                Files.createDirectories(traceDirectory);

                Path tracePath =
                        traceDirectory.resolve(
                                testName + "_"
                                        + System.currentTimeMillis()
                                        + ".zip"
                        );

                context.tracing().stop(
                        new Tracing.StopOptions()
                                .setPath(tracePath)
                );

                System.out.println(
                        "Trace saved: " + tracePath
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Failed to save trace: "
                            + e.getMessage()
            );

        } finally {

            /*
             * Close API context.
             */
            if (apiRequestContext != null) {
                try {
                   // apiRequestContext.close();
                } catch (Exception e) {
                    System.out.println(
                            "Failed to close API context: "
                                    + e.getMessage()
                    );
                }
            }

            /*
             * Close browser context.
             */
            if (context != null) {
                try {
                    context.close();
                } catch (Exception e) {
                    System.out.println(
                            "Failed to close browser context: "
                                    + e.getMessage()
                    );
                }
            }

            /*
             * Close browser.
             */
            if (browser != null) {
                try {
                    browser.close();
                } catch (Exception e) {
                    System.out.println(
                            "Failed to close browser: "
                                    + e.getMessage()
                    );
                }
            }

            /*
             * Close Playwright.
             */
            if (playwright != null) {
                try {
                    playwright.close();
                } catch (Exception e) {
                    System.out.println(
                            "Failed to close Playwright: "
                                    + e.getMessage()
                    );
                }
            }

            /*
             * Remove all ThreadLocal driver references.
             */
            DriverManager.unload();

            /*
             * Remove test execution state from
             * the current TestNG worker thread.
             */
            TestExecutionState.clear();
        }
    }
}
package tests.base;

import com.microsoft.playwright.*;
import com.pm.framework.api.client.ApiClientManager;
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

    @BeforeMethod
    public void setUp(){
        playwright = PlaywrightManager.createPlayWright();
        DriverManager.setPlaywright(playwright);
        browser = BrowserManager.launchBrowser(playwright);
        DriverManager.setBrowser(browser);
        context = BrowserContextManager.createBrowserContext(browser);
        DriverManager.setBrowserContext(context);
        page = PageManager.createPage(context);
        DriverManager.setPage(page);
        apiRequestContext = ApiClientManager.createApiContext(playwright);
        DriverManager.setApiRequestContext(apiRequestContext);

        System.out.println(
                "SETUP - Thread: "
                        + Thread.currentThread().getName()
        );
    }
    protected Page getPage() {
        return DriverManager.getPage();
    }
    protected APIRequestContext getApiRequestContext(){
        return DriverManager.getAPIRequestContext();
    }

    @AfterMethod
    public void tearDown(){

        BrowserContext context =
                DriverManager.getBrowserContext();

        Browser browser =
                DriverManager.getBrowser();

        Playwright playwright =
                DriverManager.getPlaywright();

        if(context != null){
            String testName =
                    getClass().getSimpleName();

            Path traceDirectory =
                    Paths.get(
                            "target/test-artifacts/traces"
                    );

            try {

                Files.createDirectories(traceDirectory);

                Path tracePath =
                        traceDirectory.resolve(
                                testName + "_" +
                                        System.currentTimeMillis() +
                                        ".zip"
                        );

                context.tracing().stop(
                        new Tracing.StopOptions()
                                .setPath(tracePath)
                );

                System.out.println(
                        "Trace saved: " + tracePath
                );

            } catch (Exception e) {

                System.out.println(
                        "Failed to save trace: "
                                + e.getMessage()
                );
            }
            context.close();
        }
        if(browser != null){
            browser.close();
        }
        if(playwright != null){
            playwright.close();
        }
        DriverManager.unload();
    }
}

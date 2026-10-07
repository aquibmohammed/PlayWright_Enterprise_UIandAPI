package com.pm.framework.driver;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Tracing;
import com.pm.framework.config.ConfigManager;

import java.nio.file.Paths;

public class BrowserContextManager {

    public static BrowserContext createBrowserContext(Browser browser){
        double timeout = Double.parseDouble(ConfigManager.get("timeout"));
        BrowserContext browserContext = browser.newContext(
                new Browser.NewContextOptions().setRecordVideoDir(
                        Paths.get("target/test-artifacts/videos")
                )
        );
        browserContext.setDefaultTimeout(timeout);
        browserContext.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true).setSnapshots(true).setSources(true));

        return  browserContext;
    }

}

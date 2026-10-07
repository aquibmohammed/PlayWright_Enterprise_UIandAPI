package com.pm.framework.driver;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.pm.framework.config.ConfigManager;
import org.slf4j.LoggerFactory;

import java.util.logging.Logger;


public class BrowserManager {
    private static final org.slf4j.Logger LOGGER =  LoggerFactory.getLogger(BrowserManager.class);
    public static Browser launchBrowser(Playwright playwright){

        String browserName = ConfigManager.get("browser").toLowerCase();
        boolean headless = Boolean.parseBoolean(ConfigManager.get("headless"));
        LOGGER.info(
                "Launching browser: {"+browserName+"}, headless: {"+headless+"}"
        );
        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions().setHeadless(headless);

        return switch (browserName){
            case "chromium" -> playwright.chromium().launch(options);
            case "firefox" -> playwright.firefox().launch(options);
            case "webkit" -> playwright.webkit().launch(options);
            default -> playwright.chromium().launch(options);
        };
    }
}

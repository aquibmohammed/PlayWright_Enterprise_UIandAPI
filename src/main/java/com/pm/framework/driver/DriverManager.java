package com.pm.framework.driver;

import com.microsoft.playwright.*;

public class DriverManager {
    private static final ThreadLocal<Playwright> PLAYWRIGHT = new ThreadLocal<>();
    private static final ThreadLocal<Browser> BROWSER = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> BROWSER_CONTEXT = new ThreadLocal<>();
    private static final ThreadLocal<Page> PAGE = new ThreadLocal<>();
    private static final ThreadLocal<APIRequestContext> API_REQUEST_CONTEXT = new ThreadLocal<>();


    private DriverManager() {
        // Prevent object creation
    }

    public  static void setPlaywright(Playwright playwright){
        PLAYWRIGHT.set(playwright);
    }
    public  static Playwright getPlaywright(){
        return PLAYWRIGHT.get();
    }
    public  static void setBrowser(Browser browser){
        BROWSER.set(browser);
    }
    public  static Browser getBrowser(){
        return BROWSER.get();
    }
    public  static void setBrowserContext(BrowserContext browserContext){
        BROWSER_CONTEXT.set(browserContext);
    }
    public  static BrowserContext getBrowserContext(){
        return BROWSER_CONTEXT.get();
    }
    public  static void setPage(Page page){
        PAGE.set(page);
    }
    public  static Page getPage(){
        return PAGE.get();
    }
    public  static void setApiRequestContext(APIRequestContext apiRequestContext){
        API_REQUEST_CONTEXT.set(apiRequestContext);
    }
    public  static APIRequestContext getAPIRequestContext(){
        return API_REQUEST_CONTEXT.get();
    }

    public static void unload(){
        PAGE.remove();
        BROWSER_CONTEXT.remove();
        BROWSER.remove();
        PLAYWRIGHT.remove();
        API_REQUEST_CONTEXT.remove();
    }
}

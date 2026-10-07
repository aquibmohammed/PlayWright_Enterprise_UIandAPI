package com.pm.framework.driver;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

public class PageManager {

    public static Page createPage(BrowserContext context){
        return context.newPage();
    }
}

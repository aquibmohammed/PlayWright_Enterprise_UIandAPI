package com.pm.framework.pages;

import com.microsoft.playwright.Page;
import com.pm.framework.config.ConfigManager;

public class BasePage {
    protected final Page page;

    protected BasePage (Page page){
        this.page = page;
    }

    public String getPageTitle(){
        return page.title();
    }
    public String getPageUrl(){
        return page.url();
    }
    public void naviageTo(String url){
        page.navigate(url);
    }
    protected void navigateToBaseUrl(){
        page.navigate(ConfigManager.get("baseUrl"));
    }
}

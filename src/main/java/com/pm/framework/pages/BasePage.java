package com.pm.framework.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitUntilState;
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
    public void naviageToUrl(String url){
        page.navigate(url,new Page.NavigateOptions().setWaitUntil(WaitUntilState.DOMCONTENTLOADED)
                .setTimeout(Double.parseDouble(ConfigManager.get("timeout"))));
    }
}

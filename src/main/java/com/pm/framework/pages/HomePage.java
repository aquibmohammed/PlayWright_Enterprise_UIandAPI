package com.pm.framework.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.pm.framework.components.HeadComponent;
import com.pm.framework.config.ConfigManager;

public class HomePage extends BasePage {
    private final HeadComponent header;

    public HomePage(Page page) {
        super(page);
        this.header = new HeadComponent(page);
    }


    public HomePage navigateToWebsite(){
        navigateToBaseUrl();
        return this;
    }
    public boolean ishomePageDisplayed(){

        return page.title().contains("Automation Exercise");
    }
    public void clicksSignupLogin(){
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Signup / Login")).click();
    }
    public void clickProducts(){
            page.locator("a[href='/products']").click();
    }
}

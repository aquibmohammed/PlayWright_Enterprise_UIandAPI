package com.pm.framework.pages;

import com.microsoft.playwright.Locator;
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
        naviageToUrl(ConfigManager.get("baseUrl"));
        return this;
    }
    public boolean ishomePageDisplayed(){
        return page.title().contains("Automation Exercise");
    }
    public LoginPage clicksSignupLogin(){
        header.clickSignupLogin();
        return new LoginPage(page);
    }
    public ProductPage clickProducts(){
            header.clickProducts();
            return new ProductPage(page);
    }

    public CartPage clickCart() {
        header.clickCart();
        return new CartPage(page);
    }

}

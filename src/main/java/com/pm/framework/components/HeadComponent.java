package com.pm.framework.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HeadComponent extends BaseComponent {
    private final Page page;

    public HeadComponent(Page page) {
        super(page, page.locator("header"));
        this.page = page;
    }

    private Locator link(String name){
        return root.getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName(name));
    }

    public void clickSignupLogin(){
       link("Signup / Login").click();

    }
    public void clickProducts(){
        link("Products").click();
    }
    public void clickCart(){
        link("Cart").click();
    }

    public void clickHome(){
        link("Home").click();
    }
}

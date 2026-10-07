package com.pm.framework.components;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HeadComponent {
    private final Page page;

    public HeadComponent(Page page) {
        this.page = page;
    }

    public void clickSignupLogin(){
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Signup /Login")).click();

    }
    public void clickProducts(){
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Products")).click();
    }
    public void clickCart(){
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Cart")).click();
    }

    public void clickHome(){
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Home")).click();
    }
}

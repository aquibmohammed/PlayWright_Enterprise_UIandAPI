package com.pm.framework.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.pm.framework.components.HeadComponent;

public class ProductDetailsPage extends BasePage{
   private final HeadComponent header;

    public ProductDetailsPage(Page page) {
        super(page);
        this.header = new HeadComponent(page);
    }

    public boolean isProductDetailsDisplayed(){
        return page.getByText("write a review ").isVisible();
    }

    public void addToCart(){
        page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Add to cart")).click();
    }
    public void increaseQty(int i){
        page.getByPlaceholder("quantity").fill(String.valueOf(i));
    }
    public String getProductName(){
        return page.locator(".product-information h2").textContent().trim();
    }

    public void clickCart(){
        header.clickCart();
    }

}

package com.pm.framework.pages;

import com.microsoft.playwright.Page;

public class CartPage extends BasePage{
    private final String cartRows = "#cart_info_table tbody tr";


    public CartPage(Page page) {
        super(page);
    }

    public boolean isCartDisplayed(Page page){
        return  page.getByText("Shopping Cart").isVisible();
    }

    public int getCartItemCount(){
        return page.locator(cartRows).count();
    }
    public String getProductName(int index){
        return page.locator(cartRows).nth(index).locator(".cart_description h4 a " ).textContent().trim();
    }
    public String getProductPrice(int index){
        return page.locator(cartRows).nth(index).locator("cart_price p").textContent().trim();
    }
    public String getProductQuantity(int index){
        return page.locator(cartRows).nth(index).locator("cart_quantity button").textContent().trim();
    }
}

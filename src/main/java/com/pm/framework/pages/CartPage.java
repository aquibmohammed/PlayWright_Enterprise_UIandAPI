package com.pm.framework.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.pm.framework.components.CartRow;

public class CartPage extends BasePage{
    private static final String cartRows = "#cart_info_table tbody tr";
    private final Locator cartRowsLocator;


    public CartPage(Page page) {
        super(page);
        this.cartRowsLocator = page.locator(cartRows);
    }

    public boolean isCartDisplayed(Page page){
        return  page.getByText("Shopping Cart").isVisible();
    }

    public int getCartItemCount(){
        return cartRowsLocator.count();
    }
    public CartRow getCartItem(int index){
        return  new CartRow(page,cartRowsLocator.nth(index));
    }
}

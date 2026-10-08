package com.pm.framework.components;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CartRow extends BaseComponent{
    private static final String PRODUCT_NAME = ".cart_description h4 a";
    private static final String CART_PRICE = ".cart_price p";
    private static final String CART_QUANTITY = ".cart_quantity button";

    public CartRow(Page page, Locator root) {
        super(page, root);
    }
    public String getProductName(){
        return getText(PRODUCT_NAME);
    }
    public String getCartPrice(){
        return  getText(CART_PRICE);
    }
    public String getCartQuantity(){
        return  getText(CART_QUANTITY);
    }

}

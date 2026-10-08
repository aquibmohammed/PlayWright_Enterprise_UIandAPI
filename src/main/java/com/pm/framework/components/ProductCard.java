package com.pm.framework.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.pm.framework.pages.ProductDetailsPage;
import com.pm.framework.pages.ProductPage;

public class ProductCard extends BaseComponent{

    private static final String PRODUCT_NAME =
            ".productinfo p";

    private static final String PRODUCT_PRICE =
            ".productinfo h2";

    private static final String VIEW_PRODUCT =
            "a[href*='/product_details/']";

    public ProductCard(Page page, Locator root) {
        super(page,root);
    }


    public String getName() {
        return getText(PRODUCT_NAME);
    }

    public String getPrice() {
        return getText(PRODUCT_PRICE);
    }

    public void clickAddToCart() {
        root.getByText("Add to cart").click();
    }

    public ProductDetailsPage clickViewProduct() {
        root.locator(VIEW_PRODUCT).click();
        return new ProductDetailsPage(page);
    }
}

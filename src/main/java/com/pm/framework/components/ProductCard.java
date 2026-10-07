package com.pm.framework.components;

import com.microsoft.playwright.Locator;

public class ProductCard {
    private final Locator card;

    public ProductCard(Locator card){
        this.card = card;
    }

    public String getName() {
        return card.locator(".productinfo p").textContent().trim();
    }

    public String getPrice() {
        return card.locator(".productinfo h2").textContent().trim();
    }

    public void clickAddToCart() {
        card.getByText("Add to cart").click();
    }

    public void clickViewProduct() {
        card.locator("xpath=following-sibling::div[@class = 'choose']").getByText("View Product").click();
    }

}

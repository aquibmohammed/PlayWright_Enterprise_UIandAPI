package com.pm.framework.components;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public abstract class BaseComponent {
    protected  final Page page;
    protected final Locator root;

    protected BaseComponent( Page page,Locator root) {
        this.root = root;
        this.page = page;
    }

    protected Locator locator(String selector) {
        return root.locator(selector);
    }

    protected String getText(String selector) {
        return locator(selector).textContent().trim();
    }

    protected boolean isVisible(String selector) {
        return locator(selector).isVisible();
    }
}

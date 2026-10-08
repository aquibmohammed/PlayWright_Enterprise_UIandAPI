package com.pm.framework.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.pm.framework.components.ProductCard;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends BasePage {
    private static final String PRODUCT_CARDS = ".single-products";

    private  final Locator productCardslocator;

    public ProductPage(Page page) {
        super(page);
        productCardslocator = page.locator(".single-products");
    }

    public boolean isProductPageDisplayed(){
        return page.url().contains("/products");
    }
    public int getProductCount() {
        return productCardslocator.count();
    }

    public ProductCard getProduct(int index) {
        return new ProductCard(page,
                productCardslocator.nth(index)
        );
    }


    public List<ProductCard> getAllProducts() {
        int count = getProductCount();
        List<ProductCard> products = new ArrayList<>();

        for(int i=0; i< count; i++){
            products.add(getProduct((i)));
        }
        return products;
    }
    public ProductDetailsPage clickViewProduct(int index ){
        return getProduct(index).clickViewProduct();
    }

    public void searchProduct(String productName){
        page.getByPlaceholder("Search Product").fill(productName);
        page.locator("#submit_search").click();
    }
    public boolean isSearchResultsDisplayed(){
        return  page.getByText("Search Products").isVisible();
    }
}

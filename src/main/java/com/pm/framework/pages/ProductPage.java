package com.pm.framework.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.pm.framework.components.ProductCard;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends BasePage {
    private  final Locator productCardslocator;

    public ProductPage(Page page) {
        super(page);
        productCardslocator = page.locator(".single-products");
    }


    public boolean isProductsPageDisplayed() {
        return page.url().contains("/products");
    }

    public int getProductCount() {
        return productCardslocator.count();
    }

    public ProductCard getProduct(int index) {
        Locator product = productCardslocator.nth(index);

        System.out.println("Product count: " + product.count());
        System.out.println("Product text: " + product.innerText());
        return new ProductCard(
                productCardslocator.nth(index)
        );
    }



    public List<ProductCard> getAllProducts() {

        List<ProductCard> products = new ArrayList<>();

        int count = productCardslocator.count();

        for (int i = 0; i < count; i++) {

            products.add(
                    new ProductCard(
                            productCardslocator.nth(i)
                    )
            );
        }

        return products;
    }
    public void clickViewProduct(int index ){
        ProductCard pc = new ProductCard(productCardslocator.nth(index));
        pc.clickViewProduct();
    }

    public void searchProduct(String productName){
        page.getByPlaceholder("Search Product").fill(productName);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit"));
    }
    public boolean isSearchResultsDisplayed(){
        return  page.getByText("Search Products").isVisible();
    }
}

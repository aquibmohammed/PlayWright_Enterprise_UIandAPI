package tests.ui;

import com.pm.framework.Listener.TestListener;
import com.pm.framework.components.ProductCard;
import com.pm.framework.pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tests.base.baseTest;

@Listeners(TestListener.class)
@Severity(SeverityLevel.NORMAL)

public class CartTest extends baseTest {

    @Test(groups = {"e2e","ui","regression"})
    public void verfiyProductCanBeAddedToCart(){
        HomePage homePage = new HomePage(getPage());
        LoginPage loginPage = new LoginPage(getPage());
        homePage.navigateToWebsite();
        homePage.clicksSignupLogin();
        loginPage.clickLogin();
        loginPage.enterEmail("123testsss@gmail.com");
        loginPage.enterPassword("123456");
        loginPage.clickLogin();
        homePage.clickProducts();
        homePage.ishomePageDisplayed();
        homePage.clickProducts();
        ProductPage productPage = new ProductPage(getPage());
        //productPage.isProductsPageDisplayed();
        ProductCard productCard = productPage.getProduct(5);
        productCard.clickViewProduct();
        ProductDetailsPage pg = new ProductDetailsPage(getPage());
        String productName = pg.getProductName();
        pg.addToCart();
        pg.clickCart();


        CartPage cartPage = new CartPage(getPage());
        cartPage.isCartDisplayed(getPage());

        Assert.assertEquals(cartPage.getProductName(2), productName,
                "Cart should contain the selected product"
        );

        Assert.assertTrue(
                false,
                "Intentional failure for diagnostic testing"
        );
    }
}

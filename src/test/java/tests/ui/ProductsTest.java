package tests.ui;

import com.pm.framework.components.ProductCard;
import com.pm.framework.config.ConfigManager;
import com.pm.framework.pages.HomePage;
import com.pm.framework.pages.LoginPage;
import com.pm.framework.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import tests.base.baseTest;

public class ProductsTest extends baseTest {

    @Test(groups = {"smoke","ui"})
    public void verifyProductsPage() {
        HomePage homePage = new HomePage(page);
        homePage.navigateToWebsite();
        ProductPage productsPage = homePage.clickProducts();
//        Assert.assertTrue(
//                productsPage.isProductsPageDisplayed(),
//                "Products page should be displayed"
//        );

        Assert.assertTrue(
                productsPage.getProductCount() > 0,
                "Products page should contain products"
        );
    }

    @Test(groups = {"regression","ui"})
    public void verifyFirstProduct(){
        HomePage homePage = new HomePage(page);
        homePage.navigateToWebsite();
        LoginPage loginPage = homePage.clicksSignupLogin();
        if(loginPage.isLoginPageDisplayed()) {
            loginPage.LoginUser("123testsss@gmail.com","123456");
        }
        ProductPage productPage = homePage.clickProducts();
        ProductCard firstProduct = productPage.getProduct(0);
        Assert.assertFalse(firstProduct.getName().isBlank(),"Product Name should not be empty");

        Assert.assertFalse(
                firstProduct.getPrice().isBlank(),
                "Product price should not be empty"
        );

        System.out.println(
                "Product: " + firstProduct.getName()
        );
        System.out.println(
                "Price: " + firstProduct.getPrice()
        );
    }
}

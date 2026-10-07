package tests.ui;

import com.pm.framework.pages.HomePage;
import com.pm.framework.pages.LoginPage;
import com.pm.framework.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.baseTest;

public class SearchTest extends baseTest {
    @Test
    public void searchProduct(){
        HomePage homePage = new HomePage(getPage());

        homePage.navigateToWebsite();
        homePage.ishomePageDisplayed();
        homePage.clicksSignupLogin();
        LoginPage loginPage = new LoginPage(getPage());
        if(loginPage.isLoginPageDisplayed()) {
            loginPage.enterEmail("123testsss@gmail.com");
            loginPage.enterPassword("123456");
            loginPage.clickLogin();
        }
        homePage.clickProducts();
        ProductPage productPage = new ProductPage(getPage());
        productPage.searchProduct("Men Tshirt");
        Assert.assertTrue(productPage.isProductsPageDisplayed(),"Search results should be displayed");
    }
}

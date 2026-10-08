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
        LoginPage loginPage = homePage.clicksSignupLogin();
        if(loginPage.isLoginPageDisplayed()) {
            loginPage.LoginUser("123testsss@gmail.com","123456");
        }
        ProductPage productPage = homePage.clickProducts();
        productPage.searchProduct("Men Tshirt");
      //  Assert.assertTrue(productPage.isProductsPageDisplayed(),"Search results should be displayed");
    }
}

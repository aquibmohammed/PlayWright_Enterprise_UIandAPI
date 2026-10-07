package tests.ui;

import com.pm.framework.pages.HomePage;
import com.pm.framework.pages.LoginPage;
import com.sun.source.tree.AssertTree;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.baseTest;

public class LoginTest extends baseTest {


    @Test(groups ={ "smoke","ui"})
    public void loginTowebsite(){
        HomePage homePage = new HomePage(getPage());
        homePage.navigateToWebsite();
        homePage.clicksSignupLogin();
        LoginPage loginPage = new LoginPage(getPage());
        if(loginPage.isLoginPageDisplayed()){
            loginPage.enterEmail("123testsss@gmail.com");
            loginPage.enterPassword("123456");
            loginPage.clickLogin();
            Assert.assertFalse(loginPage.ErrorMessageisVisible(),"Error message should be displayed");

        };
    }

    @Test(groups = {"regression", "ui"})
    public void loginTowebsiteWithWrongCredentials(){
    HomePage homePage = new HomePage(getPage());
        homePage.navigateToWebsite();
        homePage.clicksSignupLogin();
    LoginPage loginPage = new LoginPage(getPage());
        if(loginPage.isLoginPageDisplayed()){
        loginPage.enterEmail("123testsss@gmail.com");
        loginPage.enterPassword("12345678");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.ErrorMessageisVisible(),"Error message should be displayed");
        System.out.println(loginPage.getErrorMessage());
    };
    }
}

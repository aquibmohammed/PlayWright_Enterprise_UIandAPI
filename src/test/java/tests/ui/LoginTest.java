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
        LoginPage loginPage = homePage.clicksSignupLogin();
        if(loginPage.isLoginPageDisplayed()){
            loginPage.LoginUser("123testsss@gmail.com", "123456");
            Assert.assertFalse(loginPage.ErrorMessageisVisible(),"Error message should be displayed");
        };
    }

    @Test(groups = {"regression", "ui"})
    public void loginTowebsiteWithWrongCredentials(){
    HomePage homePage = new HomePage(getPage());
        homePage.navigateToWebsite();
    LoginPage loginPage = homePage.clicksSignupLogin();
        if(loginPage.isLoginPageDisplayed()) {
            loginPage.LoginUser("123testsss@gmail.com",
                    "123456");
        }
        Assert.assertTrue(loginPage.ErrorMessageisVisible(),"Error message should be displayed");
        System.out.println(loginPage.getErrorMessage());
    };
}


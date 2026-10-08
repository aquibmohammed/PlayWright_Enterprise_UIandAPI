package tests.ui;

import com.pm.framework.config.ConfigManager;
import com.pm.framework.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.baseTest;

public class HomePageTest extends baseTest {

    @Test(groups = {"smoke", "ui"})
    public void verifyhomePage(){
        getPage().navigate(ConfigManager.get("baseUrl"));
        HomePage homePage = new HomePage(getPage());
        Assert.assertTrue(homePage.ishomePageDisplayed(),"Home Page should be displayed");
        //return homePage;
    }
}
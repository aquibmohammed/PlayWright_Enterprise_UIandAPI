package tests.ui;

import com.microsoft.playwright.Page;
import com.pm.framework.config.ConfigManager;
import com.pm.framework.pages.HomePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.baseTest;

public class HomePageTest extends baseTest {
    private static final Logger log = LoggerFactory.getLogger(HomePageTest.class);
    HomePage homePage = new HomePage(getPage());

    @Test(groups = {"smoke", "ui"})
    public HomePage verifyhomePage(){
        getPage().navigate(ConfigManager.get("baseUrl"));
        String title = getPage().title();
        Assert.assertTrue(homePage.ishomePageDisplayed(),"Home Page should be displayed");
        return homePage;
    }
}

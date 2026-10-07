package tests.base;

import com.microsoft.playwright.*;
import com.pm.framework.api.client.ApiClientManager;
import com.pm.framework.driver.DriverManager;
import com.pm.framework.driver.PlaywrightManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

public class ApiBaseTest {

    @BeforeTest
    public void setup() {
        Playwright playwright = PlaywrightManager.createPlayWright();
        DriverManager.setPlaywright(playwright);
        APIRequestContext apiRequestContext = ApiClientManager.createApiContext(playwright);
    }

    protected APIRequestContext getAPIContext(){
        return DriverManager.getAPIRequestContext();
    }

    @AfterMethod
    public void tearDownApi(){
        APIRequestContext apiRequestContext = DriverManager.getAPIRequestContext();

        Playwright playwright = DriverManager.getPlaywright();

        if(apiRequestContext !=null){
            apiRequestContext.dispose();
        }
        if(playwright !=null){
            playwright.close();
        }
        DriverManager.unload();
    }
}

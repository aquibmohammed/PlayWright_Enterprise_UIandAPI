package tests.api;

import com.microsoft.playwright.APIResponse;
import com.pm.framework.api.client.AuthApiClient;
import com.pm.framework.api.validation.ApiAssertions;
import com.pm.framework.config.ConfigManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import tests.base.ApiBaseTest;

public class AuthApiTest extends ApiBaseTest {

    @Test(groups = {"smoke", "api"})
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that a valid user can authenticate through the API")
    public void verifyLoginApi() {

        String email =
                ConfigManager.get("test.user.email");

        String password =
                ConfigManager.get("test.user.password");

        AuthApiClient authApi =
                new AuthApiClient(getAPIContext());

        APIResponse response =
                authApi.verifyLogin(
                        email,
                        password
                );

        ApiAssertions.assertStatusCode(
                response,
                200
        );

        ApiAssertions.assertSussessfulResponse(
                response
        );
    }
}


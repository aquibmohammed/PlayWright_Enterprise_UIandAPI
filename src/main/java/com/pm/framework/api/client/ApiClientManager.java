package com.pm.framework.api.client;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;
import com.pm.framework.config.ConfigManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ApiClientManager {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(ApiClientManager.class);

    private ApiClientManager() {
        // Prevent object creation
    }

    public static APIRequestContext createApiContext(
            Playwright playwright) {

        String baseUrl =
                ConfigManager.get("baseUrl");

        LOGGER.info(
                "Creating API request context with base URL: {}",
                baseUrl
        );

        APIRequest.NewContextOptions options =
                new APIRequest.NewContextOptions()
                        .setBaseURL(baseUrl);

        APIRequest apiRequest =
                playwright.request();

        return apiRequest.newContext(options);
    }
}
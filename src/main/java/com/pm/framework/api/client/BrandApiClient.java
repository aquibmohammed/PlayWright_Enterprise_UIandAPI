package com.pm.framework.api.client;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.pm.framework.api.request.ApiEndpoints;
import com.pm.framework.api.request.ApiRequestHelper;

public class BrandApiClient {


    private final ApiRequestHelper requestHelper;

    public BrandApiClient(APIRequestContext apiContext) {
        this.requestHelper =
                new ApiRequestHelper(apiContext);
    }

    public APIResponse getBrands() {

        return requestHelper.get(
                ApiEndpoints.BRANDS
        );
    }
}

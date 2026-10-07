package com.pm.framework.api.client;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.pm.framework.api.request.ApiEndpoints;
import com.pm.framework.api.request.ApiRequestHelper;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.logging.Logger;

public class ProductApiClient {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ProductApiClient.class);
    private final APIRequestContext apiRequestContext;


    public ProductApiClient(APIRequestContext apiRequestContext) {
        this.apiRequestContext = apiRequestContext;
    }

    public APIResponse getProducts(){
        LOGGER.info(ApiEndpoints.PRODUCTS);
        APIResponse response = apiRequestContext.get(ApiEndpoints.PRODUCTS);
        LOGGER.info("GET /api/productsList response status: {}",response.status());
        return  response;
    }

    public APIResponse searchProducts(
            String searchTerm) {

        return ApiRequestHelper.post(
                ApiEndpoints.SEARCH_PRODUCT,
                Map.of(
                        "search_product",
                        searchTerm
                )
        );
    }
}

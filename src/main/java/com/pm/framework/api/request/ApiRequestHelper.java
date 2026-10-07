package com.pm.framework.api.request;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class ApiRequestHelper {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(ApiRequestHelper.class);

    private final APIRequestContext apiContext;

    public ApiRequestHelper(
            APIRequestContext apiContext) {

        this.apiContext = apiContext;
    }public APIResponse get(String endpoint) {

        LOGGER.info("Sending GET request: {}", endpoint);

        APIResponse response =
                apiContext.get(
                        endpoint,
                        new APIRequestContext.GetOptions()
                                .setHeaders(
                                        ApiHeaders.defaultHeaders()
                                )
                );

        LOGGER.info(
                "GET {} → {}",
                endpoint,
                response.status()
        );

        return response;
    }

    public APIResponse post(
            String endpoint,
            Map<String, String> formData) {

        LOGGER.info("Sending POST request: {}", endpoint);

        APIResponse response =
                apiContext.post(
                        endpoint,
                        new APIRequestContext.PostOptions()
                                .setHeaders(
                                        ApiHeaders.formHeaders()
                                )
                                .setForm(formData)
                );

        LOGGER.info(
                "POST {} → {}",
                endpoint,
                response.status()
        );

        return response;
    }

    public static APIResponse post(
            String endpoint,
            Map<String, String> formData) {

        LOGGER.info(
                "Sending POST request: {}",
                endpoint
        );

//        APIResponse response =
//                apiContext.post(
//                        endpoint,
//                        new APIRequestContext.PostOptions()
//                                .setForm(formData)
//                );

        LOGGER.info(
                "POST {} → {}",
                endpoint,
                response.status()
        );

        return response;
    }

    public APIResponse get(
            String endpoint,
            Map<String, String> queryParams) {

        LOGGER.info(
                "Sending GET request: {} with query parameters: {}",
                endpoint,
                queryParams
        );

        APIRequestContext.GetOptions options =
                new APIRequestContext.GetOptions()
                        .setHeaders(ApiHeaders.defaultHeaders())
                        .setParams(queryParams);

        APIResponse response =
                apiContext.get(endpoint, options);

        LOGGER.info(
                "GET {} → {}",
                endpoint,
                response.status()
        );

        return response;
    }
}

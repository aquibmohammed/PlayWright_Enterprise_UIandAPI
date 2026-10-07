package com.pm.framework.api.request;

import java.util.HashMap;
import java.util.Map;

public class ApiHeaders {

    private ApiHeaders() {
        // Prevent object creation
    }

    public static Map<String, String> defaultHeaders() {

        Map<String, String> headers =
                new HashMap<>();

        headers.put(
                "Accept",
                "application/json"
        );

        return headers;
    }

    public static Map<String, String> jsonHeaders() {

        Map<String, String> headers =
                defaultHeaders();

        headers.put(
                "Content-Type",
                "application/json"
        );

        return headers;
    }

    public static Map<String, String> formHeaders() {

        Map<String, String> headers =
                defaultHeaders();

        headers.put(
                "Content-Type",
                "application/x-www-form-urlencoded"
        );

        return headers;
    }
}
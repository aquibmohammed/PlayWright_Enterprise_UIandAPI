package com.pm.framework.api.request;

public class ApiEndpoints {

    private ApiEndpoints() {
        // Prevent object creation
    }

    public static final String PRODUCTS =
            "/api/productsList";

    public static final String BRANDS =
            "/api/brandsList";

    public static final String SEARCH_PRODUCT =
            "/api/searchProduct";

    public static final String VERIFY_LOGIN =
            "/api/verifyLogin";

    public static final String CREATE_ACCOUNT =
            "/api/createAccount";
}

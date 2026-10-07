package tests.api;

import com.microsoft.playwright.APIResponse;
import com.pm.framework.api.client.ProductApiClient;
import com.pm.framework.api.model.ProductsResponse;
import com.pm.framework.api.validation.ApiAssertions;
import com.pm.framework.api.validation.JsonResponseMapper;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.ApiBaseTest;
import tests.base.baseTest;

public class ProductApiTest extends ApiBaseTest {

    @Test(groups = {"regression", "ui"})
    @Severity(SeverityLevel.NORMAL)
    @Description("verfiy that the user can search for existing products")
    public void verifyProductsApi() {

        ProductApiClient productApiClient = new ProductApiClient(getAPIContext());
        APIResponse response = productApiClient.getProducts();
        ProductsResponse productResponse = JsonResponseMapper.fromJson(response.text(), ProductsResponse.class);
        ApiAssertions.assertStatusCode(response, 200);
        ApiAssertions.assertSussessfulResponse(response);
        Assert.assertEquals(
                productResponse.getResponseCode(),
                200,
                "API responseCode should be 200"
        );

        Assert.assertNotNull(
                productResponse.getProducts(),
                "Products list should not be null"
        );

        Assert.assertFalse(
                productResponse.getProducts().isEmpty(),
                "Products list should not be empty"
        );


        boolean blueTopExists =
                productResponse.getProducts()
                        .stream()
                        .anyMatch(product ->
                                "Blue Top".equals(product.getName())
                        );

        Assert.assertTrue(
                blueTopExists,
                "Expected product 'Blue Top' was not found"
        );
    }


    @Test(groups = {"regression", "api"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the product search API returns matching products")
    public void verifyProductSearchApi() {

        ProductApiClient productApi =
                new ProductApiClient(getAPIContext());

        APIResponse response =
                productApi.searchProducts("top");

        ApiAssertions.assertStatusCode(
                response,
                200
        );

        ApiAssertions.assertSussessfulResponse(
                response
        );

        ProductsResponse productsResponse =
                JsonResponseMapper.fromJson(
                        response.text(),
                        ProductsResponse.class
                );

        Assert.assertFalse(
                productsResponse.getProducts().isEmpty(),
                "Search API should return products"
        );
    }
}
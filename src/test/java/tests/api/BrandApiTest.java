package tests.api;

import com.microsoft.playwright.APIResponse;
import com.pm.framework.api.client.BrandApiClient;
import com.pm.framework.api.model.BrandsResponse;
import com.pm.framework.api.validation.ApiAssertions;
import com.pm.framework.api.validation.JsonResponseMapper;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.ApiBaseTest;

public class BrandApiTest extends ApiBaseTest {
//
//    @Test(groups = {"smoke", "api"})
//    @Severity(SeverityLevel.CRITICAL)
//    @Description("Verify that the brands API returns a valid list of brands")
//    public void verifyBrandsApi() {
//
//        BrandApiClient brandApi =
//                new BrandApiClient(getAPIContext());
//
//        APIResponse response =
//                brandApi.getBrands();
//
//        ApiAssertions.assertStatusCode(
//                response,
//                200
//        );
//
//        ApiAssertions.assertSussessfulResponse(
//                response
//        );
//
//        BrandsResponse brandsResponse =
//                JsonResponseMapper.fromJson(
//                        response.text(),
//                        BrandsResponse.class
//                );
//
//        Assert.assertEquals(
//                brandsResponse.getResponseCode(),
//                200,
//                "API responseCode should be 200"
//        );
//
//        Assert.assertNotNull(
//                brandsResponse.getBrands(),
//                "Brands list should not be null"
//        );
//
//        Assert.assertFalse(
//                brandsResponse.getBrands().isEmpty(),
//                "Brands list should not be empty"
//        );
//
//        boolean poloExists =
//                brandsResponse.getBrands()
//                        .stream()
//                        .anyMatch(brand ->
//                                "Polo".equalsIgnoreCase(
//                                        brand.getBrand()
//                                )
//                        );
//
//        Assert.assertTrue(
//                poloExists,
//                "Expected brand 'Polo' was not found"
//        );
//    }
}

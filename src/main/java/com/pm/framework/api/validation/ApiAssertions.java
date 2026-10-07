package com.pm.framework.api.validation;

import com.microsoft.playwright.APIResponse;
import org.testng.Assert;

public class ApiAssertions {
    public static void assertStatusCode(APIResponse response, int expectedStatusCode){
        Assert.assertEquals(response.status(),expectedStatusCode,"Unexpected HTTP status Code");

    }
    public static void assertSussessfulResponse(APIResponse response){

        Assert.assertTrue(response.ok(),"API response was successfull"+"status: "+ response.status());
    }
}

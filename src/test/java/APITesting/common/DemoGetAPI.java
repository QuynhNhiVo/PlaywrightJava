package APITesting.common;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static java.lang.System.out;

public class DemoGetAPI {
    @Test
    public void getUsersApiTest() {
        Playwright playwright = Playwright.create();
        APIRequest apiRequest = playwright.request();
        APIRequestContext apiRequestContext = apiRequest.newContext();
        APIResponse apiResponse = apiRequestContext.get("https://api.anhtester.com/api/users");

        int statusCode = apiResponse.status();
        out.println(statusCode);
        out.println(apiResponse.body().toString());

        Assert.assertEquals(statusCode, 200);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(statusCode, 304, "Status Code not equal 304");

        String statusText = apiResponse.statusText();
        out.println(statusText);
        softAssert.assertEquals(statusText, "Fail");
        softAssert.assertTrue(statusText.contains("OK"));
        softAssert.assertAll();
    }

}

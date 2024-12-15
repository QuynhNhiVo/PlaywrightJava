package WebTesting.learn;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;

public class BaseTestDemo {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
//
//    @BeforeMethod
//    public void setUp(){
//        playwright = Playwright.create();
//        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setSlowMo(500));
//        page = browser.newPage();
//        page.navigate("https://app.hrsale.com/erp/login");
//    }    Playwright playwright;

    @BeforeMethod
    public void beforeTest(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                                .setChannel("chrome")
                                .setHeadless(false)
                                .setArgs(List.of("--start-maximized")));
        browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        page = browserContext.newPage();
    }

    @AfterMethod
    public void tearDown(){
        page.close();
    }
}

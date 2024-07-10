package learn;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestDemo {
    Playwright playwright;
    Browser browser;
    Page page;

    @BeforeMethod
    public void setUp(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setSlowMo(500));
        page = browser.newPage();
        page.navigate("https://app.hrsale.com/erp/login");
    }

    @AfterMethod
    public void tearDown(){
        page.close();
    }
}

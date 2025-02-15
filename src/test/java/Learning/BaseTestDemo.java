package Learning;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.nio.file.Paths;
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

//    @BeforeMethod
//    public void beforeTest() {
//        playwright = Playwright.create();
//        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
//                .setChannel("chrome")
//                .setHeadless(false)
//                .setArgs(List.of("--start-maximized"))
//                .setSlowMo(1000));
//        browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
//        page = browserContext.newPage();
//    }
        @BeforeMethod
    public void beforeTestRecord() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setChannel("chrome")
                .setHeadless(false)
                .setArgs(List.of("--start-maximized"))
                .setSlowMo(1000));
        browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null)
                .setRecordVideoDir(Paths.get(System.getProperty("user.dir")+"/src/test/resources/videos/")));
        page = browserContext.newPage();
    }

    @AfterMethod
    public void tearDown(){
        page.close();
        browserContext.close();
    }
}

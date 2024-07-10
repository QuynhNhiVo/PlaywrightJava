package common;

import com.microsoft.playwright.*;
import constants.ConfigData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.LogUtils;

import java.util.Locale;

public class BaseTest {
    Browser browser;
    BrowserContext context;
    protected Page page;

    @BeforeMethod
    @Parameters({"browser"})
    public void createBrowser(@Optional("chrome") String browser){
        page = setupBrowser(browser);
    }

    private Page setupBrowser(String browserName) {
        Playwright playwright = Playwright.create();
        switch (browserName.toLowerCase(Locale.ROOT).trim()) {
            case "chrome":
                LogUtils.info("Launch Chrome.......");
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(ConfigData.HEADLESS));
                break;
            case "edge":
                LogUtils.info("Launch Edge.......");
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("edge").setHeadless(ConfigData.HEADLESS));
                break;
            case "firefox":
                LogUtils.info("Launch Firefox.......");
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("firefox").setHeadless(ConfigData.HEADLESS));
                break;
            default:
                LogUtils.info("Launch default browser (Chromium).......");
                browser = playwright.chromium().launch();
        }
        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1280, 1024));
        page = context.newPage();
        return page;
    }

    @AfterMethod
    public void closeBrowser(){
        page.close();
        browser.close();
    }
}

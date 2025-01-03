package factorys;

import com.microsoft.playwright.*;
import constants.ConfigData;
import utils.LogUtils;

import java.awt.*;
import java.util.List;
import java.util.Locale;

public class BrowserFactory {
    protected static Playwright playwright;
    protected static Browser browser;
    protected static BrowserContext context;
    protected Page page;

    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static int width = (int) screenSize.getWidth();
    private static int height = (int) screenSize.getHeight();


    public static Page setupBrowser(String browserName) {
        // Channel can be "chrome", "msedge", "chrome-beta", "msedge-beta" or "msedge-dev".
        PlaywrightFactory.setPlaywright(Playwright.create());
        switch (browserName.toLowerCase(Locale.ROOT).trim()) {
            case "chrome":
                LogUtils.info("Launch Chrome.......");
//                PlaywrightFactory.setBrowser(playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(ConfigData.HEADLESS)));
                browser = PlaywrightFactory.getPlaywright().chromium().launch
                        (new BrowserType.LaunchOptions()
                                .setChannel("chrome")
                                .setHeadless(ConfigData.HEADLESS)
                                .setArgs(List.of("--start-maximized")));
                break;
            case "edge":
                LogUtils.info("Launch Edge.......");
//                PlaywrightFactory.setBrowser(playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("edge").setHeadless(ConfigData.HEADLESS)));
                browser = PlaywrightFactory.getPlaywright().chromium().launch
                        (new BrowserType.LaunchOptions()
                                .setChannel("msedge")
                                .setHeadless(ConfigData.HEADLESS)
                                .setArgs(List.of("--start-maximized")));
                break;
            case "firefox":
                LogUtils.info("Launch Firefox.......");
//                PlaywrightFactory.setBrowser(playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("firefox").setHeadless(ConfigData.HEADLESS)));
                browser = PlaywrightFactory.getPlaywright().chromium().launch
                        (new BrowserType.LaunchOptions()
                                .setChannel("firefox")
                                .setHeadless(ConfigData.HEADLESS)
                                .setArgs(List.of("--start-maximized")));
                break;
            default:
                LogUtils.info("Launch default browser (Chromium).......");
//                PlaywrightFactory.setBrowser(playwright.chromium().launch());
                browser = PlaywrightFactory.getPlaywright().chromium().launch();
        }
        PlaywrightFactory.setBrowser(browser);
//        Set size browser
//        PlaywrightFactory.setContext(PlaywrightFactory.getBrowser().newContext(new Browser.NewContextOptions().setViewportSize(width, height)));
        PlaywrightFactory.setContext(PlaywrightFactory.getBrowser().newContext(new Browser.NewContextOptions().setViewportSize(null)));
        PlaywrightFactory.setPage(PlaywrightFactory.getContext().newPage());
        return PlaywrightFactory.getPage();
    }
}

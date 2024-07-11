package keywords;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;
import com.microsoft.playwright.assertions.PageAssertions;
import factorys.PlaywrightFactory;
import utils.LogUtils;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class WebUI {

    public static Page getPage(){
        return PlaywrightFactory.getPage();
    }

    public static void openWebsite(String url){
        getPage().navigate(url);
        LogUtils.info("Open URL: " + url);
    }

    public static void clickElement(String locator) {
        getPage().click(locator);
        LogUtils.info("Click element: " + locator);
    }

    public static void verifyURL(String url) {
        assertThat(getPage()).hasURL(url);
    }

    public static void verifyTitle(String title) {
        assertThat(getPage()).hasTitle(title);
    }

    public static void sleep(double time) {
        try {
            Thread.sleep((long) (time * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

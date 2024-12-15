package WebTesting.learn;

import com.microsoft.playwright.*;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class FirstDemo {

//    public static void main(String[] args) {
//        try (Playwright playwright = Playwright.create()) {
//            //By default, Playwright runs the browsers in headless mode. To see the browser UI, pass the setHeadless(false) flag while launching the browser.
//            //slowMo to slow down execution
//            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200));
//            Page page = browser.newPage();
//            page.navigate("https://playwright.dev/");
//            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
//            System.out.println("Lauching Chorme. Get title page: " + page.title());
//        }
//    }

    @Test
    public void TestLauching(){
        try (Playwright playwright = Playwright.create()) {
            //By default, Playwright runs the browsers in headless mode. To see the browser UI, pass the setHeadless(false) flag while launching the browser.
            //slowMo to slow down execution
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(600));
            Page page = browser.newPage();
            page.navigate("https://playwright.dev/");
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
            System.out.println("Lauching Chorme. Get title page: " + page.title());
        }
    }

    @Test
    public void TestAssert(){
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(600));
            Page page = browser.newPage();
            page.navigate("https://playwright.dev/");
            // Expect a title "to contain" a substring.
            assertThat(page).hasTitle(Pattern.compile("Playwright"));

            // create a locator
            Locator getStarted = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Get Started"));

            // Expect an attribute "to be strictly equal" to the value.
            assertThat(getStarted).hasAttribute("href", "/docs/intro");

            // Click the get started link.
            getStarted.click();

            // Expects page to have a heading with the name of Installation.
            assertThat(page.getByRole(AriaRole.HEADING,
                    new Page.GetByRoleOptions().setName("Installation"))).isVisible();
        }
    }
}

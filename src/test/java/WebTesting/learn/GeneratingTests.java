package WebTesting.learn;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.ColorScheme;
import org.testng.annotations.Test;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class GeneratingTests {

    @Test
    public void TestRecord() {
        //mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen https://app.hrsale.com/erp/login"
        try(Playwright playwright = Playwright.create()){
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setSlowMo(500));
            Page page = browser.newPage();
            page.navigate("https://app.hrsale.com/erp/login");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Super Admin")).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Login")).click();
            assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Frances Burns @kelly.flynn"))).isVisible();
            assertThat(page.getByRole(AriaRole.PARAGRAPH)).containsText("@kelly.flynn");
            page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("1").setExact(true)).click();
        }

    }

    @Test
    public void TestViewPort(){
        //mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen --viewport-size=800,600  https://app.hrsale.com/erp/login"
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setSlowMo(500));
            BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                    .setViewportSize(800, 600));
            Page page = context.newPage();
            page.navigate("https://app.hrsale.com/erp/login");
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("ViewPortSize.png")));
        }
    }

    @Test
    public void TestColorScheme(){
        // mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen --color-scheme=dark https://app.hrsale.com/erp/login"
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setSlowMo(500));
            BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                    .setColorScheme(ColorScheme.DARK));
            Page page = context.newPage();
            page.navigate("https://app.hrsale.com/erp/login");
        }
    }

}

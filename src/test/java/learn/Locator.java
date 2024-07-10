package learn;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;

public class Locator extends BaseTestDemo{

    @Test
    public void TestRecommendLocator(){

            //Locate By text: Page.getByText()
            page.getByText("Super Admin").click();

            //Locate By Role: Page.getByRole(AriaRole. , new Page.GetByRoleOptions().setName())
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();

            assertThat(page).hasTitle(Pattern.compile("Home | HRSALE"));
            System.out.println(page.title());
            assertEquals("Home | HRSALE", page.title(), "Title page Incorrect!");
            page.close();
    }

    @Test
    public void TestXPath(){

            page.locator("//button[normalize-space()='Super Admin']").click();
//            page.click("//button[normalize-space()='Super Admin']");
            page.click("//button[@type='submit']");

            assertThat(page).hasTitle(Pattern.compile("Home | HRSALE"));
            System.out.println(page.title());
            assertEquals("Home | HRSALE", page.title(), "Title page Incorrect!");

    }

    @Test
    public void TestBrowser(){
        try (Playwright playwright = Playwright.create()){
            // Channel can be "chrome", "msedge", "chrome-beta", "msedge-beta" or "msedge-dev".
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false).setSlowMo(1000));
            Page page = browser.newPage();
            page.navigate("https://google.com");
        }
    }
}

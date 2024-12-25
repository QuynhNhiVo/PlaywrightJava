package WebTesting.learn;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.annotations.Test;

import java.util.List;

public class MultiplePages_Tabs extends BaseTestDemo {

    @Test
    public void multiPages_Test_Tabs(){
        page.navigate("https://demoqa.com/browser-windows");
        // Opens a new tab
        Page newpage = browserContext.waitForPage(() -> {
            page.locator("//button[@id='tabButton']").first().click();
        });
        page.bringToFront(); //back to demoqa
        newpage.bringToFront();
    }

    @Test
    public void multiPages_Test_Tabs_2(){
        page.navigate("https://freelance-learn-automation.vercel.app/login");
        // Opens a new tab
        Page newpage = browserContext.waitForPage(() -> {
            page.locator("//a[contains(@href,'facebook')][1]").first().click();
        });
        page.bringToFront();
        newpage.bringToFront();
    }

    @Test
    public void multiPages_Test_Tabs_3() throws InterruptedException {
        browserContext.onPage(page ->{
            page.waitForLoadState();
            System.out.println(page.title());
        });
        page.navigate("https://demo.automationtesting.in/Windows.html");
        Locator locator = page.locator("//footer[@id='footer']/div/div/div/a[contains(@class,'link ')]");
        for (int i = 0; i < locator.count(); i++) {
            locator.nth(i).click();
        }
        Thread.sleep(10000);
        List<Page> allPages = browserContext.pages();
        System.out.println(allPages.size());
        for (Page j : allPages) {
            String title = j.title();
            System.out.println(title);
            if (title.toLowerCase().trim().contains("google")){
                j.bringToFront();
                System.out.println("Break");
                break;
            }
        }
        page.bringToFront();
        browserContext.close();
        browser.close();
    }
}

package WebTesting.learn;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class Screenshot_Record extends BaseTestDemo {
    @Test
    public void Test() throws InterruptedException {

        page.navigate("https://google.com");
        Thread.sleep(2000);
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(System.getProperty("user.dir")+"/src/test/resources/files/" + "src.png")));
        String path = page.video().path().toString();
        System.out.println(path);
    }
}

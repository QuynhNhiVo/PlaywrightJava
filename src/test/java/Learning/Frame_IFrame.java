package Learning;

import com.microsoft.playwright.Frame;
import org.testng.annotations.Test;

import java.util.List;


public class Frame_IFrame extends BaseTestDemo {
    @Test
    public void singleIframe_test() throws InterruptedException {
        page.navigate("https://demo.automationtesting.in/Frames.html");
        page.frameLocator("//iframe[@id='singleframe']").locator("//input[@type='text']").fill("frame");
        Thread.sleep(2000);
    }

    @Test
    public void multiIframe_Test() throws InterruptedException {
        page.navigate("https://demo.automationtesting.in/Frames.html");
        page.click("//a[normalize-space()='Iframe with in an Iframe']");
        List<Frame> frameList = page.frames();
        System.out.println(frameList.size());
        page.frameLocator("//iframe[@src='MultipleFrames.html']")
                .frameLocator("iframe[src='SingleFrame.html']")
                .locator("//input[@type='text']").fill("Test");
        Thread.sleep(2000);
    }

    @Test
    public void multiIframe_Test_3() throws InterruptedException {
        page.navigate("https://demo.automationtesting.in/Frames.html");
        page.click("//a[normalize-space()='Iframe with in an Iframe']");
        System.out.println(page.mainFrame().name() + " - " + page.mainFrame().url());

        System.out.println(page.mainFrame().childFrames().size());

        for (Frame Childframe : page.mainFrame().childFrames()) {
            System.out.println(Childframe.name());
        }
        Thread.sleep(2000);
    }
}

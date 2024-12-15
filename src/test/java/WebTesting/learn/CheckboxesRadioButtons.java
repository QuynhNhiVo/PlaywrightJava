package WebTesting.learn;

import com.microsoft.playwright.*;
import com.microsoft.playwright.Locator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.List;


public class CheckboxesRadioButtons {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;

    @BeforeMethod
    public void beforeTest(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                                .setChannel("chrome")
                                .setHeadless(false)
                                .setArgs(List.of("--start-maximized")));
        browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        page = browserContext.newPage();
    }

    //input[type=checkbox], input[type=radio] and [role=checkbox]
    @Test
    public void checkboxTest() {
        page.navigate("https://demoqa.com/checkbox");
        page.locator("//label[@for='tree-node-home']//span[@class='rct-checkbox']//*[name()='svg']").click();
        Assert.assertTrue(page.locator("//span[normalize-space()='You have selected :']").isVisible());
        System.out.printf(page.textContent("//span[normalize-space()='You have selected :']"));
        page.locator("//button[@title='Toggle']//*[name()='svg']").click();
        Assert.assertTrue(page.locator("//label[@for='tree-node-desktop']//span[@class='rct-checkbox']").isChecked());
    }
    @Test
    public void checkboxTest_2(){
        page.navigate("https://demoqa.com/checkbox");
        page.locator("//button[@title='Toggle']//*[name()='svg']").click();
        page.locator("//span[contains(text(),'Desktop')]").click();
        assertThat(page.locator("//span[contains(text(),'Desktop')]/preceding-sibling::span[@class='rct-checkbox']")).isChecked();
        assertThat(page.locator("//div[@id='result']")).containsText("You have selected :desktopnotescommands");
        page.textContent("//div[@id='result']");
        page.click("//span[contains(text(),'Home')]/preceding-sibling::span[@class='rct-checkbox']");
        assertThat(page.locator("//div[@id='result']")).containsText("You have selected :homedesktopnotescommandsdocumentsworkspacereactangularveuofficepublicprivateclass");
        System.out.println(page.textContent("//div[@id='result']"));
        page.locator("//span[contains(text(),'Downloads')]/preceding-sibling::span[@class='rct-checkbox']").uncheck();
        assertThat(page.locator("//div[@id='result']")).containsText("You have selected :desktopnotescommandsdocumentsworkspacereactangularveuofficepublicprivateclassifie");
        System.out.println(page.textContent("//div[@id='result']"));
        Locator count = page.locator("(//span[@class='rct-checkbox'])");
        System.out.println("Have " + count.count() + " checkbox");
        for (int i = 1; i <= count.count(); i++) {
            if (page.locator("(//span[@class='rct-checkbox'])["+ i+"]").isChecked()){
                System.out.println(page.textContent("((//span[@class='rct-checkbox'])["+ i+"])//following-sibling::span[2]") + " Is Selected");
            }
        }
        assertThat(page.locator("//span[contains(text(),'Downloads')]/preceding-sibling::span[@class='rct-checkbox']")).isChecked();
    }

    @Test
    public void radioButtonTest(){
        page.navigate("https://demoqa.com/radio-button");
        page.locator("//label[normalize-space()='Impressive']").click();
        page.locator("//label[normalize-space()='Yes']").check();
    }
}

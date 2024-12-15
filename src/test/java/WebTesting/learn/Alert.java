package WebTesting.learn;

import org.testng.annotations.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Alert extends BaseTestDemo {

    @Test
    public void Test_Alert_default(){
        page.navigate("https://demoqa.com/alerts");
        page.onDialog(dialog ->
        {
            System.out.println(dialog.message());
            dialog.type();
            dialog.accept();
        });
        page.click("//button[@id='alertButton']");
    }

    @Test
    public void Test_Alert_accept(){
        page.navigate("https://demoqa.com/alerts");
        page.onDialog(dialog ->
        {
            System.out.println(dialog.message());
            dialog.accept();
        });
        page.click("//button[@id='confirmButton']");
        System.out.println(page.textContent("//span[@id='confirmResult']"));
    }

    @Test
    public void Test_Alert_dismiss(){
        page.navigate("https://demoqa.com/alerts");
        page.onDialog(dialog ->
        {
            System.out.println(dialog.message());
            dialog.dismiss();
        });
        page.click("//button[@id='confirmButton']");
        System.out.println(page.textContent("//span[@id='confirmResult']"));
    }

    @Test
    public void Test_Alert_promptBox(){
        page.navigate("https://demoqa.com/alerts");
        page.onDialog(dialog ->
        {
            System.out.println(dialog.message());
            dialog.accept("Alert");
        });
        page.click("//button[@id='promtButton']");
        System.out.println(page.textContent("//span[@id='promptResult']"));
        assertThat(page.locator("//span[@id='promptResult']")).containsText("Alert");
    }

    @Test
    public void Test_Alert_type(){
        page.navigate("https://demoqa.com/alerts");
        page.onDialog(dialog ->
        {
            System.out.println(dialog.message());
            dialog.type();
            System.out.println(dialog.type());
            dialog.dismiss();
        });
        page.click("//button[@id='promtButton']");
    }

    @Test
    public void Test_Alert_beforeUnload(){
        page.navigate("https://demoqa.com/alerts");
        page.onDialog(dialog ->
        {
            System.out.println(dialog.message());
            dialog.type();
            dialog.accept();
        });
        page.click("//button[@id='timerAlertButton']");
    }
}

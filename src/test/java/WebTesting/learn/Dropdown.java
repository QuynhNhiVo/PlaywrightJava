package WebTesting.learn;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class Dropdown extends BaseTestDemo {
    @Test
    public void dropdownTest(){
        page.navigate("https://demoqa.com/select-menu");
        //Value
        page.locator("//select[@id='oldSelectMenu']").selectOption("4");
        //Index
        page.locator("//select[@id='oldSelectMenu']").selectOption(new SelectOption().setIndex(6));
        //Text
        page.locator("//select[@id='oldSelectMenu']").selectOption(new SelectOption().setLabel("Aqua"));
    }

    @Test
    public void dropdownTest_tagOption() throws InterruptedException {
        page.navigate("https://formstone.it/components/dropdown/demo/");
        page.locator("//select[@id='demo_native']").click();
        page.locator("//select[@id='demo_native']").selectOption("3");
        page.locator("//select[@id='demo_native']").selectOption(new SelectOption().setIndex(4));
        page.locator("//select[@id='demo_native']").selectOption(new SelectOption().setLabel("One"));
        Thread.sleep(30);
    }

    @Test
    public void dropdownTest_Dynamic_1() throws InterruptedException {
        page.navigate("https://techydevs.com/demos/themes/html/listhub-demo/listhub/index.html");
        page.locator("//span[normalize-space()='Select a Country']").click();
        page.fill("(//input[@type='text'])[2]", "Vietnam");
        page.keyboard().press("Enter");
    }

    @Test
    public void dropdownTest_Dynamic_2() throws InterruptedException {
        page.navigate("https://techydevs.com/demos/themes/html/listhub-demo/listhub/index.html");
        page.locator("//div[@class='main-search-input']//div[2]").click();
        page.locator("(//ul[@class='chosen-results'])[2]").getByText("Vietnam").click();
        System.out.println( page.textContent("//div[@class='main-search-input']//div[2]//div//a//span"));
        assertThat( page.locator("//div[@class='main-search-input']//div[2]//div//a//span")).hasText("Vietnam");
    }

    @Test
    public void dropdownTest_Multi() throws InterruptedException {
        page.navigate("https://demoqa.com/select-menu");
        page.locator("//select[@id='cars']").hover();
        Thread.sleep(10);
        page.locator("//select[@id='cars']").selectOption(new String[] {"Audi", "Saab"});
        Thread.sleep(10);
    }

    @Test
    public void dropdownTest_Multi_2() throws InterruptedException {
        page.navigate("https://crm.anhtester.com/admin/authentication");
        page.fill("//input[@id='email']", "admin@example.com");
        page.fill("//input[@id='password']", "123456");
        page.keyboard().press("Enter");
        page.click("//span[normalize-space()='Tasks']");
//        page.locator("//a[normalize-space()='New Task']").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(30000));
        page.locator("//a[normalize-space()='New Task']").click();
//        page.locator("//h4[@id='myModalLabel']").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(30000));
        System.out.println(page.textContent("//h4[@id='myModalLabel']"));
        String Assignees[] ={"Admin Anh Tester", "Admin Example"};
        page.locator("//select[@id='assignees']").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(30000));
        page.selectOption("//select[@id='assignees']", Assignees);
        System.out.println(page.textContent("(//div[@class='filter-option-inner'])[11]//div"));
        page.close();
    }
}

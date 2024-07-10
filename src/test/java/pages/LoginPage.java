package pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private String admin = "//button[normalize-space()='Super Admin']";
    private String login = "//button[@type='submit']";

    private final Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    public void loginWeb(){
        page.navigate("https://app.hrsale.com/erp/login");
        page.click(admin);
        page.click(login);
    }
}

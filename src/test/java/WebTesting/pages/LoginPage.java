package WebTesting.pages;

import constants.ConfigData;
import WebTesting.pages.admin.DashboardPage;

import static keywords.WebUI.*;

public class LoginPage extends CommonPage{

    private String username = "//input[@id='iusername']";
    private String admin = "//button[normalize-space()='Super Admin']";
    private String empl = "//button[normalize-space()='Employee']";
    private String client = "//button[normalize-space()='Client']";
    private String login = "//button[@type='submit']";
    private String textTitleLogin = "HRSALE | Log in";


    private void verifyLoginPage(){
        openWebsite(ConfigData.URL);
        verifyURL(ConfigData.URL);
        verifyTitle(textTitleLogin);
    }
    public DashboardPage loginAdmin(){
//        PlaywrightFactory.getPage().navigate("https://app.hrsale.com/erp/login");
//        PlaywrightFactory.getPage().click(admin);
//        PlaywrightFactory.getPage().click(login);
        verifyLoginPage();
        sendKey(username, "admin");
        clickElement(admin);
        clickElement(login);
        sleep(5);
        return new DashboardPage();
    }

    public void loginEmployee(){
        verifyLoginPage();
        clickElement(empl);
        clickElement(login);
        sleep(5);
    }

    public void loginClient(){
        verifyLoginPage();
        clickElement(client);
        clickElement(login);
        sleep(5);
    }
}

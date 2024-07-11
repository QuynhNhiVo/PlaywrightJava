package pages;

import constants.ConfigData;
import factorys.PlaywrightFactory;
import static keywords.WebUI.*;

public class LoginPage {

    private String admin = "//button[normalize-space()='Super Admin']";
    private String login = "//button[@type='submit']";
    private String textTitleLogin = "HRSALE | Log in";


    public void loginWeb(){
//        PlaywrightFactory.getPage().navigate("https://app.hrsale.com/erp/login");
//        PlaywrightFactory.getPage().click(admin);
//        PlaywrightFactory.getPage().click(login);
        openWebsite(ConfigData.URL);
        verifyURL(ConfigData.URL);
        verifyTitle(textTitleLogin);
        clickElement(admin);
        clickElement(login);
        sleep(5);
    }
}

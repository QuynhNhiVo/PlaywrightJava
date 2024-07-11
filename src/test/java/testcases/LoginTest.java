package testcases;

import common.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod
    public void LoginTest(){
        loginPage = new LoginPage();
    }

    @Test
    public void TC_login(){
        loginPage.loginWeb();
    }
}

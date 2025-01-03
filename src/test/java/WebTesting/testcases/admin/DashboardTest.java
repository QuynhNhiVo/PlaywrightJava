package WebTesting.testcases.admin;

import WebTesting.common.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import WebTesting.pages.LoginPage;

public class DashboardTest extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod
    public void initData(){
        loginPage = new LoginPage();
    }

    @Test
    public void tc_1(){
        loginPage.loginAdmin()
                .dbtest();
    }

    @Test
    public void tc_2(){
        loginPage.loginAdmin();
    }
}

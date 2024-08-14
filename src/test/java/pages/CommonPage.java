package pages;

import pages.admin.DashboardPage;

import static keywords.WebUI.*;

public class CommonPage{
    private String employees = "//span[normalize-space()='Employees']";
    private String projects = "//span[normalize-space()='Projects']";
    private String manage = "//span[normalize-space()='Manage Clients']";
    private String logout = "//i[@class='feather icon-power']";

    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    public void Logout(){
        clickElement(logout);
    }


    public LoginPage getLoginPage(){
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public DashboardPage getDashboardPage(){
        if (dashboardPage == null) {
            dashboardPage = new DashboardPage();
        }
        return dashboardPage;
    }
}

package WebTesting.pages.admin;

import WebTesting.pages.CommonPage;

import static keywords.WebUI.*;

public class DashboardPage extends CommonPage {
    private String title = "";
    private String url = "";
    private String navbar = "//li[@class='pc-item pc-caption']";

    private DashboardPage verifyPage(){

        return this;
    }

    public DashboardPage dbtest(){
        getTextElement(navbar);
        return this;
    }
}

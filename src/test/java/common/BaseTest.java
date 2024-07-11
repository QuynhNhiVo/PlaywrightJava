package common;

import factorys.BrowserFactory;
import factorys.PlaywrightFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    @BeforeMethod
    @Parameters({"browser"})
    public void createBrowser(@Optional("chrome") String browser){
        BrowserFactory.setupBrowser(browser);
    }

    @AfterMethod
    public void closeBrowser(){
        PlaywrightFactory.quitPage();
        PlaywrightFactory.quitContext();
        PlaywrightFactory.quitPlaywright();
    }
}

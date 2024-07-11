package factorys;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {

    private static final ThreadLocal<Playwright>  playwrightThreadLocal= new ThreadLocal<>();
    private static final ThreadLocal<Browser> browserThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext>  contextThreadLocal= new ThreadLocal<>();
    private static final ThreadLocal<Page> pageThreadLocal = new ThreadLocal<>();

    public static Playwright getPlaywright(){
        return playwrightThreadLocal.get();
    }

    public static Browser getBrowser() {
        return browserThreadLocal.get();
    }

    public static BrowserContext getContext() {
        return contextThreadLocal.get();
    }

    public static Page getPage() {
        return pageThreadLocal.get();
    }

    public static void setPlaywright(Playwright playwright) {
        playwrightThreadLocal.set(playwright);
    }

    public static void setBrowser(Browser browser) {
        browserThreadLocal.set(browser);
    }

    public static void setContext(BrowserContext context) {
        contextThreadLocal.set(context);
    }

    public static void setPage(Page page) {
        pageThreadLocal.set(page);
    }

    public static void quitPlaywright() {
        if (playwrightThreadLocal.get() != null) {
            pageThreadLocal.get().close();
        }
    }

    public static void quitContext() {
        if (contextThreadLocal.get() != null) {
            contextThreadLocal.get().close();
        }
    }

    public static void quitPage() {
        if (pageThreadLocal.get() != null) {
            pageThreadLocal.get().close();
        }
    }
}

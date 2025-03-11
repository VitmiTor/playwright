import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;


public class firstTest {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
            Page page = browser.newPage();
            page.navigate("https://www.saucedemo.com/v1/");


            page.locator("id=user-name").fill("standard_user");

            page.locator("id=password").fill("secret_sauce");

            page.locator("id=login-button").click();

            page.locator("text=Products").isVisible();


        }
    }
}

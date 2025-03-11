import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class firstTest {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
            Page page = browser.newPage();
            page.navigate("https://www.saucedemo.com/v1/");


            Locator getUsername = page.locator("id=user-name");
            assertThat(getUsername).isVisible();
            getUsername.fill("standard_user");

            Locator getPassword = page.locator("id=password");
            getPassword.fill("secret_sauce");

            Locator getLoginBtn = page.locator("id=login-button");
            getLoginBtn.click();

            Locator getTitle = page.locator("text=Products");
            assertThat(getTitle).isVisible();

            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot.png")));
            
        }
    }
}

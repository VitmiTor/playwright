import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class firstTest {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
            Page page = browser.newPage();
            page.navigate("https://www.saucedemo.com/v1/");


            page.locator("#user-name").fill("standard_user");

            page.locator("#password").fill("secret_sauce");

            page.locator("id=login-button").click();

            page.locator("text=Products").isVisible();


            List<ElementHandle> elementHandles = page.querySelectorAll("button[class='btn_primary btn_inventory']");

            
            for (int i = 0; i < 6; i++) {
                elementHandles.get(i).click();
            }

            assertThat(page.locator("span[class='fa-layers-counter shopping_cart_badge']")).containsText("6");

        }
    }
}

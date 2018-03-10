package clearscore.step_defs;

import clearscore.browser.Browser;
import clearscore.pom.ClearScore_main_page;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Cookie;

import java.util.Collection;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class WeUseCookies_notification_step_defs {

    @Given("^user opens ClearScore main page$")
    public void user_opens_ClearScore_main_page () throws Throwable {
        ClearScore_main_page.ClearScore_main_page_load();
    }

    @Then("^cookies notification is present$")
    public void cookies_notification_is_present () throws Throwable {
        String cookies_notification = ClearScore_main_page.WeUseCookies_notification();
        boolean isPresent = cookies_notification.contains("We use cookies to improve your experience.");
        assertTrue("When it fails means cookies notification is not present", isPresent);
    }

    @Given("^user dismisses the notification$")
    public void user_dismisses_the_notification () throws Throwable {
        ClearScore_main_page.NoProblem_button();
    }

    @Then("^notification is not present$")
    public void notification_is_not_present () throws Throwable {
        boolean cokiesTextNotification = ClearScore_main_page.getPageText().contains("We use cookies");
        assertFalse("Text is present", cokiesTextNotification);

    }

    @When("^reloads the page$")
    public void reloads_the_page () throws Throwable {
        Browser.driver().navigate().refresh();
    }

    @Then("^cookies are set$")
    public void cookies_are_set () throws Throwable {
        Collection<Cookie> cookies = Browser.driver().manage().getCookies();
        System.out.println(cookies);
        assertTrue("Cookies are set", cookies.size() > 0);
        Thread.sleep(2000);

        boolean cookieSet = false;

        for (Cookie cookieN : cookies) {
            if (cookieN.getName().contains("CS_PERSON") ){
                cookieSet = true;
            }

        }

        assertTrue("Cookie is not set", cookieSet);

    }

}




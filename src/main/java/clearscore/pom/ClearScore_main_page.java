package clearscore.pom;

import clearscore.browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ClearScore_main_page {

    public static void ClearScore_main_page_load () {
        Browser.open("https://www.clearscore.com/");
    }

    public static String WeUseCookies_notification () {
        return Browser.driver().findElement(By.cssSelector(".cs-cookie.show")).getText();

    }

    public static void NoProblem_button () {
        Browser.driver().findElement(By.cssSelector(".accept-btn")).click();
    }

    public static String getPageText () {
        WebElement body = Browser.driver().findElement(By.tagName("body"));
        String bodyText = body.getText();
        return bodyText;
    }
}


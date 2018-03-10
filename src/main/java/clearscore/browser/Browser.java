package clearscore.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class Browser {

    static {
        System.setProperty("webdriver.chromedriver", "C://Users/Aneta/IdeaProjects/Clearscore/chromedriver.exe");
    }

    private static WebDriver driver;

    public static WebDriver driver() {
        if(driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
        }

        return driver;
    }

    public static void open (String url) {
        driver().get(url);
    }

    public static void close () {
        if(driver != null) {
            driver.close();
            driver = null;
        }
    }

}
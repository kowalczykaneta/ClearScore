package clearscore.step_defs;

import clearscore.browser.Browser;
import cucumber.api.java.After;

public class Hooks {

    @After
    public void afterScenario () {
        Browser.close();
    }
}
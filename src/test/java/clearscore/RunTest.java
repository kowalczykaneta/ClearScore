package clearscore;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import clearscore.browser.Browser;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "~@Ignore", strict = true)
public class RunTest {

}

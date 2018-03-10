package clearscore.step_defs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;

public class FailedLogin_step_defs {

    Response response;
    RequestSpecification request;
    JSONObject requestParams;

    @Given("^user opens ClearScore login page$")
    public void user_opens_ClearScore_login_page () throws Throwable {

        RestAssured.baseURI = "https://api.clearscore.com";
        request = RestAssured.given();
        request.contentType(ContentType.JSON);

        requestParams = new JSONObject();
        requestParams.put("email", "test@email.com");
        requestParams.put("password", "test12");

    }

    @When("^user uses incorrect credentials$")
    public void user_uses_incorrect_credentials () throws Throwable {

        request.body(requestParams.toJSONString());
        response = request.post("/caesium-api/users/signIn");
        System.out.println(response.getBody().prettyPrint());
    }

    @Then("^returned response is (\\d+) error$")
    public void returned_response_is_error (int expected_error_code) throws Throwable {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(expected_error_code, statusCode);
    }

}


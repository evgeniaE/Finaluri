package api;

import config.ConfigReader;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class UserApiTest {

    @Test
    public void getUserTest() {

        RestAssured.baseURI = "https://reqres.in";

        given()
                .relaxedHTTPSValidation()
                .header("x-api-key", ConfigReader.getProperty("apiKey"))
                .when()
                .get("/api/users/2")
                .then()
                .log().all()
                .statusCode(200);
    }
}
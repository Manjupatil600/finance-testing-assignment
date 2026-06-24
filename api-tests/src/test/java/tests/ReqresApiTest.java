package tests;

import config.ApiConfig;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ReqresApiTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = ApiConfig.BASE_URL;
    }

    // valid login - should get token back
    @Test
    public void testLoginSuccess() {
        String body = "{\"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\"}";

        Response res = given()
                .contentType(ContentType.JSON)
                .header("x-api-key", "reqres-free-v1")
                .body(body)
            .when()
                .post(ApiConfig.LOGIN_ENDPOINT)
            .then()
                .statusCode(200)
                .body("token", notNullValue())
                .extract().response();

        String token = res.jsonPath().getString("token");
        System.out.println("Token: " + token);
        Assert.assertFalse(token.isEmpty());
    }

    // missing password - should get 400
    @Test
    public void testLoginWithoutPassword() {
        String body = "{\"email\": \"eve.holt@reqres.in\"}";

        Response res = given()
                .contentType(ContentType.JSON)
                .header("x-api-key", "reqres-free-v1")
                .body(body)
            .when()
                .post(ApiConfig.LOGIN_ENDPOINT)
            .then()
                .statusCode(400)
                .extract().response();

        String error = res.jsonPath().getString("error");
        Assert.assertEquals(error, "Missing password");
    }

    // get user by id - check fields
    @Test
    public void testGetUserById() {
        given()
                .header("x-api-key", "reqres-free-v1")
            .when()
                .get(ApiConfig.USERS_ENDPOINT + "/2")
            .then()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .body("data.email", equalTo("janet.weaver@reqres.in"))
                .body("data.first_name", equalTo("Janet"));
    }

    // user that doesnt exist - 404
    @Test
    public void testUserNotFound() {
        given()
                .header("x-api-key", "reqres-free-v1")
            .when()
                .get(ApiConfig.USERS_ENDPOINT + "/9999")
            .then()
                .statusCode(404);
    }
}

package rest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetTest {

    @Test
    public void testServerIsUp() {

        Response response = RestAssured.get("http://localhost:8080/api/user");
        System.out.println(response.body().asString());
        System.out.println(response.statusCode());
        System.out.println(response.getBody().asString());
        System.out.println(response.statusLine());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);


    }

    @Test
    public void testServer(){

        given().get("http://localhost:8080/api/user").then().statusCode(200);
    }
}

package com.apitest.steps;

import com.apitest.config.BaseUrl;
import com.thoughtworks.gauge.Step;
import io.restassured.response.Response;
import org.junit.Assert;

import static com.apitest.config.Endpoints.postsPath;
import static io.restassured.RestAssured.given;

public class PutMethods extends BaseUrl {

    @Step("Oluşturulan post güncellenir")
    public void updatePost(){
        String requestBody = "{\n" +
                "  \"title\": \"update title\",\n" +
                "  \"body\": \"text\",\n" +
                "  \"userId\": \"1\",\n" +
                "  \"id\": \"1\" \n}";
        Response response =
        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody).
        when()
                .put(postsPath+"/1").
        then()
                .extract().response();

        Assert.assertEquals(200, response.statusCode());
    }
}

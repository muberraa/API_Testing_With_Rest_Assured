package com.apitest.steps;

import com.apitest.config.BaseUrl;
import com.apitest.methods.JsonReader;
import com.thoughtworks.gauge.Step;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.IOException;

import static com.apitest.config.Endpoints.postsPath;
import static io.restassured.RestAssured.given;

public class PutMethods extends BaseUrl {

    JsonReader jsonReader;
    public PutMethods(){
        jsonReader = new JsonReader();
    }

    @Step("Oluşturulan post güncellenir")
    public void updatePost() throws IOException {
        String jsonDataInFile  = jsonReader.generateStringFromResource("UpdatePost.json");

        Response response =
        given()
                .header("Content-type", "application/json")
                .and()
                .body(jsonDataInFile).
        when()
                .put(postsPath+"/1").
        then()
                .extract().response();

        Assert.assertEquals(200, response.statusCode());
    }
}

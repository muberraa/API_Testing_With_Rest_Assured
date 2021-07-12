package com.apitest.steps;

import com.apitest.config.BaseUrl;
import com.apitest.methods.JsonReader;
import com.thoughtworks.gauge.Step;
import io.restassured.http.ContentType;

import java.io.IOException;

import static com.apitest.config.Endpoints.postsPath;
import static io.restassured.RestAssured.given;

public class PostMethods extends BaseUrl {
    JsonReader jsonReader;
    public PostMethods(){
        jsonReader = new JsonReader();
    }

    @Step("Yeni bir post oluştur")
    public void createNewPost() throws IOException {
        String jsonDataInFile  = jsonReader.generateStringFromResource("CreatePost.json");

        given()
                .contentType(ContentType.JSON)
                .body(jsonDataInFile)
        .when()
                .post(postsPath)
        .then()
                .assertThat()
                .statusCode(201);

    }

    }








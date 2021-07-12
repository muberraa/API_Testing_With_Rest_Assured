package com.apitest.steps;

import com.apitest.config.BaseUrl;
import com.apitest.methods.JsonReader;
import com.thoughtworks.gauge.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.Assert;

import java.io.IOException;

import static com.apitest.config.Endpoints.postsPath;
import static io.restassured.RestAssured.given;

public class PostMethods extends BaseUrl {
/*
    JsonReader jsonReader;
    public PostMethods(){
        jsonReader = new JsonReader();
    }

    @Step("Yeni bir kullanıcı oluştur")
    public void createNewPost() throws IOException {
        String jsonDataInFile  = jsonReader.generateStringFromResource("NewPost.json");

        given()
                .contentType(ContentType.JSON)
                .body(jsonDataInFile)
        .when()
                .post(postsPath)
        .then()
                .assertThat()
                .statusCode(200);

    }
  */
   @Step("Yeni bir post oluştur")
   public void createNewPost(){
        String requestBody = "{\n" +
               "  \"title\": \"new post\",\n" +
               "  \"body\": \"delectus reiciendis molestiae occaecati non minima eveniet qui voluptatibus\",\n" +
               "  \"userId\": \"1\" \n}";

       Response response =
       given()
               .header("Content-type", "application/json")
               .and()
               .body(requestBody).
       when()
               .post(postsPath).
       then()
               .extract().response();
       Assert.assertEquals(201, response.statusCode());

}


    }








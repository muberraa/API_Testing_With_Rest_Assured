package com.apitest.steps;

import com.apitest.config.BaseUrl;
import com.thoughtworks.gauge.Step;

import static com.apitest.config.Endpoints.postsPath;
import static com.apitest.config.Endpoints.usersPath;
import static io.restassured.RestAssured.given;

public class DeleteMethods extends BaseUrl {


    @Step("Oluşturulan post silinir")
    public void deletePost(){
       given()
                .header("Content-type", "application/json")
                .when()
                .delete(postsPath + "/1")
                .then()
                .extract().response();
    }
    @Step("<id> id'li kullanıcıyı sil")
    public void deleteStudent(int id)
    {
        given()
                .queryParam("id",id)
                .when()
                .delete(usersPath)
                .then()
                .statusCode(204);
    }

}

package com.apitest.steps;

import com.apitest.config.BaseUrl;
import com.thoughtworks.gauge.Step;
import static com.apitest.config.Endpoints.usersPath;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers.*;
import org.junit.Assert;


public class GetMethods extends BaseUrl {

    @Step("Kullanıcı listesinin tümünü getir")
    public void getAllUsers() {
        Response response = given().
                when().
                      get(usersPath);
                response.
                        then().
                      log().all();
        Assert.assertEquals(200, response.statusCode());
    }

    @Step("id = <id> olan kullanıcı bilgilerini getir")
    public void getUserInfoWithId(int id){
         given().
                queryParam("id",id).
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
        when().
               get(usersPath).
        then().
                log().body();

    }


}


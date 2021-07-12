package com.apitest.config;

import com.thoughtworks.gauge.BeforeStep;
import com.thoughtworks.gauge.BeforeSuite;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.lessThan;


public class BaseUrl {
    public static RequestSpecification endpointRequest;
    public static ResponseSpecification endpointResponse;

    @BeforeSuite
    public static void setUp(){
        endpointRequest = new RequestSpecBuilder()
                .setBaseUri("http://jsonplaceholder.typicode.com/")
                .addFilter(new RequestLoggingFilter())
                .build();

        endpointResponse = new ResponseSpecBuilder()
                .build();
        RestAssured.requestSpecification = endpointRequest;
        RestAssured.responseSpecification = endpointResponse;
    }
}



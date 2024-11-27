package com.thetestingacademy.SampleCheck;

import io.restassured.RestAssured;

public class APITest002 {
    public static void main(String[] args) {
       //Gkerkins Syntax
       //Full URL -> https://restful-booker.herokuapp.com/1
       //base URI -> https://restful-booker.herokuapp.com
       //base Path -> /booking/1
        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/booking/1")
                .when()
                    .get()
                .then().log().all()
                    .statusCode(200);



    }
}

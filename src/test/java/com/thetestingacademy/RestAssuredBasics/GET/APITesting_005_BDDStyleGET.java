package com.thetestingacademy.RestAssuredBasics.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting_005_BDDStyleGET {
    @Test
    public void test_GET_Req_POSITIVE() {

        String pin_code = "600028";
        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us/")
                    .basePath("/IN/" + pin_code)
                .when()
                    .log()
                    .all()
                    .get()
                .then()
                    .log()
                    .all()
                .statusCode(200);
    }
        @Test
        public void test_GET_Req_NEGATIVE(){

            String pin_code = "-1";
            RestAssured
                    .given()
                    .baseUri("https://api.zippopotam.us/")
                    .basePath("/IN/" +pin_code)
                    .when()
                    .log()
                    .all()
                    .get()
                    .then()
                    .log()
                    .all()
                    .statusCode(404);


    }
}

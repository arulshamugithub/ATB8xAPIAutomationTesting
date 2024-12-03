package com.thetestingacademy.RestAssuredBasics.PUT;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting010_PATCH_NonBDDStyle {

    @Description("Verify the PUT Request for the restful booker")
    @Test

    public void test_put_non_bdd(){
        //booking ID
        //Token
        String token = "88f38fbc0f45d5b";
        String bookingid = "6458";

        String payload = "{\n" +
                "    \"firstname\" : \"Arul\",\n" +
                "    \"lastname\" : \"JK\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        RequestSpecification rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com/");
        rs.basePath("/booking/" +bookingid);
        rs.contentType(ContentType.JSON);
        rs.auth().preemptive().basic("admin","paswword123");
        rs.cookie("token",token);
        rs.body(payload).log().all();
        Response response = rs.when().put();
        ValidatableResponse validatableResponse = response.then().log().all();

        validatableResponse.statusCode(200);

    }
}

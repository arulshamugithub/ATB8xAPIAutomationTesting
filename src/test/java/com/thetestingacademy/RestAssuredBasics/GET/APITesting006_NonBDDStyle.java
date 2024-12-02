package com.thetestingacademy.RestAssuredBasics.GET;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting006_NonBDDStyle {

    static RequestSpecification r = RestAssured.given();

    @Severity(SeverityLevel.CRITICAL)
    @Description("TC1 - NonBDDStyleGET - Positive Testcase")
    @Test
    public void test_NonBDDStyleGET_Positive(){

        r.baseUri("https://api.zippopotam.us/");
        r.basePath("/IN/388620");
        r.when().log().all().get();
        r.then().log().all().statusCode(200);

    }
    @Severity(SeverityLevel.CRITICAL)
    @Description("TC1 - NonBDDStyleGET - Negative Testcase")
    @Test
    public void test_NonBDDStyleGET_Negative(){
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us/");
        r.basePath("/IN/-1");
        r.when().log().all().get();
        r.then().log().all().statusCode(404);

    }

}

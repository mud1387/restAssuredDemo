package controller;

import Model.userRequest;
import Model.userResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class userController  extends abstractController{

    public RequestSpecification spec;
    public userController(String baseURI){
         spec=super.templateSetup(baseURI);
    }

    public userResponse createUser(String basePath, userRequest body) {
        try {
            Response res = given()
                    .spec(spec)
                    .when().body(body).post(basePath)
                    .then().assertThat().statusCode(201)
                    .extract().response();
            return res.as(userResponse.class);
        } catch (Exception e) {
            System.out.println("Exception in retreiving the results. "+ e.getMessage());
            return null;
        }
    }
}

package controller;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class bookStoreController extends abstractController {
    public RequestSpecification spec;
    public bookStoreController(String baseURI) {
        spec=super.templateSetup(baseURI);
    }

    public String getBookUsingISBN(String basePath, String queryParam, String queryParamValue) {
        try {
            Response res = given()
                    .spec(spec)
                    .queryParam(queryParam, queryParamValue)
                    .when().get(basePath)
                    .then().assertThat().statusCode(200)
                    .extract().response();
            return res.asString();
        } catch (Exception e) {
            System.out.println("Exception in retreiving the results");
            return null;
        }
    }

    public String getBooks(String basePath) {
        try {
            Response res = given()
                    .spec(spec)
                    .when().get(basePath)
                    .then().assertThat().statusCode(200)
                    .extract().response();
            return res.asString();
        } catch (Exception e) {
            System.out.println("Exception in retreiving the results. " + e.getMessage());
            return null;
        }
    }

}

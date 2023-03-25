package controller;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utility.utility;
public abstract class abstractController {

    public String getBaseUri() {
        return baseUri;
    }

    public void setBaseUri(String baseUri) {
        this.baseUri = baseUri;
    }

    private String baseUri;

    RequestSpecification templateSetup(String baseURI) {
        System.out.println(baseURI);
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();
        if (baseURI.toLowerCase().contains("book")){
            baseURI=utility.pro.getProperty("baseURI");
            RequestSpecification spec = new RequestSpecBuilder()
                    .setBaseUri(baseURI)
                    .setContentType(ContentType.JSON)
                    .log(LogDetail.URI)
                    .build();
            return spec;
        }else{baseURI=utility.pro.getProperty("createUserBaseURI");
            RequestSpecification spec2= new RequestSpecBuilder()
                .setBaseUri(baseURI)
                .setContentType(ContentType.JSON)
                .log(LogDetail.URI)
                .build(); return spec2;}
    }
}

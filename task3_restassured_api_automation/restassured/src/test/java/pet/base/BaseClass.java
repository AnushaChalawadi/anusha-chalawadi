package pet.base;

import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pet.Constants.Endpoints;

public class BaseClass {

    protected RequestSpecification requestSpec;
    protected ResponseSpecification responseSpec;

 @BeforeClass
    public void setup() {
        RestAssured.baseURI = Endpoints.BASE_URL;

        requestSpec = new RequestSpecBuilder()
                .setContentType("application/json")
                .setAccept("application/json")
                .log(LogDetail.ALL)
                .build();
    }
}
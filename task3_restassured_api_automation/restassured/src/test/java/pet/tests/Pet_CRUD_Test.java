package pet.tests;

import pet.Constants.Endpoints;
import pet.base.BaseClass;
import pet.client.models.Pet;
import pet.utils.api.PetRequestBuilder;
import pet.utils.api.TestData;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Pet_CRUD_Test extends BaseClass {

    // private long petId = TestData.PET_ID;

    @Test
    public void creatPet() {
        Pet pet = PetRequestBuilder.postPet();

        given()
                .spec(requestSpec)
                .body(pet)
                .when()
                .post(Endpoints.CREATE_PET)
                .then()
                .statusCode(200)
                .body("id", equalTo((int) TestData.PET_ID));
    }
}


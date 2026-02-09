package pet.client;

import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import pet.client.models.Pet;
import pet.constants.Endpoints;
import pet.utils.api.TestData;
import io.restassured.response.Response;

public class PetEndpoints {
    public static Response createPet(RequestSpecification spec, Pet payload) {
        return given()
                .spec(spec)
                .body(payload)
                .when()
                .post(Endpoints.ADD_UPDATE_PET);
    }

    public static Response getPetById(RequestSpecification spec, long petId) {
        return given()
                .spec(spec)
                .pathParam("petId", petId)
                .when()
                .get(Endpoints.GET_PET_BY_ID);
    }

    public static Response updatePet(RequestSpecification spec, Pet Payload) {
        return given()
                .spec(spec)
                .body(Payload)
                .when()
                .put(Endpoints.ADD_UPDATE_PET);
    }

    public static Response updatePetWithForm(RequestSpecification spec, long petId) {
        return given()
                .spec(spec)
                .contentType("application/x-www-form-urlencoded")
                .pathParam("petId", TestData.PET_ID)
                .formParam("name", TestData.UPDATED_PET_NAME)
                .formParam("status", TestData.STATUS_SOLD)
                .when()
                .post(Endpoints.UPDATE_PET_WITH_FORM);
    }

    public static Response findByStatus(RequestSpecification spec, String status) {
        return given()
                .spec(spec)
                .queryParam("status", TestData.STATUS_AVAILABLE)
                .when()
                .get(Endpoints.FIND_BY_STATUS);
    }

    public static Response deletePet(RequestSpecification spec, long petId) {
        return given()
                .spec(spec)
                .pathParam("petId", TestData.PET_ID)
                .when()
                .delete(Endpoints.DELETE_PET);
    }
}
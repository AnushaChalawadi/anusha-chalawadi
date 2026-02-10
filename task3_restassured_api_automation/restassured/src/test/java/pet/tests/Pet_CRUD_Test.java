package pet.tests;

import pet.base.BaseClass;
import pet.client.PetEndpoints;
import pet.client.models.Pet;
import pet.constants.AppConstants;
import pet.utils.api.PetRequestBuilder;
import pet.utils.api.TestData;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.Assert;

public class Pet_CRUD_Test extends BaseClass {

    @Test(priority = 1)
    @Description("Create a new pet and verify status code")
    public void testCreatPet() {
        // Step 1. Prepare the pet data
        Pet payload = PetRequestBuilder.postPetRequest();

        // Step 2. Make POST Api call
        Response response = PetEndpoints.createPet(requestSpec, payload);

        // Step 3. Validate the response
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), AppConstants.STATUS_CODE_SUCCESS, "Create pet failed");
        Assert.assertEquals(response.jsonPath().getLong("id"), TestData.PET_ID);
    }

    @Test
    @Description("Update existing pet")
    public void testUpdateExistingPet() {

        // Step 1. Prepare the updated pet data
        Pet payload = PetRequestBuilder.updatePetRequest();

        // Step 2. Make PUT Api call
        Response response = PetEndpoints.updatePet(requestSpec, payload);

        // Step 3. Validate the response
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), AppConstants.STATUS_CODE_SUCCESS, "Put /pet failed");
        Assert.assertEquals(response.jsonPath().getString("name"), TestData.UPDATED_PET_NAME);

    }

    @Test(dependsOnMethods = "testCreatPet")
    @Description("Retrieve pet by ID and verify details")
    public void testGetPetById() {

        // Step 1. Prepare the updated GET pet data
        Response response = PetEndpoints.getPetById(requestSpec, TestData.PET_ID);

        // Step 2. Validate the response
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), AppConstants.STATUS_CODE_SUCCESS, "Get pet by id failed");
        Assert.assertEquals(response.jsonPath().getString("name"), TestData.PET_NAME);
    }

    @Test
    @Description("Update pet details using Form Data")
    public void testUpdatePetWithFormData() {

        // Step 1. Prepare the updatedPet with form Data
        Response response = PetEndpoints.updatePetWithForm(requestSpec, TestData.PET_ID);

        // Step 2. Validate the response
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), AppConstants.STATUS_CODE_SUCCESS, "Update with form data failed");
    }

    @Test(dependsOnMethods = "testCreatPet")
    @Description("Find Pet by Status")
    public void testFindPetByStatus() {

        // Step 1. Prepare the find by status data
        Response response = PetEndpoints.findByStatus(requestSpec, TestData.STATUS_AVAILABLE);

        // Step 2. Validate the response
        Assert.assertEquals(response.getStatusCode(), AppConstants.STATUS_CODE_SUCCESS);
        java.util.List<Object> petList = response.jsonPath().getList("$");

        response.then().log().all();
        Assert.assertNotNull(petList, "The response list is null!");
        Assert.assertTrue(petList.size() > 0, "The pet list is empty!");
    }

    @Test
    @Description("Delete Pet with ID")
    public void testDeletePet() {

        // Step 1. Prepare data to delete
        Response response = PetEndpoints.deletePet(requestSpec, TestData.PET_ID);

        // Step 2. Validate the response
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), AppConstants.STATUS_CODE_SUCCESS, "Delete /pet failed");
        Assert.assertEquals(response.jsonPath().getString("message"), String.valueOf(TestData.PET_ID));

    }

    @Test
    @Description("Invalid Pet ID")
    public void invalidPetID() {

        // Step 1. Prepare the updated GET pet data
        Response response = PetEndpoints.getInvalidPetID(requestSpec, TestData.INVALID_PET_ID);

        // Step 2. Validate the response
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), AppConstants.STATUS_CODE_NOT_FOUND, "Get pet by id failed");
        Assert.assertEquals(response.jsonPath().getString("message"), TestData.PET_NOT_FOUND);

    }

}

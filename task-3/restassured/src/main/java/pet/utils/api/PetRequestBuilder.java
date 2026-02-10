package pet.utils.api;

import java.util.Arrays;
import java.util.List;

import pet.client.models.Category;
import pet.client.models.Pet;
import pet.client.models.Tag;

public class PetRequestBuilder {

        // Post -> Create Pet Request
        public static Pet postPetRequest() {

                List<Tag> tags = Arrays.asList(
                                new Tag(TestData.TAG_ID, TestData.TAG_NAME));

                return new Pet(
                                TestData.PET_ID,
                                TestData.PET_NAME,
                                new Category(TestData.CATEGORY_ID, TestData.CATEGORY_NAME),
                                TestData.PHOTO_URLS,
                                tags,
                                TestData.STATUS_AVAILABLE);
        }

        // Put -> Update an existing pet
        public static Pet updatePetRequest() {

                List<Tag> tags = Arrays.asList(
                                new Tag(TestData.TAG_ID, TestData.TAG_NAME));

                return new Pet(
                                TestData.PET_ID,
                                TestData.UPDATED_PET_NAME,
                                new Category(TestData.CATEGORY_ID, TestData.CATEGORY_NAME),
                                TestData.PHOTO_URLS,
                                tags,
                                TestData.STATUS_SOLD);
        }

}
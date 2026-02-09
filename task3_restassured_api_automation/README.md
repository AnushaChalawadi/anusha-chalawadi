# Rest Assured API Automation - Swagger Pet
### Overview
This project contains automated REST API tests for the Swagger Pet API using Java and Rest Assured.
The tests cover CRUD operations on the Pet domain, validating API behavior, request/response and HTTP status codes.

### Tech Stack
 - Language: Java
 - Test Framework: Rest Assured API Automation
 - TestNG: Test execution and assertions
 - Maven: Dependency management and build tool

### Project Structure

### Key Components
  - BaseClass

### API Coverage
The following CRUD operations are automated for PET domain
1. Create Pet -> POST /api/v3/pet endpoint
2. Update existing Pet -> PUT /api/v3/pet endpoint
3. Get Pet by ID -> GET /api/v3/pet/{petId}
4. Update Pet(Form data) -> POST /api/v3/pet/{petId}name={petname}&status={status}
5. Find Pet by status -> GET api/v3/pet/findByStatus?status={status}
6. Delete Pet -> DELETE /api/v3/pet/{petId}

### Each test validated with:
 - HTTP status code
 - Response body fields
 - Data consistency

### Setup
Prerequisites

Ensure the following are installed on your system:
 - Java
 - Maven
 - Vs code/Intellij
 - Git installed
 
API Availability
 - Public Swagger PetStore:
   https://petstore3.swagger.io/ 
 - Locally running
   http://localhost:8080/ 

### How to Run the tests
1. Clone the repository
```
   git clone <repository-name>
   cd <repository-name>/restassured>
```
2. Run tests using maven
```
   mvn clean test
```
3. View Results

### Framwork Approach
1. Separation of Concers
 - I separated the test logic, test data, endpoints, constants and request model, to improve reability and maintainability.

2. No Hardcorded data in Tests
 - All Test data i have managed in the TestData.java file and request builders.
 This allows easy access and reuse.

 3. Use of Models(POJOs)
  - Request and Response are mapped to java objects
  - It improves type safety and reduces JSON handling errors
  - It makes tests easier to access, read and maintain

4. Reusability and Maintainability
 - Centralized endpoints, BaseClass
 - I focused strictly on business logic in tests file and validation using TestNg.

### Why This Teck Stack and Approach
1. RestAssured is a simple and maintainable framework for API Testing.
2. Java is a strong typing and with the TestNG flexible test execution and assertions.
3. Using industry-standard Maven build and dependency management make more easies to download all required dependencies.
4. Reusability: API logic is centralized. If the /pet endpoint changes, we only updated one file.
5. Readability: Tests are clean and readable.
6. Scability: Adding new modules (User, Store) is a simple as creating a new Endpoint class and a new Test class







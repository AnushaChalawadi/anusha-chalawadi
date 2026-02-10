# Rest Assured API Automation - Swagger Pet
## Overview
This project contains automated REST API tests for the Swagger Pet API using Java and Rest Assured.
The tests cover CRUD operations on the Pet domain, validating API behavior, request/response and HTTP status codes.
Test execution generates Allure reports for detailed test results, including request and response logging and Reports screenshots will be available in reports/ directory.

## Tech Stack
 - Language: Java
 - Test Framework: Rest Assured API Automation
 - TestNG: Test execution and assertions
 - Maven: Dependency management and build tool
 - Test Reporting: Allure

## Project Structure
```
  task3_restassured_api_automation
└── restassured
    ├── .allure/               # Allure history and configuration
    ├── allure-report/         # Generated Allure HTML reports
    ├── reports/               # Adding reports screenshots
    ├── src
    │   ├── main/java/pet
    │   │   ├── client
    │   │   │   ├── models/    # POJO classes (Pet, Category, Tag)
    │   │   │   └── PetEndpoints.java
    │   │   ├── constants/     # Application and API Endpoints constants
    │   │   └── utils/api/     # Request builders and data providers
    │   └── test/java/pet
    │       ├── base/          # Base setup and teardown logic
    │       └── tests/         # Functional Test Scripts (CRUD)
    ├── target/                # Compiled bytecode and build artifacts
    ├── pom.xml                # Maven dependencies and plugins
    ├── testng.xml             # Test suite configuration
    └── README.md              # Project documentation
```


## API Coverage
The following CRUD operations are automated for PET domain
1. Create Pet -> POST /api/v3/pet endpoint
2. Update existing Pet -> PUT /api/v3/pet endpoint
3. Get Pet by ID -> GET /api/v3/pet/{petId}
4. Update Pet(Form data) -> POST /api/v3/pet/{petId}name={petname}&status={status}
5. Find Pet by status -> GET api/v3/pet/findByStatus?status={status}
6. Delete Pet -> DELETE /api/v3/pet/{petId}
7. Invalid Pet ID -> GET /api/v3/pet/{invalid_petId}

## Each test validated with:
 - HTTP status code
 - Response body fields
 - Data consistency

## Setup Instructions
### Prerequisites

Ensure the following are installed on your system:
 - Java - "21.0.7"
 - Maven - Apache Maven 3.9.10
 - Vs code/Intellij
 - Git installed
 
### API Availability
 - Public Swagger PetStore:
   https://petstore3.swagger.io/ 
 - Locally running
   http://localhost:8080/ 

## How to Run the tests
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
```
  mvn allure:report
```
Open Allure report in browser
```
  mvn allure:serve
```
## Reporting
Allure reports are generated in:
```
  target/site/allure-maven-plugin
```

Open the report:
```
  mvn allure:serve
```  
The report provides detailed logs for all requests and responses executed during the tests.


## Framework Approach
1. Separation of Concerns
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

## Why This Teck Stack and Approach?
1. RestAssured is a simple, readable and maintainable framework for API Testing.
2. Java provides typing and with the TestNG flexible test execution and assertions.
3. Using industry-standard Maven build and dependency management make more easies to download all required dependencies.
4. Reusability: API logic is centralized. If the /pet endpoint changes, we only updated one file.
5. Readability: Tests are clean and readable.
6. Scability: Adding new modules (User, Store) is a simple as creating a new Endpoint class and a new Test class.







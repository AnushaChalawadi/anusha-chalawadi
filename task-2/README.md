# Monefy Android Automation Project

## Project Overview
This project contains end-to-end (E2E) automated tests for the Monefy Android application, covering all main user workflows for account, expenses and income management.

The automation validates the following user flows:

- Account Creation and Selection for Transactions
- Create, Edit, Delete Expense
- Income and Expense balance validation flow

These flows were selected because they directly impact financial accuracy, user trust, and core product usability.
The tests are designed to ensure that key financial operations in Monefy work correctly and reliably.

## Selected E2E User Flows and Business Importance
### 1. Create and Select Account Flow 
 - Account management is foundational for organizing financial data.

### 2. Create, Edit, Delete Expense
 - Expenses are the most frequently used feature in the app. Any failure leads to incorrect balances and broken financial insights and Trust.

### 3. Income and Expense balance validation flow
 - Income and Expense are the core functionality and the highest-risk area of an Monefy Application.

## Key Features:
- Page Object Model (POM) design pattern
- Reusable utility methods and test data management
- Comprehensive E2E test coverage
- Detailed reporting with Allure
- Robust error handling and wait strategies

## Tech Stack
- Programming Language - Java
- Mobile Automation Framework - Appium with TestNG
- Dependency Managment - Maven
- Design Pattern - Page Object Model
- Reporting - Allure

## Project Structure
```
monefy/
│
├── src/
│   ├── main/java/
│   │   ├── pages/                          
│   │   │   ├── AccountSelectionPage.java   # Account list screen
│   │   │   ├── AddExpensePage.java         # Expense entry screen
│   │   │   ├── AddIncomePage.java          # Income entry screen
│   │   │   ├── HomePage.java               # Main app screen
│   │   │   └── TransactionDetailsPage.java # Transaction history
│   │   │
│   │   └── utils/                         
│   │       ├── AndroidTestData.java        # Test data constants
│   │       ├── CommonActions.java          # Reusable methonds
│   │       └── DriverManager.java          # Appium driver configuration
│   │
│   └── test/java/androidtests/             
│       ├── BaseClass.java                  # Base test setup/teardown
│       ├── E2E_CreateAndSelectAccountTest.java  # Account creation tests
│       ├── E2E_ExpensesFlowTest.java           # Expense flow tests
│       └── E2E_IncomeExpenseFlowTest.java      # Income/Expense tests
│
├── pom.xml                    # Maven dependencies & plugins
├── testng.xml                 # TestNG suite configuration
├── .gitignore                 # Git ignore rules
└── README.md                  # This file

```
## Prerequisites
1. Software Requirements
- Java JDK - java version "21.0.7"
- Maven - Apache Maven 3.9.10
- Appium Server - 3.2.0
- Android Studio + SDK installed 
- Appium Inspector
- Device or Emulator configured
- Ensure the Monefy app is installed on the device/emulator.

2. Android Setup
- Android SDK
- Android Emulator
- Monefy APK

## Setup Instructions
### Step 1: Clone the Repository
```
git clone <repositoryName>
cd monefy
```
### Step 2: Install Dependencies
```
mvn clean install
```
### Step 3: Start Appium Server
```
    Appium
```
### Step 4: Connect Android Device/Emulator

**For Emulator:**
### List available emulators
```
    emulator -list-avds
```
### Devices connected
``` 
    adb devices
```   

## How to Run Tests
1. If want to run all tests
```
    mvn test
```  
2. Run specific TestNG class
```
    mvn clean test -Dtest=<ClassName>
```
3. Run with TestNG XML
```
    mvn test -DsuiteXmlFile=testng.xml
```

## Test Scenarios Covered and Execution Flow

TestCase_01: E2E_CreateAndSelectAccountTest

Steps:
- Navigate to Accounts section
- Click "Add New Account"
- Enter account name(example: My Cash)
- Select account icon/type
- Save account
- Verify account appears in account list
- Select newly created account
- Verify account name displays in header
- Create Income with Newly created account
- Verifies Income should be able to create with New Account

TestCase_02: E2E_ExpensesFlowTest

Steps:
- Verify main page is displayed
- Click Expense button
- Select category
- Click on Balance history to edit expense
- Deletes the expense
- Verifies the amount in each step and in transaction history

TestCase_03: E2E_IncomeExpenseFlowTest

Steps:
- Adds income 
- Adds expense 
- Validates balance changes correctly after transactions

## Reporting
1. Allure Reports
Generate and view Allure reports:
```
allure serve allure-results
```
2. TestNG Reports
After test execution, find reports at:
```
target/surefire-reports/index.html
```

## Approach and Best Practices
1. Page Object Model (POM)
Each screen (HomePage, AddExpense, AddIncome, TransactionDetailsPage, AccountSelection) has its own class
Encapsulates locators and actions, making tests modular and reusable
2. Modern Appium Usage
WebElement replaces deprecated MobileElement
Explicit waits ensure elements are clickable or visible before interacting
3. TestNG Features
@Test(priority) sequences the flows logically
Assertions verify creation, edit, and deletion of transactions

 ## Why this stack?
- Java with TestNG : Industry standard for test automation, easy to integrate with CI/CD
- Appium, supports for the mobile automation on real devices and with emulators
- Framework maintainability using POM keeps locators and actions separate from test logic, making tests easier to maintain.
- With Maven, it handles all dependecies and simplifies runnings tests

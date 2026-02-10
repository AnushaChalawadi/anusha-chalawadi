# Task 1: Exploratory Testing Session - Monefy android app

## 1. Exploratory Testing Charters
This document summarizes an exploratory testing session performed on the Monefy Android application.
Focused on functionality, integration, usability, data-related risk in a personal finance tracking application.

### Charter 1: Core Income and Expense functionality 
**Mission:** Explore the manual transaction entry, ability to add, edit and delete the income and expenses to understand how reliably the application handles financial data and user actions.

**Areas Covered:**
- Adding new income transactions('+')
- Adding new expense transactions('-') with different categories
- Editing the amount, category, date and description of existing expense or income via 'Balance' list
- Deleting transactions and verifying the immediate reversal of the amount from the total balance
- Transaction validation (negative amounts, zero amounts, large amounts) within the amount field
- Date picker functioanlity(past dates, future dates, edge dates)
- Validation of mandatory fields

**Test Data:**
- Various transaction amounts(eg: small-99, large-99999, decimal- 90.09)
- Different dates(day, week, month, all, interval, future dates)
- Multiple categories

**Expected Result:** Users can add, edit, and delete transactions without data loss or calculation errors.

### Charter 2: Category Management
**Mission:** Explore creation, modification and deletion categories to understand how changes affect existing expense data and reporting accuracy.

**Areas Covered:**
- Creating custom expense categories
- Creating custom income categories
- Editing category names and icons
- Deleting categories with existing transactions
- Observe impact on historical expense data

**Test Data:**
- Multiple custom category names
- Multiple transactions per category

**Expected Result:** Category changes should preserve historical data and clearly communicate any impacts to users.

### Charter 3: Account Management and Multi-Account Support
**Mission:** Explore account creation, switching and transfer functionality

**Areas Covered:**
- Creating new accounts(cash, card, savings)
- Switching between multiple accounts
- Transferring money between accounts
- Account balance accuracy after transfers
- Editing account names and properties
- Deleting account with existing transactions
- Multi-currency account handling

**Test Data:**
- Multiple account types
- Transfer amounts of varying sizes
- Account with different currencies

**Expected Result:** Account balances remain accurate across all actions without data loss.

### Charter 4: Data Persistence
**Mission:** Explore how reliably expense data is stored and retained across app restarts and navigation flows.

**Areas Covered:**
- App backgrounding and reopening
- Full app restart
- Navigation between different views
- Verification of previously added expenses

**Test Data:**
- Recently added expenses
- Edited expenses

**Expected Result:** All transactions made should remain consistent across app restarts or navigation flow.

### Charter 5: Data Visualization and Reporting
**Mission:** Explore charts and reporting features

**Areas Covered:**
- Pie chart accuracy for expenses
- Balance display over time periods
- Filtering by date ranges like(day,week, month, year, all, interval, custom)
- Cateory breakdown visualization
- Income vs expense comparison
- Percentage calculations
- Data aggregation accuracy

**Test Data:**
- Multiple transactions across different dates
- Transactions in multiple categories
- Both income and expenses

**Expected Result:** Charts should reflect correctly with accurate data.

### Charter 6: Settings and Configuration
**Mission:** Explore app settings, preferences and configuration options to understand their impact on existing financial data and user interpretation of information.

**Areas Covered:**
- Currency selection and changing
- First day of week/month settings
- Language selection
- Theme switching (light/dark)
- Passcode/fingerprint protection
- Observing impact on existing expense values 

**Test Data:**
- Different currency formats
- Existing data when changing settings

**Expected Result:** Changes to settings(currency, language etc) should apply consistency without any UI Issues or corrupting.

### Charter 7: Budget and Planning Features
**Mission:** Explore budget setting and monitoring capabilities

**Areas Covered:**
- Setting monthly budget amount
- Budget carry over behavior
- Budget reset functionality
- Overspending indicators
- Future recurring records

**Test Data:**
- Transactions that exceed budget
- Transactions approaching budget limit
- Multiple budget periods

**Expected Result:** Budget planning functionality should be work as expected, without any data loss between carry over behavior

### Charter 8: Data Backup and Export
**Mission:** Explore data backup, restore and export functionality

**Areas Covered:**
- Creating manual backups
- Restoring data from backup
- Data Integrity after restore
- Export file format and structure
- Dropbox sunc configuration
- Google drive Integration
- Backup file location and accessibility

**Test Data:**
- Multiple accounts and categories
- Dropbox/Google drive accounts for testing sync

**Expected Result:** Backup, restore and export opertaion preserve complete and accurate data across all accounts.

### Charter 9: User Interface and Usability
**Mission:** Explore UI responsiveness, navigation and user experience

**Areas to Cover:**
- Navigation flow and Icon clarity between screens
- Back button behavior
- Gesture support (swipe, long press, double tap)
- Visual feedback after user actions
- Error message clarity
- Accessibility features

**Test Data:**
- Empty input fields

**Expected Result:** The UI should be responsive and accessible to user with clear feedback for all actions.

### Charter 10: Data Integrity and Mathematical Calculations
**Mission:** Explore mathematical accuracy and data consistency

**Areas to Cover:**
- Balance calculation accuracy
- Addition/Subtraction amounts
- Decimal precision handling
- Amount Rounding behavior
- Large Number handling

**Test Data:**
- Precise decimal amounts
- Large transaction amounts
- Complex transaction sequence

**Expected Result:** Data should be mathematical correct, stable across edge cases invloving large values

### Charter 11: Performace and Responsiveness for Edge Cases
**Mission:** Explore app responsiveness during normal usage and various conditions to identify any noticeable delays or performace issues

**Areas to Cover:**
- App launch time 
- Adding, editing and deleting expenses
- Navigating between screens
- Response time for calculations
- App behavior during any interruptions(calls, notifications)

**Test Data:**
- Multiple accounts and categories
- Offline environment

**Expected Result:** The Performance of the application should remain stable and responsiveness for all edge cases

## 2. Findings from Charters 

### Charter 1: Core Income and Expense functionality
### Findings_01: Lack of explict save affirmation
- Expense creation worked as expected
- Editing expenses or income is generally stable, but Auto-save mechanism without a dedicated 'Save' or 'Done' button on the edit screen, users often feel uncertain whether their changes were successfully committed. To confirm an edit, users must manually tap the back arrow

### Findings_02: Risk of accidental deletion
- Deleting an expense requires a confirmation to delete, which could lead to accidental data loss

### Charter 2: Category Management
### Findings_01: Feature Limitation for Free Version
- Adding custom categories is not allowed for Free version
- No subcategory functionality for free versions.

### Findings_02: Renaming and Deletion Category feels risky
- Renaming and deleting category did not clearly communicate how historical expenses were effected

### Charter 3: Account Management and Multi-Account Support
### Findings_01: Lack of explict save affirmantion
- Editing the account is generally Auto-Save mechanism, but without dedicated 'Save' or 'Done' button on edit screen, Users will be in a confusion whether the changes are save sucessfully committed.
### Findings_02: Allows Duplicate account names
- Account names allowed duplicate names, which may cause confusion to users
### Findings_03: No Quick overview of balances
- There no quick overview of total balances across all accounts

### Charter 4: Data Persistence
### Findings_01: Device change / reinstall behavior unclear 
- Unclear behavior when switching devices or reinstalling app, No previous transaction

### Charter 5: Data Visualization and Reporting
**Finding 1:** No major functional issues observed

### Charter 6: Settings and Configuration
### Findings_01 : Currency change behavior unclear 
- Changing currency settings was possible
- The app did not clearly indicate whether existing expenses were recalculated or only displayed differently after the change, this behavior mislead the users
- Themes selection are restricted to the Free version, which limits financial planning usability.

### Charter 7: Budget and Planning Features
### Findings_01 : Feature restrictions in free version 
- Use of dropbox, Google Drive is not in Free Version

### Charter 8: Data Backup and Export
### Findings_01 : Limited export formats
- Data can be exported only in CSV format

### Charter 11: Performance and Responsiveness
**Finding 1:** No noticeable performance degradation  
- App remained responsive during navigation, transaction creation, and background/foreground transitions.

## 3. Bugs Identified
```
BUG_01_HomPage  
    - Title : Duplicate hamburger menus
    - Description : The app features two separate "hamburger" menus that both lead to the same history page, creating unnecessary complexity
    - Severity : Medium  
```
```
BUG_02_Budget and planning feature
    - Title : Incorrect validation message for zero budget
    - Description : when user click on budget mode and add zero number should appear message "enter valid number" but appear message "budget ammount should be positive" while zero is not a negative number handling message
    - Severity : Medium 
```
```
BUG_03_Settings and Configuration
    - Title : Incomplete language translation
    - Description : Changing language when change it from english to german not all text and pages displayed into german
    - Severity : High 
```

## 4. Charter Prioritization

```
Charter 1: Core Income and Expense functionality
Priority : P0
Reason : Core financial functionality — any defects directly affect user trust and data accuracy
```
```
Charter 10: Data Integrity and Mathematical Calculations
Priority : P0
Reason : Incorrect balances or calculations create critical financial risk
```
```
Charter 4: Data Persistence
Priority : P1
Reason : Loss of financial data severely impacts user confidence
```
```
Charter 3: Account Management and Multi-Account Support
Priority : P1
Reason : Multi-account errors can cause incorrect financial decisions
```
```
Charter 5: Data Visualization and Reporting
Priority : P2
Reason : Impacts user insights but not core data correctness
```
```
Charter 7: Budget and Planning Features
Priority : P3
Reason : Value-add feature, less critical than transaction correctness
```
```
Charter 9: User Interface and Usability 
Priority : P3
Reason : Impacts experience but not financial accuracy. 
```
```
Charter 11: Performace and Responsiveness for Edge Cases
Priority : P3
Reason : No issues observed, but monitored for scale risks. 
```

## 5. Risk Analysis for Personal Finance Applications
1. Data Accuracy & Financial Integrity Risks (Highest Priority)
    Risk:
    Incorrect balances, rounding errors, or transaction miscalculations can lead users to make wrong financial decisions and lose trust.

    Mitigation:
    Extensive testing of calculations, decimals, currency handling
    Regression tests around balance updates, edits, and deletions and Edge-case testing

2. Data Loss & Persistence Risks
    Risk:
    Users losing financial history due to crashes, reinstallations, sync failures, or backups not restoring correctly.

    Mitigation:
    Persistence testing across app restarts, updates, and device changes

3. Localization & Currency Risks
    Risk:
    Incorrect currency formatting, conversion logic, or partial translations leading to misinterpretation of financial values.

    Mitigation:
    Multi-currency testing
    Language switching validation

4. Reporting & Visualization Risks
    Risk:
    Charts and summaries showing misleading data due to aggregation or filtering errors.

    Mitigation:
    Cross-checking reports against raw transaction data
    Date-range and category-filter testing
    Boundary and aggregation testing

5. Performance & Scalability Risks
    Risk:
    Slow app behavior or crashes when data volume grows or network conditions degrade.

    Mitigation:
    Performance testing with large datasets
    Background/foreground transition testing
    Offline mode testing
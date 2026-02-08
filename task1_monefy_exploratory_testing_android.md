# Task 1: Exploratory Testing Session of the Monefy android app

## Exploratory testing charters
This document summarizes an exploratory testing session performed on the Monefy Android application.
Focused on functionality, integration, usability, data-related risk in a personal finance tracking application.

### Charter 1: Core Income and Expense functionality 
**Mission:** Explore the manual transaction entry, ability to add, edit and delete the income and expenses to understand how reliably the application handles financial data and user actions.

**Areas to Cover:**
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

### Charter 2: Category Management
**Mission:** Explore creating, modification and deleting categories to understand how changes affect existing expense data and reporting accuracy.

**Areas to Cover:**
- Creating custom expense categories
- Creating custom income categories
- Editing category names and icons
- Deleting categories with existing transactions
- Observe impact on historical expense data

**Test Data:**
- Multiple custom category names
- Multiple transactions per category

### Charter 3: Account Management and Multi-Account Support
**Mission:** Explore account creation, switching and transfer functionality

**Areas to Cover:**
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

### Charter 4: Data Persistence
**Mission:** Explore how reliably expense data is stored and retained across app restarts and navigation flows.

**Areas to Cover:**
- App backgrounding and reopening
- Full app restart
- Navigation between different views
- Verification of previously added expenses

**Test Data:**
- Recently added expenses
- Edited expenses

### Charter 5: Data Visualization and Reporting
**Mission:** Explore charts and reporting features

**Areas to Cover:**
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

### Charter 6: Settings and Configuration
**Mission:** Explore app settings, preferences and configuration options to understand their impact on existing financial data and user interpretation of information.

**Areas to Cover:**
- Currency selection and changing
- First day of week/month settings
- Language selection
- Theme switching (light/dark)
- Passcode/fingerprint protection
- Observing impact on existing expense values 

**Test Data:**
- Different currency formats
- Existing data when changing settings

### Charter 7: Budget and Planning Features
**Mission:** Explore budget setting and monitoring capabilities

**Areas to Cover:**
- Setting monthly budget amount
- Budget carry over behavior
- Budget reset functionality
- Overspending indicators
- Future recurring records

**Test Data:**
- Transactions that exceed budget
- Transactions approaching budget limit
- Multiple budget periods

### Charter 8: Data Backup and Export
**Mission:** Explore data backup, restore and export functionality

**Areas to Cover:**
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

## Findings from Charters 

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

### Findings_02: Renaming and Deletion Category feelis risky
- Renaming and deleting category did not clearly communicate how historical expenses were effected

### Charter 3: Account Management and Multi-Account Support
### Findings_01: Lack of explict save affirmantion
- Editing the account is generally Auto-Save mechanism, but without dedicated 'Save' or 'Done' button on edit screen, Users will be in a confusion whether the changes are save sucessfully committed.
### Findings_02: Allows Duplicate account names
- Account names allowed duplicate names, which may cause confusion to users
### Findings_03: No Quick overview of balances
- There no quick overview of total balances across all accounts

### Charter 4: Data Persistence
### Findings_01:
- Unclear behavior when switching devices or reinstalling app

### Charter 5: Data Visualization and Reporting
### Findings_01:

### Charter 6: Settings and Configuration
### Findings_01 : 
- Changing currency settings was possible
- The app did not clearly indicate whether existing expenses were recalculated or only displayed differently after the change, this behavior mislead the users


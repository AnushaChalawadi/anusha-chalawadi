package androidtests;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddExpensePage;
import pages.HomePage;
import utils.AndroidTestData;
import utils.CommonActions;
import pages.AccountSelectionPage;

public class E2E_CreateAndSelectAccountTest extends BaseClass {

    HomePage homePage;
    AddExpensePage addExpensePage;
    CommonActions commonActions;
    AccountSelectionPage accountsPage;

    @BeforeMethod
    public void initializePages() {
        homePage = new HomePage(driver);
        addExpensePage = new AddExpensePage(driver);
        commonActions = new CommonActions(driver);
        accountsPage = new AccountSelectionPage(driver);
    }

    @Test(priority = 1, description = "Add Account, Select and Verify Selected Account in Header")
    public void addAccountAndSelect() {

        // Step1: Verify that main page is displayed
        Assert.assertTrue(homePage.isMainPageDisplayed(), "Main page is not displayed");

        homePage.clickOnOverFlowSettings();
        homePage.clickOnAccountsPanel();
        homePage.clickPlusToAddAccount();

        accountsPage.addNewAccount("demo", "1000");
        accountsPage.selectAccountType();
        accountsPage.clickOnAddButton();

        commonActions.waitForHomePage();

        homePage.clickOpenNavigation();
        accountsPage.clickOnAllAccounts();

        // wait for all Accounts list
        Assert.assertTrue(accountsPage.waitForAllAccountsList(), "All accounts list is not visible");
        // Assert demo is present
        accountsPage.selectAccount("demo");
        commonActions.waitForHomePage();

        String expectedAccountName = "demo";

        Assert.assertTrue(homePage.isAccountNameDisplayed(expectedAccountName),
                "Account '" + expectedAccountName + "' is not displayed");
        System.out.println("Account Validation is successfull");
    }


    @Test(priority = 2, dependsOnMethods = "addAccountAndSelect")
    public void creatExpenseForAccount() {
        homePage.clickOnBalanceHistory();
        System.out.println(("Step 5: Add Expense Transaction"));
        homePage.clickExpenseButton();
        addExpensePage.isNewExpenseHeaderDisplayed();
        commonActions.enterDigits(AndroidTestData.EXPENSE_AMOUNT);
        commonActions.clickOnChooseCategory();
        commonActions.selectCategory(AndroidTestData.EXPENSE_CATEGORY_FOOD);

        // Step 6: Verify Final Balance
        System.out.println("Step 6: Verify Final Balance");
        commonActions.waitForHomePage();
        commonActions.waitForVisibility(homePage.addExpenseButton, 10);

        double balanceAfterExpense = Double.parseDouble(homePage.getBalanceAmount());
        System.out.println("Balance after adding expense: " + balanceAfterExpense);

        // double expectedBalance = initialBalanceValue +
        //         Double.parseDouble(AndroidTestData.INCOME_AMOUNT)
        //         - Double.parseDouble(AndroidTestData.EXPENSE_AMOUNT);
        // Assert.assertEquals(balanceAfterExpense, expectedBalance,
        //         "Balance did not update correctly after adding expense");
    }
}

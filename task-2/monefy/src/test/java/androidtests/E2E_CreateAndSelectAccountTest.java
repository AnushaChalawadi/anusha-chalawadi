package androidtests;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import io.qameta.allure.Description;

import pages.AddExpensePage;
import pages.HomePage;
import utils.AndroidTestData;
import utils.CommonActions;
import pages.AccountSelectionPage;

@Listeners({ io.qameta.allure.testng.AllureTestNg.class })
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

        System.out.println("Clicking on over flow settings from Corner");
        homePage.clickOnOverFlowSettings();
        System.out.println("Selecting Account from Panel");
        homePage.clickOnAccountsPanel();
        System.out.println("Clicking on + to add new account");
        homePage.clickPlusToAddAccount();

        accountsPage.addNewAccount(AndroidTestData.NEW_ACCOUNT_NAME, AndroidTestData.INITIAL_ACCOUNT_BALANCE);
        accountsPage.selectAccountType();
        accountsPage.clickOnAddButton();

        System.out.println("Waiting for home pae to display");
        commonActions.waitForHomePage();

        homePage.clickOpenNavigation();
        System.out.println("Select All Accounts");
        accountsPage.clickOnAllAccounts();

        Assert.assertTrue(accountsPage.waitForAllAccountsList(), "All accounts list is not visible");
        // Assert New account is present
        commonActions.selectAccountFromList(AndroidTestData.NEW_ACCOUNT_NAME);
        commonActions.waitForHomePage();

        String expectedAccountName = AndroidTestData.NEW_ACCOUNT_NAME;
        String accountBalance = homePage.getBalanceAmount();
        System.out.println("Created account with Amount " + accountBalance);

        Assert.assertTrue(homePage.isAccNameDisplayedInHeader(expectedAccountName),
                "Account '" + expectedAccountName + "' is not displayed");
        System.out.println("Newly Created Account is Displayed Successfully");
    }


    @Test(priority = 2, dependsOnMethods = "addAccountAndSelect")
    @Description("Create Income for newly created Account")
    public void createIncomeForAccount() {

        System.out.println("Verify Main Page");
        Assert.assertTrue(homePage.isMainPageDisplayed(), "Main page is not displayed");

        System.out.println("Capture Initial Balance");
        String initialBalance = homePage.getBalanceAmount();
        System.out.println("Initial balance: " + initialBalance);

        System.out.println((" Clicking on Add Income Button"));
        homePage.clickIncomeButton();

        double initialBalanceValue = Double.parseDouble(initialBalance);
        System.out.println("Initial balance value: " + initialBalanceValue);
        commonActions.enterDigits(AndroidTestData.INCOME_AMOUNT);
        commonActions.clickOnChooseCategory();
        commonActions.selectCategory(AndroidTestData.INCOME_CATEGORY_SALARY);

        System.out.println("Verify Balance After Income added");
        commonActions.waitForHomePage();

        commonActions.waitForVisibility(homePage.addExpenseButton, 10);
        double balanceAfterIncome = Double.parseDouble(homePage.getBalanceAmount());
        System.out.println("Balance after adding income: " + balanceAfterIncome);
        Assert.assertEquals(balanceAfterIncome, initialBalanceValue + Double.parseDouble(AndroidTestData.INCOME_AMOUNT),
                "Balance did not update correctly after adding income");
        System.out.println("Successfully added Income to the newly created Account");

    }
}

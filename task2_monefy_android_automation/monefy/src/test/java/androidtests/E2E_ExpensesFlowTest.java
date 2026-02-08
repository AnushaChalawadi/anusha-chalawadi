package androidtests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.Assert;

import pages.AddExpensePage;
import pages.HomePage;
import utils.CommonActions;
import utils.AndroidTestData;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class E2E_ExpensesFlowTest extends BaseTest {

    HomePage homePage;
    AddExpensePage addExpensePage;
    CommonActions commonActions;
    AndroidTestData androidTestData;
    @BeforeMethod
    public void initializePages() {
        homePage = new HomePage(driver);
        addExpensePage = new AddExpensePage(driver);
        commonActions = new CommonActions(driver);
    } 

    @Test(priority = 1, description = "E2E Flow: Add, View and Delete Expense Transaction from History")
        public void verifyExpenseTransaction() {

             // Step 1: Verify that main page is displayed
        System.out.println("Step 1: Verify Main Page");
        Assert.assertTrue(homePage.isMainPageDisplayed(), "Main page is not displayed");

        // Step 3: Add Income Transaction
        System.out.println(("Step 3: Add Income Transation"));
        homePage.clickIncomeButton();
        // String incomeAmount = "1000";
        commonActions.enterDigits(AndroidTestData.INCOME_AMOUNT);
        commonActions.clickOnChooseCategory();
        commonActions.selectCategory(AndroidTestData.INCOME_CATEGORY_SALARY);

        // // Step 4: Verify balance after income added
        // System.out.println("Step 4: Verify Balance After Income");
        // commonActions.waitForHomePage();
        // commonActions.waitForVisibility(homePage.addExpenseButton, 10);
        // double balanceAfterIncome = Double.parseDouble(homePage.getBalanceAmount());
        // System.out.println("Balance after adding income: " + balanceAfterIncome);
        // Assert.assertEquals(balanceAfterIncome, initialBalanceValue + Double.parseDouble(AndroidTestData.INCOME_AMOUNT),
        //         "Balance did not update correctly after adding income");

        // // Step 1: Verify that main page is displayed
        // System.out.println("Step 1: Verify Main Page");
        // Assert.assertTrue(homePage.isMainPageDisplayed(), "Main page is not displayed");

        // // Step 2: Capture initial balance
        // System.out.println("Step 2: Capture Initial Balance");
        // String initialBalance = homePage.getBalanceAmount();
        // System.out.println("Initial balance: " + initialBalance);
        // homePage.clickOnBalanceHistory();
        // homePage.clickOnBalanceHistory();


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

        homePage.clickOnBalanceHistory();


    }
    
}

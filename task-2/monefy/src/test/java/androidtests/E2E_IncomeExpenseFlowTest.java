package androidtests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.Assert;

import pages.AddExpensePage;
import pages.AddIncomePage;
import pages.HomePage;
import utils.CommonActions;
import utils.AndroidTestData;

@Listeners({ io.qameta.allure.testng.AllureTestNg.class })
public class E2E_IncomeExpenseFlowTest extends BaseClass {

    HomePage homePage;
    AddExpensePage addExpensePage;
    AddIncomePage addIncomePage;
    CommonActions commonActions;

    @BeforeMethod
    public void initializePages() {
        homePage = new HomePage(driver);
        addExpensePage = new AddExpensePage(driver);
        addIncomePage = new AddIncomePage(driver);
        commonActions = new CommonActions(driver);
    }

    @Test(priority = 1, description = "E2E Flow: Add Income Amount")
    public void testIncomeFlow() {

        System.out.println("Verify Main Page is Displayed");
        Assert.assertTrue(homePage.isMainPageDisplayed(), "Main page is not displayed");

        System.out.println("Capture Initial Balance");
        String initialBalance = homePage.getBalanceAmount();
        System.out.println("Initial balance: " + initialBalance);

        System.out.println("Clicking on Add Income Button");
        homePage.clickIncomeButton();
   
        double initialBalanceAmount= Double.parseDouble(initialBalance);
        System.out.println("Initial balance value: " + initialBalanceAmount);
        
        System.out.println("Entering digits for Income");
        commonActions.enterDigits(AndroidTestData.INCOME_AMOUNT);
        commonActions.clickOnChooseCategory();

        System.out.println("Select Catefory from list");
        commonActions.selectCategory(AndroidTestData.INCOME_CATEGORY_SALARY);

        
        commonActions.waitForHomePage();
        commonActions.waitForVisibility(homePage.addExpenseButton, 10);

        System.out.println("Verify Balance After Income added");
        double balanceAfterIncome = Double.parseDouble(homePage.getBalanceAmount());
        System.out.println("Balance after adding income :" + balanceAfterIncome);
        Assert.assertEquals(balanceAfterIncome, initialBalanceAmount + Double.parseDouble(AndroidTestData.INCOME_AMOUNT),
                "Balance did not update correctly after adding income");
        System.out.println("Income added Successfully");

    }
    @Test(priority = 2, dependsOnMethods = "testIncomeFlow", description = "Add Expense Amount")
    public void testExpenseFlow(){

        System.out.println("Home Page is Displayed");
        commonActions.waitForHomePage();
        commonActions.waitForVisibility(homePage.addExpenseButton, 10);
   
        double balanceBeforeExpense = Double.parseDouble(homePage.getBalanceAmount());
        System.out.println("Balance before expense added :" + balanceBeforeExpense);

        homePage.clickExpenseButton();
        addExpensePage.isNewExpenseHeaderDisplayed();

        System.out.println("Entering digits for Expense");
        commonActions.enterDigits(AndroidTestData.EXPENSE_AMOUNT);
        commonActions.clickOnChooseCategory();
        commonActions.selectCategory(AndroidTestData.EXPENSE_CATEGORY_FOOD);

        System.out.println("Navigating Back to Home Page");
        commonActions.waitForHomePage();
        commonActions.waitForVisibility(homePage.addExpenseButton, 10);

        System.out.println("Verify Final Balance after adding expenses");
        double balanceAfterExpense = Double.parseDouble(homePage.getBalanceAmount());
        System.out.println("Balance after adding expense: " + balanceAfterExpense);

        double expectedBalance = balanceBeforeExpense - Double.parseDouble(AndroidTestData.EXPENSE_AMOUNT);
        Assert.assertEquals(balanceAfterExpense, expectedBalance,
                "Balance did not update correctly after adding expense");       
    }

}

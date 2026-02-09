package androidtests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.beans.Transient;

import org.testng.Assert;

import pages.AccountSelectionPage;
import pages.AddExpensePage;
import pages.HomePage;
import utils.CommonActions;
import utils.AndroidTestData;
import pages.TransactionDetailsPage;

@Listeners({ io.qameta.allure.testng.AllureTestNg.class })
public class E2E_ExpensesFlowTest extends BaseClass {

    HomePage homePage;
    AddExpensePage addExpensePage;
    CommonActions commonActions;
    AndroidTestData androidTestData;
    TransactionDetailsPage transactionDetailsPage;

    @BeforeMethod
    public void initializePages() {
        homePage = new HomePage(driver);
        addExpensePage = new AddExpensePage(driver);
        commonActions = new CommonActions(driver);
        transactionDetailsPage = new TransactionDetailsPage(driver);
    }

    @Test(priority = 1, description = "E2E Flow: Add, View and Delete Expense Transaction from History")
    public void verifyExpenseTransaction() {

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

        double initialAmount = Double.parseDouble(homePage.getBalanceAmount());
        System.out.println("Balance after adding expense: " + initialAmount);

        // homePage.clickOnBalanceHistory();

        // Step 1: Verify that main page is displayed
        System.out.println("Step 1: Verify Main Page");
        Assert.assertTrue(homePage.isMainPageDisplayed(), "Main page is not displayed");
        commonActions.waitForHomePage();

    }

    @Test(dependsOnMethods = "verifyExpenseTransaction")
    public void editExpense() {

        
        double initialAmountBeforeEdit = Double.parseDouble(homePage.getBalanceAmount());
        homePage.clickOnBalanceHistory();

        transactionDetailsPage.clickTransactionCategory();
        transactionDetailsPage.clickTransactionAmount();
        addExpensePage.clearExpensesAmountField(2);
        commonActions.enterDigits(AndroidTestData.EDIT_EXPENSE);
        commonActions.navigateBack();

        homePage.clickOnBalanceHistory();

        // initial amount-editexpense = total

      //Get balance after
    double balanceAfterEdit = Double.parseDouble(homePage.getBalanceAmount());
    // System.out.println("balance"+ balanceAfter);

    double expectedBalance = initialAmountBeforeEdit +  Double.parseDouble(AndroidTestData.EDIT_EXPENSE);
     Assert.assertEquals(balanceAfterEdit, expectedBalance, 
        "Balance mismatch after editing expense amount");


    // double expectedBalance = initialAmount - Double.parseDouble(AndroidTestData.EDIT_EXPENSE);;

   
}

}

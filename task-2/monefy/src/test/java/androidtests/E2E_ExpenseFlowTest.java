package androidtests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.beans.Transient;

import io.qameta.allure.Description;

import org.testng.Assert;

import pages.AccountSelectionPage;
import pages.AddExpensePage;
import pages.HomePage;
import utils.CommonActions;
import utils.AndroidTestData;
import pages.TransactionDetailsPage;

@Listeners({ io.qameta.allure.testng.AllureTestNg.class })
public class E2E_ExpenseFlowTest extends BaseClass {

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

    @Test(priority = 1, description = "E2E Flow: Add Expense Transaction")
    public void addExpenseFlow() {

        System.out.println(("Clicking on Expense Tab"));
        homePage.clickExpenseButton();
        addExpensePage.isNewExpenseHeaderDisplayed();
        commonActions.enterDigits(AndroidTestData.EXPENSE_AMOUNT);
        commonActions.clickOnChooseCategory();
        System.out.println("Choose category from list");
        commonActions.selectCategory(AndroidTestData.EXPENSE_CATEGORY_FOOD);

        System.out.println("Verify Home Page is displayed");
        commonActions.waitForHomePage();
        commonActions.waitForVisibility(homePage.addExpenseButton, 10);

        // Verfied expense amount is added
        double balanceAfterExpense = Double.parseDouble(homePage.getBalanceAmount());
        System.out.println("Balance after adding expense: " + balanceAfterExpense);

        System.out.println("Verify screen navigated to Home page");
        Assert.assertTrue(homePage.isMainPageDisplayed(), "Main page is not displayed");
        commonActions.waitForHomePage();
        System.out.println("Successfully Expense is added");

    }

    @Test(priority = 2, dependsOnMethods = "addExpenseFlow", description = "E2E Flow: Edit Expense")
    public void editExpenseFlow() {

        double balanceBeforeEdit = Double.parseDouble(homePage.getBalanceAmount());
        System.out.println("Balance before editing the expense" + balanceBeforeEdit);

        homePage.clickOnBalanceHistory();

        // Select transaction category and open details
        transactionDetailsPage.clickTransactionCategory();
        transactionDetailsPage.clickTransactionAmount();

        System.out.println("Enter digits in edit expense");
        addExpensePage.clearExpensesAmountField(2);
        commonActions.enterDigits(AndroidTestData.EDIT_EXPENSE);
        commonActions.navigateBack();

        double balanceAfterEdit = Double.parseDouble(homePage.getBalanceAmount());
        System.out.println("Balance after editing expense: " + balanceAfterEdit);

        double expectedBalance = balanceBeforeEdit + Double.parseDouble(AndroidTestData.EDIT_EXPENSE);
        Assert.assertEquals(balanceAfterEdit, expectedBalance,
                "Balance mismatch after editing expense amount");
        System.out.println("Sucessfully edited the expense");

    }

    @Test(priority = 3, dependsOnMethods = "editExpenseFlow", description = "Delete Expense")
    public void deleteExpenseFlow() {

        double balanceBeforeDelete = Double.parseDouble(homePage.getBalanceAmount());
        System.out.println("balance before delete " + balanceBeforeDelete);

        transactionDetailsPage.clickTransactionCategory();
        transactionDetailsPage.clickTransactionAmount();

        addExpensePage.clickDeleteExpense();

        commonActions.waitForHomePage();

        double balanceAfterDelete = Double.parseDouble(homePage.getBalanceAmount());
        System.out.println("Balance after editing expense: " + balanceAfterDelete);

        Assert.assertEquals(balanceAfterDelete, 0.0, 0.01, "Balance should be zero after deleting the expense");

    }

}

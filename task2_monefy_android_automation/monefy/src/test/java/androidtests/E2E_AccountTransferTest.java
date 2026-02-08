package androidtests;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddExpensePage;
import pages.HomePage;
import utils.CommonActions;
import pages.AccountSelectionPage;

public class E2E_AccountTransferTest extends BaseTest {

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

    @Test
    public void addAccountAndTransferMoney(){

        // Step1: Verify that main page is displayed
        Assert.assertTrue(homePage.isMainPageDisplayed(), "Main page is not displayed");

        homePage.clickOnOverFlowSettings();
        homePage.clickOnAccountsPanel();
        homePage.clickPlusToAddAccount();

        accountsPage.addNewAccount("demo" , "1000");
        accountsPage.selectAccountType();
        accountsPage.clickOnAddButton();

        commonActions.waitForHomePage();

        homePage.clickOpenNavigation();
        accountsPage.clickOnAllAccounts();

        //wait for all Accounts list
        Assert.assertTrue(accountsPage.waitForAllAccountsList(), "All accounts list is not visible");
        //Assert demo is present
        accountsPage.selectAccount("demo");
        commonActions.waitForHomePage();

        String expectedAccountName = "demo";

        Assert.assertTrue(homePage.isAccountNameDisplayed(expectedAccountName), "Account '" + expectedAccountName + "' is not displayed");
        System.out.println("Account Validation is successfull");

       // commonActions.waitForTextToBeInHeader(homePage.accountNameHeader, expectedAccountName);

        // //Verify selected account is displayed
        // String actualAccountName = homePage.getSelectedAccountName();
        // System.out.println("Selected Account: " + actualAccountName);
        // Assert.assertEquals(actualAccountName, expectedAccountName,"Selected account '" + expectedAccountName + "' is not displayed in header. Found: " + actualAccountName);



        //select demo from list
        // wait for home page loads
        //verifiy demo is selected
        //created expense



    }
    
}

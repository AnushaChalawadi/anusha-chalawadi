package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {

    AndroidDriver driver;
    private WebDriverWait wait;

    // Elements
    @AndroidFindBy(id = "expense_button")
        //"com.monefy.app.lite:id/expense_button")
    public WebElement addExpenseButton;

    @AndroidFindBy(id = "income_button")
        //"com.monefy.app.lite:id/income_button")
    public WebElement addIncomeButton;

    @AndroidFindBy(id = "balance_amount")
       // "com.monefy.app.lite:id/balance_amount")
    public WebElement balanceAmount;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Open navigation\"]")
    public WebElement openNavigation;

    @AndroidFindBy(id = "overflow")
    public WebElement openSettingsPanel;

    @AndroidFindBy(id = "accounts_panel")
    public WebElement accountsPanel;

    @AndroidFindBy(id = "imageButtonAddCategory")
    public WebElement addAccount;

    // Constructor
    public HomePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    // Actions
    public void clickExpenseButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addExpenseButton));
        addExpenseButton.click();
    }

    public void clickIncomeButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addIncomeButton));
        addIncomeButton.click();
    }

    // public String getBalanceAmount(){
    //     String balance = balanceAmount.getText().replace("$", )
    // }

    public String getBalanceAmount() {
        String balanceText = balanceAmount.getText();
        // Remove non-numeric characters to extract the numeric value
        return balanceText.replaceAll("[^0-9.]", "");
    }

    public void clickOpenNavigation() {
        openNavigation.click();
        System.out.println("Clicked on Open Navigation");
    }

    // public boolean isMainPageDisplayed() {
    //     return addExpenseButton.isDisplayed() &&
    //             addIncomeButton.isDisplayed() && balanceAmount.isDisplayed();
    // }
    public boolean isMainPageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(addExpenseButton));
            wait.until(ExpectedConditions.elementToBeClickable(addExpenseButton));
            wait.until(ExpectedConditions.visibilityOf(balanceAmount));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public void clickOnOverFlowSettings() {
        openSettingsPanel.click();
        System.out.println("Clicked on Panel");
    }

    public void clickOnAccountsPanel() {
        accountsPanel.click();
        System.out.println("Clicked on Accounts");
    }

    public void clickPlusToAddAccount() {
        addAccount.click();
        System.out.println("Clicked on Plus to add new account");
    }

    public boolean isAccountNameDisplayed(String expectedAccountName) {
        try {
            WebElement accountHeader = driver.findElement(
                    By.xpath("//android.widget.TextView[@text='" + expectedAccountName + "']"));
            return accountHeader.isDisplayed();
        } catch (Exception e) {
            System.out.println("Account '" + expectedAccountName + "' not found in header");
            return false;
        }
    }

    public WebElement getAccountNameHeader(String accountName) {
        return driver.findElement(
                By.xpath("//android.widget.TextView[@text='" + accountName + "']"));
    }

    public void clickOnBalanceHistory()
    {
        balanceAmount.click();
    }


}

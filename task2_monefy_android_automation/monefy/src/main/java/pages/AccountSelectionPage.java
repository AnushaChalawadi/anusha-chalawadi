package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AccountSelectionPage {

    public AndroidDriver driver;
    private WebDriverWait wait;

    // Elements
    @AndroidFindBy(id = "editTextCategoryName")
    public WebElement accountNameField;

    @AndroidFindBy(id = "initialAmount")
    public WebElement initialAmountField;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.GridView/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ImageView")
    public WebElement accountType;

    @AndroidFindBy(id = "save")
    public WebElement saveButton;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.monefy.app.lite:id/imageView\"])[2]")
    public WebElement cashAccountType;

    @AndroidFindBy(id = "com.monefy.app.lite:id/account_spinner")
    public WebElement allAccounts;

    // Constructor
    public AccountSelectionPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Actions
    public void enterDigits(String digits) {
        for (char digit : digits.toCharArray()) {
            driver.findElement(By.id("com.monefy.app.lite:id/buttonKeyboard" + digit)).click();
        }
    }

    public void addNewAccount(String accountName, String initialAmount) {
        wait.until(ExpectedConditions.visibilityOf(accountNameField)).sendKeys(accountName);

        // Enter initial Amount
        if (initialAmount != null && !initialAmount.isEmpty()) {
            wait.until(ExpectedConditions.visibilityOf(initialAmountField)).clear();
            wait.until(ExpectedConditions.visibilityOf(initialAmountField)).sendKeys(initialAmount);
        }
    }

    public void selectAccountType() {
        cashAccountType.click();
        System.out.println("Selected account type from all accounts");
    }

    public void clickOnAddButton() {
        saveButton.click();
    }

    public void clickOnAllAccounts() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(allAccounts));
        allAccounts.click();
    }

    public boolean waitForAllAccountsList() {
        try {
            WebElement listView = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.monefy.app.lite:id/listView")));
            return listView.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // public boolean isAccountPresent(String accountName) {
    // try {
    // driver.findElement(AppiumBy.androidUIAutomator(
    // "new UiScrollable(new UiSelector().scrollable(true))" + // scroll any
    // scrollable container
    // ".scrollIntoView(new UiSelector().text(\"" + accountName + "\"))"));
    // return true;
    // } catch (Exception e) {
    // return false;

    // }
    // }

    public void selectAccount(String accountName) {
        driver.findElement(By.xpath(
                "//android.widget.TextView[@resource-id='com.monefy.app.lite:id/title' and @text='" + accountName
                        + "']"))
                .click();
    }
}

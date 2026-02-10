package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddExpensePage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    // Elements
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='New expense']")
    public WebElement newExpenseHeader;

    @AndroidFindBy(id = "//android.widget.ImageButton[@content-desc='Navigate up']")
    public WebElement backButton;

    @AndroidFindBy(id = "textViewAmount")
    public WebElement amountField;

    @AndroidFindBy(id = "delete")
    public WebElement deleteExpensesBtn;

    @AndroidFindBy(id = "buttonKeyboardClear")
    public WebElement clearAmountField;

    @AndroidFindBy(id = "delete")
    public WebElement deleteExpense;

    // Constructor
    public AddExpensePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Actions
    public String getDisplayedAmount() {
        return amountField.getText();
    }

    public boolean isNewExpenseHeaderDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(newExpenseHeader));
            boolean isDisplayed = newExpenseHeader.isDisplayed();
            String headerText = newExpenseHeader.getText();

            System.out.println("Expense Header Text" + headerText);
            return isDisplayed;
        } catch (Exception e) {
            System.out.println("New Expense header not found");
            return false;
        }
    }

    public void clearExpensesAmountField(int numDigits) {
        for (int i = 0; i < numDigits; i = i + 1) {
            clearAmountField.click();
        }
    }

    public void clickDeleteExpense(){
        deleteExpense.click();
    }

}

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

public class TransactionDetailsPage {

    
    AndroidDriver driver;
    private WebDriverWait wait;

    // locators
	@AndroidFindBy(id = "textViewCategoryName")
	public WebElement transactionCategory;

	@AndroidFindBy(id = "textViewTransactionAmount")
	public WebElement transactionAmount;

	@AndroidFindBy(id = "balance_amount")
	public WebElement balanceAmountDisplay;

	@AndroidFindBy(id = "leftLinesImageView")
	public WebElement viewDetails;

     // Constructor
    public TransactionDetailsPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    // keywords / actions
	public void clickTransactionCategory() {
		transactionCategory.click();
	}

	public void clickTransactionAmount() {
		transactionAmount.click();
	}

	public void clickBalanceAmount() {
		balanceAmountDisplay.click();
	}

	public void clickLeftViewPanel() {
		viewDetails.click();
	}
 
	public String getBalanceAmount(){
		return balanceAmountDisplay.getText();
	}
}



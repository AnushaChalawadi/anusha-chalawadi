package pages;

import java.time.Duration;
import java.util.List;

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

	public String getBalanceAmount() {
		String balanceAmount = balanceAmountDisplay.getText();
		// Remove non-numeric characters to extract the numeric value
		return balanceAmount.replaceAll("[^0-9.]", "");
	}

	public void selectCategoryFromHistory(String categoryName) {
		String categoryFromList = "//android.widget.TextView[@resource-id='com.monefy.app.lite:id/textViewCategoryName' and @text='"
				+ categoryName + "']";
		List<WebElement> categoryList = driver.findElements(By.xpath(categoryFromList));

		if (categoryList.isEmpty()) {
			throw new RuntimeException("No expense found with category: " + categoryName);
		}
		// select the first transaction in that category
		WebElement categoryElement = categoryList.get(0);
		WebElement row = categoryElement.findElement(By.xpath("./../.."));
		row.click();
	}
}

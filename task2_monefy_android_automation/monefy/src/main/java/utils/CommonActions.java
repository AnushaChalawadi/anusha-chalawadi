package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import io.appium.java_client.android.AndroidDriver;

public class CommonActions {

    private AndroidDriver driver;
    private WebDriverWait wait;

    // Constructor, to initialize a class data members
    public CommonActions(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Enter digits using calculator pad
    public void enterDigits(String digits) {
        for (char digit : digits.toCharArray()) {
            String buttonId = "com.monefy.app.lite:id/buttonKeyboard" + digit;
            driver.findElement(By.id(buttonId)).click();
        }
    }

    // Click on Choose Category button
    public void clickOnChooseCategory() {
        String chooseCategory = "com.monefy.app.lite:id/keyboard_action_button";
        driver.findElement(By.id(chooseCategory)).click();
    }

    // Select Category from list
    public void selectCategory(String categoryName) {
        String categoryXpath = "//android.widget.TextView[@resource-id=\"com.monefy.app.lite:id/textCategoryName\" and @text=\""
                + categoryName + "\"]";
        driver.findElement(By.xpath(categoryXpath)).click();
    }

    // Click on 'X' to clear field
    public void clearField() {
        WebElement clearButton = driver.findElement(By.id("com.monefy.app.lite:id/buttonKeyboardClear"));
        clearButton.click();
    }

    // Click on back navigation
    public void navigateBack() {
        WebElement backButton = driver
                .findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"));
        backButton.click();
    }

    // Write a text/note
    public void addNote(String note) {
        WebElement noteField = driver.findElement(By.id("com.monefy.app.lite:id/textViewNote"));
        noteField.sendKeys(note);
    }

    // Wait for element to be visible
    public WebElement waitForVisibility(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Wait for Home page to load
    public void waitForHomePage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("com.monefy.app.lite:id/expense_button")));
    }

    // Select Account from All Accounts list
    public void selectAccountFromList(String accountName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement accountElement = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//android.widget.TextView[@text='" + accountName + "']")));
        accountElement.click();
    }

    // wait for account name in header
    public void waitForTextToBeInHeader(WebElement element, String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
    }

}

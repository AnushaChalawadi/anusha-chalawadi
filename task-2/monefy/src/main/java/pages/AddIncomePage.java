package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddIncomePage {

    public AndroidDriver driver;

    // Elements
    @AndroidFindBy(id = "//android.widget.TextView[@text='New income']")
    WebElement newIncomeHeader;

    // Constructor
    public AddIncomePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Actions
    public boolean isNewIncomeHeaderDisplayed() {
        boolean isDisplayed = newIncomeHeader.isDisplayed();
        System.out.println("New income header displayed");
        return isDisplayed;
    }

}

package androidtests;

import java.net.URL;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseClass {
    protected AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException{

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("monefy-android");
        
        options.setApp("C:\\Users\\PC\\Documents\\N26_Home_Assignment\\monefy_android_automation\\monefy\\src\\test\\resources\\apps\\monefy.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        // AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        //xpath, Id, accessibilityId, className, androidUIAutomator
        //driver.findElement(AppiumBy.accessibilityId("EXPENSE")).click();
        //driver.findElement(AppiumBy.id("com.monefy.app.lite:id/expense_button_title")).click();

        //E2E user flow
        //TC1: Verify that user can add an expense successfully and view it in histroy
        //TC2: Verify that user can add an income successfully - expense and verify that the balance is updated correctly
        //TC3: 
    }

        @AfterClass
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
    }

}


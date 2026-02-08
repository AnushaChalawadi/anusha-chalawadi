package utils;

import java.net.URL;

import javax.management.RuntimeErrorException;

import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DriverManager {

    private AndroidDriver driver;

    public AndroidDriver getDriver(){
     if(driver == null){
        try{

        UiAutomator2Options options = new UiAutomator2Options();

        // Device configuration
        options.setPlatformName("Android");
        options.setDeviceName("monefy-android");
        
        options.setApp("C:\\Users\\PC\\Documents\\N26_Home_Assignment\\monefy_android_automation\\monefy\\src\\test\\resources\\apps\\monefy.apk");

        // Driver initialization
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

        System.out.println("Appium driver created successfully");
        }
        catch(MalformedURLException e){
            System.err.println("Failed to create driver: " + e.getMessage());
            //throw new RuntimeErrorException("Driver initialization failed", e);
        }
    }
    return driver;
}
    public void quiteDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}

        // AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        
        //xpath, Id, accessibilityId, className, androidUIAutomator
        //driver.findElement(AppiumBy.accessibilityId("EXPENSE")).click();
        //driver.findElement(AppiumBy.id("com.monefy.app.lite:id/expense_button_title")).click();

        //E2E user flow
        //TC1: Verify that user can add an expense successfully and view it in histroy
        //TC2: Verify that user can add an income successfully - expense and verify that the balance is updated correctly
        //TC3: 

    // @AfterClass


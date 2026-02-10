package utils;

import java.net.URL;

import javax.management.RuntimeErrorException;

import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DriverManager {

    private AndroidDriver driver;

    public AndroidDriver getDriver() {
        if (driver == null) {
            try {

                UiAutomator2Options options = new UiAutomator2Options();

                // Device configuration
                options.setPlatformName("Android");
                options.setDeviceName("monefy-android");

                String apkPath = System.getProperty("user.dir") + "/src/test/resources/apps/monefy.apk";
                options.setApp(apkPath);

                // Driver initialization
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
                driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

                System.out.println("Appium driver created successfully");
            } catch (MalformedURLException e) {
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
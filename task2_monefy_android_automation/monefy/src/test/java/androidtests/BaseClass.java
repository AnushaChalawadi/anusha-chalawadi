package androidtests;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.*;
import utils.*;

public class BaseClass {

    protected AndroidDriver driver;
    protected DriverManager driverManager;

    @BeforeClass
    public void setUp() {
        driverManager = new DriverManager();
        driver = driverManager.getDriver();
        System.out.println("Driver initialized successfully");

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Driver closed successfully");
        }
    }

}

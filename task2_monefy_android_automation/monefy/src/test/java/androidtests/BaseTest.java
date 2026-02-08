package androidtests;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.*;
import utils.*;

public class BaseTest {

    protected AndroidDriver driver;
    protected DriverManager driverManager;
    
    @BeforeMethod
    public void setUp(){
        driverManager = new DriverManager();
        driver = driverManager.getDriver();
        System.out.println("Driver initialized successfully");

    }

    @AfterMethod
    public void tearDown()
    {
         if (driver != null) {
            driver.quit();
            System.out.println("Driver closed successfully");
        }
    }
    
}

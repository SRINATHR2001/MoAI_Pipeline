package Zcom.Appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class DemoClasss
{
    //Actual declaration of driver.
    public static  AppiumDriver driver;
    public static  AppiumDriverLocalService service;

    public static void OpenApp() throws MalformedURLException
    {
//
//        service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\santhosh\\AppData\\Roaming\\npm\\node_modules\\appium"))
//                .withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();
        
        //Declaring the Capability
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "gokul OnePlus");
        cap.setCapability("udid", "a34bd5d2");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "12");
        cap.setCapability("automationName", "uiAutomator2");
        cap.setCapability("appPackage", "com.ubercab");
        cap.setCapability("appActivity", "com.ubercab.presidio.app.core.root.RootActivity");

        //Here we need to provide tha URL
        URL url = new URL("http://127.0.0.1:4723/");

        //Declaring the driver with required attribute
        driver = new AppiumDriver(url, cap);

        System.out.println("Application started");

//        driver.findElement(new AppiumBy.ByAndroidUIAutomator("")).click();
//        driver.findElements(new AppiumBy.ByAndroidUIAutomator(""));
    }

    public static void main(String[] args) throws MalformedURLException
    {
        OpenApp();
    }
}

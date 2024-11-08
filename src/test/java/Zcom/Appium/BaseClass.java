package Zcom.Appium;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseClass
{
    public AppiumDriverLocalService Service;
    public static AndroidDriver driver;

    @BeforeMethod
    public void ConfigureAppium() throws MalformedURLException
    {
        System.out.println("Server starts running from Base Class.");

        //Run server automatically
        Service = new AppiumServiceBuilder()
                .withAppiumJS(new File("/home/srinath/.nvm/versions/node/v18.20.4/bin/appium"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();

        Service.start();

        UiAutomator2Options options = new UiAutomator2Options();

        options.setDeviceName("test");

        options.setApp("/home/srinath/MoAI_Project/src/test/java/Resourse/app-debug-aug1-changes.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
    }

    @AfterMethod
    public void StopConfigureAppium()
    {
        driver.quit();
        Service.stop();
        System.out.println("Server stops running from Base Class");
    }

}

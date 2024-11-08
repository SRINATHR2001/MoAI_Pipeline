package Base;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.io.MultiOutputStream;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class BaseClass1
{
    public AppiumDriverLocalService Service;
    public static AndroidDriver driver;
    public static WebDriverWait WAIT;
    private static PrintStream originalConsole;
    private static PrintStream dualPrintStream;
    public static Logger logger = Logger.getLogger("MyLog");

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

    @Test
    public void BaseLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Clicking the Get started button
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtGetStart"))).click();

        //clicking the mobile number input field and send the keys to it.
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id
                ("com.moai.android:id/edtMobileNumber"))).sendKeys("0000000000");

        //Clicking the continue button
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtContinue"))).click();

        //Fill the OTP into input field.
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/editTextOTP1"))).sendKeys("1");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/editTextOTP2"))).sendKeys("2");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/editTextOTP3"))).sendKeys("3");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/editTextOTP4"))).sendKeys("4");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/editTextOTP5"))).sendKeys("5");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/editTextOTP6"))).sendKeys("6");

        //Verify the OTP
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtVerify"))).click();
    }

    public void initializeOutput(String fileName) {
        try {
            // Create a file for output
            File outputFile = new File(fileName);

            // Create a PrintStream for the file
            PrintStream filePrintStream = new PrintStream(outputFile);

            // Save original System.out
            originalConsole = System.out;

            // Create a custom PrintStream that writes to both file and console
            dualPrintStream = new PrintStream(new MultiOutputStream(filePrintStream, originalConsole));

            // Redirect System.out to the dual PrintStream
            System.setOut(dualPrintStream);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public static void printToBoth(String message) {
        System.out.println(message);
    }

    public static void resetToConsole() {
        if (originalConsole != null) {
            System.setOut(originalConsole);
        }
    }

    /*class MultiOutputStream extends OutputStream {
        private final PrintStream[] printStreams;

        public MultiOutputStream(PrintStream... printStreams) {
            this.printStreams = printStreams;
        }

        @Override
        public void write(int b) {
            for (PrintStream ps : printStreams) {
                ps.write(b);
            }
        }

        @Override
        public void flush() {
            for (PrintStream ps : printStreams) {
                ps.flush();
            }
        }

        @Override
        public void close() {
            for (PrintStream ps : printStreams) {
                ps.close();
            }
        }

        @Override
        public void write(byte[] b, int off, int len) {
            for (PrintStream ps : printStreams) {
                ps.write(b, off, len);
            }
        }
    }*/

    public static void setupLogger(String fileName) {
        try {
            FileHandler fh = new FileHandler(fileName, true); // true for append mode
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
            logger.setUseParentHandlers(true); // Use console handler as well
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


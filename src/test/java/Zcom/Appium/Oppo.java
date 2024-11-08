package Zcom.Appium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Oppo extends BaseClass
{
    @Test(enabled = false)
    public static void LogIn() throws InterruptedException
    {
        /*Positive case for login into MoAI application.*/

        //To click the MoAi application for launching we need to wait for some time.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Clicking the Get started button
        driver.findElement(AppiumBy.id("com.moai.android:id/txtGetStart")).click();

        //clicking the mobile number input field and send the keys to it.
        driver.findElement(AppiumBy.id("com.moai.android:id/edtMobileNumber")).sendKeys("0000000000");

        //Clicking the continue button
        driver.findElement(AppiumBy.id("com.moai.android:id/txtContinue")).click();

        driver.findElement(AppiumBy.id("com.moai.android:id/editTextOTP1")).sendKeys("1");

        driver.findElement(AppiumBy.id("com.moai.android:id/editTextOTP2")).sendKeys("2");

        driver.findElement(AppiumBy.id("com.moai.android:id/editTextOTP3")).sendKeys("3");

        driver.findElement(AppiumBy.id("com.moai.android:id/editTextOTP4")).sendKeys("4");

        driver.findElement(AppiumBy.id("com.moai.android:id/editTextOTP5")).sendKeys("5");

        driver.findElement(AppiumBy.id("com.moai.android:id/editTextOTP6")).sendKeys("6");

        //Here we are waiting to enter the OTP manually.
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Clicking the Allow button to access the OTP
      //  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(AppiumBy.id("com.google.android.gms:id/positive_button")))).click();

        //After verifying the OTP we can click the verify button now.
        WebElement verifyOtp = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtVerify")));

        // Clicking the verify button.
        verifyOtp.click();

        /* Clicking the skip button.
        * ***IMPORTANT** Need this line of code when the there is no dependent is added , so we need to click skip button.
        *
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/tvSkip"))).click();*/
    }

    @Test(enabled = false)
    public void ConnectingDevices() throws InterruptedException
    {

        LogIn();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        /*Connecting to the device*/

        //Scrolling to the Connect device button.
        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\"Connect Device\"));"));

        //Clicking the connect to device button
        wait.until(ExpectedConditions.visibilityOfElementLocated((AppiumBy.id("com.moai.android:id/txtConnectDevice")))).click();

        //Click on heart heath monitor device
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Heart Health Monitor\")")).click();

        //click on continue
        driver.findElement(AppiumBy.id("com.moai.android:id/txtContinue")).click();
//-----------------
        //Location Access confirmation
        driver.findElement(AppiumBy.id("com.android.packageinstaller:id/permission_allow_button")).click();

        //Find nearby device
     //   driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")).click();

        //click on continue again
        driver.findElement(AppiumBy.id("com.moai.android:id/txtContinue")).click();

        //Clicking the nearby device.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtDeviceName"))).click();

        //Success page push profiles button confirmation
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtPushProfile"))).click();

        //Select which profile need to be push, by using the PUSH button option
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtPushProfile"))).click();

       //After selecting the profile to push
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtFinish"))).click();

    }

    @Test(enabled = false)
    public void ChangeCountryCode() throws InterruptedException
    {
        //To click the MoAi application for launching we need to wait for some time.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Clicking the Get started button
        driver.findElement(AppiumBy.id("com.moai.android:id/txtGetStart")).click();

        //Check whether the country code is displayed or not
       WebElement cc = driver.findElement(AppiumBy.id("com.moai.android:id/textinput_prefix_text"));

        System.out.println(cc.isDisplayed());


        //Change the country code
       WebElement country = driver.findElement(AppiumBy.id("com.moai.android:id/textinput_prefix_text"));
       country.click();
       country.sendKeys("+44");

    }



}

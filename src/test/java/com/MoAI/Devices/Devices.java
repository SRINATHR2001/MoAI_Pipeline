package com.MoAI.Devices;

import Base.BaseClass1;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Devices extends BaseClass1
{
    @Test
    public void TC_023()
    {
        BaseLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Clicking the device section
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Devices"))).click();

        //Verify the burger menu is clickable.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/imgMenu"))).click();

        //Clicking on the connect device
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Connect Device\")"))).click();

        //Clicking on continue button to find out the device
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtContinue"))).click();

        //permission
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.android.packageinstaller:id/permission_allow_button"))).click();

        //Clicking again on continue button to find out the device
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtContinue"))).click();

        //Actual device freq,
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtDeviceName"))).click();

        //Success message of device connection
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtFailDescription")));
        WebElement message = driver.findElement(AppiumBy.id("com.moai.android:id/txtFailDescription"));
        System.out.println("Success message : " + message.getText());

        //clicking on device info
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtDeviceInfo"))).click();

        //Push profile
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtPushProfile"))).click();

        //Navigate home
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().description(\"Navigate up\")"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtEcg"))).isDisplayed();

       WebElement deviceIndication = driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/imgDeviceIndication\"));"));

        System.out.println("Device indication is present : " + deviceIndication.isDisplayed());

    }

    @Test
    public void TC_024()
    {
        TC_023(); // to connect with device

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Clicking the device section
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Devices"))).click();

        //Verify the burger menu is clickable.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/imgMenu"))).click();

        //Disconnect the device
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Disconnect Device\")"))).click();

        //Confirmation of disconnect the device
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();

        //Verify the devices is disconnected by clicking burger menu.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/message")));
        WebElement message = driver.findElement(AppiumBy.id("android:id/message"));
        System.out.println("Disconnected message : " + message.getText());

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();

    }
}

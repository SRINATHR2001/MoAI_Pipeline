package com.MoAI.LoginPage;
import Base.BaseClass1;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;

public class LoginScenarios extends BaseClass1
{
    @Test(groups = {"Login Positive"})
    public static void LogIn() throws InterruptedException
    {
        /*Positive case for login into MoAI application.*/

        //To click the MoAi application for launching we need to wait for some time.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Clicking the Get started button
        driver.findElement(AppiumBy.id("com.moai.android:id/txtGetStart")).click();

        //clicking the mobile number input field and send the keys to it.
        driver.findElement(AppiumBy.id("com.moai.android:id/edtMobileNumber")).sendKeys("9087631080");

        //Clicking the continue button
        driver.findElement(AppiumBy.id("com.moai.android:id/txtContinue")).click();

        //Here we are waiting to enter the OTP manually.
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //After verifying the OTP we can click the verify button now.
        WebElement verifyOtp = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtVerify")));

        /*After located the element, we are waiting for 1 minute. but still its clicking the verify button. So we are using the thread sleep.
         * which is not recommended. Solution: we need automate the otp */
        Thread.sleep(10000);

        // Clicking the verify button.
        verifyOtp.click();

        //Clicking the Allow notification Button.
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.android.permissioncontroller:id/permission_allow_button\")")).click();
    }

    @Test(groups = {"Login Positive"})
    public void LogOut() throws InterruptedException
    {
        /*Positive case for login into MoAI application and clicking the profile page.*/

        //To click the MoAi application for launching we need to wait for some time.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Clicking the Get started button
        driver.findElement(AppiumBy.id("com.moai.android:id/txtGetStart")).click();

        //clicking the mobile number input field and send the keys to it.
        driver.findElement(AppiumBy.id("com.moai.android:id/edtMobileNumber")).sendKeys("9087631080");

        //Clicking the continue button
        driver.findElement(AppiumBy.id("com.moai.android:id/txtContinue")).click();

        //Here we are waiting to enter the OTP manually.
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //After verifying the OTP we can click the verify button now.
        WebElement verifyOtp = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtVerify")));

        /*After located the element, we are waiting for 1 minute. but still its clicking the verify button. So we are using the thread sleep.
         * which is not recommended. Solution: we need automate the otp */
        Thread.sleep(10000);

        // Clicking the verify button.
        verifyOtp.click();

        //Clicking the Allow notification Button.
        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiSelector().resourceId(\"com.android.permissioncontroller:id/permission_allow_button\")")).click();

        //Clicking the More page.
        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiSelector().resourceId(\"com.moai.android:id/navigation_bar_item_icon_view\").instance(4)")).click();

        //Clicking the Logout button.
        driver.findElement(AppiumBy.id("com.moai.android:id/txtLogout")).click();

        //Confirm the Logout.
        driver.findElement(AppiumBy.id("android:id/button1")).click();

        //Verifying the logout
        boolean login = driver.findElement(AppiumBy.id("com.moai.android:id/txtPhoneLabel")).isDisplayed();
        System.out.println(login);

    }

    @Test(groups = {"Login Negative"})
    public void InvalidPhoneNumber()
    {
        /*Negative scenario. Verify the error message invalid phone number.*/

        //To click the MoAi application for launching we need to wait for some time.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Clicking the Get started button
        driver.findElement(AppiumBy.id("com.moai.android:id/txtGetStart")).click();

        //clicking the mobile number input field and send the keys to it.
        driver.findElement(AppiumBy.id("com.moai.android:id/edtMobileNumber")).sendKeys("908763108");

        //Clicking the continue button
        driver.findElement(AppiumBy.id("com.moai.android:id/txtContinue")).click();

        //Need to get the Error message.
        String ErrorMeg = driver.findElement(AppiumBy.androidUIAutomator
                ("new UiSelector().resourceId(\"com.moai.android:id/textinput_error\")")).getText();
        System.out.println("Actual Error message: " + ErrorMeg);

    }

    @Test(groups = {"Login Negative"})
    public void InvalidOTP() throws InterruptedException
    {
        /*Negative Scenario. Verify the error message for invalid OTP*/

        //To click the MoAi application for launching we need to wait for some time.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Clicking the Get started button
        driver.findElement(AppiumBy.id("com.moai.android:id/txtGetStart")).click();

        //clicking the mobile number input field and send the keys to it.
        driver.findElement(AppiumBy.id("com.moai.android:id/edtMobileNumber")).sendKeys("9087631080");

        //Clicking the continue button
        driver.findElement(AppiumBy.id("com.moai.android:id/txtContinue")).click();

        //Here we are waiting to enter the OTP manually.
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //After verifying the OTP we can click the verify button now.
        WebElement verifyOtp = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtVerify")));

        /*After located the element, we are waiting for 1 minute. but still its clicking the verify button. So we are using the thread sleep.
         * which is not recommended. Solution: we need automate the otp */
        Thread.sleep(10000);

        // Clicking the verify button.
        verifyOtp.click();

        String OtpErrorMeg = driver.findElement(AppiumBy.androidUIAutomator
                ("new UiSelector().resourceId(\"com.moai.android:id/text_message_toaster\")")).getText();

        System.out.println("Actual Error message: " + OtpErrorMeg);
    }
}

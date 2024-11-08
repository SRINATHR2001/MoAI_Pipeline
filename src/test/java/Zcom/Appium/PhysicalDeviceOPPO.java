package Zcom.Appium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class PhysicalDeviceOPPO extends BaseClass
{
    @Test(priority = 0, enabled = true)
    public void LogIn() throws InterruptedException
    {
        /*Positive case for login into MoAI application.*/

        //To click the MoAi application for launching we need to wait for some time.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Clicking the Get started button
        driver.findElement(AppiumBy.id("com.moai.android:id/txtGetStart")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //clicking the mobile number input field and send the keys to it.
        driver.findElement(AppiumBy.id("com.moai.android:id/edtMobileNumber")).sendKeys("9087631080");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //Clicking the Allow notification Button.
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.android.permissioncontroller:id/permission_allow_button\")")).click();
    }
    @Test(priority = 1, enabled = true)
    public void LogOut() throws InterruptedException
    {
        /*Positive case for login into MoAI application and clicking the profile page.*/

        //To click the MoAi application for launching we need to wait for some time.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Clicking the Get started button
        driver.findElement(AppiumBy.id("com.moai.android:id/txtGetStart")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //clicking the mobile number input field and send the keys to it.
        driver.findElement(AppiumBy.id("com.moai.android:id/edtMobileNumber")).sendKeys("9087631080");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //Clicking the Allow notification Button.
        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiSelector().resourceId(\"com.android.permissioncontroller:id/permission_allow_button\")")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //Clicking the More page.
        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiSelector().resourceId(\"com.moai.android:id/navigation_bar_item_icon_view\").instance(4)")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //Clicking the Logout button.
        driver.findElement(AppiumBy.id("com.moai.android:id/txtLogout")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //Confirm the Logout.
        driver.findElement(AppiumBy.id("android:id/button1")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //Verifying the logout
        boolean login = driver.findElement(AppiumBy.id("com.moai.android:id/txtPhoneLabel")).isDisplayed();
        System.out.println(login);

    }

    @Test(priority = 2, enabled = true)
    public void LoginNegative()
    {
        /*Negative scenario. Verify the error message invalid phone number.*/

        //To click the MoAi application for launching we need to wait for some time.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Clicking the Get started button
        driver.findElement(AppiumBy.id("com.moai.android:id/txtGetStart")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //clicking the mobile number input field and send the keys to it.
        driver.findElement(AppiumBy.id("com.moai.android:id/edtMobileNumber")).sendKeys("908763108");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Clicking the continue button
        driver.findElement(AppiumBy.id("com.moai.android:id/txtContinue")).click();

        //Need to get the Error message.
        String ErrorMeg = driver.findElement(AppiumBy.androidUIAutomator
                ("new UiSelector().resourceId(\"com.moai.android:id/textinput_error\")")).getText();
        System.out.println("Actual Error message: " + ErrorMeg);

    }

    @Test(priority = 3, enabled = true)
    public void InvalidOTP() throws InterruptedException
    {
        /*Negative Scenario. Verify the error message for invalid OTP*/

        //To click the MoAi application for launching we need to wait for some time.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Clicking the Get started button
        driver.findElement(AppiumBy.id("com.moai.android:id/txtGetStart")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //clicking the mobile number input field and send the keys to it.
        driver.findElement(AppiumBy.id("com.moai.android:id/edtMobileNumber")).sendKeys("9087631080");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Clicking the continue button
        driver.findElement(AppiumBy.id("com.moai.android:id/txtContinue")).click();

        //Here we are waiting to enter the OTP manually.
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //After verifying the OTP we can click the verify button now.
        WebElement verifyOtp = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtVerify")));

        /*After located the element, we are waiting for 1 minute. but still its clicking the verify button. So we are using the thread sleep.
         * which is not recommended. Solution: we need automate the otp */
        Thread.sleep(10000);

        // driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        // Clicking the verify button.
        verifyOtp.click();

        String OtpErrorMeg = driver.findElement(AppiumBy.androidUIAutomator
                ("new UiSelector().resourceId(\"com.moai.android:id/text_message_toaster\")")).getText();

        System.out.println("Actual Error message: " + OtpErrorMeg);

    }
}

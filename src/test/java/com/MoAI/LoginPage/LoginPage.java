package com.MoAI.LoginPage;
import Base.BaseClass1;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;

public class LoginPage extends BaseClass1
{

    @Test ( groups = {"Login page"}, enabled = true)
    public void TC_002()
    {
        //Global wait.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Clicking the Get started button
        driver.findElement(AppiumBy.id("com.moai.android:id/txtGetStart")).click();

        //Verify the logo is present or not in the login page.
        Boolean logo = driver.findElement(AppiumBy.id("com.moai.android:id/imgLogo")).isDisplayed();

        //Verified
        System.out.println(logo);

        //2.country code is present in the screen or not.
        WebElement countryCode = driver.findElement(AppiumBy.id("com.moai.android:id/textinput_prefix_text"));
        System.out.println(countryCode.isDisplayed());

        //clicking the mobile number input field and send the keys to it.
        driver.findElement(AppiumBy.id("com.moai.android:id/edtMobileNumber")).sendKeys("0000000000");

        //Clicking the continue button
        driver.findElement(AppiumBy.id("com.moai.android:id/txtContinue")).click();

        //Clicking on the back button to navigate back to the mobile number verification page.
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();

        //clicking in the link
        driver.findElement(AppiumBy.id("com.moai.android:id/txtTerms")).click();

        //clicking on terms and condition link before that user should be on the login page.
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();

        //clicking on the privacy policy link
        driver.findElement(AppiumBy.id("com.moai.android:id/txtPrivacy")).click();

        //clicking on terms and condition link before that user should be on the login page.
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();

        System.out.println("TC_002 completed");

    }

    @Test(priority = 1, groups = {"Login page"})
    public void TC_003()
    {
        //Global wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Clicking the Get started button
        driver.findElement(AppiumBy.id("com.moai.android:id/txtGetStart")).click();

        //clicking the mobile number input field and send the keys to it.
        driver.findElement(AppiumBy.id("com.moai.android:id/edtMobileNumber")).sendKeys("0000000000");

        //Clicking the continue button
        driver.findElement(AppiumBy.id("com.moai.android:id/txtContinue")).click();

        //verify mobile number label
        WebElement label = driver.findElement(AppiumBy.id("com.moai.android:id/txtPhoneLabel"));
        System.out.println("Verify mobile number label : " + label.isDisplayed());

        //Enter OTP label
        WebElement OtpLabel = driver.findElement(AppiumBy.id("com.moai.android:id/txtPhoneLabel"));
        System.out.println("Enter OTP label : "+OtpLabel.isDisplayed());

        //Fill the OTP into input field.
        driver.findElement(AppiumBy.id("com.moai.android:id/editTextOTP1")).sendKeys("1");

        driver.findElement(AppiumBy.id("com.moai.android:id/editTextOTP2")).sendKeys("2");

        driver.findElement(AppiumBy.id("com.moai.android:id/editTextOTP3")).sendKeys("3");

        driver.findElement(AppiumBy.id("com.moai.android:id/editTextOTP4")).sendKeys("4");

        driver.findElement(AppiumBy.id("com.moai.android:id/editTextOTP5")).sendKeys("5");

        driver.findElement(AppiumBy.id("com.moai.android:id/editTextOTP6")).sendKeys("6");


        //Resend label
        WebElement resend = driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/txtResend\"));"));
        System.out.println("Resent label is present : " +resend.isDisplayed());

        //Scroll Timer ----------
        WebElement Timer = driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/txtTimer\"));"));
        System.out.println("Timer is present : " + Timer.isDisplayed());

        //clicking the verify button.
        WebElement verifyButton = driver.findElement(AppiumBy.id("com.moai.android:id/txtVerify"));
        System.out.println("Verify button : "+verifyButton.isDisplayed());

        System.out.println("TC_003 completed");

    }

    @Test(priority = 2, groups = {"Login page"})
    public void TC_004()
    {
        //Global wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Clicking the Get started button
        driver.findElement(AppiumBy.id("com.moai.android:id/txtGetStart")).click();

        //clicking the mobile number input field and send the keys to it.
        driver.findElement(AppiumBy.id("com.moai.android:id/edtMobileNumber")).sendKeys("0000000000");

        //Clicking the continue button
        driver.findElement(AppiumBy.id("com.moai.android:id/txtContinue")).click();

        //Fill the OTP into input field.
        driver.findElement(AppiumBy.id("com.moai.android:id/editTextOTP1")).sendKeys("1");

        driver.findElement(AppiumBy.id("com.moai.android:id/editTextOTP2")).sendKeys("2");

        driver.findElement(AppiumBy.id("com.moai.android:id/editTextOTP3")).sendKeys("3");

        driver.findElement(AppiumBy.id("com.moai.android:id/editTextOTP4")).sendKeys("4");

        driver.findElement(AppiumBy.id("com.moai.android:id/editTextOTP5")).sendKeys("5");

        driver.findElement(AppiumBy.id("com.moai.android:id/editTextOTP6")).sendKeys("6");

        //Verify the OTP
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtVerify"))).click();

        //1.Clicking the profile pic option.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/imgPickProfile"))).click();

        //permission
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.android.packageinstaller:id/permission_allow_button"))).click();

        //permission
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.android.packageinstaller:id/permission_allow_button"))).click();

        //Gallery
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                ("new UiSelector().className(\"android.widget.ImageView\").instance(1)"))).click();

        //Gmail button.
       /* wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                ("new UiSelector().text(\"babuji@codingmart.com\")"))).click();
*/
        /*//My drive
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                ("new UiSelector().text(\"My Drive\")"))).click();*/

        //image.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                ("new UiSelector().text(\"IMG20241015102212.jpg\")"))).click();

        //2.Full name
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id
                ("com.moai.android:id/edtFullName"))).sendKeys("Sam");

        //3.Email ID
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id
                ("com.moai.android:id/edtEmail"))).sendKeys("b@gmail.com");

        //4.Mobile number
        System.out.println( wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id
                ("com.moai.android:id/edtMobileNumber"))).getText());

        //5.Continue button
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id
                ("com.moai.android:id/txtContinue"))).click();

        //6.Respective pagination
        WebElement Pagination = driver.findElement(AppiumBy.id("com.moai.android:id/txtSelected"));
        System.out.println("Pagination is visible : "+Pagination.isDisplayed());

        System.out.println("TC_004 completed");

    }

    @Test(priority = 3, groups = {"Login page"})
    public void TC_005()
    {
        TC_004(); //  1st page of basic details.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //1.Select the female option.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/imgWoman"))).click();

        //2.Select the male option
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/imgMan"))).click();

        //3.Others.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/imgOther"))).click();

        //4.Respective pagination
        WebElement Pagination = driver.findElement(AppiumBy.id("com.moai.android:id/txtSelected"));
        System.out.println("Pagination is visible : "+Pagination.isDisplayed());

        //5.continue button clicking
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtContinue"))).click();

        System.out.println("TC_005 completed");
    }

    @Test(priority = 4, groups = {"Login page"})
    public void TC_006()
    {
        TC_005(); // To complete the before pages.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //3.verifying the logo is present or not.
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/imgUserImage"))).isDisplayed();

        //4.pagination is present in the screen
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtSelected"))).isDisplayed();

        //5.clicking the continue button.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtContinue"))).click();

        System.out.println("TC_006 completed");
    }

    @Test(priority = 5, groups = {"Login page"})
    public void TC_007()
    {
        TC_006(); //To complete the previous steps.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Verify the logo
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/imgUserImage"))).isDisplayed();

        //Pagination verification
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtSelected"))).isDisplayed();

        //Clicking the continue button
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtContinue"))).click();

        System.out.println("TC_007 completed");

    }

    @Test(priority = 6, groups = {"Login page"})
    public void TC_008()
    {
        TC_007(); //To complete the previous steps.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //pagination.
        WebElement pagination = driver.findElement(AppiumBy.id("com.moai.android:id/txtSelected"));
        System.out.println("pagination is present : " + pagination.isDisplayed());

        //submit
        WebElement submit = driver.findElement(AppiumBy.id("com.moai.android:id/txtContinue"));
        System.out.println("Submit button is present : " + submit.isDisplayed());
        submit.click();

    }

    @Test
    public void TC_009()
    {
        TC_008(); // To complete the previous steps.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        //confirm alert
        wait.until(ExpectedConditions.alertIsPresent());

        //Alcohol NO button
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtAlcoholNo"))).click();

        //Smoke NO button
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtSmokeNo"))).click();

        //Submit button
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtContinue"))).click();

    }
}

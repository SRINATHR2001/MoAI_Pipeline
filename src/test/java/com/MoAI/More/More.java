package com.MoAI.More;

import Base.BaseClass1;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.time.Duration;

public class More extends BaseClass1
{
    private static final Logger log = LoggerFactory.getLogger(More.class);

    @Test
    public void TC_033()
    {
        BaseLogin(); // Login process

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        setupLogger("OutputFile.txt");

        //Clicking on more section
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"More\")"))).click();

        //1.Notification toggle off and on
        WebElement NotificationToggle = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/swEnable")));
        logger.info("Notification toggle is enabled : " + NotificationToggle.isEnabled());
        NotificationToggle.click();

        //All Notification section
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtNotification"))).click();
        WebElement NotificationHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator
                ("new UiSelector().text(\"Notifications\")")));
        logger.info("User currently present in : " + NotificationHeader.getText() + " page.");
        WebElement Notification = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator
                ("new UiSelector().resourceId(\"com.moai.android:id/llMain\").instance(0)")));
        logger.info("Notification is present : " + Notification.getText());

        //User can click the notification to view the details of it.
        Notification.click();

        //notification description
        WebElement Description = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/description")));
        logger.info("Notification description :" + Description.getText());

        //notification time
        WebElement time = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtCurrentTime")));
        logger.info("Notification time : " +time.getText());

        //Notification personal note
        WebElement PersonalNote = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtCurrentTime")));
        logger.info("Notification personal note : " +PersonalNote.getText());

        //Notification Days
        WebElement NotificationDays = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/tvWeekDay")));
        logger.info("Notification personal note : " +NotificationDays.getText());

        //Done.
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/tvOkay"))).click();

        //clear
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/menu_clear"))).click();

        //Clearing confirmation message.
        WebElement ConfirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/message")));
        logger.info("Confirmation message : " + ConfirmationMessage.getText());

        //ok button for the clearing notification.
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/button1"))).click();

        //navigate back
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Navigate up"))).click();

        //2.Clicking on FAQ section
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtFaq"))).click();

        //FAQ's header
        WebElement FAQ_Header = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"FAQs\")")));
        logger.info("User currently present in : " + FAQ_Header.getText() + " page.");

        //How to use this app
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                ("new UiSelector().text(\"How to use this app?\")"))).click();
        WebElement HowToUseThisApp = wait.until(ExpectedConditions.visibilityOfElementLocated
                (AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.moai.android:id/txtTitle2\").instance(0)")));
        logger.info("How to use this app content is present : " + HowToUseThisApp.isDisplayed());

        //Why do we use it
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                ("new UiSelector().text(\"Why do we use it?\")"))).click();
        WebElement WhyDoWeUseIt = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.
                androidUIAutomator("new UiSelector().resourceId(\"com.moai.android:id/txtTitle2\").instance(1)")));
        logger.info("Why do we use it content is present : " + WhyDoWeUseIt.isDisplayed());

        //navigate back
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Navigate up"))).click();

        //3.Clicking on Contact us
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtContactUs"))).click();

        //Contact us header
        WebElement ContactUs = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"Contact Us\")")));
        logger.info("User currently present in : " + ContactUs.getText() + " page.");

        //To email address.
        WebElement To = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/tvTo")));
        logger.info("User can see the To email address : " + To.isDisplayed());

        //To email address.
        WebElement From = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/tvFrom")));
        logger.info("User can see the To email address : " + From.isDisplayed());

        //Write your message
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id
                ("com.moai.android:id/edtMessage"))).sendKeys("Th");

        //Submit
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();

        //Error for less character
        WebElement ErrorText = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/text_message_toaster")));
        logger.info("Error message for less character : " + ErrorText.getText());

        //Write your message
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id
                ("com.moai.android:id/edtMessage"))).sendKeys("Thanks for developing the application and try to resolve all the conflict.");

        //Submit
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();

        //Success message
        WebElement SuccessMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/text_message_toaster")));
        logger.info("Success message for the : " + SuccessMessage.getText());

        //navigate back
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Navigate up"))).click();

    }

    @Test
    public void TC_034()
    {
        BaseLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        setupLogger("OutputFile.txt");

        //Clicking on more section
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"More\")"))).click();

        //1.Clicking on About us
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtAboutUs"))).click();

        //About us header
        WebElement AboutUsHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator
                ("new UiSelector().text(\"About Us\")")));
        logger.info("User currently present in : " + AboutUsHeader.getText());

        //About us content
        WebElement Content = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator
                ("new UiSelector().text(\"What is Lorem Ipsum? Lorem Ipsum is " +
                        "simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                        "when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic " +
                        "typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. Why do we use it? It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. " +
                        "The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, " +
                        "sometimes on purpose (injected humour and the like).\")")));
        logger.info("About us content is present : " + Content.isDisplayed());

        //navigate back
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Navigate up"))).click();

        //2.clicking on Terms & Conditions
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtTerms"))).click();

        //Terms and condition header
        WebElement TermsAndCondition = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator
                ("new UiSelector().text(\"Terms & Conditions\")")));
        logger.info("User currently present in : " + TermsAndCondition.getText());

        //Terms and condition content.
        WebElement ContentOfTermsAndCondition = wait.until(ExpectedConditions.visibilityOfElementLocated
                (AppiumBy.androidUIAutomator("new UiSelector().text(\"Terms & Conditions\")")));
        logger.info("Terms and Condition content is present : " + ContentOfTermsAndCondition.isDisplayed());

        //navigate back
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Navigate up"))).click();

        //3.Clicking on Privacy policy
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtPrivacy"))).click();

        //Privacy policy header
        WebElement PrivacyPloicy = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator
                ("new UiSelector().text(\"Privacy Policy\")")));
        logger.info("User currently present in : " + PrivacyPloicy.getText());

        //Privacy policy content.
        WebElement PrivacyPolicyContent = wait.until(ExpectedConditions.visibilityOfElementLocated
                (AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\").instance(2)")));
        logger.info("Privacy policy content is present : " + PrivacyPolicyContent.isDisplayed());

        //navigate back
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Navigate up"))).click();


    }
}

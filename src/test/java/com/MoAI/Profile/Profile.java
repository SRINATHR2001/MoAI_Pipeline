package com.MoAI.Profile;
import Base.BaseClass1;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Profile extends BaseClass1 {

    @Test
    public void TC_031()
    {   /*User navigation from profile section */

        BaseLogin(); //Login process.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //DB string
        WebElement DB = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtDashboard")));
        System.out.println("User present in : " + DB.getText());

        //MOTO - Clicking on profile section
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Profile\")"))).click();

        //1.Clicking the edit for alcohol
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/editConsume"))).click();

        System.out.println("User present in : Alcohol or smoke habit confirmation page");

        //Selecting yes for Alcohol
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtAlcoholYes"))).click();

        //Selecting occasionally for smoke
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSmokeOther"))).click();

        //Confirm with submit
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtContinue"))).click();

        //Success toast for the update
        WebElement SuccessMeg = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/text_message_toaster")));
        System.out.println("Success toast : " + SuccessMeg.getText());

        //Parameter range header
        WebElement PMR = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"Parameter Range\")")));
        System.out.println("User present in : " + PMR.getText() + " page ");

        //2. Editing parameter range
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtParameterRange"))).click();

        //Skip button
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/tvSkip"))).click();

        //Customize the Blood pressure
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                ("new UiSelector().resourceId(\"com.moai.android:id/txtCustomize1\").instance(0)"))).click();

        //Submit the blood pressure
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();

        //Skip button
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/tvSkip"))).click();

        //Back to the profile section
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up"))).click();

        //3.Editing My dependent
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtMyDependent"))).click();

        //My dependent header
        WebElement MyD = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"My Dependent\")")));
        System.out.println("User present in : " +MyD.getText() + " page");

        //Clicking the kebab option
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                ("new UiSelector().resourceId(\"com.moai.android:id/imgMenu\").instance(0)"))).click();

        //Clicking the Edit profile option.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Edit Profile\")"))).click();

        //Edit profile header
        WebElement EP = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"Edit Profile\")")));
        System.out.println("User present in : " +EP.getText() + " page");

        //Back to the profile section
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up"))).click();

        // Clicking the home option
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up"))).click();

        //Clicking on profile section
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Profile\")"))).click();

    }

    @Test
    public void TC_032()
    {
        BaseLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //MOTO - Clicking on profile section
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Profile\")"))).click();

        //1. Care circle
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtCareCircle"))).click();

        //Care circle header
        WebElement CC = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"Care Circles\")")));
        System.out.println("User present in : " +CC.getText() + " page");

        //Care circle list
        WebElement CareCircle = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator
                ("new UiSelector().text(\"Family Group\")")));
        System.out.println("My care circle : " + CareCircle.getText());

        //Kebab menu click
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                ("new UiSelector().resourceId(\"com.moai.android:id/ivOptions\").instance(0)"))).click();

        //Edit Care circle header
        WebElement CCL = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"Edit Care Circle\")")));
        System.out.println("User present in : " +CCL.getText() + " page");

        //Clicking the Edit care circle option
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Edit Care Circle\")"))).click();

        //Allow button
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.android.packageinstaller:id/permission_allow_button"))).click();

        //Selecting the contact
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"A Raveender Ho\")"))).click();

        //Add member button
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/tvAddMembers"))).click();

        //Changing the care circle name input field
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/edtGroupName"))).sendKeys("Family Group");

        //Update button
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/tvOkay"))).click();

        // Clicking the home option
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().description(\"Navigate up\")"))).click();

        //Clicking on profile section
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Profile\")"))).click();

        //Scroll to the bottom.
        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/txtMyReminder\"));"));

        //5.Clicking on My devices section.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtMyDevice"))).click();

        System.out.println("User present in : My device page.");

        //Connected device
        WebElement DeviceName = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtDeviceName")));
        System.out.println("Listed Device : "+ DeviceName.getText());

        //Kebab menu on the device section
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/imgMenu"))).click();

        //Connect device option
        WebElement ConnectDevice = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Connect Device\")")));
        System.out.println("Connect device option is present : " + ConnectDevice.isDisplayed());

        if (ConnectDevice.isDisplayed() == true)
        {
            System.out.println("User can connect with the listed device by using connect device option.");
        }
        else
        {
            System.out.println("User should add the device to connect.");
        }

        ConnectDevice.click();

        //Back
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up"))).click();

        //Add Another device option
        WebElement AddAnother = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtAddAnotherDevice")));
        if (AddAnother.isDisplayed() == true)
        {
            System.out.println("User can able to another device.");
        }

        //Device connection video
        WebElement Video = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/imgVideoImage")));
        if (Video.isDisplayed() == true)
        {
            System.out.println("User can get to know the how the device work.");
        }

        //MOTO - Clicking on profile section
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Profile\")"))).click();

        //Scroll to the bottom.
        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/txtMyReminder\"));"));

        //6.Clicking on my reminder
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtMyReminder"))).click();

        //My reminder header
        WebElement MyR = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"My Reminders\")")));
        System.out.println("User present in : " +MyR.getText() + " page");

        //Reminder list
        WebElement Reminder_1 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator
                ("new UiSelector().resourceId(\"com.moai.android:id/rlMainItem\").instance(0)")));

        if (Reminder_1.isDisplayed() == true)
        {
            System.out.println("Reminder details : " + Reminder_1.getText());
        }

        //Scroll to the bottom.
        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/rlMainItem\"));"));

        WebElement Reminder_3 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator
                ("new UiSelector().resourceId(\"com.moai.android:id/rlMainItem\").instance(3)")));

        if (Reminder_3.isDisplayed() == true)
        {
            System.out.println("Reminder details : "+Reminder_3.getText());
        }

        //Editing the reminder
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                ("new UiSelector().resourceId(\"com.moai.android:id/rlMainItem\").instance(2)"))).click();

        //Update reminder header
        WebElement upr = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"Update Reminder\").instance(0)")));
        System.out.println("User present in : " +upr.getText() + " page");

        //Edit the reminder name
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/edtReminderName"))).sendKeys("BP reminder.");

        //Update the reminder
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSetReminder"))).click();

        //Adding reminder
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                ("new UiSelector().resourceId(\"com.moai.android:id/menu_add\")"))).click();

        //Set reminder header
        WebElement sr = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"Set Reminder\").instance(0)")));
        System.out.println("User present in : " +sr.getText() + " page");

        //Reminder list with default blood pressure radio button selected. clicking on done button.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();

        //Reminder name
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id
                ("com.moai.android:id/edtReminderName"))).sendKeys("Blood pressure reminder.");

        //Selecting the Day
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtTUE"))).click();

        //Add time
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/chipAdd"))).click();

        //Selecting time
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("3"))).click();

        //Selecting minutes
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("30"))).click();

        //Confirm with ok
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();

        //Scroll to the bottom.
        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/edtPersonalNotes\"));"));

        //Personal note
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/edtPersonalNotes"))).sendKeys("Take care.");

        //Set reminder button
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSetReminder"))).click();

        //Deleting the reminder
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.moai.android:id/imgDelete\").instance(1)"))).click();

        //Confirmation
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();

        //reminder deleted meg
        WebElement ReminderDeleteMeg = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/message")));
        System.out.println("Deleted Message : " + ReminderDeleteMeg.getText());

        //Confirm ok
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();

        //Back to home page
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up"))).click();

    }

}

package com.MoAI.DashBoardPage;

import Base.BaseClass1;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.MultiOutputStream;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.Duration;

public class DashBoardPage extends BaseClass1 {
    @Test(enabled = false)
    public void Login() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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

    @Test
    public void TC_010() {
        Login();// to complete the login scenario.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //1.Verify the LOGO text present in the top.
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"MoAI\")")));
        WebElement LogoText = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"MoAI\")"));
        System.out.println("Logo text : " + LogoText.getText());
        System.out.println("Logo text is present : " + LogoText.isDisplayed());

        //2.Verify the Sync button.
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Sync data")));
        WebElement SyncData = driver.findElement(AppiumBy.accessibilityId("Sync data"));
        System.out.println("Sync data button is present : " + SyncData.isDisplayed());
        SyncData.click();

        //3.Notification button.
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Notification")));
        WebElement NotificationButton = driver.findElement(AppiumBy.accessibilityId("Notification"));
        System.out.println("Notification button is present : " + NotificationButton.isDisplayed());
        NotificationButton.click();

        //4.Seeing the notification and clearing them
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator
                ("new UiSelector().resourceId(\"com.moai.android:id/llMain\").instance(0)")));
        WebElement Notifications = driver.findElement(AppiumBy.androidUIAutomator
                ("new UiSelector().resourceId(\"com.moai.android:id/llMain\").instance(0)"));
        System.out.println("Notification is present : " + Notifications.isDisplayed());

        //5. clearing them
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("clear"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up"))).click();

        //6.health score section
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtEcg"))).isDisplayed();
        //Scrolling to heath score section.
        WebElement deviceIndication = driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/view5\"));"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/view5")));
        WebElement HealthScore = driver.findElement(AppiumBy.id("com.moai.android:id/view5"));
        System.out.println("Health score :" + HealthScore.isDisplayed());
        System.out.println("TC_010 is completed");
    }

    @Test
    public void TC_011() {
        Login(); // To complete the login process.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //1.Verify My dependent section.
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtMyDependent")));
        WebElement MyDependent = driver.findElement(AppiumBy.id("com.moai.android:id/txtMyDependent"));
        System.out.println("My dependent section is present : " + MyDependent.isDisplayed());

        //2.Add new dependent
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"+2\")"))).click();
        //My Dependent details page, new journey for adding dependent. user should cross all the 5 pages.
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"My Dependent\")")));
        WebElement MyDependentSection = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"My Dependent\")"));
        System.out.println("My Dependent page is present : " + MyDependentSection.isDisplayed());
        //Home button, moving back to dashboard.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up"))).click();

        //3.Verify added dependent in the dashboard
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"K\")")));
        WebElement AddedDependent = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"K\")"));
        System.out.println("Newly added dependent profile is visible : " + AddedDependent.isDisplayed());

        //4.Dependent profile
        AddedDependent.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtUserName")));
        WebElement userName = driver.findElement(AppiumBy.id("com.moai.android:id/txtUserName"));
        System.out.println("Dependent profile name : " + userName.getText());

        //Navigate back to the DB
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up"))).click();

        //6.Sharing the report detail
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/imgShare"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/rbECG"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Messages"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.android.mms:id/one"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.android.mms:id/send_button"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Cancel"))).click();

        //7.downloading the reports and sharing to the people.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/imgDownload"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/rbECG"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/rbSpo2"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/rbHR"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();


    }

    @Test
    public void TC_012() {
        Login(); // To complete the login process.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //verify the care circle section
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtCareCirclesLabel")));
        WebElement careCircleLabel = driver.findElement(AppiumBy.id("com.moai.android:id/txtCareCirclesLabel"));
        System.out.println("Care circle label is present : " + careCircleLabel.isDisplayed());

        //2.Clicking the Get stared button
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtCareCircle"))).click();

        //Permission
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id
                ("com.android.packageinstaller:id/permission_allow_button"))).click();

        //Selecting the contact
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"A\")"))).click();

        //Add member
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/tvAddMembers"))).click();

        //Enter group name
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id
                ("com.moai.android:id/edtGroupName"))).sendKeys("Fam");

    }

    @Test
    public void TC_013() {
        TC_012();  // To complete the previous steps.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Click the submit to get the error, not enough character.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/tvOkay"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/textinput_error")));
        WebElement error1 = driver.findElement(AppiumBy.id("com.moai.android:id/textinput_error"));
        System.out.println("Not enough character error : " + error1.getText());

        //Clearing the input field.
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id
                ("com.moai.android:id/edtGroupName"))).clear();

        //To get empty input field error.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/tvOkay"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/textinput_error")));
        WebElement error2 = driver.findElement(AppiumBy.id("com.moai.android:id/textinput_error"));
        System.out.println("Empty input field error : " + error2.getText());

    }


    @Test
    public void TC_014() {
        Login();// To complete the login scenario.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        //Care circle button.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/imgOtherProfile"))).click();

        //permission
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id
                ("com.android.packageinstaller:id/permission_allow_button"))).click();

        //Add member
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/tvAddMembers"))).click();

        //1.clicking the kebab menu
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("More options"))).click();

        //2.(i)Kebab menu list with edit care circle.
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator
                ("new UiSelector().text(\"Edit Care Circle\")")));
        WebElement EditCareCircle = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Edit Care Circle\")"));
        System.out.println("Edit care circle option is present in the list : " + EditCareCircle.isDisplayed());

        //2.(ii)Kebab menu list with set reminder
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator
                ("new UiSelector().text(\"Set Reminder\")")));
        WebElement SetReminder = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Set Reminder\")"));
        System.out.println("Set reminder option is present in the list : " + SetReminder.isDisplayed());

        //2.(iii)Kebab menu list with Delete care circle
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator
                ("new UiSelector().text(\"Delete Care Circle\")")));
        WebElement DeleteCareCircle = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Delete Care Circle\")"));
        System.out.println("Delete care circle option is present in the list : " + DeleteCareCircle.isDisplayed());

        //3.Clicking on the edit care circle option in the kebab menu
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                ("new UiSelector().text(\"Edit Care Circle\")"))).click();

        //Clearing the input field.
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id
                ("com.moai.android:id/edtGroupName"))).clear();

        //Editing the care circle name.
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id
                ("com.moai.android:id/edtGroupName"))).sendKeys("SANTH");

        //4.Clicking on the update to complete the change.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/tvOkay"))).click();

        System.out.println("Tc_016 is completed successfully.");

    }

    @Test
    public void TC_015() {
        Login(); // To complete the login process.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(13));

        //pre - Care circle button.
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/imgOtherProfile"))).click();

        //pre - permission
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id
                ("com.android.packageinstaller:id/permission_allow_button"))).click();

        //pre - Add member
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/tvAddMembers"))).click();

        //pre - clicking the kebab menu
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("More options"))).click();

        //1.clicking the Set reminder button in the kebab menu
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator
                ("new UiSelector().text(\"Set Reminder\")"))).click();

        //2.Verify the blood pressure radio button is selected by default.
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/rbBp")));
        WebElement BP = driver.findElement(AppiumBy.id("com.moai.android:id/rbBp"));
        System.out.println("Bp reminder is selected default : " + BP.isDisplayed());

        //3.verify the ECG radio button is selectable
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/rbECG"))).click();
        WebElement ECG = driver.findElement(AppiumBy.id("com.moai.android:id/rbECG"));
        System.out.println("Ecg is selected : " + ECG.isDisplayed());

        //4. verify the Spo2 reminder radio button is selectable
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/rbSpo2"))).click();
        WebElement Spo2 = driver.findElement(AppiumBy.id("com.moai.android:id/rbSpo2"));
        System.out.println("Spo2 is selected : " + Spo2.isDisplayed());

        //5.Heart rate reminder radio button is selectable
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/rbHR"))).click();
        WebElement HR = driver.findElement(AppiumBy.id("com.moai.android:id/rbHR"));
        System.out.println("HR is selected : " + HR.isDisplayed());

        //Done button
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();

        //Add reminder name
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id
                ("com.moai.android:id/edtReminderName"))).sendKeys("Take Heart rate.");

        //Selecting the days for the reminder
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtMUN"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtTHU"))).click();

        //Set the time for the reminder
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/chipAdd"))).click();

        //Choose the hour time for the reminder
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("6"))).click();

        //Choose the minute time for the reminder
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("0"))).click();

        //Confirm the with OK
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();

        //Using + to Adding invite to the reminder
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/imgAddReminder"))).click();

        //6.Add the invite to the reminder
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Kavya\")"))).click();

        //Clicking the add invite button
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();

        //Scrolling to personal note
        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/edtPersonalNotes\"));")).sendKeys("Take care Your self..");

        //7.Confirm the reminder
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSetReminder"))).click();
    }


    @Test
    public void TC_016() {
        Login();// To complete the login process.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Scrolling to the plus button.
        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/imgAddReminder\"));"));

        //Clicking the plus button
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/imgAddReminder"))).click();

        //Clicking the SpO2 radio button.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/rbSpo2"))).click();

        //Clicking the DONE button.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();

        /* CASE - 1*/
        //1.Selecting the days for the reminder
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtMUN"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtTHU"))).click();

        //2.Unselect the days in the reminder
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtMUN"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtTHU"))).click();

        /* CASE - 2 & 3 */
        //Empty reminder name
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/edtReminderName")));

        //Confirm the reminder using set reminder button.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSetReminder"))).click();

        //Empty reminder name error will be shown up.
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/textinput_error")));
        WebElement EmptyReminderName = driver.findElement(AppiumBy.id("com.moai.android:id/textinput_error"));
        System.out.println("Error 1 :" + EmptyReminderName.getText());

        //Less character error on reminder name.
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/edtReminderName"))).sendKeys("sa");

        //Confirm the reminder using set reminder button.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSetReminder"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/textinput_error")));
        WebElement LessCharacterError = driver.findElement(AppiumBy.id("com.moai.android:id/textinput_error"));
        System.out.println("Error 2 :" + LessCharacterError.getText());

        //3.
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/edtReminderName"))).sendKeys("Sant");

        //Empty Personal note less character.
        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/edtPersonalNotes\"));")).sendKeys("Take care");

        //Confirm the reminder using set reminder button.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSetReminder"))).click();

        //Popup for not selecting the day
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/message")));
        WebElement message = driver.findElement(AppiumBy.id("android:id/message"));
        System.out.println("Pop up message for days not selected : " + message.getText());
    }

    @Test
    public void TC_017() {
        Login(); // To complete the login process.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //Scrolling to the plus button.
        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/imgAddReminder\"));"));

        //Clicking the plus button
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/imgAddReminder"))).click();

        //Clicking the SpO2 radio button.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/rbSpo2"))).click();

        //Clicking the DONE button.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();

        //----------------This scroll is not working-----------------------need to work on that-----------------

        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/txtSetReminder\"));"));

        //Empty Personal note less character.
        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/edtPersonalNotes\"));")).sendKeys("Take");

        //Confirm the reminder using set reminder button.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSetReminder"))).click();

        //Error for empty personal note.
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/textinput_error")));
        WebElement error1 = driver.findElement(AppiumBy.id("com.moai.android:id/textinput_error"));
        System.out.println("Error 1 :" + error1.getText());

        //Clearing the personal note to get another error
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/edtPersonalNotes"))).clear();

        //Confirm the reminder using set reminder button.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSetReminder"))).click();

        //Error for empty personal note.
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/textinput_error")));
        WebElement error2 = driver.findElement(AppiumBy.id("com.moai.android:id/textinput_error"));
        System.out.println("Error 2 :" + error2.getText());

    }

    @Test
    public void TC_018() {
        Login();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Scrolling to the plus button.
        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/imgAddReminder\"));"));

        //Clicking the plus button
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/imgAddReminder"))).click();

        //Clicking the SpO2 radio button.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/rbSpo2"))).click();

        //Clicking the DONE button.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();

        //reminder name
        driver.findElement(AppiumBy.id("com.moai.android:id/edtReminderName")).sendKeys("SpO2 reminder ");

        //Selecting the required days
        driver.findElement(AppiumBy.id("com.moai.android:id/txtSUN")).click();
        driver.findElement(AppiumBy.id("com.moai.android:id/txtMUN")).click();

        //Click add Button.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/chipAdd"))).click();

        //Selecting the Hour.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("9"))).click();

        //Selecting the Minutes.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("15"))).click();

        //Clicking the ok
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();

        //Checking whether the reminder time is added or not.
        System.out.println(" just checking whether the reminder time is added or not: " +
                driver.findElement(AppiumBy.id("com.moai.android:id/chipText")).isDisplayed());

        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/edtPersonalNotes\"));")).sendKeys("Take");

        //Adding personal notes.
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/edtPersonalNotes"))).sendKeys("Take SpO2");

        //Set the reminder
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSetReminder"))).click();

    }

    @Test
    public void TC_019() {
        Login();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //Verify the care circle is present in the screen
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/imgOtherProfile")));
        WebElement CareCircle = driver.findElement(AppiumBy.id("com.moai.android:id/imgOtherProfile"));
        System.out.println("Care is present : " + CareCircle.isDisplayed());

        //Care circle button.
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/imgOtherProfile"))).click();

        //permission
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id
                ("com.android.packageinstaller:id/permission_allow_button"))).click();

        //Add member
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/tvAddMembers"))).click();

        //1.clicking the kebab menu
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("More options"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                ("new UiSelector().text(\"Delete Care Circle\")"))).click();

        //Confirmation for deleting the care circle
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();

        System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/dialog_layout_toaster"))).getText());
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/dialog_layout_toaster"))).getText();
        WebElement SuccessToast = driver.findElement(AppiumBy.id("com.moai.android:id/dialog_layout_toaster"));
        System.out.println("Success toast : " + SuccessToast.getText());

    }

    @Test
    public void TC_025() {
        BaseLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"+2\")"))).click();

        //1.Verify the dependent list
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"Kavya\")")));
        WebElement Dependent_1 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Kavya\")"));
        System.out.println(Dependent_1.getText() + " is one of the dependent is present : " + Dependent_1.isDisplayed());

        //2.Edit the dependent profile, click on kebab menu.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                ("new UiSelector().resourceId(\"com.moai.android:id/imgMenu\").instance(1)"))).click();
        //Actual edit profile option.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                ("new UiSelector().text(\"Edit Profile\")"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/edtFullName"))).sendKeys("NIHIL");
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up"))).click();

        //3.Deleting the profile
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                ("new UiSelector().resourceId(\"com.moai.android:id/imgMenu\").instance(2)"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Delete\")"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/message")));
        WebElement message = driver.findElement(AppiumBy.id("android:id/message"));
        System.out.println("Success message for deleted dependent :" + message.getText());
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();

    }

    @Test
    public void TC_026() {
        BaseLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"+2\")"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                ("new UiSelector().resourceId(\"com.moai.android:id/imgMenu\").instance(0)"))).click();

        //Clicking the health report option to navigate to report section.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Health Report\")"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().text(\"Blood Pressure\")")));
        WebElement lable = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Blood Pressure\")"));
        System.out.println("Report section : " + lable.getText());
    }

    @Test
    public void TC_027() {
        /*Adding the reminder for Blood pressure.*/
        BaseLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.moai.android:id/txtEcg"))).isDisplayed();

        //Scrolling to the plus button.
        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/imgAddReminder\"));"));

        //1.Clicking the plus button
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/imgAddReminder"))).click();

        //Clicking the HR radio button.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/rbHR"))).click();

        //Selecting the DONE button.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();

        //2.reminder name
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/edtReminderName"))).sendKeys("Heart rate reminder");

        //Selecting the required days
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSUN"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtMUN"))).click();

        //Click add Button.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/chipAdd"))).click();

        //Selecting the Hour as 12.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("9"))).click();

        //Selecting the Minutes as 00.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("15"))).click();

        //Clicking the ok
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();

        //Checking whether the reminder time is added or not.
        System.out.println(" just checking whether the reminder time is added or not: " +
                driver.findElement(AppiumBy.id("com.moai.android:id/chipText")).isDisplayed());

        //3.Adding invite
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/imgAddReminder"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                ("new UiSelector().resourceId(\"com.moai.android:id/mainLayout\").instance(0)"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();

        //Scrolling to the Adding personal notes.
        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/edtPersonalNotes\"));"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/edtPersonalNotes"))).sendKeys("Take HR daily.");

        //Set the reminder
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSetReminder"))).click();

    }

    @Test
    public void TC_028() {
        BaseLogin(); // Login process.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //BP report values with chart.
        WebElement bloodPressureElement = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtBloodPressure")));
        System.out.println("Blood pressure report is present: " + bloodPressureElement.isDisplayed());

        WebElement pressureChart = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/bloodPressureChart")));
        System.out.println("Blood pressure report chart is present: " + pressureChart.isDisplayed());

        WebElement pressureValue = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtBPValue")));
        System.out.println("Blood pressure value is present: " + pressureValue.getText());

        //Hr report values with chart.
        WebElement hrElement = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtHeartRate")));
        System.out.println("Heart rate report is present: " + hrElement.isDisplayed());

        WebElement hrChart = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/HeartRateChart")));
        System.out.println("Heart rate report chart is present: " + hrChart.isDisplayed());

        WebElement hrValue = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtHeartRateValue")));
        System.out.println("Heart rate value is present: " + hrValue.getText());

        //Spo2 report values with chart.
        WebElement Spo2Element = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtSpo2")));
        System.out.println("Spo2 report is present: " + Spo2Element.isDisplayed());

        WebElement Spo2Chart = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/spo2Chart")));
        System.out.println("Spo2 report chart is present: " + Spo2Chart.isDisplayed());

        WebElement Spo2Value = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtSpo2Value")));
        System.out.println("Spo2 value is present: " + Spo2Value.getText());

        //ECG report va;ues with chart
        WebElement ECGElement = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtEcg")));
        System.out.println("ECG report is present: " + ECGElement.isDisplayed());

        WebElement ECGChart = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/mpSingleLeadECG")));
        System.out.println("ECG report chart is present: " + ECGChart.isDisplayed());

    }

    @Test
    public void TC_029() {

        BaseLogin(); //Login process from base class.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Clicking on primary user profile
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/imgProfile"))).click();

        //Clicking on parameter range option in the primary user profile
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtParameterRange"))).click();

        //Customize the BP range
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.moai.android:id/txtCustomize2\").instance(0)"))).click();
        //Submit button
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();
        //Reset can happen
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.moai.android:id/txtBPRest\").instance(0)"))).click();
        //confirmation Ok
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
        //Skip
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/tvSkip"))).click();


        //Blood sugar range is not customizable
        WebElement CustomizeBlood = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtCustomize1")));
        System.out.println("Blood sugar is not customizable :" + CustomizeBlood.isEnabled());


        //Customize the Spo2 range
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.moai.android:id/txtCustomize2\").instance(0)"))).click();
        //Submit button
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();
        //Reset can happen
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.moai.android:id/txtBPRest\").instance(0)"))).click();
        //confirmation Ok
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();


        //Customizing the cholesterol is not possible.
        WebElement CustomizeCholesterol = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.moai.android:id/txtCustomize1\").instance(1)")));
        System.out.println("Cholesterol is not Customizable :" + CustomizeCholesterol.isEnabled());

        //Scroll to the bottom customize.
        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/txtCustomize2\"));"));

        //Customize the heart rate.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.moai.android:id/txtCustomize2\").instance(0)"))).click();
        //Submit button
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();
        //Reset can happen
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.moai.android:id/txtBPRest\").instance(0)"))).click();
        //confirmation Ok
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();


        //Navigate to the profile page.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up"))).click();

    }


    @Test
    public void TC_030() {

        BaseLogin(); //Login process.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //clicking the dependent profile
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"K\")"))).click();

        //Customize the BP range
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtCustomize2"))).click();
        //Submit button
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();
        //Reset can happen
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtBPRest"))).click();
        //confirmation Ok
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
        /*//Skip
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/tvSkip"))).click();*/

        //Scroll to the bottom customize.
        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/txtCustomize2\"));"));

        //Blood sugar range is not customizable
        WebElement CustomizeBlood = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.moai.android:id/txtCustomize1")));
        System.out.println("Blood sugar is not customizable :" + CustomizeBlood.isEnabled());

        //Customize the Spo2 range
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.moai.android:id/txtCustomize2\").instance(0)"))).click();
        //Submit button
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();
        //Reset can happen
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.moai.android:id/txtBPRest\").instance(0)"))).click();
        //confirmation Ok
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();

        //Customizing the cholesterol is not possible.
        WebElement CustomizeCholesterol = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.moai.android:id/txtCustomize1\").instance(1)")));
        System.out.println("Cholesterol is not Customizable :" + CustomizeCholesterol.isEnabled());

        //Scroll to the bottom customize.
        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"com.moai.android:id/txtCustomize2\"));"));

        //Customize the heart rate.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.moai.android:id/txtCustomize2\").instance(0)"))).click();
        //Submit button
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/txtSubmit"))).click();
        //Reset can happen
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.moai.android:id/txtBPRest\").instance(0)"))).click();
        //confirmation Ok
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();

    }


    @Test(enabled = false)
    public void LoggerDemoCase()
    {
        initializeOutput("OutputFile.txt");
        printToBoth("print into both,");
        printToBoth("print into both 23 ,");

        resetToConsole();
        System.out.println("console alone print");

        setupLogger("OutputFile.txt");
        logger.info("this is form logger for both console and file print.");
        logger.warning("This warning for both console and file print.");
    }


}

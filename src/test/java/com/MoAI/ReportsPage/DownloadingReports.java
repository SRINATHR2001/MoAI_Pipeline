package com.MoAI.ReportsPage;

import Base.BaseClass1;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class DownloadingReports extends BaseClass1
{

    @Test
    public void TC_020()
    {
        BaseLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Clicking on the report section
        wait.until(ExpectedConditions.elementToBeClickable
                (AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.moai.android:id/navigation_bar_item_icon_view\").instance(1)"))).click();

        //Drop down filter.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                ("new UiSelector().text(\"Day\")"))).click();

        //Selecting the month on this filter
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Month\")"))).click();

        //clicking the to the specific day.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Nov\")"))).click();

        //Moving to previous month
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Previous month"))).click();

        //Report on Oct-29 for BP
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("29 October 2024"))).click();

        //Ok button
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();

        //Clicking the download button on Spo2 report section
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/imgDownload"))).click();

        //Allow permission
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.android.packageinstaller:id/permission_allow_button"))).click();

    }

    @Test
    public void TC_021()
    {
        BaseLogin();

        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));

        //Clicking on the report section
        wait.until(ExpectedConditions.elementToBeClickable
                (AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.moai.android:id/navigation_bar_item_icon_view\").instance(1)"))).click();

        //Clicking on the ECG report
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"ECG\")"))).click();

        //Clicking on the download button in ECG report section
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/ivDownload1"))).click();

        //Allow permission
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.android.packageinstaller:id/permission_allow_button"))).click();

    }

    @Test
    public void TC_022()
    {
        BaseLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Clicking on the report section
        wait.until(ExpectedConditions.elementToBeClickable
                (AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.moai.android:id/navigation_bar_item_icon_view\").instance(1)"))).click();

        //Clicking on the HR report
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Heart Rate\")"))).click();

        //Clicking on the download button in ECG report section
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.moai.android:id/imgDownload"))).click();

        //Allow permission
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.android.packageinstaller:id/permission_allow_button"))).click();


    }

}

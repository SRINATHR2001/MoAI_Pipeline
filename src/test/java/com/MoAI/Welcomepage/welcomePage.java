package com.MoAI.Welcomepage;

import Base.BaseClass1;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class welcomePage extends BaseClass1
{
    //TC_001
    @Test(enabled = false)
    public void TC_001()
    {
        //Global wait.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //confirm the image is present in the screen
        System.out.println( "image is displayed in the welcome screen : " +
                driver.findElement(AppiumBy.id("com.moai.android:id/images")).isDisplayed());

        //Description verification.
        WebElement description = driver.findElement(AppiumBy.id("com.moai.android:id/txtDescription"));
        System.out.println("Welcome screen description : " + description.getText());

        //Clicking the Get started button
        WebElement getStarted =  driver.findElement(AppiumBy.id("com.moai.android:id/txtGetStart"));

        System.out.println("Get started button is present in the welcome page : " + getStarted.isDisplayed());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.elementToBeClickable(getStarted)).click();

        //Verifying the login or signup label present or not.
        boolean loginOrSignup = driver.findElement(AppiumBy.id("com.moai.android:id/txtPhoneLabel")).isDisplayed();
        System.out.println("Navigated to login page : "+ loginOrSignup);
    }

}

package Zcom.Appium;
import Base.BaseClass12;
import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class Demo2 extends BaseClass12
{
    @Test(groups = {"Smoke"}, dependsOnMethods = "ConfigureAppium")
    public void test1()
    {
        System.out.println("test1 smoke");
        driver.findElement(AppiumBy.id("ddd")).isDisplayed();
    }

    @Test(groups = {"Sanity"})
    public void test2()
    {
        System.out.println("test2 sanity");
    }

    @Test(groups = {"Smoke"})
    public void test3()
    {
        System.out.println("test3 smoke");
    }

    @Test(groups = {"Sanity"})
    public void test4()
    {
        System.out.println("test4 sanity");
    }
}

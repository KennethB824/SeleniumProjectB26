package com.cydeo.test.day8_dropdown_alert_iframe;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class AlertPractices {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://practice.cydeo.com/javascript_alerts");
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }

    @Test
    public void alertTest(){

        //3. Click “Click for JS Confirm” button
        WebElement confirmAlert = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        confirmAlert.click();

        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //if we wanted to cancel we would use:
        //alert.dismiss();

        //5. Verify “You clicked: Ok” text is displayed.
        WebElement resultText = driver.findElement(By.id("result"));
        String actualResultText = resultText.getText();
        String expectedResultText = "You clicked: Ok";

        //Doesn't verify if the exact text is being displayed. It just shows there's some text being displayed in that location
        Assert.assertTrue(resultText.isDisplayed(), "result text did not appear");

        //Using this one to make sure the exact text is being displayed
        Assert.assertEquals(actualResultText, expectedResultText, "Incorrect result");

    }

    @Test
    public void promptAlertTest(){
        WebElement jsPrompt = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        jsPrompt.click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");
        alert.accept();

        WebElement resultText = driver.findElement(By.id("result"));
        String actualText = resultText.getText();
        String expectedText = "You entered: hello";
        assertEquals(actualText, expectedText, "result text did not appear correctly!");
    }

}
/*
1. Open browser
2. Go to website: http://practice.cydeo.com/javascript_alerts
3. Click to “Click for JS Confirm” button
4. Click to OK button from the alert
5. Verify “You clicked: Ok” text is displayed.
 */
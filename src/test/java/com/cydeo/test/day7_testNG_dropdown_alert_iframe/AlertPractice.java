package com.cydeo.test.day7_testNG_dropdown_alert_iframe;

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

public class AlertPractice {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        //1- Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

    @Test
    public void InformationAlertTest(){
        //3. Click “Click for JS Alert” button
        WebElement jsAlertBtn = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        jsAlertBtn.click();

        //4. Click  OK button from the alert
        //driver.switchTo().alert().accept -> can also use it this way. Useful if you don't need to do more than one action with it
        Alert jsAlert = driver.switchTo().alert();
        jsAlert.accept();

        //5. Verify “You successfully clicked an alert” text is displayed.
        String actualResult = driver.findElement(By.id("result")).getText();
        String expectedResult = "You successfully clicked an alert";

        Assert.assertEquals(actualResult, expectedResult, "Incorrect result");

        //Assert.assertTrue(resultText.isDisplayed()); -> since requirement said is displayed, we could do this. But it'll just come out true if there's any text. That's why we're still using line 52.

    }

}


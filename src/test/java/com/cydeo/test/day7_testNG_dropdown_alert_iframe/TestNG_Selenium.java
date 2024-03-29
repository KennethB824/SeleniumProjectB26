package com.cydeo.test.day7_testNG_dropdown_alert_iframe;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNG_Selenium {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        //set up chrome and create WebDriver instance
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //Providing extra time for our driver before it throws NoSuchElementException
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void googleTitle(){
        //Get "https://google.com"
    driver.get("https://google.com");

    //Assert: title is "Google"
    String actualTitle = driver.getTitle();
    String expectedTitle = "Google";

    //3rd argument is optional for failed message. It will only appear when verification is failed
        Assert.assertEquals(actualTitle, expectedTitle, "Title verification is failed!");

    }

    @Test
    public void yahooTitle(){
        //Get "https://google.com"
        driver.get("https://yahoo.com");

        //Assert: title is "Yahoo"
        String actualTitle = driver.getTitle();
        String expectedTitle = "Yahho";

        //3rd argument is optional for failed message. It will only appear when verification is failed
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Title verification is failed!");

    }

    @Test
    public void etsyTitle(){ //Tests run alphabetically, not in top to bottom order. So etsy will run first.
        //Get "https://etsy.com"
        driver.get("https://etsy.com");

        //Assert: title is "Etsy"
        String actualTitle = driver.getTitle();
        String expectedTitle = "Etsy";

        //3rd argument is optional for failed message. It will only appear when verification is failed
        Assert.assertEquals(actualTitle, expectedTitle, "Title verification is failed!");

    }

}

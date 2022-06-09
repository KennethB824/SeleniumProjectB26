package com.cydeo.test.day7_testNG_dropdown_alert_iframe;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_Simple_DropDown {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        //1- Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Since both tests are on same website, we can put this line in setUpMethod. If each test had different website, we would've put this line on each test.
        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

    @Test
    public void simpleDropdownTest(){

        //3. Verify “Simple dropdown” default selected value is correct
        //Expected: “Please select an option”
        Select simpleDropdown = new Select(driver.findElement(By.id("dropdown")));

        String actualDefaultSimpleDropdown = simpleDropdown.getFirstSelectedOption().getText();
        String expectedDefaultSimpleDropdown = "Please select an option";

        Assert.assertEquals(actualDefaultSimpleDropdown, expectedDefaultSimpleDropdown, "Validation failed");
    }

    @Test
    public void stateDropdownTest(){
        //4. Verify “State selection” default selected value is correct
        //Expected: “Select a State”
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        String actualDefaultStateDropdown = stateDropdown.getFirstSelectedOption().getText();
        String expectedDefaultStateDropdown = "Select a State";

        Assert.assertEquals(actualDefaultStateDropdown, expectedDefaultStateDropdown);
    }



}

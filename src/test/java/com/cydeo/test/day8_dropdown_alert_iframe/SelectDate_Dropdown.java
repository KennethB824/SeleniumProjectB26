package com.cydeo.test.day8_dropdown_alert_iframe;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SelectDate_Dropdown {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void dateDropdownTest(){

        //3. Select “December 1st, 1923” and verify it is selected.
        // Select year using   : visible text
        Select year = new Select(driver.findElement(By.id("year")));
        year.selectByVisibleText("1923");

        //Select month using    : value attribute Select
        Select month = new Select(driver.findElement(By.id("month")));
        month.selectByValue("11");

        //day using : index number
        Select day = new Select(driver.findElement(By.id("day")));
        day.selectByIndex(0);


        //// Verify each year, month and day selected correctly
        String actualYear = year.getFirstSelectedOption().getText();
        String actualMonth = month.getFirstSelectedOption().getText();
        String actualDay = day.getFirstSelectedOption().getText();

        String expectedYear = "1923";
        String expectedMonth = "December";
        String expectedDay = "1";

        Assert.assertTrue(actualYear.equals(expectedYear), "Year selection did not pass!");
        Assert.assertTrue(actualMonth.equals(expectedMonth), "Month selection did not pass!");
        Assert.assertTrue(actualDay.equals(expectedDay), "Day selection did not pass!");

        //can also do assertEquals
        //Assert.assertEquals(actualYear, expectedYear, "Year selection did not pass!");


    }

}
/*
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Select “December 1st, 1923” and verify it is selected.
 Select year using   : visible text
Select month using    : value attribute Select
day using : index number
 */

/*
Additional notes: (preceding-sibling and following-sibling)
To go to preceding-sibling
---- the [2] is how many indexes up you want to go ----
(//option[@value='5'])[1]/preceding-sibling::option[2]
---- value=5 would be June. So 2 preceding would be April ----

To go to following-sibling
---- the [2] is how many indexes up you want to go ------
(//option[@value='5'])[1]/following-sibling::option[2]
---- value=5 would be June. So 2 following would be August
 */
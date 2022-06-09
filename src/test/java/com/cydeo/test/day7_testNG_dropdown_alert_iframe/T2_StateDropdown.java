package com.cydeo.test.day7_testNG_dropdown_alert_iframe;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T2_StateDropdown {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void stateDropdownTest(){
        Select stateDropdown = new Select(driver.findElement(By.id("state")));

        //Use all Select options. (visible text, value, index)
        //3. Select Illinois
        stateDropdown.selectByIndex(14);

        //4. Select Virginia
        stateDropdown.selectByValue("VA");

        //5. Select California
        stateDropdown.selectByVisibleText("California");

        //6. Verify final selected option is California.
        //getFirstSelectedOption() method will return CURRENT selected option.
        String actualSelected = stateDropdown.getFirstSelectedOption().getText();
        String expectedSelected = "California";

        Assert.assertEquals(actualSelected, expectedSelected, "Test failed");
        //can also make it without creating the variables
        //Assert.assertEquals(stateDropdown.getFirstSelectedOption().getText(), "California", "Test failed");

    }

    @Test
    public void multiSelectDropdown(){

        //3. Select all the options from multiple select dropdown.
        Select languages = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));

        //This returns true if this dropdown allows you to click on multiple options (not just one option)
        //System.out.println("languages.isMultiple() = " + languages.isMultiple());

//        languages.selectByValue("java");
//        languages.selectByVisibleText("C#");
//        languages.selectByIndex(3);

        //4. Print out all selected values.
        //getOptions() method will return all options in dropdown
        for (WebElement each : languages.getOptions()) {
            each.click();
            System.out.println("each.getText() = " + each.getText());
        }

        /*
        Can also do it like this:
        List<WebElement> list = languages.getOptions();
        for (int i = 0; i < list.size(); i++) {
            languages.selectByIndex(i);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getText());
        }
        */

        //5. Deselect all values.
        languages.deselectAll();

    }

}
/*
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Select Illinois
4. Select Virginia
5. Select California
6. Verify final selected option is California.
Use all Select options. (visible text, value, index)
 */

/*
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Select all the options from multiple select dropdown.
4. Print out all selected values.
5. Deselect all values.
 */
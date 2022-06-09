package com.cydeo.test.day5_findElements_checkBox_radioButton;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T4_RadioButton {
    public static void main(String[] args) {

        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");

        //3. Click to “Hockey” radio button
        WebElement hockeyRadioBtn = driver.findElement(By.xpath("//input[@id='hockey']"));
        hockeyRadioBtn.click();

        //4. Verify “Hockey” radio button is selected after clicking.
        System.out.println("hockey radio button verification is " + hockeyRadioBtn.isSelected());

        //5. Locate Green button and verify if it is enabled
        WebElement greenRadioBtn = driver.findElement(By.xpath("//input[@id='green']"));
        System.out.println("green button verification is " + greenRadioBtn.isEnabled());

        driver.quit();

    }
}

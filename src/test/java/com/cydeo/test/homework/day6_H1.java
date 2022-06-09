package com.cydeo.test.homework;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class day6_H1 {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testWebsite() throws InterruptedException {
        driver.get("https://www.etsy.com");

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='global-enhancements-search-query']"));
        searchBox.sendKeys("wooden spoon" + Keys.ENTER);

        WebElement filterBtn = driver.findElement(By.xpath("//span[@class='wt-hide-xs wt-show-md filter-expander']"));
        filterBtn.click();

        WebElement freeShippingBtn = driver.findElement(By.xpath("//label[@for='special-offers-free-shipping']"));
        freeShippingBtn.click();

        WebElement onSaleBtn = driver.findElement(By.xpath("//label[@for='special-offers-on-sale']"));
        onSaleBtn.click();

        WebElement under25Btn = driver.findElement(By.xpath("//label[@for='price-input-1']"));
        under25Btn.click();

        WebElement applyBtn = driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--primary wt-width-full wt-mt-xs-3 wt-mb-xs-3 wt-mr-xs-3']"));
        applyBtn.click();

        Thread.sleep(3000);

        String results = driver.findElement(By.xpath("(//span[@class='wt-display-inline-flex-sm']//span)[1]")).getText();

        System.out.println(results);
    }



}
/*
TC: Etsy checkbox and radio button
1. Go to https://www.etsy.com
2. Search for “wooden spoon”
3. Click on filters
4. Select free shipping, on sale
5. Select under $25 Click on apply filters
6. Print count of results
 */
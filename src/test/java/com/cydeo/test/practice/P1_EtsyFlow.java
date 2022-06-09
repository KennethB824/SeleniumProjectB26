package com.cydeo.test.practice;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class P1_EtsyFlow {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://etsy.com");
    }

//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//    }

    @Test
    public void test(){
        WebElement searchBox = driver.findElement(By.id("global-enhancements-search-query"));
        searchBox.sendKeys("Bad Bunny sweater" + Keys.ENTER);

        WebElement filterBtn = driver.findElement(By.xpath("//span[@class='wt-hide-xs wt-show-md filter-expander']"));
        filterBtn.click();

        //Free Shipping -> On Sale -> Under $50 -> Apply
        driver.findElement(By.xpath("//label[@for='special-offers-free-shipping']")).click();
        driver.findElement(By.xpath("//label[@for='special-offers-on-sale']")).click();
        driver.findElement(By.xpath("//label[@for='price-input-1']")).click();
        driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--primary wt-width-full wt-mt-xs-3 wt-mb-xs-3 wt-mr-xs-3']")).click();

        List<WebElement> names = driver.findElements(By.xpath("//h3[contains(text(),'unny')]"));
        //List<WebElement> stars = driver.findElements(By.xpath("//span[contains(text(),'stars')]"));
        List<WebElement> stars = driver.findElements(By.xpath("//h3[contains(text(),'unny')]/..//span[contains(text(),'stars')]"));

        Map<List, List> map = new HashMap<>();


        for (WebElement each : stars) {
            if (!each.getText().contains("5 out of 5 stars")){
                String temp = each.getText();
                System.out.println(temp + " isn't 5 stars");
            }
        }

    }

}

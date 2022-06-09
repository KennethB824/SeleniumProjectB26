package com.cydeo.test.day2_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework1 {
    public static void main(String[] args) {

//        TC #3: Back and forth navigation
//        1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        2- Go to: https://google.com
        driver.get("https://google.com");

//        3- Click to Gmail from top right.
        driver.findElement(By.className("gb_d")).click();

//        4- Verify title contains:
//        Expected: Gmail
        String expectedTitle = "Gmail";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Correct title");
        }else{
            System.out.println("Incorrect title");
        }

//        5- Go back to Google by using the .back();
        driver.navigate().back();

//        6- Verify title equals:
//        Expected: Google
        expectedTitle = "Google";
        actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Correct title");
        }else{
            System.out.println("Incorrect title");
        }

        driver.quit();

    }
}

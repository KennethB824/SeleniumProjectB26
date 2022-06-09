package com.cydeo.test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basic_Navigations {

    public static void main(String[] args) throws InterruptedException {

        //1 - Setting up webdriver manager
        WebDriverManager.chromedriver().setup();

        //2 - Create instance of WebDriver
        WebDriver driver = new ChromeDriver();

        //3 - Make our page full screen
        driver.manage().window().maximize();

        //Both of the following work:
        driver.get("https://www.etsy.com");

        //This one does same as .get, but .navigate has some other functions. So we will use it for other methods
        //driver.navigate().to("https://www.etsy.com");

        Thread.sleep(3000);

        driver.navigate().back(); //back() is one of the other methods it has. Go to the previous page.

        Thread.sleep(3000);

        driver.navigate().forward(); //go to forward page

        Thread.sleep(3000);

        driver.navigate().refresh(); //refresh page

        String currentTitle = driver.getTitle();
        System.out.println(currentTitle);
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl()); //get the url
        //can also print it directly - System.out.println(driver.getTitle());

        driver.get("https://www.tesla.com");
        System.out.println("Tesla page - driver.getTitle() = " + driver.getTitle()); //soutv to get it in this format
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        //driver.close(); //will close currently open tab (if just one tab open on browser, will close browser)

        driver.quit(); //will close all tabs (browser getting closed)

    }

}

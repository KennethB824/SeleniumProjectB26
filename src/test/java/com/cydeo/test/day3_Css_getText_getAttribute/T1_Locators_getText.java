package com.cydeo.test.day3_Css_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_Locators_getText {
    public static void main(String[] args) throws InterruptedException {

        //TC #1: NextBaseCRM, locators and getText() practice 1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Enter incorrect username: “incorrect”
        WebElement userName = driver.findElement(By.className("login-inp"));
        userName.sendKeys("incorrect");

        //4- Enter incorrect password: “incorrect”
        WebElement password = driver.findElement(By.name("USER_PASSWORD"));
        password.sendKeys("incorrect");

        //5- Click to login button.
        driver.findElement(By.className("login-btn")).click();

        //6- Verify error message text is as expected:
        //Expected: Incorrect login or password
        Thread.sleep(3000);
        String expectedText = "Incorrect login or password";
        String actualText = driver.findElement(By.className("errortext")).getText(); //getText() will get the content(text) in between the opening and closing tag

        if (actualText.equals(expectedText)){
            System.out.println("Correct message");
        }else{
            System.out.println("Incorrect message");
        }

        driver.quit();

    }
}
/*
TC #1: NextBaseCRM, locators and getText() practice 1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Enter incorrect username: “incorrect”
4- Enter incorrect password: “incorrect”
5- Click to login button.
6- Verify error message text is as expected:
Expected: Incorrect login or password
 */
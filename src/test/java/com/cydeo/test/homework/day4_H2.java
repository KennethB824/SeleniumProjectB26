package com.cydeo.test.homework;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class day4_H2 {
    public static void main(String[] args) throws InterruptedException {

        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        //3- Enter incorrect username into login box:
        WebElement loginBtn = driver.findElement(By.className("login-inp"));
        loginBtn.sendKeys("abcd");

        //4- Click to `Reset password` button
        driver.findElement(By.cssSelector("button[class='login-btn']")).click();

        Thread.sleep(3000);

        //5- Verify “error” label is as expected
        //Expected: Login or E-mail not found
        String expectedError = "Login or E-mail not found";
        String actualError = driver.findElement(By.cssSelector("div[class='errortext']")).getText();
        if (actualError.equals(expectedError)){
            System.out.println("Correct error message");
        }else{
            System.out.println("Incorrect error message");
        }

        driver.quit();
    }
}
/*
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
3- Enter incorrect username into login box:
4- Click to `Reset password` button
5- Verify “error” label is as expected
Expected: Login or E-mail not found
 */
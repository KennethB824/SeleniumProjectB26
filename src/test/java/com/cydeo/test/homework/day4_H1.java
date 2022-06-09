package com.cydeo.test.homework;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class day4_H1 {
    public static void main(String[] args) {

        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Verify “remember me” label text is as expected:
        //Expected: Remember me on this computer
        String expectedText = "Remember me on this computer";
        String actualText = driver.findElement(By.cssSelector("label[class='login-item-checkbox-label']")).getText();
        if (actualText.equals(expectedText)){
            System.out.println("Correct text");
        }else{
            System.out.println("Incorrect text");
        }

        //4- Verify “forgot password” link text is as expected:
        //Expected: FORGOT YOUR PASSWORD?
        expectedText = "FORGOT YOUR PASSWORD?";
        actualText = driver.findElement(By.cssSelector("a[class='login-link-forgot-pass']")).getText();
        if (actualText.equals(expectedText)){
            System.out.println("Correct text");
        }else{
            System.out.println("Incorrect text");
        }

        //5- Verify “forgot password” href attribute’s value contains expected:
        //Expected: forgot_password=yes
        expectedText = "forgot_password=yes";
        actualText = driver.findElement(By.cssSelector("a[class='login-link-forgot-pass']")).getAttribute("href");
        if (actualText.contains(expectedText)){
            System.out.println("Correct text");
        }else{
            System.out.println("Incorrect text");
        }

        driver.quit();

    }
}
/*
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Verify “remember me” label text is as expected:
Expected: Remember me on this computer
4- Verify “forgot password” link text is as expected:
Expected: Forgot your password?
5- Verify “forgot password” href attribute’s value contains expected:
Expected: forgot_password=yes
 */
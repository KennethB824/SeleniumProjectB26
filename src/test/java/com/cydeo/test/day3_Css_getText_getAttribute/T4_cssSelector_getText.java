package com.cydeo.test.day3_Css_getText_getAttribute;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T4_cssSelector_getText {
    public static void main(String[] args) {

        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        //3- Verify “Reset password” button text is as expected:
        //Expected: Reset password

        WebElement resetBtn = driver.findElement(By.cssSelector("button.login-btn"));
        //using cssSelector with className -> button = TagName   . = AttributeType: class   login-btn = AttributeValue
        //another cssSelector way: driver.findElement(By.cssSelector("button[value = 'Reset password']"));

        String expectedText = "Reset password";
        String actualText = resetBtn.getText();
        if (actualText.equals(expectedText)){
            System.out.println("Correct text");
        }else{
            System.out.println("Incorrect text");
        }

        driver.quit();

    }
}
/*
TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
3- Verify “Reset password” button text is as expected:
Expected: Reset password
 */
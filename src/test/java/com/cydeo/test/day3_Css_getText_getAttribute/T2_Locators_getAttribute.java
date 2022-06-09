package com.cydeo.test.day3_Css_getText_getAttribute;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_Locators_getAttribute {
    public static void main(String[] args) {

        //1- Open a chrome browser
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");

        //3- Verify header text is as expected:
        //Expected: Registration form

        //Using parent to child cssSelector
        //WebElement headerText = driver.findElement(By.cssSelector("div[class='page-header']>h2"));

        WebElement headerText = driver.findElement(By.tagName("h2"));
        String expectedHeader = "Registration form";
        String actualHeader = headerText.getText();
        //String actualHeader = driver.findElement(By.className("page-header")).getText(); - can also do it like this

        if (actualHeader.equals(expectedHeader)){
            System.out.println("Correct header");
        }else{
            System.out.println("Incorrect header");
        }

        //4- Locate “First name” input box
        //5- Verify placeholder attribute’s value is as expected:
        // Expected: first name
        WebElement firstNameInput = driver.findElement(By.name("firstname"));
        String expectedPlaceholder = "first name";

        //getAttribute(attribute argument) method is helping us to get value of attributes
        String actualPlaceholder = firstNameInput.getAttribute("placeholder");
        if (actualHeader.equals(expectedHeader)){
            System.out.println("Correct placeholder");
        }else{
            System.out.println("Incorrect placeholder");
        }

        driver.quit();

    }
}
/*
TC #5: getText() and getAttribute() method practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/registration_form
3- Verify header text is as expected:
Expected: Registration form
4- Locate “First name” input box
5- Verify placeholder attribute’s value is as expected: Expected: first name
 */
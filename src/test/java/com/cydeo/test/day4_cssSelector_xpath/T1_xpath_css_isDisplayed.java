package com.cydeo.test.day4_cssSelector_xpath;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_xpath_css_isDisplayed {
    public static void main(String[] args) {

        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");

        //3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)
        //a. “Home” link
        WebElement homeLink1 = driver.findElement(By.cssSelector("a[class='nav-link']"));

        //a2. Locate using href
        WebElement homeLink2 = driver.findElement(By.cssSelector("a[href='/']"));

        //a3. Locate homeLink using xpath - using text of element
        // "." stands for Text. Home in this scenario would be the actual text.
        WebElement homeLink3 = driver.findElement(By.xpath("//a[.='Home']")); //xpath(text()='Home')

        //a4. Locate homeLink using xpath
        // xpath syntax -> "//tagName[@attribute='attributeValue']"
        WebElement homeLink4 = driver.findElement(By.xpath("//a[@class='nav-link']"));

        //b. “Forgot password” header using cssSelector from parent to child with ">"
        WebElement forgotPassword1 = driver.findElement(By.cssSelector("div[class='example']>h2"));

        //b2. Locate forgot password using xpath
        WebElement forgotPassword2 = driver.findElement(By.xpath("//h2[text()='Forgot Password']"));

        //c. “E-mail” text
        WebElement emailText = driver.findElement(By.cssSelector("label[for='email']"));

        //d. E-mail input box
        WebElement inputBox = driver.findElement(By.cssSelector("input[name='email']"));

        //d2. Email input box using xpath
        WebElement inputBox2 = driver.findElement(By.xpath("//input[@name='email']"));

        //e. “Retrieve password” button using cssSelector syntax2 - the shortcut version
        //tagName#value    - the # stands for class. the value is the value of the class attribute
        WebElement retrieveBtn = driver.findElement(By.cssSelector("button#form_submit"));

        //f. “Powered by Cydeo text
        WebElement cydeoText = driver.findElement(By.cssSelector("div[style='text-align: center;']"));

        //4. Verify all web elements are displayed.
        System.out.println(homeLink1.isDisplayed());
        System.out.println(homeLink2);
        System.out.println(forgotPassword1.isDisplayed());
        System.out.println(emailText.isDisplayed());
        System.out.println(inputBox.isDisplayed());
        System.out.println(retrieveBtn.isDisplayed());
        System.out.println(cydeoText.isDisplayed());

    }
}
/*
TC #1: XPATH and cssSelector Practices
1. Open Chrome browser
2. Go to https://practice.cydeo.com/forgot_password
3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)
a. “Home” link
b. “Forgot password” header
c. “E-mail” text
d. E-mail input box
e. “Retrieve password” button
f. “Powered by Cydeo text
4. Verify all web elements are displayed.
 */
package com.cydeo.test.day6_StaleElement_TestNG;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro {

    @BeforeClass
    public void setUp(){
        System.out.println("Before class is running...");
    }

    @AfterClass
    public void tearDown(){
        System.out.println("After class is running...");
    }

    @BeforeMethod
    public void setUpMethod(){
        System.out.println("Before method is running...");
    }

    @AfterMethod
    public void tearDownMethod(){
        System.out.println("After method is running...");
    }

    @Test (priority = 2)
    public void test1(){
        System.out.println("Test1 is running...");
        String actual = "apple";
        String expected = "apple";

        //asssertEquals(actual, expected, (Optional)"Message will appear only if it fails")
        Assert.assertEquals(actual, expected, "Test did not pass!");
    }

    @Test (priority = 1)
    public void test2(){
        System.out.println("Test2 is running...");
        Assert.assertEquals("orange", "orange", "Test 2 did not pass!");
    }

}

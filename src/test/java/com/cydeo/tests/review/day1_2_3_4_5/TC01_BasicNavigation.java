package com.cydeo.tests.review.day1_2_3_4_5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC01_BasicNavigation {
    // TestNG for annotations and test handling
    WebDriver driver;
        @BeforeMethod
        public void setup(){
            // initialize driver and manage driver
            driver = new ChromeDriver();
        }
        @AfterMethod
        public void teardown(){
            // close driver, take screenshot if test fails etc.
        }

        @Test
        public void NavigationTest(){

        }

        @Test
    public void LoginTest(){

        }


}

package com.cydeo.tests.review.day9_10_11;


import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Old_driver_Version {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        System.out.println("Before method is running");
        // set up chrome and create WebDriver instance
        driver = WebDriverFactory.getDriver("chrome");

        System.out.println("Before method driver " + ((RemoteWebDriver) driver).getSessionId());

        driver.manage().window().maximize();
        //Providing extra time for our driver before it throws NoSuchElementException
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

//    @AfterMethod
//    public void tearDownMethod(){
//        System.out.println("After method is running");
//        driver.close();
//        System.out.println("After method driver " + ((RemoteWebDriver) driver).getSessionId());
//    }


    @Test
    public void googleTitle(){
        driver.get("https://google.com");
        System.out.println("google test driver = " + ((RemoteWebDriver) driver).getSessionId());
    }

    @Test
    public void yahooTitle(){
        driver.get("https://yahoo.com");
        System.out.println("yahoo test driver = " + ((RemoteWebDriver) driver).getSessionId());
    }

    @Test
    public void etsyTitle(){
        driver.get("https://etsy.com");
        System.out.println("etsy test driver = " + ((RemoteWebDriver) driver).getSessionId());
    }


}



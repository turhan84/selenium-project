package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_CydeoVerifications {
    public static void main(String[] args) throws InterruptedException {

        //TC #1: Cydeo practice tool verifications
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to https://practice.cydeo.com
       // driver.get("https://www.cydeo.com");
        driver.navigate().to("https://practice.cydeo.com");

        //3. Verify URL contains
       // System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        String expectedInURL = "cydeo";
        String acturlURL = driver.getCurrentUrl();
        if (acturlURL.contains(expectedInURL)){
            System.out.println("URL verification PASSED!");
        }else {
            System.out.println("URL verification  FAIL!");
        }


        //Expected: cydeo


        //4. Verify title:
//        String currentTitle = driver.getTitle();
//        System.out.println("currentTitle = " + currentTitle);

        //Expected: Practice

        String expectedTitel = "Practice";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitel)){
            System.out.println("Title verification PASSED!");
        }else {
            System.out.println("Title verification FAIL!");
        }

        Thread.sleep(5000);

        if(driver.getTitle().equals("Practice")){
            System.out.println("Pass!");
        }

        //close the browser
        driver.close();

        // stop to program
        driver.quit();

    }
}

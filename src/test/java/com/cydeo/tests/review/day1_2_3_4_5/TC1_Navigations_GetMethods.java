package com.cydeo.tests.review.day1_2_3_4_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TC1_Navigations_GetMethods {

    // TC#1: Navigations and Get methods Practice

    // 1. Open a chrome browser
    // 2. Go to: https://www.etsy.com
    // 3. Navigate to https://www.amazon.com/
    // 4. Navigate back, forward and refresh
    // 5. Write “selenium” in search box
    // 6. Press search button to search
    // 7. Verify title is "Amazon.com : selenium"
    // 8. Verify url contains "selenium"

    public static void main(String[] args) throws InterruptedException {

        // setting up driver browser with WebDriverManager was used in selenium 3 version
        // WebDriverManager.chromedriver().setup();

        // selenium 4 version doesn't need anymore
        // 1. Open a chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2. Go to: https://www.etsy.com
        driver.get("https://www.etsy.com");
        driver.findElement(By.linkText("Registry")).click();
        String expectedURL = "registry";
        String actualURL = driver.getCurrentUrl();

        if(actualURL.contains(expectedURL)){
            System.out.println("URL verification is passed!");
        }else{
            System.out.println("URL verification is failed!");
        }


        Thread.sleep(3000);

        // 3. Navigate to https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com");

        Thread.sleep(3000);

        // 4. Navigate back, forward and refresh
        driver.navigate().back();

        Thread.sleep(3000);

        driver.navigate().forward();

        Thread.sleep(3000);

        driver.navigate().refresh();

        // 5. Write “selenium” in search box
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("selenium");

        // If requirement doesn't say about pressing search button you can use keys class in sendkeys method
        //searchBox.sendKeys("selenium" + Keys.ENTER);

        // 6. Press search button to search
        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();

        // 7. Verify title is "Amazon.com : selenium"
        String expectedTitle = "Amazon.com : selenium";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification is passed!");
        } else {
            System.out.println("Title verification is failed!");
        }


        // 8. Verify url contains "selenium"
        expectedURL = "selenium";
        actualURL = driver.getCurrentUrl();

        if(actualURL.contains(expectedURL)){
            System.out.println("URL verification is passed!");
        }else{
            System.out.println("URL verification is failed!");
        }

        // it will only close current tab/window
        //driver.close();

        // it will close all tabs/windows
        driver.quit();


    }
    }


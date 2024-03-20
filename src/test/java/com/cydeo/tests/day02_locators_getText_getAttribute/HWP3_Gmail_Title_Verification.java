package com.cydeo.tests.day02_locators_getText_getAttribute;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWP3_Gmail_Title_Verification {
    public static void main(String[] args) {
        //TC #3: Back and forth navigation
        //1- Open a chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://google.com
        driver.get("https://google.com");

        // Close pop-up
        WebElement closingButton = driver.findElement(By.id("L2AGLb"));
        closingButton.click();

        //3- Click to Gmail from the top right.

        WebElement gmailButtonLink = driver.findElement(By.linkText("Gmail"));

        gmailButtonLink.click();

        //4- Verify title contains:
        //Expected: Gmail


        String expectedGmailTitle = "Gmail";
        String actualGmailTitle = driver.getTitle();

       // System.out.println(actualTitle);

        if (actualGmailTitle.contains(expectedGmailTitle)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAIL!!!");

        }



        //5- Go back to Google by using the .back();
        driver.navigate().back();

        //6- Verify title equals:
        //Expected: Google

        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAIL!!!");

        }
    }
}

package com.cydeo.tests.review.day1_2_3_4_5;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class TC2_PracticePageLogin {

    // 1. Open Chrome browser
    // 2. Go to https://practice.cydeo.com/login
    // 3. Enter username: "tomsmith"
    // 4. Enter password: "SuperSecretPassword"
    // 5. Click to Login button
    // 6. Verify text displayed on page
    //    Expected: "You logged into a secure area!"

    public static void main(String[] args) {

        // 1. Open Chrome browser
        // 2. Go to https://practice.cydeo.com/login
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://practice.cydeo.com/login");

        // 3. Enter username: "tomsmith"
        WebElement username1 = driver.findElement(By.name("username"));
        WebElement username2 = driver.findElement(By.xpath("//input[@type='text']"));
        WebElement username3 = driver.findElement(By.cssSelector("input[name='username']"));

        username2.sendKeys("tomsmith");

        // 4. Enter password: "SuperSecretPassword"
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("SuperSecretPassword");

        // 5. Click to Login button
        WebElement loginBtn = driver.findElement(By.id("wooden_spoon"));
        loginBtn.click();


        // 6. Verify text displayed on page contains
        //    Expected: "You logged into a secure area!"

        WebElement resultText1 = driver.findElement(By.cssSelector("div#flash"));

        // If text has white-spaces in webelement, you can use normalize-space(text()) method
        WebElement resultText2 = driver.findElement(By.xpath("//div[normalize-space(text())='You logged into a secure area!']"));

        String actualText = resultText1.getText();
        String expectedText = "You logged into a secure area!";

        System.out.println("actualText = " + actualText);

        if(actualText.contains(expectedText)){
            System.out.println("Text verification is passed!");
        }else{
            System.out.println("Text verification is failed!");
        }


    }
}

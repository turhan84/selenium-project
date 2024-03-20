package com.cydeo.tests.day02_locators_getText_getAttribute;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWP4_Class_Locator_Practice {
    public static void main(String[] args) throws InterruptedException {
        //TC #4: Practice Cydeo – Class locator practice
        //1- Open a chrome browser

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://practice.cydeo.com/inputs
        driver.navigate().to("https://practice.cydeo.com/inputs");

        //3- Click to “Home” link

       // WebElement homeButton = driver.findElement(By.linkText("Home"));
       // homeButton.click();

        Thread.sleep(2000);
        //PS: Locate “Home” link using “className” locator
        WebElement homeButton = driver.findElement(By.className("nav-link"));
        homeButton.click();

        //4- Verify title is as expected:
        //Expected: Practice


        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Title verification PASSED!");
        } else {
            System.out.println("Title verification FAIL!!!");

        }


    }
}

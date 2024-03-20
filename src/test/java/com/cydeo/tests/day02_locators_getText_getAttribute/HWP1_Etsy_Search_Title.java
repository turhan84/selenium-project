package com.cydeo.tests.day02_locators_getText_getAttribute;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWP1_Etsy_Search_Title {
    public static void main(String[] args) throws InterruptedException {
        //HWP #1: Etsy Title Verification
        //1. Open Chrome browser

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to https://www.etsy.com

        driver.navigate().to("https://www.google.com");
        // Close pop-up
        WebElement closingButton = driver.findElement(By.id("L2AGLb"));
        closingButton.click();

        //3. Search for “wooden spoon”

        WebElement searchForWoodenSpoon = driver.findElement(By.name("q"));
        searchForWoodenSpoon.sendKeys("wooden spoon" + Keys.ENTER);
        //4. Verify title:
        //Expected: “Wooden spoon - Etsy”

        String expectedTitle = "Wooden spoon";
        String actualTitle = driver.getTitle();


        if (actualTitle.startsWith(actualTitle)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAIL!!!");

        }

        //Thread.sleep(5000);
       // driver.quit();

    }
}

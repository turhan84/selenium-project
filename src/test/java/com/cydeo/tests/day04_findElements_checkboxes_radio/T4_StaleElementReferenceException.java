package com.cydeo.tests.day04_findElements_checkboxes_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T4_StaleElementReferenceException {
    public static void main(String[] args) {
        //TC #4: StaleElementReferenceException Task
        //1- Open a chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- Go to: https://practice.cydeo.com/abtest
        driver.get("https://practice.cydeo.com/abtest");

        //3- Locate “CYDEO” link, verify it is displayed.
        WebElement cydeoLink = driver.findElement(By.xpath("//a[.='CYDEO']"));
        System.out.println("Before refresh: cydeoLink.isDisplayed() = " + cydeoLink.isDisplayed());

        //4- Refresh the page.
        driver.navigate().refresh();
        System.out.println("Refreshing the page...");

        //5- Verify it is displayed, again.
        cydeoLink = driver.findElement(By.xpath("//a[.='CYDEO']"));
        System.out.println("After refresh: cydeoLink.isDisplayed() = " + cydeoLink.isDisplayed());


        //This is a simple StaleElementReferenceException to understand what is
        //this exception and how to handle it.
    }
}

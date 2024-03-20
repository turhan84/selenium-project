package com.cydeo.tests.day05_testNG_intro_dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T2_radio_buttons {
    public static void main(String[] args) throws InterruptedException {
        //TC #2: Radiobutton handling
        //1. Open Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");

        //3. Click to “Hockey” radio button
        Thread.sleep(2000);
        WebElement HockeyRdButton = driver.findElement(By.xpath("//input[@id='hockey']"));
        HockeyRdButton.click();
        //4. Verify “Hockey” radio button is selected after clicking.

        Thread.sleep(2000);

        if (HockeyRdButton.isSelected()){
            System.out.println("Button is selected. Verification PASSED!");
        }else {
            System.out.println("Button is NOT selected. Verification FAILED!");
        }



        //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
    }
}

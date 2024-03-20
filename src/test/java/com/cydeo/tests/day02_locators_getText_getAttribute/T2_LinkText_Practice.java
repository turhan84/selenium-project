package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_LinkText_Practice {
    public static void main(String[] args) throws InterruptedException {
        //TC #2: Back and forth navigation
        //1- Open a Chrome browser

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://practice.cydeo.com

        driver.navigate().to("https://practice.cydeo.com");

        //3- Click to A/B Testing from top of the list.

        //driver.findElement(By.linkText("A/B Testing")).click();

        WebElement abTestLink = driver.findElement(By.linkText("A/B Testing"));
        abTestLink.click();

        Thread.sleep(2000);

        //4- Verify title is:
        //Expected: No A/B Test
        String expectedTitle = "No A/B Test";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED! \" No A/B Test \"");
        }else{
            System.out.println("Title verification FAIL! \" No A/B Test \"");
        }

        //5- Go back to home page by using the .back();

        driver.navigate().back();
        Thread.sleep(2000);

        //6- Verify title equals:
        //Expected: Practice

         expectedTitle = "Practice";
         actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAIL!");
        }


        driver.close();
        driver.quit();
    }
}

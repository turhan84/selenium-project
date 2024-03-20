package com.cydeo.tests.day07_webtables_utilities_javafaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class T1_WindowsHandling {
    //TC #1: Window Handle practice
    //1. Create new test and make set ups
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //2. Go to website: https://www.amazon.com
        driver.get("https://www.amazon.co.uk/");
    }

    @AfterMethod
    public void tearDownMethod(){
       driver.quit();
    }

    @Test
    public void window_handling_test() throws InterruptedException {

        WebElement amazon = driver.findElement(By.xpath("//a[@onclick='window.location.reload()']"));

        Thread.sleep(3000);
        amazon.click();

        WebElement amazond = driver.findElement(By.xpath("//button[@id='sp-cc-rejectall-link']"));
        Thread.sleep(3500);
        amazond.click();



        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");

        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");

        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        for(String each : driver.getWindowHandles()){

            driver.switchTo().window(each);

            if(driver.getTitle().contains("Google")){
                //      decline cookies :
                Thread.sleep(2000);

                driver.findElement(By.xpath("//div[.='Reject all']")).click();;
            }

            if(driver.getTitle().contains("Etys")){
                //      decline cookies :
                Thread.sleep(2000);

                driver.findElement(By.xpath("//button[.='Accept']")).click();;
            }

            if(driver.getTitle().contains("Facebook")) {
                Thread.sleep(2000);
                WebElement declineCookies = driver.findElement(By.xpath("//button[@title='Decline optional cookies']"));
                declineCookies.click();
            }
        }



        //Return and store all window handles in a Set.
        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String each : allWindowHandles) {

            driver.switchTo().window(each);
            System.out.println("Current URL: " + driver.getCurrentUrl());

            if (driver.getCurrentUrl().contains("etsy")){
                break;
            }
        }

        //5. Assert:Title contains “Etsy”
       // String actualTitle = driver.getTitle();
      // String expectedInTitle = "Etsy";

      // Assert.assertTrue(actualTitle.contains(expectedInTitle));
       BrowserUtils.verifyTitleContains(driver, "Etsy");
    }


    }




    //3. Copy paste the lines from below into your class
    //4. Create a logic to switch to the tab where Etsy.com is open
    //5. Assert: Title contains “Etsy”
    //Lines to be pasted:
    //((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
    //((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
    //((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
    //These lines will simply open new tabs using something called JavascriptExecutor
    //and get those pages. We will learn JavascriptExecutor later as well.


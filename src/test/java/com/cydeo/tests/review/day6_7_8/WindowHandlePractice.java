package com.cydeo.tests.review.day6_7_8;

import com.cydeo.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class WindowHandlePractice {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // TC : Windows handle practice
        //    1. Open browser
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void window_handle_test() {
        //    2. Go to website: https://demoqa.com/browser-windows
        driver.get("https://demoqa.com/browser-windows");
        //    3. Click on New Tab button
        BrowserUtils.sleep(2);
        driver.findElement(By.xpath("//p[.='Consent']")).click();
        driver.findElement(By.cssSelector("button#tabButton")).click();

        //    4. Click on New Window button
        driver.findElement(By.xpath("//button[@id='windowButton']")).click();

        //    5. Click on New Window Message button
        driver.findElement(By.xpath("//button[.='New Window Message']")).click();

        //    6. Store parent window handle id in a variable
        String mainWindowID = driver.getWindowHandle();

        //    7. Store all window handle ids in to a Set
        Set<String> allWindows = driver.getWindowHandles();

        //    9. Print out each window title

        for (String eachWindow : allWindows) {
            driver.switchTo().window(eachWindow);
            System.out.println("Window Handle: " + eachWindow);
            System.out.println("Window Title: " + driver.getTitle());
            System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        }
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}













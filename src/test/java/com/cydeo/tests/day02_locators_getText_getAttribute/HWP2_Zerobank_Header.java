package com.cydeo.tests.day02_locators_getText_getAttribute;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWP2_Zerobank_Header {
    public static void main(String[] args) {
        //HWP #2: Zero Bank header verification
        //1. Open Chrome browser
        WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();

        //2. Go to http://zero.webappsecurity.com/login.html
        driver.navigate().to("http://zero.webappsecurity.com/login.html");


        //3. Verify header text
        //Expected: “Log in to ZeroBank”
        WebElement herderText = driver.findElement(By.tagName("h3"));

        String expectedHeader = "Log in to ZeroBank";
        String actualHeader =  herderText.getText();

        if (expectedHeader.equals(actualHeader)){
            System.out.println("Header verification PASSED!");
        }else{
            System.out.println("Header verification FAIL!!!");
        }

    }
}

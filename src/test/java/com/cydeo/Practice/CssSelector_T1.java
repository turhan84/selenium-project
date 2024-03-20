package com.cydeo.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class CssSelector_T1 {
    @Test
    public void Css_Selector_Test(){
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://practice.cydeo.com/");

       driver.findElement(By.cssSelector("li>a[href='/abtest']")).click();



       driver.quit();


    }
}

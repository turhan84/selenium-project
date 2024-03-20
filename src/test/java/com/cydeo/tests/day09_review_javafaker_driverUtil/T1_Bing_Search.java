package com.cydeo.tests.day09_review_javafaker_driverUtil;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_Bing_Search {
    //TC #1: Bing search

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1- Open a chrome browser
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- Go to: https://bing.com

        driver.get(ConfigurationReader.getProperty("bingURL"));

        BrowserUtils.sleep(2);
        BrowserUtils.pupUpClose_ByID("bnp_btn_reject");

       // driver.findElement(By.id("bnp_btn_reject")).click();

    }

    //Use `configuration.properties` for the following:
    //1. The browser type
    //2. The URL
    //3. The search keyword
    //4. Make title verification dynamic. If search value changes, title
    //assertion should not fail.

    @Test
    public void bing_search_test(){
        //3- Write “apple” in search box
        //locate the search box

        WebElement searchBox = driver.findElement(By.xpath("//textarea[@name='q']"));
        searchBox.sendKeys(ConfigurationReader.getProperty("searchValue") + Keys.ENTER);

        //4- Verify title:
        //Expected: apple - Search
        //Expected: flowers - Search
        String actualTitle = driver.getTitle();

        //String expectedTitle = "apple - Search";
        //We are just making the expectedTitle dynamic based on the text we are searching.
        BrowserUtils.sleep(2);
        String expectedTitle = ConfigurationReader.getProperty("searchValue") + " - Search" ;

        Assert.assertTrue(expectedTitle.equals(actualTitle));

    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }




}

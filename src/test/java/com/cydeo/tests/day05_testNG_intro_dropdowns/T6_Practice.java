package com.cydeo.tests.day05_testNG_intro_dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T6_Practice {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        //TC #6: Selecting date on dropdown and verifying
        //1. Open Chrome browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void webLink(){
        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void verifySelected(){
        //3. Select “December 1st, 1933” and verify it is selected.

        //Select year using : visible text
        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
        Select selectYear = new Select(year);
        selectYear.selectByVisibleText("1933");

        //Select day using : index number
        WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
        Select selectDay = new Select(day);
        selectDay.selectByIndex(0);

        //Select month using : value attribute

        WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
        Select selectMonth = new Select(month);
        selectMonth.selectByValue("11");

        String expectedYear = "1933";
        String expectedMonth = "December";
        String expectedDay = "1";

        String actualYear = selectYear.getFirstSelectedOption().getText();
        String actualMonth = selectMonth.getFirstSelectedOption().getText();
        String actualDay = selectDay.getFirstSelectedOption().getText();

        Assert.assertTrue(actualYear.equals(expectedYear));
        Assert.assertEquals(actualMonth,expectedMonth);
        Assert.assertEquals(actualDay,expectedDay);


    }

        @AfterMethod
        public void close(){
        driver.close();
        }

}

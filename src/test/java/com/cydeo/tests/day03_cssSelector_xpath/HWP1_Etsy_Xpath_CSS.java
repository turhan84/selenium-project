package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HWP1_Etsy_Xpath_CSS {
    public static void main(String[] args) {
        //HWP #1: Etsy Title Verification
        //1. Open Chrome browser

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2. Go to https://www.etsy.com

        driver.get("https://www.seslisozluk.net/");

        //3. Search for “wooden spoon”

        WebElement searchSesliSosluk = driver.findElement(By.xpath("//input[@type='search']"));
        searchSesliSosluk.sendKeys("wooden spoon" + Keys.ENTER);

        //4. Verify title:
        //Expected: “Wooden spoon - Etsy”

        String expectedTitle = "Sesli Sözlük - wooden spoon";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("actualTitle = " + actualTitle);
            System.out.println("expectedTitle = " + expectedTitle);
            System.out.println("Title verification is FAILED!!!");

        }




    }
}

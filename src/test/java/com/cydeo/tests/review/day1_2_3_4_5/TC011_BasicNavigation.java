package com.cydeo.tests.review.day1_2_3_4_5;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC011_BasicNavigation {
// TC2 for Login
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://practice.cydeo.com/login");

        // Locate elements and interact

        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("tomsmith");

        WebElement passwordBox = driver.findElement(By.name("password"));
        passwordBox.sendKeys("SuperSecretPassword");

        WebElement button = driver.findElement(By.id("wooden_spoon"));
        button.click();

        String expectedText = "You logged into a secure area!";

        WebElement messageElement = driver.findElement(By.cssSelector("#flash-messages>div"));

        String actualText = messageElement.getText().split(" ")[0];

        System.out.println("expectedText = " + expectedText);
        System.out.println("actualText = " + actualText);

        driver.quit();  // break until 12:10 pm

        if(actualText.contains(expectedText)){
            System.out.println("Test is successful");
        }



    }

}

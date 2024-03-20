package com.cydeo.tests.review.day1_2_3_4_5;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03_RegistrationForm {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("firefox");
        driver.get("https://practice.cydeo.com/registration_form");

        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        driver.findElement(By.name("username")).sendKeys("johnsmith123");
        driver.findElement(By.name("email")).sendKeys("john.smith@email.com");
        driver.findElement(By.name("password")).sendKeys("John1234");
        driver.findElement(By.name("phone")).sendKeys("123-456-7890");


        // 9. Click to "Male" from Gender
        driver.findElement(By.cssSelector(".radio>label>input[value='male']")).click();
        driver.findElement(By.name("birthday")).sendKeys("01/28/1990");

        // how to handle dropdowns with select
        WebElement departmentDropDownElement = driver.findElement(By.name("department"));
        Select departmentMenu = new Select(departmentDropDownElement); // this object comes with ready methods
        departmentMenu.selectByValue("DE");
        System.out.println("departmentMenu.getFirstSelectedOption() = " + departmentMenu.getFirstSelectedOption());

 // short-cut
       new Select(driver.findElement(By.name("job_title"))).selectByVisibleText("QA");

    // java checkbox locator
    driver.findElement(By.id("inlineCheckbox2")).click();

    // click submit
        driver.findElement(By.id("wooden_spoon")).click();

        System.out.println(driver.findElement(By.cssSelector("h4.alert-heading")).getText());

    }

    @Test
    public void RegistrationTest(){
        WebDriver driver = WebDriverFactory.getDriver("firefox");
        driver.get("https://practice.cydeo.com/registration_form");

        // verify title
        Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Registration Form"));

        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        driver.findElement(By.name("username")).sendKeys("johnsmith123");
        driver.findElement(By.name("email")).sendKeys("john.smith@email.com");
        driver.findElement(By.name("password")).sendKeys("John1234");
        driver.findElement(By.name("phone")).sendKeys("123-456-7890");


        // 9. Click to "Male" from Gender
        driver.findElement(By.cssSelector(".radio>label>input[value='male']")).click();
        driver.findElement(By.name("birthday")).sendKeys("01/28/1990");

        // how to handle dropdowns with select
        WebElement departmentDropDownElement = driver.findElement(By.name("department"));
        Select departmentMenu = new Select(departmentDropDownElement); // this object comes with ready methods
        departmentMenu.selectByValue("DE");
        Assert.assertEquals(departmentMenu.getFirstSelectedOption().getText(), "Department of Engineering");


        // short-cut
        new Select(driver.findElement(By.name("job_title"))).selectByVisibleText("QA");

        // java checkbox locator
        driver.findElement(By.id("inlineCheckbox2")).click();

        // click submit
        driver.findElement(By.id("wooden_spoon")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("h4.alert-heading")).getText(),"Well done!");

    }


}

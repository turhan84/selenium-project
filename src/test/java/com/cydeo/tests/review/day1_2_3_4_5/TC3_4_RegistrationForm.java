package com.cydeo.tests.review.day1_2_3_4_5;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC3_4_RegistrationForm {

     WebDriver driver;

     @BeforeMethod
     public void setUp(){
          // 1. Open Chrome browser
          driver = WebDriverFactory.getDriver("chrome");
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

          // 2. Go to https://practice.cydeo.com/registration_form
          driver.get("https://practice.cydeo.com/registration_form");

     }

     @Test
     public void registrationFormPageTest(){
//           // 1. Open Chrome browser
//          WebDriver driver = WebDriverFactory.getDriver("chrome");
//          driver.manage().window().maximize();
//          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//
//          // 2. Go to https://practice.cydeo.com/registration_form
//          driver.get("https://practice.cydeo.com/registration_form");

          // 3. Verify title is as expected:
          // Expected: "Registration Form"

          String expectedTitle = "Registration Form";
          String actualTitle = driver.getTitle();

          //Assert.assertEquals(actualTitle,expectedTitle,"Title verification failed!");
          Assert.assertTrue(actualTitle.equals(expectedTitle),"Title verification failed!");

     }

    @Test
     public void registrationFillingOutTest(){
//         // 1. Open Chrome browser
//         WebDriver driver = WebDriverFactory.getDriver("chrome");
//         driver.manage().window().maximize();
//         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//
//         // 2. Go to https://practice.cydeo.com/registration_form
//         driver.get("https://practice.cydeo.com/registration_form");


         // 3. Enter First name: "John"
         driver.findElement(By.xpath("//input[@placeholder='first name']")).sendKeys("John");

         // 4. Enter Last name: "Smith"
         driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Smith");

         // 5. Enter Username: "johnsmith123"

         // 6. Enter Email address: "john.smith@email.com"
         // 7. Enter password: "John1234"
         // 8. Enter Phone number: "123-456-7890"
         // 9. Click to "Male" from Gender
        WebElement maleRadioBtn = driver.findElement(By.xpath("(//input[@name='gender'])[1]")); // //input[@value='male']
        maleRadioBtn.click();

        Assert.assertTrue(maleRadioBtn.isSelected());

         // 10. Enter Date of birth "01/28/1990"
         // 11. Select "Department of Engineering" from Department/Office dropdown

        // cssSelector --> .form-control.selectpicker if class attribute value has space you have to replace with . because
        // space stand for another class value
        Select selectDepartment = new Select(driver.findElement(By.xpath("//select[@name='department']")));

        System.out.println("Before selection: " + selectDepartment.getFirstSelectedOption().getText());

        // selection by index
       // selectDepartment.selectByIndex(1);

        //selection by value
       // selectDepartment.selectByValue("DE");

        //selection by text of option
        selectDepartment.selectByVisibleText("Department of Engineering");

        System.out.println("After selection: " + selectDepartment.getFirstSelectedOption().getText());


        // 12. Select "SDET" from Job title dropdown
        Select selectJobTitle = new Select(driver.findElement(By.cssSelector("select[name='job_title']")));
        selectJobTitle.selectByVisibleText("SDET");
        System.out.println("selectJobTitle.getFirstSelectedOption().getText() = " + selectJobTitle.getFirstSelectedOption().getText());


        // 13. Click to "Java" from languages
        WebElement javaCheckboxBtn = driver.findElement(By.id("inlineCheckbox2"));
        javaCheckboxBtn.click();

        Assert.assertTrue(javaCheckboxBtn.isSelected());


         // 14. Click to "Sign up" button
         // 15. Verify text displayed on page
         //     Expected: "Well done!"


    }




}

package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T7_Practice {
    //TC #7: Selecting state from State dropdown and verifying result
    //1. Open Chrome browser
    //2. Go to http://practice.cybertekschool.com/dropdown
    //3. Select Illinois
    //4. Select Virginia
    //5. Select California
    //6. Verify final selected option is California.
    //Use all Select options. (visible text, value, index)

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }

    @Test
    public void select_state() throws InterruptedException {
        WebElement stateDropdown = driver.findElement(By.id("state"));
        Select stateSelect = new Select(stateDropdown);
        stateSelect.selectByVisibleText("Illinois");
        Thread.sleep(500);
        stateSelect.selectByValue("VA");
        Thread.sleep(500);
        stateSelect.selectByIndex(5);
        Thread.sleep(500);

        String expectedFinalValue = "California";
        String actualFinalValue = stateSelect.getFirstSelectedOption().getText();


        Assert.assertEquals(actualFinalValue, expectedFinalValue);
        if (actualFinalValue.equals(expectedFinalValue)) {
            System.out.println("State verification PASSED!!");
        } else {
            System.out.println("State verification FAILED!!");
        }
    }
}

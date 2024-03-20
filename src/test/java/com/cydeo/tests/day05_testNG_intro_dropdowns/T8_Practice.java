package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T8_Practice {

    //TC #8: Selecting value from non-select dropdown
    //1. Open Chrome browser
    //2. Go to https://practice.cydeo.com/dropdown
    //3. Click to non-select dropdown
    //4. Select Facebook from dropdown
    //5. Verify title is “Facebook - Log In or Sign Up”

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
    public void select_website() throws InterruptedException {
        WebElement dropdownMenu = driver.findElement(By.id("dropdownMenuLink"));
        dropdownMenu.click();

        WebElement facebookOption = driver.findElement(By.xpath("//a[text()='Facebook']"));
        facebookOption.click();

        //Thread.sleep(100000);
        WebElement declineCookies = driver.findElement(By.xpath("//button[@title='Decline optional cookies']"));
        declineCookies.click();

        String expectedTitle = "Facebook – log in or sign up";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Website title verification PASSED!!");
        } else {
            System.out.println("Website title verification FAILED!!");
        }
    }
}

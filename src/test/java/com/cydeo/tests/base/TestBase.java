package com.cydeo.tests.base;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class TestBase {
    protected WebDriver driver;

    protected Select select;
    protected Actions actions;

    @BeforeMethod
    public void setup() {

        //
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterMethod
    public void tearDownMethod() {
        // without Singleton
       // driver.quit();

        // with using Singleton design pattern
        Driver.closeDriver();
    }
}

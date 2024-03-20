package com.cydeo.tests.day08_properties_config_reader;

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

import java.util.concurrent.TimeUnit;

public class T4_use_config_reader {

    //Use `configuration.properties` for the following:
    //1. The browser type
    //2. The URL
    //3. The search keyword
    //4. Make title verification dynamic. If search value changes, title
    //assertion should not fail.

    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        //1- Open a chrome browser
        String browserType =  ConfigurationReader.getProperty("browser");
        driver = WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2- Go to: https://google.com
        driver.get(ConfigurationReader.getProperty("googleURL"));

        // Close pop-up
       /* WebElement closingButton = driver.findElement(By.id("W0wltc"));
        closingButton.click();*/

        BrowserUtils.pupUpClose_ByID("W0wltc");
    }

    @Test
    public void google_search_test(){

        WebElement searchBox = driver.findElement(By.name("q"));

        //3- Write “apple” in search box
        searchBox.sendKeys("apple" + Keys.ENTER);

        // 4- Verify title:
        //Expected: apple - Google Search
        String expectedTitle = ConfigurationReader.getProperty("searchValue") +" - Google Search";
        BrowserUtils.sleep(2);
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }


}

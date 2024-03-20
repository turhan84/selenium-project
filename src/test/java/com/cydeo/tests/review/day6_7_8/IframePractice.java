package com.cydeo.tests.review.day6_7_8;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class IframePractice {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }


    @Test
    public void iframe_test(){
        // TC : Iframe practice
        // 1. Users are already login and on the homepage of CRM app
        driver.get("https://login1.nextbasecrm.com/");
        CRM_Utilities.login_crm(driver);

        // 2. Users click the MESSAGE tab
//        WebElement messageTab = driver.findElement(By.id("feed-add-post-form-tab-message"));
//        messageTab.click();
        driver.findElement(By.id("feed-add-post-form-tab-message")).click();

        // 3. Users write test message
        // driver.switchTo().frame(0); // index number starts from 0 in frame()

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));

        driver.findElement(By.tagName("body")).sendKeys("something");

        // 4. Users click the SEND button
        //driver.switchTo().parentFrame(); // if there are nested iframes, this will take us to do direct parent frame
        driver.switchTo().defaultContent(); // If you want to go direct main HTML

        driver.findElement(By.id("blog-submit-button-save")).click();

        // 5. Verify the message is displayed on the feed
        WebElement feedMsg = driver.findElement(By.xpath("//div[contains(@id,'blog_post_body')]"));

        BrowserUtils.sleep(3);

        Assert.assertEquals(feedMsg.getText(),"something");

    }


    @AfterMethod
    public void teardown(){
        driver.quit();

    }
}
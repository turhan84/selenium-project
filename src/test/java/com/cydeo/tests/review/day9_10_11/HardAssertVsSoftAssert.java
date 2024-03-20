package com.cydeo.tests.review.day9_10_11;

import com.cydeo.pages.WebDriverWaitPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class HardAssertVsSoftAssert {
    WebDriverWaitPage webDriverWaitPage = new WebDriverWaitPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

    @Test
    public void web_driver_wait_test_hard_assertion() {
        // TC: WebdriverWait practice
        // 1. Go to https://practice.cydeo.com/dynamic_loading/1
        Driver.getDriver().get(ConfigurationReader.getProperty("explicitwait.url"));

        // 2. Click to start
        webDriverWaitPage.startBtn.click();

        // 3. Wait until loading bar disappears
        wait.until(ExpectedConditions.invisibilityOf(webDriverWaitPage.loadingBar));

        // 4. Assert username inputbox is displayed
        Assert.assertTrue(webDriverWaitPage.username.isSelected(), "username is not selected");

        // 5. Enter username: tomsmith
        webDriverWaitPage.username.sendKeys("tomsmith");

        // 6. Enter password: incorrectpassword
        webDriverWaitPage.password.sendKeys("incorrectpassword");

        // 7. Click to Submit button
        webDriverWaitPage.submitBtn.click();

        // 8. Assert “Your password is invalid!” text is displayed.
        Assert.assertTrue(webDriverWaitPage.errorMsg.isSelected(), "text is not selected");

    }


    @Test
    public void web_driver_wait_test_soft_assertion() {
        // TC: WebdriverWait practice
        // 1. Go to https://practice.cydeo.com/dynamic_loading/1
        Driver.getDriver().get(ConfigurationReader.getProperty("explicitwait.url"));

        // 2. Click to start
        webDriverWaitPage.startBtn.click();

        // 3. Wait until loading bar disappears
        wait.until(ExpectedConditions.invisibilityOf(webDriverWaitPage.loadingBar));

        // 4. Assert username inputbox is displayed
        // Assert.assertTrue(webDriverWaitPage.username.isDisplayed());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(webDriverWaitPage.username.isSelected(), "username is not selected");

        // 5. Enter username: tomsmith
        webDriverWaitPage.username.sendKeys("tomsmith");

        // 6. Enter password: incorrectpassword
        webDriverWaitPage.password.sendKeys("incorrectpassword");

        // 7. Click to Submit button
        webDriverWaitPage.submitBtn.click();

        // 8. Assert “Your password is invalid!” text is displayed.
        //  Assert.assertTrue(webDriverWaitPage.errorMsg.isDisplayed());
        softAssert.assertTrue(webDriverWaitPage.errorMsg.isSelected(), "text is not selected");

        softAssert.assertAll();
    }
}

package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class T3_Actions_Hover {

    @Test
    public void hovering_test(){
        //TC #3: Hover Test
        //1. Go to https://practice.cydeo.com/hovers
        Driver.getDriver().get("https://practice.cydeo.com/hovers");
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //Locate all the images here
        WebElement image1 = Driver.getDriver().findElement(By.xpath("(//img)[1]"));
        WebElement image2 = Driver.getDriver().findElement(By.xpath("(//img)[2]"));
        WebElement image3 = Driver.getDriver().findElement(By.xpath("(//img)[3]"));

        //Locate all the "user" headers here
        WebElement user1 = Driver.getDriver().findElement(By.xpath("//h5[text()='name: user1']"));
        WebElement user2 = Driver.getDriver().findElement(By.xpath("//h5[text()='name: user2']"));
        WebElement user3 = Driver.getDriver().findElement(By.xpath("//h5[text()='name: user3']"));


        //To be able to hover on images, we need to create Actions class object,
        //and pass 'driver' in the constructor

        Actions actions = new Actions(Driver.getDriver());

        //2. Hover over to first image
        BrowserUtils.sleep(2);
        actions.moveToElement(image1).perform();

        //3. Assert:
        //a. “name: user1” is displayed
        Assert.assertTrue(user1.isDisplayed());
        System.out.println("user1.getText() = " + user1.getText());

        //4. Hover over to second image
        BrowserUtils.sleep(2);
        actions.moveToElement(image2).perform();

        //5. Assert:
        //a. “name: user2” is displayed
        Assert.assertTrue(user2.isDisplayed());
        System.out.println("user2.getText() = " + user2.getText());

        //6. Hover over to third image
        BrowserUtils.sleep(2);
        actions.moveToElement(image3).perform();

        //7. Confirm:
        //a. “name: user3” is displayed
        Assert.assertTrue(user3.isDisplayed());
        System.out.println("user3.getText() = " + user3.getText());

        Driver.closeDriver();

    }

}

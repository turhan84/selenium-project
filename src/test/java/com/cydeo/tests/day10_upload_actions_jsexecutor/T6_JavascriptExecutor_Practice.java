package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class T6_JavascriptExecutor_Practice {
    @Test
    public void infinite_scroll_test_using_JSExecutor() {

        //TC #6: Scroll using JavascriptExecutor
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/infinite_scroll
        Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll");

        //((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(0,-750)");

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        BrowserUtils.sleep(2);

        //window.scrollBy(x,y)

        //3- Use below JavaScript method and scroll
        //a. 750 pixels down 10 times.
        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,750)");
        }

        //b. 750 pixels up 10 times
        //JavaScript method to use : window.scrollBy(0,0)
        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,-750)");
        }
    }

    @Test
    public void infinite_scroll_test_using_JSExecutor_2() {
        //TC #7: Scroll using JavascriptExecutor
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/large
        Driver.getDriver().get("https://practice.cydeo.com/large");

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        BrowserUtils.sleep(2);


        // Locate the elements for "Cydeo" and "Home" links
        WebElement cydeoLink = Driver.getDriver().findElement(By.xpath("//a[.='CYDEO']"));

        WebElement homeLink = Driver.getDriver().findElement(By.xpath("//a[.='Home']"));

        //3- Scroll down to “Cydeo” link
        // Scroll down to “Cydeo” link
        js.executeScript("arguments[0].scrollIntoView(true);", cydeoLink);
        BrowserUtils.sleep(2);  // Optional: Wait for the scroll effect

        //4- Scroll up to “Home” link
        // Scroll up to “Home” link
        js.executeScript("arguments[0].scrollIntoView(true);", homeLink);
        BrowserUtils.sleep(2);  // Optional: Wait for the scroll effect

        //5- Use below provided JS method only
        //JavaScript method to use : arguments[0].scrollIntoView(true)
        //Note: You need to locate the links as web elements and pass them as
        //arguments into executeScript() method
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

}

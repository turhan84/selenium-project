package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HWP2_Zerobank_XPATH_CSS {
    public static void main(String[] args) {
        //HWP #2: Zero Bank header verification
        //1. Open Chrome browser

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2. Go to http://zero.webappsecurity.com/login.html

        driver.get("http://zero.webappsecurity.com/login.html");

        //3. Verify header text
        //Expected: “Log in to ZeroBank”

        String expectedHeaderText = "Log in to ZeroBank";

        WebElement headerTitle = driver.findElement(By.xpath("//div[@class=\'page-header\']"));

       String actualheaderTitleText =  headerTitle.getText();

        if (expectedHeaderText.equals(actualheaderTitleText)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("actualTitle = " + actualheaderTitleText);
            System.out.println("expectedTitle = " + expectedHeaderText);
            System.out.println("Title verification is FAILED!!!");

        }
    }
}

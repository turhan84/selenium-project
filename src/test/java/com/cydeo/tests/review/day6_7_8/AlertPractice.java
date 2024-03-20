package com.cydeo.tests.review.day6_7_8;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertPractice {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        // TC : Alert practice
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // 2. Go to website: https://practice.cydeo.com/javascript_alerts
        driver.get("https://practice.cydeo.com/javascript_alerts");
    }

    @Test
    public void alert_test(){

/*        public void alert_test() throws InterruptedException {
            // TC : Alert practice
            // 1. Open browser
            // WebDriverManager.chromedriver().setup(); // We have to use in selenium 3
            WebDriver driver = new ChromeDriver(); // Selenium 4 is already including Webdrivermanager automatically
            // That is why we don't need to setup webdrivermanager
            driver.manage().window().maximize();

            // it is going to give time whenever app. need time for looking/findElement element
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 */



        // 3. Click to “Click for JS Prompt” button

        WebElement JSPromptButton = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        JSPromptButton.click();

        // 4. Send “hello” text to alert

        Alert alert = driver.switchTo().alert();
        System.out.println("alert.getText() = " + alert.getText());

        alert.sendKeys("hello");

        // 5. Click to OK button from the alert
        alert.accept();
        // 6. Verify “You entered: hello” text is displayed.

        WebElement resultText =  driver.findElement(By.xpath("//p[@id='result']")); //cssSelector("p#result")
        String actualText = resultText.getText();
        String expectedText = "You entered: hello";

        Assert.assertEquals(actualText,expectedText,"Text verification FAILED!");
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }
}

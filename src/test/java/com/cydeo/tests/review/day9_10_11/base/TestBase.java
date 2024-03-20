package com.cydeo.tests.review.day9_10_11.base;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestBase {
    protected WebDriver driver;

    protected Select select;
    protected Actions actions = new Actions(Driver.getDriver());

    @BeforeMethod
    public void setup() {

        //you will not use below 3 lines of code in Singleton
      //  driver = new ChromeDriver();
      //  driver.manage().window().maximize();
      //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Driver.getDriver().get("https://demo.guru99.com/test/drag_drop.html");

        //Pupup close
        BrowserUtils.sleep(2);

        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//iframe[@id='gdpr-consent-notice']")));

        // BrowserUtils.pupUpClose_ByXpath(driver, "//span[text()='Reject All']");
        //  BrowserUtils.pupUpClose_ByXpath(driver, "//span[text()='Reject']");
        Driver.getDriver().findElement(By.xpath("//span[text()='Reject All']")).click();
        Driver.getDriver().findElement(By.xpath("//span[text()='Reject']")).click();
        Driver.getDriver().switchTo().defaultContent();



    }

    @AfterMethod
    public void tearDownMethod() {
        // without Singleton
       // driver.quit();

        // with using Singleton design pattern
        Driver.closeDriver();
    }
}

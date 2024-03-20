package com.cydeo.tests.review.day9_10_11;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Guru99UploadTest extends TestBase {

    @Test
    public void guru99_upload_test() {

        // TC: Guru99 Upload Test
        //1. Go to  “https://demo.guru99.com/test/upload”
        driver.get("https://demo.guru99.com/test/upload");

        //Pupup close
        BrowserUtils.sleep(2);

        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//iframe[@id='gdpr-consent-notice']")));

       // BrowserUtils.pupUpClose_ByXpath(driver, "//span[text()='Reject All']");
      //  BrowserUtils.pupUpClose_ByXpath(driver, "//span[text()='Reject']");
        Driver.getDriver().findElement(By.xpath("//span[text()='Reject All']")).click();
        Driver.getDriver().findElement(By.xpath("//span[text()='Reject']")).click();
        Driver.getDriver().switchTo().defaultContent();


        //2. Upload file into Choose File

        WebElement choooseFile = Driver.getDriver().findElement(By.id("uploadfile_0"));
        choooseFile.sendKeys("C:/Users/turha/Desktop/New Text Document.txt");

        //3. Click terms of service check box
        driver.findElement(By.cssSelector("input#terms")).click();

        //4. Click Submit File button
        driver.findElement(By.cssSelector("button.btn.buttoncolor.has-spinner")).click();


        //5. Verify expected message appeared.
        // Expected: “1 file
        // has been successfully uploaded.

        WebElement resultMsg = driver.findElement(By.xpath("//h3[@id='res']/center"));

        BrowserUtils.sleep(3);

        System.out.println("resultMsg = " + resultMsg.getText());

        String actualText = resultMsg.getText();
        String expectedText = "1 file\nhas been successfully uploaded.";

        Assert.assertEquals(actualText,expectedText);


    }
}

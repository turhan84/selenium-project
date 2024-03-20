package com.cydeo.tests.review.day9_10_11;

import com.cydeo.tests.review.day9_10_11.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DragAndDropTest extends TestBase {
    @Test
    public void drag_and_drop_test() {

        // TC: Guru99 Drag and Drop Test
        // 1- Open a chrome browser
        // 2- Go to: https://demo.guru99.com/test/drag_drop.html
        // 3- Drag “BANK” and drop into Account area under Debit Side
        WebElement bank = Driver.getDriver().findElement(By.linkText("BANK"));
        WebElement acount = Driver.getDriver().findElement(By.id("bank"));
        //actions = new Actions(Driver.getDriver()); // in TestBase now
        actions.dragAndDrop(bank,acount).perform();


        // 4- Drag “5000” and drop into Amount area under Debit Side

        WebElement fiveK = Driver.getDriver().findElement(By.linkText("5000"));
        WebElement amount = Driver.getDriver().findElement(By.id("amt7"));
        actions.dragAndDrop(fiveK,amount).perform();
        BrowserUtils.sleep(5);
    }

}

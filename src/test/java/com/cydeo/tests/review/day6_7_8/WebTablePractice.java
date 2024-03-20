package com.cydeo.tests.review.day6_7_8;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablePractice extends TestBase {

    @Test
    public void web_table_test(){
        // TC : Web table practice
        // 1. Open Chrome browser
        // 2. Go to https://practice.cydeo.com/tables
        driver.get("https://practice.cydeo.com/tables");

        // 3. Print table data as a single String, not so common, but useful sometimes
        WebElement table1 = driver.findElement(By.id("table1"));
        System.out.println("table1.getText() = " + table1.getText());

        // 4. verify tconway@earthlink.net is anywhere in the table
        Assert.assertTrue(table1.getText().contains("tconway@earthlink.net"),"tconway@earthlink.net is not in table1");

        // 5. print all column names in single line
        WebElement allColNames = driver.findElement(By.xpath("//table[@id='table1']/thead/tr"));
        System.out.println("allColNames.getText() = " + allColNames.getText());


        // 6. print each column name in separate lines using a loop and findElements method
        List<WebElement> colNamesList = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));


        for(WebElement each : colNamesList){
            System.out.println("each.getText() = " + each.getText());
        }


        tearDownMethod();


        // How to handle any specific date in table
        // first, we are going to determine and locate unique data
        // second, we will use /preceding-sibling::td or /following-sibling::td to reach element

        // We are reaching here money due for Tim using email of Tim
        //table[@id='table1']//td[.='tconway@earthlink.net']/following-sibling::td[1]

        //table[@id='table1']//td[.='tconway@earthlink.net']/../td[4]



    }

}

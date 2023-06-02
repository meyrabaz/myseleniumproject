package com.myfirstproject;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.myfirstproject.utilities.TestBase;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Day10_ExtentReports extends TestBase {

    /*
    -What is extent report?
    Extent Report is a library to generate automation reports
     */
    @Test
    public void extentReportTests1(){

        String text = "selenium";
        if(text.contains("e")){
            extentTest.pass("PASSED : "+text+ " CONTAINS e");
        }else{
            extentTest.fail("FAILED : "+text+ " DOESN'T CONTAINS THAT LETTER");
        }

//        pass is used in the lines we are expecting to pass. this is use a lot
        extentTest.pass("PASSED");
//        fail is used in the lines we are expecting to fail such as else condition above
        extentTest.fail("FAILED");

        extentTest.info("INFO");
        extentTest.skip("SKIP");
        extentTest.warning("WARNING");

    }

    @Test
    public void extentReportsTest() throws IOException, InterruptedException {

//        Given user is on https://testcenter.techproeducation.com/index.php?page=autocomplete
        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");

//        When user type “uni” in the search box
        extentTest.pass("Taking the screenshot of the home page");
//        TAKE SCREENSHOT
        takeScreenshotOfTheEntirePage();

        driver.findElement(By.id("myCountry")).sendKeys("uni");
        Thread.sleep(2000);

//        And select the ‘United Kingdom’ from the suggestions
        extentTest.pass("Selecting the United Kingdom option");
//        TAKE SCREENSHOT
        takeScreenshotOfTheEntirePage();
//        TAKING SCREENSHOT OF ONLY UNITED KINGDOM ELEMENT
        takeScreenshotOfThisElement( driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//*[.='United Kingdom']")));

        driver
                .findElement(By.xpath("//div[@id='myCountryautocomplete-list']//*[.='United Kingdom']"))
                .click();
        Thread.sleep(2000);

//        And click on submit button
        extentTest.pass("Clicking on the submit button");
//        TAKE SCREENSHOT
        takeScreenshotOfTheEntirePage();
        driver.findElement(By.xpath("//input[@type='button']")).click();
        Thread.sleep(2000);

//        TAKE SCREENSHOT
        takeScreenshotOfTheEntirePage();
//        TAKING THE SCREENSHOT OF THE RESULT ELEMENT
        extentTest.pass("Taking the screenshot of result element");
        WebElement result = driver.findElement(By.id("result"));
        takeScreenshotOfThisElement(result);

//        Then verify the result contains ‘United Kingdom’
        extentTest.pass("Asserting the result contains United Kingdom");
        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("United Kingdom"));

    }
}
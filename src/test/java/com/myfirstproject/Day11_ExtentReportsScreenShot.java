package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Day11_ExtentReportsScreenShot extends TestBase {
    /*
    So for we can capture screenshot of the entire page and save under test output folder
    So far we can capture the screenshot of specific elements and save under test output folder
    NOW WE WILL ATTACH SOME SCREENSHOTS ON THE EXTENT REPORTS
     */

    @Test
    public void extentReportsScreenShot() throws IOException, InterruptedException {

//        Given user is on https://testcenter.techproeducation.com/index.php?page=autocomplete
        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");

//        When user type “uni” in the search box
        extentTest
                .pass("Taking the screenshot of the home page")
                .assignDevice("Mac","Chrome")
                .assignCategory("Smoke","Regression","Integration")
                .assignAuthor("Meyra")
                .addScreenCaptureFromPath(takeScreenshotOfTheEntirePageAsString());
//        TAKE SCREENSHOT
        takeScreenshotOfTheEntirePage();

        driver.findElement(By.id("myCountry")).sendKeys("uni");
        Thread.sleep(2000);

//        And select the ‘United Kingdom’ from the suggestions
        extentTest
                .pass("Selecting the United Kingdom option")
                .addScreenCaptureFromPath(takeScreenshotOfTheEntirePageAsString());
//        TAKE SCREENSHOT
        takeScreenshotOfTheEntirePage();
//        TAKING SCREENSHOT OF ONLY UNITED KINGDOM ELEMENT
        takeScreenshotOfThisElement( driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//*[.='United Kingdom']")));

        driver
                .findElement(By.xpath("//div[@id='myCountryautocomplete-list']//*[.='United Kingdom']"))
                .click();
        Thread.sleep(2000);

//        And click on submit button
        extentTest
                .pass("Clicking on the submit button")
                .addScreenCaptureFromPath(takeScreenshotOfTheEntirePageAsString());
//        TAKE SCREENSHOT
        takeScreenshotOfTheEntirePage();
        driver.findElement(By.xpath("//input[@type='button']")).click();
        Thread.sleep(2000);

//        TAKE SCREENSHOT
        takeScreenshotOfTheEntirePage();
//        TAKING THE SCREENSHOT OF THE RESULT ELEMENT
        extentTest
                .pass("Taking the screenshot of result element")
                .addScreenCaptureFromPath(takeScreenshotOfTheEntirePageAsString());
        WebElement result = driver.findElement(By.id("result"));
        takeScreenshotOfThisElement(result);

//        Then verify the result contains ‘United Kingdom’
        extentTest
                .pass("Asserting the result contains United Kingdom")
                .addScreenCaptureFromPath(takeScreenshotOfTheEntirePageAsString());
        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("United Kingdom"));


    }

}
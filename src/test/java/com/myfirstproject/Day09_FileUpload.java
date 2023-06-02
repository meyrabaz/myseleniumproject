package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day09_FileUpload extends TestBase {

    @Test
    public void fileUploadTest(){

//        When user goes to https://the-internet.herokuapp.com/upload
        driver.get("https://the-internet.herokuapp.com/upload");

//        When user selects an image from the desktop
//        to upload a file to this type of element, we should send the path of the file to the input
//        element is TAG = INPUT , TYPE = FILE
//        locate to choose a file element, get the path of the file, then use send keys function
        WebElement choseAFile = driver.findElement(By.id("file-upload"));

        String pathOfFlower = System.getProperty("user.home")+"/Desktop/flower.jpeg";

        choseAFile.sendKeys(pathOfFlower);

//        And click on the upload button
        driver.findElement(By.id("file-submit")).click();

//        Then verify the File Uploaded!  Message displayed
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']//h3")).isDisplayed());

    }
}
package com.exercise;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class Task11 extends TestBase {

    //Task 11:
    /*
Given
   Go to https://testpages.herokuapp.com/
When
   Click on File Downloads
And
   Click on Server Download
Then
   Verify that file is downloaded
*/


    @Test

    public void task11 (){

        driver.get("https://testpages.herokuapp.com/");

        driver.findElement(By.id("download")).click();

        waitFor(1);

        driver.findElement(By.id("server-download")).click();


    //    Assert.assertEquals(By.tagName("https://testpages.herokuapp.com/styled/download/download.html"),By.tagName(driver.getCurrentUrl()));

        String filePath = System.getProperty("user.home")+"/Downloads/textfile.txt";
        waitFor(2);
        Assert.assertTrue(Files.exists(Paths.get(filePath)));


    }


}

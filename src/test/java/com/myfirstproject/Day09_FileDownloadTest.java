package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day09_FileDownloadTest extends TestBase {
    /*
    We use send keys functions files if the html is INPUT TYPE = FILE
    If other elements is used to upload files, then we can ROBOT class in JAVA
     */

    @Test
    public void downloadTest() throws InterruptedException {

//        https://testcenter.techproeducation.com/index.php?page=file-download
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

//        Download b10 all test cases, code.docx  file
        driver.findElement(By.partialLinkText("b10 all test cases")).click();
        Thread.sleep(2000);//wait until the file is download COMPLETELY

//        Then verify if the file downloaded successfully
        String filePath = System.getProperty("user.home")+"/Downloads/b10 all test cases, code.docx";
        Assert.assertTrue(Files.exists(Paths.get(filePath)));

    }
}

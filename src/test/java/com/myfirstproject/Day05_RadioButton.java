package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class Day05_RadioButton extends TestBase {
    /*
    Go to https://testcenter.techproeducation.com/index.php?page=radio-buttons
    Click on Red
    Click on Football
    */
    @Test
    public void radioButtonTest() throws InterruptedException {
//        Go to https://testcenter.techproeducation.com/index.php?page=radio-buttons
        driver.get("https://testcenter.techproeducation.com/index.php?page=radio-buttons");

//        Click on Red
        WebElement red = driver.findElement(By.id("red"));
        Thread.sleep(3000);
        red.click();
        assertTrue(red.isSelected());

//        Click on Football
        WebElement football = driver.findElement(By.id("football"));
        Thread.sleep(3000);
        football.click();
        assertTrue(football.isSelected());

    }
}











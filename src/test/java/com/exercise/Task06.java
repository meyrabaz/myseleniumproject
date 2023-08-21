package com.exercise;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Task06 extends TestBase {


    //Task06:

     /*
    Go to http://szimek.github.io/signature_pad/
    Draw the line or shape you want on the screen
    Press the clear button after drawing
    Close the page
     */



    @Test
    public void name() throws InterruptedException {
        driver.get("http://szimek.github.io/signature_pad/");
        WebElement board = driver.findElement(By.xpath("//canvas"));
        Actions actions = new Actions(driver).clickAndHold(board);

        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(-5,-5);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(0,5);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(5,0);
        }
        actions.release().build().perform();

        driver.findElement(By.xpath("//*[text()='Clear']")).click();

    }

}
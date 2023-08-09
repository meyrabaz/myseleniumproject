package com.exercise;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.myfirstproject.utilities.ReusableMethodsUtils.clickByJS;
import static org.apache.commons.io.FileUtils.waitFor;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Task04 extends TestBase {

    /*
    -Go to http://demo.automationtesting.in/Alerts.html

    -Click the button "click the button to display an alert box:" opposite "Alert with OK"

    -Print the text on the alert to the console and click the "OK" button.

    -Click the "Alert with OK & Cancel" button and then click the "Click the button to display a confirm box"

    -Press the "cancel" button in the alert

    -Assert "You Pressed Cancel" text is displayed

    -Click the "Alert with Textbox" button and then click the "Click the button to demonstrate the prompt box"

    -Write your 'name' in the prompt box and click "OK"

    -Print the message to console

    -Verify that the message is 'Hello <your name> How are you today'
    */
    @Test
    public void test(){

//        -Go to http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");

//        -Click the button "click the button to display an alert box:" opposite "Alert with OK"
        WebElement click = driver.findElement(By.xpath("//button[@onclick='alertbox()']"));
        clickByJS(click);

//        -Print the text on the alert to the console and click the "OK" button.
        String alert = driver.switchTo().alert().getText();
        System.out.println("alert = " + alert);
        driver.switchTo().alert().accept();

//         -Click the "Alert with OK & Cancel" button and then click the "Click the button to display a confirm box"
        waitFor(1);
        WebElement alertWithOk = driver.findElement(By.xpath("//a[@href='#CancelTab']"));
        clickByJS(alertWithOk);

        waitFor(1);
        WebElement click2 = driver.findElement(By.xpath("//button[@onclick='confirmbox()']"));
        clickByJS(click2);

//         -Press the "cancel" button in the alert
        waitFor(1);
        driver.switchTo().alert().dismiss();

//         -Assert "You Pressed Cancel" text is displayed
        waitFor(1);
        String cancel = driver.findElement(By.xpath("//p[@id='demo']")).getText();
        //System.out.println("cancel = " + cancel);
        assertEquals("You Pressed Cancel", cancel);

//         -Click the "Alert with Textbox" button and then click the "Click the button to demonstrate the prompt box"
        waitFor(1);
        WebElement click3 = driver.findElement(By.xpath("//a[@href='#Textbox']"));
        clickByJS(click3);

        waitFor(1);
        driver.findElement(By.xpath("//button[@onclick='promptbox()']")).click();

//          -Write your 'name' in the prompt box and click "OK"
        driver.switchTo().alert().sendKeys("Brad Pit");
        driver.switchTo().alert().accept();

//          -Print the message to console
        String message = driver.findElement(By.xpath("//p[@id='demo1']")).getText();
        System.out.println("message = " + message);

//         -Verify that the message is 'Hello <your name> How are you today'
        assertTrue(message.contains("How are you today"));



    }

}

package com.myfirstproject;

import com.myfirstproject.utilities.LoggerUtils;
import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;

public class Day08_Actions1 extends TestBase {
    /*
    Given go to https://testcenter.techproeducation.com/index.php?page=context-menu
    When use right-click on the box
    Then verify the alert message is "You selected a context menu"
    And accept the alert
     */

    @Test
    public void contextClickTest() {
        LoggerUtils.info("Going to the page");
//        Given go to https://testcenter.techproeducation.com/index.php?page=context-menu
        driver.get("https://testcenter.techproeducation.com/index.php?page=context-menu");

//        When use right-click on the box
        LoggerUtils.info("Right clicking the box");
        WebElement box = driver.findElement(By.id("hot-spot"));
        //To right-click on the box we need to use "actions class"

        //Create actions object
        Actions actions = new Actions(driver);

        //Use contextClick() method with web element inside it. And DO NOT forget to use PERFORM() method at the end.
        actions.contextClick(box).perform();

//        Then verify the alert message is "You selected a context menu"
        LoggerUtils.info("Getting alert message");
        String alertMessage = driver.switchTo().alert().getText();
        assertEquals("You selected a context menu", alertMessage);

//        And accept the alert
        driver.switchTo().alert().accept();
        LoggerUtils.info("Test is success!!!");

    }
}
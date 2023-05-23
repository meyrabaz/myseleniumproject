package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Set;

public class Day07_WindowHandle1 extends TestBase {

    @Test
    public void windowHandleTest() throws InterruptedException {

//    Given user is on the https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");

//    Then user verifies the text : "Opening a new window"
        String page1HeaderText = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window",page1HeaderText);

//    Then user verifies the title of the page is "The Internet"
        Assert.assertEquals("The Internet",driver.getTitle());

//    When user clicks on the "Click Here" button
        driver.findElement(By.xpath("//a[.='Click Here']")).click();

//    LET'S GET WINDOW HANDLE 1 FIRST CAUSE WE MAY NEED TO SWITCH BACK TO WINDOW 1
        String window1Handle = driver.getWindowHandle();
        System.out.println(window1Handle);

//    DRIVER IS STILL ON WINDOW 1
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles);
        for(String eachHandle : allWindowHandles){   // ??
            if(!eachHandle.equals(window1Handle)){//if we are not on window1, then we MUST BE on window2, then switch
                driver.switchTo().window(eachHandle);
                break;
            }
        }
        Thread.sleep(5000);

//    Then user verifies the new window 2 title is "New Window"
//      System.out.println("Current Window Title = " + driver.getTitle());
        Assert.assertEquals("New Window",driver.getTitle());

//    Then user verifies the text: "New Window"
        Assert.assertEquals("New Window",driver.findElement(By.xpath("//h3[.='New Window']")).getText());

//    DRIVER IS ON 2ND WINDOW AS OF NOW
        String window2Handle = driver.getWindowHandle();//We can use this window 2 id if we want to switch back to this window

//    When user goes back to the previous window(window1) and then verifies the title : "The Internet"
        driver.switchTo().window(window1Handle);//switching to window 1
        Assert.assertEquals("The Internet",driver.getTitle());
        Thread.sleep(5000);

//    SWITCH BACK TO WINDOW 2
        driver.switchTo().window(window2Handle);
        Thread.sleep(5000);

//    SWITCH BACK TO WINDOW 1
        driver.switchTo().window(window1Handle);
        Thread.sleep(5000);

//    SWITCH BACK TO WINDOW 2
        driver.switchTo().window(window2Handle);
        Thread.sleep(5000);



    }
}
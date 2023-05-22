package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Day06_Iframe extends TestBase {
    //     https://testcenter.techproeducation.com/index.php?page=iframe
//     click on the Back to TechProEducation.com
    @Test
    public void iframeTest() throws InterruptedException {
//      going to the page
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");
//      the element is INSIDE THE IFRAME SO SWITCH THE FRAME FIRST
        /*
        NOTE: I have to switch to the frame otherwise I will get "no such element exception" when
        I try to locate button
        When I switch to the frame I will locate the element and will not get "no such element exception"
        */
//      There are 3 ways to switch to iframe: by index,id/class or webelement
//      driver.switchTo().frame(0);//1.switching to the first frame by index
//      driver.switchTo().frame("ID OR NAME ATTRIBUTE");//2.if there is an id or name of the iframe we can use them
        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@src='/index.php']"));
        driver.switchTo().frame(iframeElement);//3. switching the frame by locating the frame.
        Thread.sleep(2000);

//      AT THIS POINT DRIVER IS INSIDE THE FRAME

//      locating the element inside the frame and trying to click
        WebElement techProLink = driver.findElement(By.xpath("//a[@type='button']"));
        Thread.sleep(2000);

//      NOTE: NORMAL CLICK DIDN'T WORK I USED JS EXECUTOR YOU WILL LEARN THIS LATER
//      element.click(); UNFORTUNATELY DIDN'T WORK

//      JavascriptExecutor js = (JavascriptExecutor)driver;
//      js.executeScript("arguments[0].click();", techProLink);
        techProLink.sendKeys(Keys.ENTER);

//      Assert if h3 element's text is equal to "iframe"
//      STILL INSIDE THE FRAME. DRIVER MUST SWITCH BACK TO PARENT FRAME OF DEFAULT CONTENT BECAUSE THE ELEMENT IS NOT IN THE FRAME
//      driver.switchTo().parentFrame();//This will take driver one step back to parent page.
        driver.switchTo().defaultContent();//alternatively we can switch to default page
        String h3Text =  driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("iframe",h3Text);










    }

}
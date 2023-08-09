package com.exercise;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

public class Task02 extends TestBase {
    //Task02:
    /*
    Create and Maximize the driver with the BeforeClass method and put implicit wait for 15 seconds
    Go to http://www.google.com in the before method
    With 3 different test methods:
     -Type "Desktop" in the search box and print the number of results
     -Type "Smartphone" in the search box and print the number of results
     -Type "Laptop" in the search box and print the number of results
    NOTE: Print the result numbers in After method
    Close driver with AfterClass method
     */
    @Test
    public void task02(){

        driver.get("http://www.google.com");
        driver.findElement(By.id("APjFqb")).sendKeys("Desktop");
        driver.findElement(By.xpath("(//input[@class='gNO89b'])[1]")).click();
        System.out.println(driver.findElement(By.xpath("//div[@id='result-stats']")).getText());



    }
}
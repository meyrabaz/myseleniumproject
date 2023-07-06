package com.myfirstproject;
import com.myfirstproject.utilities.LoggerUtils;
import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import java.io.IOException;
public class Day16_ReusableMethods extends TestBase {
    //    And click on Create Account
//    Then verify the account creating is successful. Account Created! Element is displayed
//    GOAL: Use Reusable Methods only.
    @Test
    public void registerUserTest() throws IOException {
        //    When user goes to https://www.automationexercise.com/
        LoggerUtils.info("starting the test case....");
        openURL("https://www.automationexercise.com/");
        extentTest
                .pass("navigating the sign up page")
                .addScreenCaptureFromPath(takeScreenshotOfTheEntirePageAsString());
        //    And click on Sing up link
//        driver.findElement(By.partialLinkText("Signup / Login")).click();//WORKS BUT NOT PERFECT
//        clickWithTimeOut( driver.findElement(By.partialLinkText("Signup / Login")) , 6 );//WORKS BUT NOT EXCELLENT
        clickWithTimeOut(waitForVisibility(By.partialLinkText("Signup / Login"),3),6);//WORKS AND EXCELLENT
        //    And enter credentials and click sign up button
//        THIS IS OK BUT USING REUSABLE METHODS ARE BETTER JUST LIKE BELOW
//        driver.findElement(By.name("name")).sendKeys("John Wick");
//        driver.findElement(By.name("email")).sendKeys("fasdffa@gmail.com");
//        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        sendKeysWithTimeout(waitForVisibility(By.name("name"),3),"John Wick", 6);
        sendKeysWithTimeout(waitForVisibility(By.xpath("//input[@data-qa='signup-email']"),3),"ghsadfa@gmail.com", 6);
        clickWithTimeOut(waitForVisibility(By.xpath("//button[@data-qa='signup-button']"),3),6);
        extentTest
                .pass("adding user information...")
                .addScreenCaptureFromPath(takeScreenshotOfTheEntirePageAsString());
        //    And enter the information
//        gender
        clickWithTimeOut(waitForVisibility(By.id("id_gender1"),3),6);
//        password
        sendKeysWithTimeout(waitForVisibility(By.id("password"),3),"mysecretpassword", 6);
//        day dropdown
        selectByVisibleText(waitForVisibility(By.id("days"),3),"14");
//        months dropdown
        selectByVisibleText(waitForVisibility(By.id("months"),3),"June");
//        year dropdown
        selectByVisibleText(waitForVisibility(By.id("years"),3),"2000");
//        first name
        sendKeysWithTimeout(waitForVisibility(By.id("first_name"),3),"Test", 6);
//        last name
        sendKeysWithTimeout(waitForVisibility(By.id("last_name"),3),"Last", 6);
//        company
        sendKeysWithTimeout(waitForVisibility(By.id("company"),3),"My Comp LLC", 6);
//        address
        sendKeysWithTimeout(waitForVisibility(By.id("address1"),3),"123 highway dr.", 6);
//        country
        selectByVisibleText(waitForVisibility(By.id("country"),3),"United States");
        //        state
        sendKeysWithTimeout(waitForVisibility(By.id("state"),3),"TX", 6);
//        city
        sendKeysWithTimeout(waitForVisibility(By.id("city"),3),"Dallas", 6);
//        zipcode
        sendKeysWithTimeout(waitForVisibility(By.id("zipcode"),3),"12345", 6);
//        mobile_number
        selectByVisibleText(waitForVisibility(By.id("mobile_number"),3),"1234567890");
//       click on create account
        clickWithTimeoutByJS(waitForVisibility(By.xpath("//button[@data-qa='create-account']"),3));
    }
}
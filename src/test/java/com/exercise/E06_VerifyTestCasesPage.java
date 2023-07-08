package com.exercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class E06_VerifyTestCasesPage {

    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Test Cases' button
    5. Verify user is navigated to test cases page successfully
     */

    //        1. Launch browser

    WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

//    @After
//    public void tearDown() throws InterruptedException {
//        Thread.sleep(2000);
//        driver.quit();
//    }

    @Test
    public void test() throws InterruptedException {

//        2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com");

//        3. Verify that home page is visible successfully
        String correctionPage = driver.findElement(By.xpath("//*[text()=' Home']")).getText();
        assertEquals("Home", correctionPage);

//        4. Click on 'Test Cases' button
        driver.findElement(By.xpath("(//*[@href='/test_cases'])[1]")).click();

//        5. Verify user is navigated to test cases page successfully
        String verify = driver.findElement(By.xpath("//h2[@class='title text-center']")).getText();

        //Google ad
        // assertEquals("TEST CASES", verify);



    }
}
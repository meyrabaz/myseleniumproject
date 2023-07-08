package com.exercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class E05_RegisterUserWithExistingEmail {
 /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'New User Signup!' is visible
    6. Enter name and already registered email address
    7. Click 'Signup' button
    8. Verify error 'Email Address already exist!' is visible

  */

    WebDriver driver;

    //        1. Launch browser

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {

//        2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com");

//        3. Verify that home page is visible successfully
        String correctionPage = driver.findElement(By.xpath("//*[text()=' Home']")).getText();
        assertEquals("Home", correctionPage);

//        4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();

//        5. Verify 'New User Signup!' is visible
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        String verifyLogin = driver.findElement(By.xpath("//*[.='New User Signup!']")).getText();

        assertEquals("New User Signup!", verifyLogin);

//      6. Enter name and already registered email address
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Barney");
        driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("gaylene.douglas@hotmail.com");

//      7. Click 'Signup' button
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

//      8. Verify error 'Email Address already exist!' is visible
        String valid = driver.findElement(By.xpath("//p[text()='Email Address already exist!']")).getText();
        assertTrue(valid.contains("Email Address already exist!"));

    }
}
package com.exercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class E06_ContactUsForm {

    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Contact Us' button
    5. Verify 'GET IN TOUCH' is visible
    6. Enter name, email, subject and message
    7. Upload file
    8. Click 'Submit' button
    9. Click OK button
    10. Verify success message 'Success! Your details have been submitted successfully.' is visible
    11. Click 'Home' button and verify that landed to home page successfully
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

//        4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//a[@href='/contact_us']")).click();

//        5. Verify 'GET IN TOUCH' is visible
        String verify = driver.findElement(By.xpath("(//h2[@class='title text-center'])[2]")).getText();
        assertTrue(verify.contains("GET IN TOUCH"));

//        6. Enter name, email, subject and message
        driver.findElement(By.xpath("//*[@name='name']")).sendKeys("Barney");
        driver.findElement(By.xpath("//*[@name='email']")).sendKeys("gaylene.douglas@hotmail.com");
        driver.findElement(By.xpath("//*[@name='subject']")).sendKeys("Registration");
        driver.findElement(By.xpath("//*[@id='message']")).sendKeys("I don't handle google add");

//        7. Upload file
        String pathOfFile = System.getProperty("user.home")+ "/Desktop/flower.jpeg";
        WebElement chooseFileInput = driver.findElement(By.name("upload_file"));
        chooseFileInput.sendKeys(pathOfFile);

//        8. Click 'Submit' button
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@value='Submit']")).click();

//        9. Click OK button
        driver.switchTo().alert().accept();

//        10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        String verifyOk = driver.findElement(By.xpath("//*[@class='status alert alert-success']")).getText();
        assertEquals("Success! Your details have been submitted successfully.", verifyOk);

//        11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//*[@class='btn btn-success']")).click();



    }
}
package com.exercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class E03_LoginUserWithIncorrectEmailAndPassword {

    /*
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click on 'Signup / Login' button
        5. Verify 'Login to your account' is visible
        6. Enter incorrect email address and password
        7. Click 'login' button
        8. Verify error 'Your email or password is incorrect!' is visible
     */
    WebDriver driver ;

    //        1. Launch browser

    @Before
    public void setUp(){

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
    public void test(){

//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//        3. Verify that home page is visible successfully
        String correctionPage = driver.findElement(By.xpath("//*[text()=' Home']")).getText();
        assertEquals("Home",correctionPage );

//        4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();

//        5. Verify 'Login to your account' is visible
        String verifyLogin = driver.findElement(By.xpath("//*[text()='Login to your account']")).getText();
        assertEquals("Login to your account", verifyLogin);

//        6. Enter incorrect email address and password
        driver.findElement(By.xpath("//*[@name='email']")).sendKeys("cormier@hotmail.com");
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("0oa5");

//        7. Click 'login' button
        driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();

//        8. Verify error 'Your email or password is incorrect!' is visible
        String verify = driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']")).getText();
        assertEquals("Your email or password is incorrect!", verify);


    }

}
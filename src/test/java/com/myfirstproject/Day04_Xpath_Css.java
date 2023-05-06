package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Day04_Xpath_Css {

    /*
    When user goes to : https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
    And enter username
    And enter password
    And click on submit button
    Then verify the login is successful
     */
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void loginTestXpath(){

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");

        //sendKeys("admin123"+ Keys.ENTER) ==> enter password and press ENTER


        driver.findElement(By.xpath("//*[@type='submit']")).click();

        assertTrue(driver.getCurrentUrl().contains("dashboard"));

    }

    @Test
    public void loginTestCss(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123"+Keys.ENTER);

        assertTrue(driver.getCurrentUrl().contains("dashboard"));

    }

}
package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Day03_Locators {
    /*
    When user goes to : https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
    And enter username
    And enter password
    And click on submit button
    Then verify the login is successful
    When Click on "updated collings" options
    And Click on logout option
    Then verify the logout is successful
    */

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void loginTest() throws InterruptedException {
//        When user goes to : https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

//        And enter username
        WebElement userNameBox = driver.findElement(By.name("username"));//Identify the element
        userNameBox.sendKeys("Admin");//Perform the action
        Thread.sleep(3000);//This is hard wait(Java wait). This waits in any condition. This will keep execution for 3 seconds.

//        And enter password
        WebElement passwordBox = driver.findElement(By.name("password"));
        passwordBox.sendKeys("admin123");
        Thread.sleep(3000);

//        And click on submit button
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();

//        Then verify the login is successful
        String url = driver.getCurrentUrl();
        assertEquals("Url did not match","https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index",url);//OR
        assertTrue(driver.getCurrentUrl().contains("dashboard"));
        Thread.sleep(3000);


//        When Click on "user dropdown" options
        driver.findElement(By.className("oxd-userdropdown-tab")).click();
        Thread.sleep(3000);

//        And Click on logout option
        driver.findElement(By.linkText("Logout")).click();

        //        And Click on logout option
        // we can write partial "Logou" then click(). it will work again.
        // if we have <a tag in the source this is link tag
        // to click we put link on it
        // Logout has to be with uppercase. When we write lower case it did not work and we got exception().
        // ( Case Sensitive )
//        Then verify the logout is successful

//        Then verify the logout is successful
        assertTrue(driver.findElement(By.xpath("//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']")).isDisplayed());


        assertEquals("Login", driver.findElement(By.tagName("h5")).getText());

    }


    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}





package com.exercise;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task02V {

    public static class GoogleSearch {
        protected static WebDriver driver;
        protected static String desktopResult;
        protected static String smartPhoneResult;
        protected static String laptopResult;
        //    Create and Maximize the driver with the BeforeClass method and put implicit wait for 15 seconds
        @BeforeClass
        public static void setUp(){
            System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        //    Go to http://www.google.com in the before method
        @Before
        public void googleSearchTest(){
            driver.get("http://www.google.com");
        }
        //    With 3 different test methods:
        @Test
        public void searchDesktop() {
//     -Type "Desktop" in the search box and print the number of results
            WebElement searchBox = driver.findElement(By.id("APjFqb"));
            searchBox.sendKeys("Desktop");
            searchBox.submit();
        }
        @Test
        public void smartphoneTest() throws InterruptedException {
//     -Type "Smartphone" in the search box and print the number of results
            WebElement searchBox = driver.findElement(By.id("APjFqb"));
            searchBox.sendKeys("Smartphone");
            searchBox.submit();
        }
        @Test
        public void laptopTest() throws InterruptedException {
//     -Type "Laptop" in the search box and print the number of results
            WebElement searchBox = driver.findElement(By.id("APjFqb"));
            searchBox.sendKeys("Laptop");
            searchBox.submit();
        }
        //    NOTE: Print the result numbers in After method
        @After
        public void printingResults(){
            String desktopResult = driver.findElement(By.id("result-stats")).getText();
            System.out.println("desktopResult = " + desktopResult);
            String smartPhoneResult = driver.findElement(By.id("result-stats")).getText();
            System.out.println("smartPhoneResult = " + smartPhoneResult);
            String laptopResult = driver.findElement(By.id("result-stats")).getText();
            System.out.println("laptopResult = " + laptopResult);
        }
        //    Close driver with AfterClass method
        @AfterClass
        public static void tearDown() throws InterruptedException {
            Thread.sleep(1000);
            driver.quit();
        }
    }
}
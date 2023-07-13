package com.exercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Tas02V1 {

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

    static WebDriver driver;
    WebElement searchBox;

    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Before
    public void setUp() {
        driver.get("http://www.google.com");
    }

    @Test
    public void test01() {
        searchBox = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        searchBox.sendKeys("Desktop", Keys.ENTER);
    }

    @Test
    public void test02() {
        searchBox = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        searchBox.sendKeys("Smartphone", Keys.ENTER);
    }

    @Test
    public void test03() {
        searchBox = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        searchBox.sendKeys("Laptop", Keys.ENTER);
    }

    @After
    public void tearDown() {
        String [] result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
        System.out.println("Number of search result = "+result[0]);
    }

    @AfterClass
    public static void afterClass() {
        driver.close();
    }

}

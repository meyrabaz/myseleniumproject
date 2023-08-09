package com.exercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Task01V {

    /*
   Go to ebay page
   Click on electronics section
   Click on all the images with a Width of 225 and a Length of 225
   Print the page title of each page
   Close the page
    */
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void ebayTest() throws InterruptedException {
//        Go to ebay page
        driver.get("https://www.ebay.com/");

//        Click on electronics section
        driver.findElement(By.xpath("(//a[.='Electronics'])[2]")).click();

//        Click on all the images with a Width of 225 and a Length of 225
//        Print the page title of each page
        List<WebElement> images = driver.findElements(By.xpath("//img[@width='225'][@height='225']"));
        for(WebElement image: images){
            Thread.sleep(5000);
            image.click();
            System.out.println("driver.getTitle() = " + driver.getTitle());
            Thread.sleep(5000);
            driver.navigate().back();
        }

    }


//        Close the page

    @AfterClass
    public static void tearDown(){

        driver.quit();
    }



}
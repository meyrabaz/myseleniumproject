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

public class Task01 {

    /*
  Go to ebay page
  Click on electronics section
  Click on all the images with a Width of 225 and a Length of 225
  Print the page title of each page
  Close the page
   */
    static WebDriver driver;
    static List<WebElement> products;
    @BeforeClass
    public static void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void ebayTest() throws InterruptedException {

//Go to ebay page
        driver.get("https://www.ebay.com/");

//        Click on electronics section
        driver.findElement(By.xpath("(//a[.='Electronics'])[2]")).click();

//        Click on all the images with a Width of 225 and a Length of 225
//        Print the page title of each page

        products = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
        for (int i = 0; i<products.size();i++){
            products = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
            products.get(i).click();
            Thread.sleep(2000);
            System.out.println(i + 1 + ". title: " + driver.getTitle());
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);

        }

    }

    //        Close the page
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
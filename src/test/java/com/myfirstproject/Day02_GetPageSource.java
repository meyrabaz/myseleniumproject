package com.myfirstproject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class Day02_GetPageSource {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup(); // setup
        WebDriver driver = new ChromeDriver();   //create chrome driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // implicit wait
        driver.manage().window().maximize();  // maximize windows


        //        Test if amazon contains “Registry” on the homepage
        driver.get("https://www.amazon.com");
        String pageSource = driver.getPageSource();
        if(pageSource.contains("Registry")){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println(pageSource + " DOESN'T EXIST ON THE PAGE");
        }
       driver.quit();


    }
}
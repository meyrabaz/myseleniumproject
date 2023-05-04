package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day02_VerifyURLTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
//        Navigate to TechProEducation homepage
//        Verify if google homepage url is “https://techproeducation.com/”

        driver.get("https://techproeducation.com/");

        //      driver.findElement(By.linkText("LMS LOGIN")).click(); // Click LMS Login button and go on it,

        // So our test will fail beacuse it will go lms page --> FAIL
        //ACTUAL URL : https://lms.techproeducation.com/
        //BUT EXPECTED URL : https://techproeducation.com/”

        String actualCurrentURL = driver.getCurrentUrl();//returns the EXISTING URL
        if (actualCurrentURL.equals("https://techproeducation.com/")){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("ACTUAL URL : "+actualCurrentURL);
            System.out.println("BUT EXPECTED URL : https://techproeducation.com/”");
        }
        driver.quit();
    }
}
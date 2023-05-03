package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day02_VerifyTitleTest {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();

//        Create a new class: VerifyTitleTest 
//        Navigate to techproeducation homepage 
//        Verify if page title is “Techpro Education | Online It Courses & Bootcamps”

        driver.get("https://www.techproeducation.com");

       // ?? assertFalse(driver.getTitle().equals("this is not techpro title")); for negative test

        String actualTitle = driver.getTitle();//returns the TITLE of the page as string

        if (actualTitle.equals("Techpro Education | Online It Courses & Bootcamps")){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("EXPECTED TITLE : Techpro Education | Online It Courses & Bootcamps");
            System.out.println("ACTUAL TITLE : "+actualTitle);
        }
         driver.quit();



    }
}
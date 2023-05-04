package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day02_WebDriverManager {

    public static void main(String[] args) {
////        WITHOUT WEBDRIVER MANAGER
////        TESTING ON CHROME
//        System.setProperty("webdriver.chrome.driver","./driver/chromedriver");//chrome setup
//        WebDriver chrome = new ChromeDriver();
//
////        TESTING ON FIREFOX
//        System.setProperty("webdriver.firefox.driver","./driver/firefoxdriver");//firefox setup
//        WebDriver firefox = new FirefoxDriver();
//
////        TESTING ON EDGE
//        System.setProperty("webdriver.edge.driver","./driver/edgedriver");//edge setup
//        WebDriver edge = new EdgeDriver();

//        *****WITH WEBDRIVER MANAGER*****
        WebDriverManager.chromedriver().setup();//chrome setup
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.techproeducation.com");

//        WebDriverManager.firefoxdriver().setup();//firefox setup
//        WebDriver driver = new FirefoxDriver();//firefox driver create
//        driver.manage().window().maximize();//maximize
//        driver.get("https://www.techproeducation.com");//navigate





    }
}
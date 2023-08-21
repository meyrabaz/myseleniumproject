package com.exercise;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Task09V1 extends TestBase {

        /*
        Given
         Go to  https://www.saucedemo.com/
        When
         Enter the username  as "standard_user"
        And
         Enter the password as "secret_sauce"
        And
         Click on login button
        And
         Add all products to cart
        And
         Go to cart
        And
         Click on checkout
        And
         Fill your information
        And
         Click on continue
        Then
         Assert that total price is $140.34
        When
         Click on finish
        Then
         Assert that CHECKOUT: COMPLETE!
        */

    @Test
    public void test(){

//        Go to  https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");

//        Enter the username  as "standard_user"
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

//        Enter the password as "secret_sauce"
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");

//        Click on login button
        driver.findElement(By.id("login-button")).click();

//        Add all products to cart
        List<WebElement> checkboxes = driver.findElements(By.xpath("//button[@data-test]"));
        for (WebElement w: checkboxes){
            w.click();
        }

//        Go to cart
        driver.findElement(By.className("shopping_cart_badge")).click();

//        Click on checkout
        driver.findElement(By.id("checkout")).click();

//        Fill your information
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Def");
        driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("41000");

//        Click on continue
        driver.findElement(By.id("continue")).click();

//        Assert that total price is $140.34
        assertEquals("Total: $140.34",driver.findElement(By.xpath("//div[text()='140.34']")).getText());

//        Click on finish
        driver.findElement(By.id("finish")).click();

//        Assert that CHECKOUT: COMPLETE!
        assertEquals("Checkout: Complete!",driver.findElement(By.xpath("//span[text()='Checkout: Complete!']")).getText());
    }

}
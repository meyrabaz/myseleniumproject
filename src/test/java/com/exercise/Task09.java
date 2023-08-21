package com.exercise;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class Task09 extends TestBase {


    //Task 09:
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
  public void task09 (){

      driver.get("https://www.saucedemo.com/");

      driver.findElement(By.id("user-name")).sendKeys("standard_user");

     // driver.findElement(By.xpath("//input[@name='user-name']"));

      driver.findElement(By.id("password")).sendKeys("secret_sauce");

      driver.findElement(By.id("login-button")).click();


      driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
      driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
      driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
      driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
      driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
      driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();

      waitFor(2);

      driver.findElement(By.id("shopping_cart_container")).click();

      waitFor(1);

      driver.findElement(By.id("checkout")).click();

      driver.findElement(By.id("first-name")).sendKeys("meyra");

      driver.findElement(By.id("last-name")).sendKeys("baz");

      driver.findElement(By.name("postalCode")).sendKeys("34000");

      driver.findElement(By.name("continue")).click();


      waitFor(1);


//
    assertEquals("Total: $140.34",waitForVisibility(By.xpath("//div[@class='summary_info_label summary_total_label']"),2).getText());
//     // Assert.assertEquals("Checkout: Complete!",waitForVisibility(By.xpath("//div[@class='header_secondary_container']//span[@class='title']"),2).getText());
//
//     assertEquals("Checkout: Complete!",driver.findElement(By.xpath("//div//span")).getText());
//

//        Click on finish
      driver.findElement(By.id("finish")).click();

//        Assert that CHECKOUT: COMPLETE!
      assertEquals("Checkout: Complete!",driver.findElement(By.xpath("//span[@class='title']")).getText());




















  }
}

package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Day09_Authentication extends TestBase {

    @Test
    public void authTest(){
        /*
        username    : admin
        password    : admin
        url         :http://the-internet.herokuapp.com/basic_auth
         */

//        driver.get("http://the-internet.herokuapp.com/basic_auth");
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");

//        assert if login is successful
        String actualLoginText = driver.findElement(By.id("//div[@id='content']//p")).getText();
        Assert.assertTrue(actualLoginText.contains("Congratulations!"));




    }
}
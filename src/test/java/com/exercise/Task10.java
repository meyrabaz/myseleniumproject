package com.exercise;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Task10 extends TestBase {

    //Task 10:

    /*
  Given
      Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
  When
      Click on "click me" button
  Then
      Verify that "Event Triggered"
   */




    @Test

    public void task10 (){


        driver.get("https://testpages.herokuapp.com/styled/challenges/growing-clickable.html");
        waitFor(5);

        driver.findElement(By.id("growbutton")).click();

      //  driver.findElement(By.xpath("//button")).click();

        Assert.assertEquals("Event Triggered",waitForVisibility(By.id("growbuttonstatus"),2).getText());










    }
}

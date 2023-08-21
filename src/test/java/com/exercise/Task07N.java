package com.exercise;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static com.myfirstproject.utilities.TestBase.scrollAllTheWayDownJS;

public class Task07N extends TestBase {

    @Test
    public void task07N(){
/*
  Given
      Go to https://demo.guru99.com/test/drag_drop.html
  When
      Drag orange elements on proper boxes below them
  Then
      Verify they are dropped.
*/
        //        Go to https://demo.guru99.com/test/drag_drop.html
        driver.get("https://demo.guru99.com/test/drag_drop.html");
        scrollAllTheWayDownJS();
        //        Drag orange elements on proper boxes below them
        Actions actions = new Actions(driver);
        actions
                .dragAndDrop(waitForVisibility(By.id("credit2"),2),waitForVisibility(By.id("bank"),2)).release()
                .dragAndDrop(waitForVisibility(By.id("fourth"),2),waitForVisibility(By.id("amt7"),2)).release()
                .dragAndDrop(waitForVisibility(By.id("credit1"),2),waitForVisibility(By.id("loan"),2)).release()
                .dragAndDrop(waitForVisibility(By.id("fourth"),2),waitForVisibility(By.id("amt8"),2)).release()
                .perform();
        //        Verify they are dropped.
        Assert.assertEquals("Perfect!",waitForVisibility(By.xpath("//a[.='Perfect!']"),2).getText());
    }

}

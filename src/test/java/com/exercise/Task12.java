package com.exercise;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Task12 extends TestBase {

    //Task 12:

    //We will make a roof of 5% of the height of the earliest built tower.
    //Find how many meters we will build.
     /*
    Given
        Go to https://www.techlistic.com/p/demo-selenium-practice.html
    When
        Put all built years into a list
    And
        Calculate min year
    And
        Put all heights into a list
    And
        Calculate the height to build
    Then
        Assert that build height is 25.45 meters
     */

    @Test


    public void task12 (){

        List<WebElement> years = driver.findElements(By.xpath("(//table)[2]//tr//td[4]"));














    }
}

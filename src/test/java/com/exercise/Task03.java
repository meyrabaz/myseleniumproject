package com.exercise;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
public class Task03 extends TestBase {

     /*
    Go to https://amazon.com
    Print all the options in the 'Departments' dropdown on the left side of the search box
    Search for each first five options and print titles
     */

    @Test
    public void amazonTest() throws InterruptedException {

//    Go to https://amazon.com
        driver.get("https://amazon.com");

//    Print all the options in the 'Departments' dropdown on the left side of the search box
        Select select = new Select(driver.findElement(By.xpath("//*[@id='searchDropdownBox']")));
        for (WebElement w : select.getOptions()) {
            System.out.println(w.getText());
        }

        System.out.println("*************************");

//    Search for each first five options and print titles
        int index = 1;
        for (WebElement w : select.getOptions()) {
            Select option = new Select(driver.findElement(By.xpath("//*[@id='searchDropdownBox']")));
            option.selectByIndex(index);
            driver.findElement(By.xpath("//*[@type='submit']")).click();
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
            index++;
            if (index == 6) {
                break;
            }

        }


    }
}
package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class Day05_DropDown extends TestBase {
        /*

        Go to https://testcenter.techproeducation.com/index.php?page=dropdown
        1.Create a test method selectByIndexTest and Select Option 1 using index
        2.Create a test method selectByValueTest Select Option 2 by value
        3.Create a test method selectByVisibleTextTest Select Option 1 value by visible text
        4.Create a test method printAllTest Print all dropdown value
        5.Create a test method printFirstSelectedOptionTest Print first selected option
        6.Verify the dropdown has Texas text
        7.Find the size of the dropdown

        */

    //        1.Create a test method selectByIndexTest and Select Option 1 using index.
    @Test
    public void selectByIndexTest() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        //1st Step: Locate the dropdown
        WebElement dropDown = driver.findElement(By.id("dropdown"));

        //2nd Step: Create Select object
        Select select = new Select(dropDown);

        //3rd Step: Select Option 1 using index
        Thread.sleep(3000);
        select.selectByIndex(1);

    }

    //        2.Create a test method selectByValueTest Select Option 2 by value.
    @Test
    public void selectByValueTest() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        //1st Step: Locate the dropdown
        WebElement dropDown = driver.findElement(By.id("dropdown"));

        //2nd Step: Create Select object
        Select select = new Select(dropDown);

        //3rd Step: Select Option 2 by value..
        Thread.sleep(3000);
        select.selectByValue("2");

    }

    //        3.Create a test method selectByVisibleTextTest Select Option 1 value by visible text..
    @Test
    public void selectByVisibleTextTest() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        //1st Step: Locate the dropdown
        WebElement dropDown = driver.findElement(By.id("dropdown"));

        //2nd Step: Create Select object
        Select select = new Select(dropDown);

        //3rd Step: Select Option 1 value by visible text
        Thread.sleep(3000);
        select.selectByVisibleText("Option 1");

    }

    //        4.Create a test method printAllTest Print all dropdown value
    @Test
    public void printAllTest(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        //1st Step: Locate the dropdown
        WebElement dropDown = driver.findElement(By.id("state"));

        //2nd Step: Create Select object
        Select select = new Select(dropDown);

        //3rd Step: Print all dropdown value
        List<WebElement> optionsList = select.getOptions();

        //By using ForEach Loop
//        for(WebElement w : optionsList){
//            System.out.println(w.getText());
//        }

        //By using lambda: Recommended
        optionsList.forEach(w-> System.out.println(w.getText()));

    }


    //        5.Create a test method printFirstSelectedOptionTest Print first selected option
    @Test
    public void printFirstSelectedOptionTest(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        //1st Step: Locate the dropdown
        WebElement dropDown = driver.findElement(By.id("state"));

        //2nd Step: Create Select object
        Select select = new Select(dropDown);

        //3rd Step: Print first selected option
        String firstSelectedOption = select.getFirstSelectedOption().getText();
        //Returns: The first selected option in this select tag (or the currently selected option in a normal select)
        System.out.println(firstSelectedOption);
    }

//        6.Verify the dropdown has Texas text

    @Test
    public void verifyOption(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        //1st Step: Locate the dropdown
        WebElement dropDown = driver.findElement(By.id("state"));

        //2nd Step: Create Select object
        Select select = new Select(dropDown);

        //3rd Step: Verify the dropdown has Texas text
        List<WebElement> optionsList = select.getOptions();
        boolean containsOption = false;
        for(WebElement w : optionsList){
            if(w.getText().equalsIgnoreCase("texas")){
                containsOption = true;
            }
        }
        assertTrue(containsOption);

        //        7.Find the size of the dropdown
        int sizeOfOptions = optionsList.size();
        System.out.println("sizeOfOptions = " + sizeOfOptions);

    }

}
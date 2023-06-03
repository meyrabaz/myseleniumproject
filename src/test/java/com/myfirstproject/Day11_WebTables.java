package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Day11_WebTables extends TestBase {

    /*
    Go to: https://the-internet.herokuapp.com/tables
    Task 1 : Print the entire table
    Task 2 : Print All Rows
    Task 3 : Print Last row data only
    Task 4 : Print column 5 data in the table body
    Task 5 : Write a method that accepts 2 parameters
    Parameter 1 = row number
    Parameter 2 = column number
    printData(2,3); => prints data in 2nd row 3rd column
     */

    //       Task 1 : Print the entire table
    @Test
    public void printEntireTable(){
        driver.get("https://the-internet.herokuapp.com/tables");
        extentTest.pass("****PRINT ENTIRE TABLE****");
        String entireTable = driver.findElement(By.xpath("//table[@id='table1']")).getText();
        System.out.println("entireTable = " + entireTable);

//        ALTERNATIVELY
        List<WebElement> elements = driver.findElements(By.xpath("//table[@id='table1']//td"));
        for (WebElement eachData : elements){
            System.out.println(eachData.getText());
            extentTest.pass(eachData.getText());
        }

//        GET SPECIFIC INDEXED ELEMENTS
        System.out.println("6TH DATA IN THE TABLE =>>> "+elements.get(5).getText());

    }

    //        Task 2 : Print All Rows
    @Test
    public void printAllRows(){
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        int rowNum = 1;
        for(WebElement eachRow : allRows){
            System.out.println(rowNum + " : "+eachRow.getText());
            rowNum++;
        }
        System.out.println("2ND ROW DATA : "+allRows.get(1).getText());

//        Task 3 : Print Last row data only
        System.out.println("LAST ROW DATA : "+allRows.get(allRows.size()-1).getText());
    }

//        Task 4 : Print column 5 data in the table body

    @Test
    public void printColumns(){
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> col5Data = driver.findElements(By.xpath("//table[@id='table1']//tr//td[5]"));
        int colNum=1;
        for (WebElement eachData : col5Data){
            System.out.println(colNum + " : "+eachData.getText());
            extentTest.pass(eachData.getText());
            colNum++;
        }
    }






}
package com.myfirstproject;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Day15_ReadExcel {

    @Test
    public void readExcelTest() throws IOException {

        String pathOfFile = "resources/Capitals.xlsx";
//        Open the file
        FileInputStream fileInputStream = new FileInputStream(pathOfFile);

//        Open the workbook using fileinputstream   (workbook as an interface)
        Workbook workbook = WorkbookFactory.create(fileInputStream);

//        Open the first worksheet

        Sheet sheet1 = workbook.getSheet("Sheet1");

//        Go to first row

        Row row1 = sheet1.getRow(0);

//        Go to first cell on that first row and print

        Cell cell1 = row1.getCell(0); // index start with 0

        System.out.println( "cell1 is : " + cell1);

//        Go to second cell on that first row and print

        Cell cell2 = sheet1.getRow(0).getCell(1);
        System.out.println("cell2 = " + cell2); // CAPITAL


//        Go to 2nd row first cell and assert if the data equal to USA

       Cell row2cell1 = sheet1.getRow(1).getCell(0);
        System.out.println("cell3 = " + row2cell1);  // USA
        assertEquals("USA", String.valueOf(row2cell1));  // We can use ---- getStringCellValue()---

//        Go to 3rd row 2nd cell-chain the row and cell

        Cell row3cell2 = sheet1.getRow(2).getCell(1);
        System.out.println("row3cell2 = " + row3cell2);//Paris

        // Print to the console raw2 cell 6

        Cell cell6 = sheet1.getRow(10).getCell(1);
        System.out.println("cell6 = " + cell6);

//        Find the number of row
        int totalRowCount = sheet1.getLastRowNum()+1;//index starts at 0
        System.out.println(totalRowCount);
//        Find the number of used row
        int usedRowCount = sheet1.getPhysicalNumberOfRows();
        System.out.println(usedRowCount);//index starts at 1

// for loop logic, this question is homework in a map { key , value {turkey , ankara

        //Print country, capitol key value pairs as map object
        //        Print country, capitol key value pairs as map object
//        create a map, and use a loop, and add all countries as key, and capitals as value
//        String country = sheet1.getRow(ROW INDEX).getCell(CELL INDEX).toString();
//        String capital = sheet1.getRow(ROW INDEX).getCell(CELL INDEX).toString();
        Map<String,String> capitals = new HashMap<>();
        for (int rowNum =1; rowNum <totalRowCount;rowNum++ ){  //iterate the rows 1 to END
            String country = sheet1.getRow(rowNum).getCell(0).toString();
            System.out.println(country);
            String capital=sheet1.getRow(rowNum).getCell(1).toString();
            System.out.println(capital);
            capitals.put(country,capital);
        }
        System.out.println(capitals);
    }
}







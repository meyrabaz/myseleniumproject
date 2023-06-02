package com.myfirstproject;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day09_FileExistTest{

    @Test
    public void isExist(){
        /*
        We cannot handle files with selenium, but we can use JAVA to work with files.
         */

//        Pick a file on your desktop
//        And verify if that file exist on your computer or not

//        Get the path of the home directory
        String userHome = System.getProperty("user.home");
        System.out.println("userHome = " + userHome);

        String pathOfFlower = userHome+"/Desktop/flower.jpeg";
        System.out.println("pathOfFlower = " + pathOfFlower);

//        check if the flower file exist in my desktop
        Assert.assertTrue(Files.exists(Paths.get(pathOfFlower)));


    }

}
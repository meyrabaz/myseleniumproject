package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class Day08_Cookies extends TestBase {
    @Test
    public void cookiesTest() throws InterruptedException {
        driver.get("https://www.amazon.com");

//        1.Find the total number of cookies
        Set<Cookie> allCookies = driver.manage().getCookies();
        int totalNumCookies = allCookies.size();
        System.out.println("totalNumCookies = " + totalNumCookies);

//        2.Print all the cookies
        for(Cookie eachCookie : allCookies){
            System.out.println("Cookie --->>>" + eachCookie);
            System.out.println("Cookie Value --->>>" + eachCookie.getValue());
            System.out.println("Cookie Name --->>>" + eachCookie.getName());
            System.out.println("Cookie Expire --->>>" + eachCookie.getExpiry());
            System.out.println("Cookie Domain --->>>" + eachCookie.getDomain());
        }

//        3.Get the cookies by their name
//        entering cookie name, returning the entire cookie
        System.out.println("Cookie by Name : " + driver.manage().getCookieNamed("sp-cdn"));

//        4.Add new cookie
        Cookie myFavCookie = new Cookie("my-cookie","chocolate");
        driver.manage().addCookie(myFavCookie);
        Thread.sleep(3000);
        int newTotalNumOfCookie = driver.manage().getCookies().size();
        System.out.println("New Total Number Of Cookies --->>> " + newTotalNumOfCookie);

//        5.Delete cookie by name
//        passing the name of the cookie, and deleting that cookie
        driver.manage().deleteCookieNamed("i18n-prefs");
        Thread.sleep(3000);
        System.out.println("After deleting 1 cookie : " + driver.manage().getCookies().size());

//        6.Delete all the cookies
        driver.manage().deleteAllCookies();
        Thread.sleep(3000);
        System.out.println("Final number of cookies --->>> " + driver.manage().getCookies().size());



    }
}
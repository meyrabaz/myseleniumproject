package practices.practice02;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Q03_Alert extends TestBase {

    @Test
    public void alertTest() throws InterruptedException {

        /*
        Given
    Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
        When
    Click "CLICK ME" of JavaScript Alert
        And
    Get the Alert text
        Then
    Verify that message is "I am an alert box!"
        When
    Accept Alert
        */

//        Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");

//       Click "CLICK ME" of JavaScript Alert
        driver.findElement(By.id("button1")).click();
        Thread.sleep(1000);

//      Get the Alert text
        String alertText = driver.switchTo().alert().getText();
        Thread.sleep(1000);

//      Verify that message is "I am an alert box!"
        Assert.assertTrue(alertText.contains("I am an alert box!"));
        Thread.sleep(1000);
//       Accept Alert
        driver.switchTo().alert().accept();

    }
}
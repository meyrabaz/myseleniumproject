package practices;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class practiceme01 extends TestBase {


        @Test

        public void MyPractiseTestExpWait (){

            //    Go to https://the-internet.herokuapp.com/dynamic_loading/1

          driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

            //    When user clicks on the Start button


            driver.findElement(By.xpath("//button")).click();

            //    Then verify the 'Hello World!' Shows up on the screen

            //Using Explicit Wait:
            //1st: Create WebDriverWait object

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            //2nd: Use the wait object to handle the wait
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h4[.='Hello World!']"))));
            //visibilityOf() method will wait until the element is visible

            //    Then verify the ‘Hello World!’ Shows up on the screen
            String text = driver.findElement(By.xpath("//h4[.='Hello World!']")).getText();//Implicit wait did not work here.
            //Implicit wait is waiting for element to be loaded. Not for the visibility.
            //This wait will stop waiting when the element is loaded. But text will be visible after a few seconds being loaded.
            //For the visibility we will use Explicit wait.

            assertEquals("Hello World!", text);



        }

}



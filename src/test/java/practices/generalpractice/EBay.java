package practices.generalpractice;

import com.myfirstproject.utilities.TestBase;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EBay extends TestBase {
        /*
    Go to ebay page
    Click on electronics section
    Click on all the images with a Width of 225 and a Length of 225
    Print the page title of each page
    Close the page
     */

    @Test
    public void ebayTest() throws InterruptedException {

//        Go to ebay page
        driver.get("https://www.ebay.com/");

//        Click on electronics section
        driver.findElement(By.xpath("(//a[.='Electronics'])[2]")).click();

//        Click on all the images with a Width of 225 and a Length of 225
//        Print the page title of each page
        List<WebElement> images = driver.findElements(By.xpath("//img[@width='225'][@height='225']"));
        for (WebElement image : images) {
            Thread.sleep(1000);
            image.click();
            System.out.println("driver.getTitle() = " + driver.getTitle());
            Thread.sleep(1000);
            driver.navigate().back();
        }
    }

    @AfterClass
    public static void afterClass() {
//       Close the page
        driver.close();
    }
}

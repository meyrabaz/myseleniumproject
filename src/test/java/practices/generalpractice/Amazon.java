package practices.generalpractice;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Amazon extends TestBase {

    @Test
    public void amazonTest() throws InterruptedException {

//    Go to https://amazon.com
        driver.get("https://amazon.com");

//    Print all the options in the 'Departments' dropdown on the left side of the search box
        WebElement dropDown = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));

        Select options = new Select(dropDown);

        for(WebElement w:options.getOptions()){
            System.out.println("w.getText() = " + w.getText());
        }
        System.out.println("*******************************");

//    Search for each first five options and print titles
        int index=1;
        for (WebElement w: options.getOptions()){
            Select option = new Select(driver.findElement(By.xpath("//*[@id='searchDropdownBox']")));
            option.selectByIndex(index);
            driver.findElement(By.xpath("//*[@type='submit']")).click();
            System.out.println(driver.getTitle());
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
            index++;
            if (index==6){
                break;
            }
        }


    }
}
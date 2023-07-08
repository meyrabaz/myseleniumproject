package practices.generalpractice;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookSignIn extends TestBase {

    @Test
    public void signInTest() throws InterruptedException {
//        Go to https://www.facebook.com
        driver.get("https://www.facebook.com");

//        Click on "Yeni Hesap Oluştur" button
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

//        Enter a firstname
        driver.findElement(By.name("firstname")).sendKeys("John");
        Thread.sleep(2000);

//        Enter  a lastname
        driver.findElement(By.name("lastname")).sendKeys("Doe");
        Thread.sleep(2000);

//        Enter an email
        driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("johndoe@gmail.com");
        Thread.sleep(2000);

//        Enter a password
        driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("johndoe1234");
        Thread.sleep(2000);

//        Select a day
        WebElement day = driver.findElement(By.id("day"));
        Select options1 = new Select(day);
        options1.selectByVisibleText("6");

//        Select a month
        WebElement month = driver.findElement(By.id("month"));
        Select options2 = new Select(month);
        options2.selectByValue("4");

//        Select a year
        WebElement year = driver.findElement(By.id("year"));
        Select options3 = new Select(year);
        options3.selectByVisibleText("1981");

//        Select "Male" checkbox
        WebElement checkbox = driver.findElement(By.xpath("//label[text()='Male']"));
        boolean maleIsSelected = checkbox.isSelected();
        if(!maleIsSelected){
            checkbox.click();
        }

//        Click submit button
        driver.findElement(By.name("websubmit")).click();









    }
}
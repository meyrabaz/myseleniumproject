package practices.automationexercises;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginUser extends TestBase {

    @Test
    public void correctLoginUserTest(){

//  1. Launch browser, 2.Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//  3. Verify that home page is visible successfully
        String homePageVerify = driver.findElement(By.xpath("//*[text()=' Contact us']")).getText();
        Assert.assertEquals("Contact us",homePageVerify);

//  4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

//  5. Verify 'Login to your account' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[.='Login to your account']")).isDisplayed());

//  6. Enter correct email address and password
        driver.findElement(By.name("email")).sendKeys("j.johndoe@gmail.com");
        driver.findElement(By.name("password")).sendKeys("1234");

//  7. Click 'login' button
        driver.findElement(By.xpath("//button[.='Login']")).click();

//  8. Verify that 'Logged in as username' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed());
//  9. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();

//  10. Verify that 'ACCOUNT DELETED!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Account Deleted!']")).isDisplayed());

    }

    @Test
    public void incorrectLoginUserTest(){

//  1. Launch browser, 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//  3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Category']")).isDisplayed());

//  4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

//  5. Verify 'Login to your account' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[.='Login to your account']")).isDisplayed());

//  6. Enter incorrect email address and password
        driver.findElement(By.name("email")).sendKeys("johndoe@gmail.com");
        driver.findElement(By.name("password")).sendKeys("john");

//  7. Click 'login' button
        driver.findElement(By.xpath("//button[.='Login']")).click();

//  8. Verify error 'Your email or password is incorrect!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("(//form/p)[1]")).isDisplayed());
    }


}
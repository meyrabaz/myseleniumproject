package practices.automationexercises;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class LogoutUser extends TestBase {

    @Test
    public void logoutUserTest(){

//        1. Launch browser , 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//        3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Brands']")).isDisplayed());

//        4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

//        5. Verify 'Login to your account' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[.='Login to your account']")).isDisplayed());

//        6. Enter correct email address and password
        driver.findElement(By.name("email")).sendKeys("j.johndoe@gmail.com");
        driver.findElement(By.name("password")).sendKeys("1234");

//        7. Click 'login' button
        driver.findElement(By.xpath("//button[.='Login']")).click();

//        8. Verify that 'Logged in as username' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed());

//        9. Click 'Logout' button
        driver.findElement(By.xpath("(//*[.=' Logout'])[1]")).click();

//        10. Verify that user is navigated to login page
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://automationexercise.com/login",currentUrl);
    }
}
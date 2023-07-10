package practices.practice02;

import com.github.javafaker.Faker;
import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Q02_Form_Addition extends TestBase {
    /*
        Given
     Go to url : https://phptravels.com/demo/
        When
     Fill the form
        And
     Click on 'SUBMIT'
        Then
     Assert that the form has been sent
 */
    @Test
    public void formAdditionTest() throws InterruptedException {
//        Go to url : https://phptravels.com/demo/
        driver.get("https://phptravels.com/demo/");

//        Fill the form
        driver.findElement(By.name("first_name")).sendKeys(Faker.instance().name().firstName());
        driver.findElement(By.name("last_name")).sendKeys(Faker.instance().name().lastName());
        driver.findElement(By.name("business_name")).sendKeys(Faker.instance().name().title());
        driver.findElement(By.name("email")).sendKeys(Faker.instance().internet().emailAddress());

//        Locate number1
        int number1 = Integer.parseInt(driver.findElement(By.id("numb1")).getText());

//        Locate number2
        int number2 = Integer.parseInt(driver.findElement(By.id("numb2")).getText());

        int sum = number1+number2;

//        Locate the result
        WebElement result = driver.findElement(By.id("number"));
        Thread.sleep(1000);
        result.sendKeys(sum+"");//sum+"" ==> converts int to String

//        Click on 'SUBMIT'
        driver.findElement(By.id("demo")).click();

//        Assert that the form has been sent
        WebElement checkCircle = driver.findElement(By.id("colored"));
        Thread.sleep(2000);
        Assert.assertTrue(checkCircle.isDisplayed());









    }




}
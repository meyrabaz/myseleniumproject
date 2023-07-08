package practices.generalpractice;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GoogleSearch {

    static WebDriver driver;
    WebElement searchbox;
    protected static String desktopResult;
    protected static String smartPhoneResult;
    protected static String laptopResult;

    //    Create and Maximize the driver with the BeforeClass method and put implicit wait for 15 seconds
    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    //    Go to http://www.google.com in the before method
    @Before
    public void googleSearchTest(){
        driver.get("http://www.google.com");
    }

//    With 3 different test methods:

    @Test
    public void searchDesktop() {

//     -Type "Desktop" in the search box and print the number of results
        searchbox = driver.findElement(By.id("APjFqb"));
        searchbox.sendKeys("Desktop");
        searchbox.submit();

    }

    @Test
    public void smartphoneTest() throws InterruptedException {

//     -Type "Smartphone" in the search box and print the number of results
        searchbox = driver.findElement(By.id("APjFqb"));
        searchbox.sendKeys("Smartphone");
        searchbox.submit();

    }

    @Test
    public void laptopTest() throws InterruptedException {

//     -Type "Laptop" in the search box and print the number of results
        searchbox = driver.findElement(By.id("APjFqb"));
        searchbox.sendKeys("Laptop");
        searchbox.submit();

    }

    //    NOTE: Print the result numbers in After method
    @After
    public void printingResults(){
        String [] result = driver.findElement(By.id("result-stats")).getText().split(" ");
        System.out.println("Number of search result = " + result[1]);

    }

    //    Close driver with AfterClass method
    @AfterClass
    public static void tearDown(){
        driver.close();
    }


}
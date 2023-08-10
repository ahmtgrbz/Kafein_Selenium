package D07_AssertionExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

//@TestMethodOrder(OrderAnnotation.class)
public class AP_Case04 {
    WebDriver driver;

    @BeforeEach
    public void setup(){
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void tearDown(){
        //11. Close driver
        driver.close();
        driver.quit();
    }

    @Test
    //@Order
    public void test04() {

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement logo= driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        assertTrue(logo.isDisplayed());

        //4. Click on 'Signup / Login' button
        WebElement signup_login= driver.findElement(By.xpath("//a[text()=' Signup / Login'] "));
        signup_login.click();

        //5. Verify 'Login to your account' is visible
        WebElement login= driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        assertTrue(login.isDisplayed());

        //6. Enter correct email address and password
        WebElement emailTextBox= driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        emailTextBox.sendKeys("ben@ahmet.com");

        WebElement passwordTextBox= driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        passwordTextBox.sendKeys("benahmet");

        //7. Click 'login' button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        //8. Verify that 'Logged in as username' is visible
        WebElement loggedInText= driver.findElement(By.xpath("//a[text()=' Logged in as '] "));
        assertTrue(loggedInText.isDisplayed());

        //9. Click 'Logout' button
        driver.findElement(By.xpath("//a[text()=' Logout'] ")).click();

        //10. Verify that user is navigated to login page
        String expectedUrl="https://automationexercise.com/login";
        String actualUrl= driver.getCurrentUrl();
        assertEquals(expectedUrl,actualUrl);
    }

}

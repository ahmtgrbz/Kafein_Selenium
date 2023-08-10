package D07_AssertionExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;

public class AP_CASE09 {

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
        //8. Close driver
        driver.close();
        driver.quit();
    }

    @Test
    public void test09() {

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement logo= driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        assertTrue(logo.isDisplayed());

        //4. Click on 'Products' button
        driver.findElement(By.xpath("//a[text()=' Products'] ")).click();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        String expectedUrl="https://automationexercise.com/products";
        String actualUrl= driver.getCurrentUrl();
        assertEquals(expectedUrl,actualUrl);

        //6. Enter product name in search input and click search button
        WebElement searchBox= driver.findElement(By.xpath("//input[@id='search_product']"));
        searchBox.sendKeys("tshirt");
        driver.findElement(By.xpath("//button[@id='submit_search']")).click();

        //7. Verify 'SEARCHED PRODUCTS' is visible
        WebElement searchConfirm= driver.findElement(By.xpath("//h2[text()='Searched Products']"));
        assertTrue(searchConfirm.isDisplayed());

    }
}

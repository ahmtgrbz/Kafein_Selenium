package D07_AssertionExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Executable;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class F02_Example {
    WebDriver driver;

   @BeforeEach
   public void setup(){
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
   }

   @Test
    public void test01(){

       driver.get("https://the-internet.herokuapp.com/dynamic_controls");

       String expectedEnabledMessage = "It's enabled!";

       WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));

       Assertions.assertFalse(textBox.isEnabled());

       WebElement EnableButton = driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
       EnableButton.click();

       WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

       WebElement returnMessage = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

       Assertions.assertEquals(expectedEnabledMessage,returnMessage.getText());
       Assertions.assertTrue(textBox.isEnabled());

   }

   @AfterEach
   public void teardown(){
       driver.quit();
   }
}

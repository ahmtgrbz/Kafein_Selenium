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

import java.time.Duration;

public class F02_Example_AssertAll {

    WebDriver driver;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void test01() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        String expectedEnabledMessage = "It's enabled!";

        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        WebElement enableButton = driver.findElement(By.xpath("//button[@onclick='swapInput()']"));

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Assertions.assertAll(
                () -> Assertions.assertFalse(textBox.isEnabled(), "Text box should be disabled initially"),
                () -> {
                    enableButton.click();
                    WebElement returnMessage = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
                    Assertions.assertEquals(expectedEnabledMessage, returnMessage.getText(), "Message is incorrect");
                },
                () -> Assertions.assertTrue(textBox.isEnabled(), "Text box should be enabled after clicking the button")
        );
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }
}

package D08_ActionsClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

public class QA_Buttons {

    WebDriver driver;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void test_buttons(){

        driver.get("https://demoqa.com/buttons");

        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        WebElement clickBtn = driver.findElement(By.xpath("(//button[@type='button'])[4]"));

        Actions actions = new Actions(driver);

        actions.doubleClick(doubleClickBtn).perform();
        actions.contextClick(rightClickBtn).perform();
        actions.click(clickBtn).perform();

        String doubleClickMessage = driver.findElement(By.id("doubleClickMessage")).getText();
        String rightClickMessage = driver.findElement(By.id("rightClickMessage")).getText();
        String dynamicClickMessage = driver.findElement(By.id("dynamicClickMessage")).getText();

        assertAll(
                () -> assertEquals("You have done a double click",doubleClickMessage),
                () -> assertEquals("You have done a right click",rightClickMessage),
                () -> assertEquals("You have done a dynamic click",dynamicClickMessage)
        );

    }

    @AfterEach
    public void tearDown() {

        driver.close();
        driver.quit();
    }
}

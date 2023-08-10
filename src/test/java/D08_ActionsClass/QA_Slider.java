package D08_ActionsClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

public class QA_Slider {

    WebDriver driver;

    @BeforeEach
    public void setup() {
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void tearDown() {
        //8. Close driver
        driver.close();
        driver.quit();
    }

    @Test
    public void test_slider(){

        driver.get("https://demoqa.com/slider");

        WebElement sliderElement = driver.findElement(By.xpath("//input[@type='range']"));

        System.out.println(sliderElement.getRect().height);
        System.out.println(sliderElement.getRect().width);
        System.out.println(sliderElement.getRect().getX());
        System.out.println(sliderElement.getRect().getY());

        Actions actions = new Actions(driver);

        actions.dragAndDropBy(sliderElement,330,673).perform();

    }
}

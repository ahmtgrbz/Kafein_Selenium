package D08_ActionsClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class QA_Tabs {

    WebDriver driver;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void tearDown() {

        driver.close();
        driver.quit();
    }

    @Test
    public void new_Tab(){

        driver.get("https://demoqa.com/browser-windows");

        WebElement tabButton = driver.findElement(By.id("tabButton"));
        tabButton.click();

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));

        String newTabText = driver.findElement(By.id("sampleHeading")).getText();

        driver.close();

        driver.switchTo().window(tabs.get(0));

        String currentUrl = driver.getCurrentUrl();

        assertAll(
                () -> assertEquals("This is a sample page",newTabText),
                () -> assertEquals("https://demoqa.com/browser-windows",currentUrl)
        );

    }

    @Test
    public void new_window(){

        driver.get("https://demoqa.com/browser-windows");

        WebElement windowButton = driver.findElement(By.id("windowButton"));
        windowButton.click();

        List<String> windows = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(windows.get(1));

        String newWindowText = driver.findElement(By.id("sampleHeading")).getText();

        driver.close();

        driver.switchTo().window(windows.get(0));

        String currentUrl = driver.getCurrentUrl();

        assertAll(
                () -> assertEquals("This is a sample page",newWindowText),
                () -> assertEquals("https://demoqa.com/browser-windows",currentUrl)
        );
    driver.switchTo().newWindow(WindowType.TAB);
    }

}

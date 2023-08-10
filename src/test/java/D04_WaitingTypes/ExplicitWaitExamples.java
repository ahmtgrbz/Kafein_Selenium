package D04_WaitingTypes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitExamples {

    /*
    * ExpectedConditions detayları için:
    * https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/ExpectedConditions.html
    * */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/dynamic-properties");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        /*
        // 1.buton için
        WebElement enableAfterButton = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter")));
        enableAfterButton.click();
        */

        /*
        // 2.buton için attributeToBe kullancaksanız tam value vermelisiniz.
        webDriverWait.until(ExpectedConditions.attributeContains(By.id("colorChange"), "class", "text-danger"));
        driver.findElement(By.id("colorChange")).click();
        */

        //3.buton için
        WebElement visibleAfter = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
        visibleAfter.click();

        //driver.close();
        //driver.quit();
    }
}

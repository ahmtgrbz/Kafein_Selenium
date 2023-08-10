package D04_WaitingTypes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;


public class FluentWaitExamples {

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

        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);

        /*
        // 1.buton için
        WebElement enableAfter = fluentWait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter")));
        enableAfter.click();
        */


        /*
        // 2.buton için attributeToBe kullancaksanız tam value vermelisiniz.
        fluentWait.until(ExpectedConditions.attributeContains(By.id("colorChange"), "class", "text-danger"));
        driver.findElement(By.id("colorChange")).click();
        */

        /*
        //3.buton için
        WebElement visibleAfter = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
        visibleAfter.click();
        */

        //driver.close();
        //driver.quit();
    }
}

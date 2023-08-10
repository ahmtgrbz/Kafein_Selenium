package D06_JUnit_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class C02_AssertionMetods {

    WebDriver driver;

    @BeforeAll
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterAll
    public void tearDown(){
        driver.close();
        driver.quit();
    }
    @Test
    public void pods(){

        // 1- https://www.ebay.com/ adresine git.
        driver.get("https://www.ebay.com/");

        // 2- Açılan ekranda arama çubuğuna Airpods yaz.
        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("pods");

        // 3- Enter'a basarak aramayı yap.
        searchBox.submit();

        // 4- Airpods araması yapıldığını doğrula.
        WebElement result = driver.findElement(By.xpath("//h1//span[2]"));
        String resultText = result.getText();

        // 5- Tüm dataların Kontrolünü başlangıç için if else konsola yazdırarak yaptık.
        assertEquals("Airpods",resultText);

    }

}

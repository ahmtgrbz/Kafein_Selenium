package D06_JUnit_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_IfClause_TestCase_0 {

    @Test
    public void pods(){

        // Kurulumlarımızı sırasıyla yaptık.
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1- https://www.ebay.com/ adresine git.
        driver.get("https://www.ebay.com/");

        // 2- Açılan ekranda arama çubuğuna pods yaz.
        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("pods");

        // 3- Enter'a basarak aramayı yap.
        searchBox.submit();

        // 4- Airpods araması yapıldığını doğrula.
        WebElement result = driver.findElement(By.xpath("//h1//span[2]"));
        String resultText = result.getText();

        // 5- Tüm dataların Kontrolünü başlangıç için if else konsola yazdırarak yaptık.
        if(resultText.equals("Airpods"))
        {
            System.out.println("Aratılan kelime " + resultText);
            System.out.println("Test Passed");
        }else {
            System.out.println("Aratılan kelime " + resultText);
            System.out.println("Test Failed");
        }

        // 6- driver'ı kapattık.
        driver.close();
        driver.quit();


    }
}

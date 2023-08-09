package ders3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase_0 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1-
        driver.get("https://ebay.com");

        //2-
        WebElement searchBox = driver.findElement(By.id("gh-ac"));

        //3-
        searchBox.click();

        //4-
        String expected = "Airpods";
        searchBox.sendKeys(expected);

        //5-
        searchBox.submit();

        WebElement result = driver.findElement(By.xpath("//h1/span[2]"));

        String resultText = result.getText();

        if(resultText.equals(expected)){
            System.out.println("Test başarı ile geçti");
        }else {
            System.out.println("Test kaldı");
        }

    }
}

package D03_CreatingTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebElementMethods {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/text-box");

        /*
        *   Detaylı olarak tüm metodların ne yaptığını öğrenmek isterseniz:
        *
        *   https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/WebElement.html
        *
        */

        // Web element sınıfnın en çok kullanılan metodları
        WebElement webElement = driver.findElement(By.id("userName"));

        // 1- .click() --> webElementine tıklar.
        webElement.click();

        // 2- .sendKeys() --> webElementi içine verdiğimiz karakter dizisini gönderir.
        webElement.sendKeys("Kelime");

        // 3- .getText() --> webElementi içindeki metni döndürür.
        webElement.getText();

        // 4- .clear() --> webElementi içindeki metni temizler.
        webElement.clear();

        // 5- .isEnabled() --> Web elementinin etkin olup olmadığını doğrular.
        webElement.isEnabled();

        // 6- .isDisplayed(); --> Web elementinin görünür olup olmadığını doğrular.
        webElement.isDisplayed();

        // 7- .isSelected(); --> Web elementinin seçili olup olmadığını doğrular (örn. checkbox).
        webElement.isSelected();

        // 8- .getAttribute() --> webElementinin istediğimiz bir attirbute'unu değerini döndürür.
        webElement.getAttribute("id");

        // 9- .submit() --> Bu webelementi geçerli öğe bir formsa veya bir form içindeki bir öğeyse,
        //   bu formu gönderir(Entera basmak gibi düşünebilirsiniz).
        webElement.submit();

        // 10- .getSize() --> Bu webelementinin genişliğini ve yüksekliğini döndürür.
        webElement.getSize();

        // 11- .getLocation() --> Bu webelementinin sol üst koşeyeyi refrans alarak pozisyonunu döndürür.
        webElement.getLocation();

    }
}

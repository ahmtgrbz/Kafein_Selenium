package ders1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FirstClass {
    public static void main(String[] args) {

        /* chromedriver.exe' yi System32 içine attıysanız bir kurulum satırı yazmanıza gerek yok.

        /*
        Eğerki Bonigarcia ile değilde manuel olarak webdriver eklediyseniz aşağıdki satırı kodunuza eklemelisiniz.

              System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

         */

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        /*
            Eğerki chromium tabanlı farklı bir browser kullanıyorsak aşağıdaki gibi option nesnesini kulannarak
            ayarlarını ChromeDriver'a vermeliyiz.

            ChromeOptions options = new ChromeOptions().setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
            WebDriver driver = new ChromeDriver(options);
        */


        driver.get("https://google.com/");

    }
}

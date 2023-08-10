package D02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverGetMethods {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        // 1- driver.get("url") --> Verdiğimiz url adresine gider.
        driver.get("https://demoqa.com/");

        // 2- driver.getCurrentUrl() --> Bulunulan sayfanın URL'ini verir.
        System.out.println(driver.getCurrentUrl());

        // 3- driver.getTitle() --> Bulunulan sayfanın başlığını verir.
        System.out.println("Sayfanın Başlığı : " + driver.getTitle());

        // 4- driver.getPageSource(); --> Bulunulan sayfanın kaynak kodlarını verir.
        System.out.println("Sayfanın Kaynak Kodu :");
        System.out.println(driver.getPageSource());

        // 5- driver.getWindowHandle() --> Bulunulan sayfannın UNIQUE hash kodunu verir. Her çalıştırmanızda değişir.
        System.out.println("Sayfanın UNIQUE hash kodu : " + driver.getWindowHandle());

        // 6- driver.getWindowHandles() --> driver çalışırken açık olan tüm tablerin UNIQUE hash kodunu verir.
        //driver.getWindowHandles().forEach(code -> System.out.println(code));
    }
}

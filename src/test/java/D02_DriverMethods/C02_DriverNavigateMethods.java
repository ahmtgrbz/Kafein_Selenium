package D02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverNavigateMethods {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        /*
        1- driver.navigate().to("url") --> Verdiğimiz url adresine gider.
           driver.get("url") ile aynı işlemi yapar ancak metod üzerinden
           forward ve back yapılmasını mümkün kılar.
        */

        driver.get("https://demoqa.com/");
        driver.navigate().to("https://www.google.com");

        // 2- driver.navigate().back(); --> bir önceki sayfaya döner.
        driver.navigate().back();

        // 3- driver.navigate().forward(); --> back() ile gelinen sayfaya tekrar gider.
        driver.navigate().forward();

        // 4- driver.navigate().refresh(); --> bulunulan sayfayı yeniler.
        driver.navigate().refresh();


        //driver.close() ve driver.quit() denemek için aşağıdaki kodu kullanabilirsiniz.
        //driver.switchTo().newWindow(WindowType.TAB);
        //driver.get("https://www.twitter.com");


        //Bulununduğu tabi yada window'u kapatır.
        driver.close();

        // driver'ı tamamen kapatır. Bu durumda açılan tüm tablerde dahil olmak üzere session kapanır.
        //driver.quit();

    }
}

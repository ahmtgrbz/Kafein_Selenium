package D02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_DriverManageMethods {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        System.out.println("-----------------------------------------------------------------------------------");

        // 1- driver.manage().window() method'ları

        // A - driver.manage().window().getSize() --> Bulunulan sayfanın pixel ölçülerini verir.
        System.out.println(driver.manage().window().getSize()); // (1936, 1056) pixel --- (Genişlik - Yükseklik)
        //System.out.println(driver.manage().window().getSize().width); // 1936

        // B driver.manage().window().getPosition() -->  Bulunulan sayfanın pixel olarak konumunu verir (sol-üst köşe).
        System.out.println(driver.manage().window().getPosition());

        // C driver.manage().window().setPosition(new Point(x,y)) --> Bulunulan sayfanının sol üst köşesini x,y noktasına taşır.
        driver.manage().window().setPosition(new Point(50,30));

        /* D driver.manage().window().setSize(new Dimension(x,y)) -->
         Bulunulan sayfanının sol üst köşesini sabitler
         pencereyi bizim yazdığımız x genişliğine y yüksekliğine getirir.
         */
        driver.manage().window().setSize(new Dimension(500,200));

        // Konum ve boyutu tekrar yazdırarak kontro edelim.
        System.out.println("Yeni pencere boytu: " + driver.manage().window().getSize());
        System.out.println("Yeni pencere pozisyonu: " + driver.manage().window().getPosition());

        // E driver.manage().window().maximize(); --> Bulunulan sayfayı maximize eder.
        driver.manage().window().maximize();
        // F driver.manage().window().fullscreen(); --> Bulunulan sayfayı fullscreen moduna geçirir.
        driver.manage().window().fullscreen();

        // Bu iki metodun farkını görmek istersek aşağıdaki kodu kullanabiliriz.
        /*
        driver.manage().window().maximize();
        System.out.println("maximize konum : " + driver.manage().window().getPosition());
        System.out.println("maximize boyut : " + driver.manage().window().getSize());

        driver.manage().window().fullscreen();
        System.out.println("fullscreen konum : " + driver.manage().window().getPosition());
        System.out.println("fullscreen boyut : " + driver.manage().window().getSize());
        */

        // G driver.manage().window().minimize(); --> Bulunulan sayfayı minimize eder.
        driver.manage().window().minimize();

        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------");

        // 2- driver.manage().timeouts() implicitlyWait.

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        /*      wait konusunu ilerde ayrıca inceleyeceğiz.
                Ancak her test sınıfı için yapmamız gereken bir ayar olduğu için burada kısaca değinelim.

                implicitlyWait : driver'a sayfanın yüklenmesi ve kullanacağımız WebElementlerinin bulunması için
                                 bekleyeceği maximum süreyi belirtir.
                                 bu süre içerisinde sayfadaki tüm WebElemenları yüklenirse
                                 driver beklemeden çalışmaya devam eder.
                                 bu süre bittiği halde sayfa sayfadaki tüm WebElemenları yüklenmemişse
                                 exception(“No Such Element Exception”) vererek çalışmayı durdurur.

                Duration.ofSeconds(10) : Duration class'ı Selenium-4 ile gelen zaman class'ıdır.
                                         Yani driver'a ne kadar bekleyeceğini söyler
                                         Duration.ofSeconds(15) yerine milis,minutes,hours da kullanılabilir.
         */

        /* NOT :    Driver'ın istediğimiz işlemleri yaparken sorunla karşılaşmaması için
                    driver.manage() method'larından
                    maximize() ve implicitlyWait() method'larının her test'te kullanılması
                    FAYDALI OLACAKTIR.

         */

    }

}

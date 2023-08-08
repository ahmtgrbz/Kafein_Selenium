package ders2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C04_Cookie_DriverManager {

    public static void main(String[] args) {

        /*
         *  Cookiler ilgili daha detaylı bilgi için :
         * https://www.selenium.dev/documentation/webdriver/interactions/cookies/
         *
         * */

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://google.com");

        // A - Tarayıcıya cookie eklemeye yarar. Cookiler Key-Value şeklindedirler.
        driver.manage().addCookie(new Cookie("testCookie", "cookie"));

        // B - Tüm cookileri bir set içinde yada Arraylist içinde almanızı sağlıyor.
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("-------------------------");
        for (Cookie cookie : cookies) {
            System.out.println(cookie);
        }
        System.out.println("-------------------------");
        /*
         * Not: Seti isterseniz Aşağıdaki gibi array haline getirebilir ve get ile tek tek alabilirsiniz.
         *      ArrayList<Cookie> cookies1 = new ArrayList<>(driver.manage().getCookies());
         * */

        // C - O sayfada istediğiniz bir cookie'yi almanızı sağlıyor.
        Cookie testCookie = driver.manage().getCookieNamed("testCookie");
        System.out.println("Test Cookiesi : " + testCookie);

        // D - ismini verdiğiniz cookieyi silmenizi sağlıyor.
        //driver.manage().deleteCookieNamed("testCookie");

        // E - Cookie olarak verdiğiniz cookieyi de driver üstünden silmenizi sağlıyor. (Verdiğiniz tür farklı sadece)
        driver.manage().deleteCookie(testCookie);

        // F - Tüm Cookieleri silmenizi sağlıyor.
        driver.manage().deleteAllCookies();

        /*
         * Son olarak cookilerin 2 özelliği var bunları ayarlayaibliryorsunuz
         *
         *   new Cookie.Builder("key", "value").sameSite("Strict").build(); --> bu türde site tarafında yapılan tanımlama
         *                                                                          isteklerin içine cookie eklenmez.
         *
         *   new Cookie.Builder("key", "value").sameSite("Lax").build();  --> bu türde site tarafında yapılan tanımlama
         *                                                                        isteklerin içine cookie eklenir.
         *
         * */

    }
}

package D05_JUnit_Anotations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;



@DisplayName("İlk test Sınıfı")
public class C01_FirstJunitClass {

    /*
    *
    * Şuana kadar test medodlarımızı main metod yardımı ile çağırıyorduk artık buna ihtiyacımız yok.
    * @Test anotasyonu bize bu çalıştırma imkanını sağlıyor olacak.
    *
    * Ayrıca eskiden hata alındığında yada test başarılı olduğunda metodun adını görüyorduk.
    * Bu sebeple metodun adlandırması çok önemliydi. Şimdi @DisplayName ile istediğimiz adı
    * rapor aşamasında görebiliriz.
    *
    * @Test anotasyonunu yazınca bu test metodu bağımsız olarak çalışabilir hale geldi.    *
    * Peki Hocam bir klasta birden fazla test metodu olur mu ?
    * */

    @Test
    @DisplayName("İlk test metodu")
    public void test01(){

        // Kurulumlarımızı sırasıyla yaptık.
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1- login sayfamıza gittik
        driver.get("https://demoqa.com/login");

        // 2- UserName alanını seçtik ve Test datası ile doldurduk.
        WebElement userNameBox = driver.findElement(By.id("userName"));
        userNameBox.sendKeys("newdemo");

        // 3- Password alanı seçtik ve Test datası ile doldurduk.
        WebElement passwordBox = driver.findElement(By.id("password"));
        passwordBox.sendKeys("Newdemotester@123");

        // 4- Login butonunu seçtik ve tıkladık.
        WebElement submitButton = driver.findElement(By.id("login"));
        submitButton.click();

        // 5- Dönen hatayı uyarı mesajını aldık.
        WebElement errorMessage = driver.findElement(By.id("name"));
        String errorMessageText = errorMessage.getText();

        //6- Tüm dataların Kontrolünü başlangıç için if else konsola yazdırarak yaptık.
        if(errorMessageText.equals("Invalid username or password!"))
        {
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }

        //7- driver'ı kapattık.
        driver.close();
        driver.quit();

    }
}

package D03_CreatingTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase_2 {
    public static void main(String[] args) {

        // Kurulumlarımızı sırasıyla yaptık.
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1- login sayfamıza gittik
        driver.get("https://demoqa.com/login");

        // 2- UserName alanını seçtik ve Test datası ile doldurduk.
        WebElement userNameBox = driver.findElement(By.id("userName"));
        userNameBox.sendKeys("newdemotester");

        // 3- Password alanı seçtik ve Test datası ile doldurduk.
        WebElement passwordBox = driver.findElement(By.id("password"));
        passwordBox.sendKeys("Newdemotester@123");

        // 4- Login butonunu seçtik ve tıkladık.
        WebElement submitButton = driver.findElement(By.id("login"));
        submitButton.click();

        // 5- sağ üstte kullanıcı adı değerini aldık
        WebElement userNameValue = driver.findElement(By.id("userName-value"));
        String userNameValueText = userNameValue.getText();

        //6- Tüm dataların Kontrolünü başlangıç için if else konsola yazdırarak yaptık.
        if(userNameValueText.equals("newDemoTester"))
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

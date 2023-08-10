package D08_ActionsClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class C02_ActionsClassKeyBoardActions {

    public static void main(String[] args) {

        /*
         *
         *
         *       !!! ÖNEMLİ NOT: !!!
         *
         *       Action sınıfı zincileme işlemler yapmamıza izin verir bu sebepten ötürü
         *       mutla işlemin yapılmasını istediğimizde metodun sonunda .perform(); metodunu
         *       ekleyerek çağrı yapmalıyız.
         *
         *       Bunu yapmazsak ekranımızda bir aksiyon göremeyiz.
         *
         *       örn: actions.click().doubleClick().preform();
         *
         * */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/buttons");

        WebElement exampleElement1 = driver.findElement(By.id("doubleClickBtn"));
        WebElement exampleElement2 = driver.findElement(By.id("rightClickBtn"));

        Actions actions = new Actions(driver);

        /*
        * Temelde 3 adet metodumuz klavye üzerinde var.
        *
        * */

        //1- actions.sendKeys() --> bu metod Webelementin üzerindeki metodla aynı metoddur.
        //  İstediğimiz tuşlara sadece tek seferlik basar.
        actions.sendKeys("Ahmet");
        actions.sendKeys(Keys.ENTER);


        //2,3- action.keyDown() ve action.keyUp() aslında bir tuşa ayrı zamanlarda basma ve çekme işlemidir.
        actions.keyDown(Keys.LEFT_SHIFT)
                .sendKeys("merhaba")
                .keyUp(Keys.LEFT_SHIFT)
                .perform();

    }
}

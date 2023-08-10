package D08_ActionsClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class C01_ActionsClassMouseActions {

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


        //1- bir web elementi üstüne gidip beklememizi sağlar.
        actions.moveToElement(exampleElement1);

        //2- istediğimiz web element’e click yapar.
        actions.click(exampleElement1);

        //3- istediğimiz web element’e basili bekler.
        actions.clickAndHold(exampleElement1);

        //4- istediğimiz web element’e sag click yapar.
        actions.contextClick(exampleElement1);

        //5-istediğimiz web element’e çift click yapar.
        actions.doubleClick(exampleElement1);

        //6- istediğimiz web element’i alıp, istediğimiz başka bir elementin üzerine bırakır.
        actions.dragAndDrop(exampleElement1,exampleElement2) ;

        //7- sayfayı ona vereceğimiz x ve y pixeli kadar scroll eder, kaydır.
        actions.scrollByAmount(100,200);

    }
}

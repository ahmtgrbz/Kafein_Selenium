package D05_JUnit_Anotations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_OneClassAllTests {

    /*
    * @Test anotasyonun bir avantajıda test sınıfları içindeki test
    * metodlarına tekli yada çoklu çalışma imkanı sağlamasıdır.
    *
    * Ama dikkat ettiyseniz sürekli olarka testlerin için tekrar eden yerlerimiz var.
    * Çok basit işlerimde olsa sürekli ayar yapıyorum. Bunun kolay bir yolu yok mu ?
    * Bunu bir kere yapsak kullansak Java kullanıyoruz OOP konseptin avantajı bu değil mi ?
    *
    * */

    @Test
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

    @Test
    public void test02(){
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

    @Test
    public void test03(){

        // Kurulumlarımızı sırasıyla yaptık.
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1- text-box sayfamıza gittik
        driver.get("https://demoqa.com/text-box");

        // 2- Full Name alanını seçtik ve Test datası ile doldurduk.
        WebElement userNameTextBox = driver.findElement(By.id("userName"));
        userNameTextBox.sendKeys("Ahmet");

        // 3- emailTextBox alanını seçtik ve Test datası ile doldurduk.
        WebElement emailTextBox = driver.findElement(By.id("userEmail"));
        emailTextBox.sendKeys("ahmet@ben.com");

        // 4- currentAddressTextBox alanını seçtik ve Test datası ile doldurduk.
        WebElement currentAddressTextBox = driver.findElement(By.id("currentAddress"));
        currentAddressTextBox.sendKeys("istanbul");

        // 5- permanentAddressTextBox alanını seçtik ve Test datası ile doldurduk.
        WebElement permanentAddressTextBox = driver.findElement(By.id("permanentAddress"));
        permanentAddressTextBox.sendKeys("izmir");

        // 6- Submit butonunu seçtik ve tıkladık.
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();


        // 7- Dönen Name değerini seçtik ve aldık.
        WebElement nameTextElement = driver.findElement(By.id("name"));
        String nameText = nameTextElement.getText();


        // 8- Dönen email değerini seçtik ve aldık.
        WebElement emailTextElement = driver.findElement(By.cssSelector("#email"));
        String emailText = emailTextElement.getText();


        // 9- Dönen currentAddressElement değerini seçtik ve aldık.
        WebElement currentAddressTextElement = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        String currentAddressText = currentAddressTextElement.getText();


        // 10- Dönen Permananet Address değerini seçtik ve aldık.
        WebElement permanentAddressTextElement = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        String permanentAddressText = permanentAddressTextElement.getText();


        //11- Tüm dataların Kontrolünü başlangıç için if else konsola yazdırarak yaptık.
        if(nameText.equals("Name:Ahmet") &&
                emailText.equals("Email:ahmet@ben.com") &&
                currentAddressText.equals("Current Address :istanbul") &&
                permanentAddressText.equals("Permananet Address :izmir"))
        {
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }

        //12- driver'ı kapattık.
        driver.close();
        driver.quit();

    }

}

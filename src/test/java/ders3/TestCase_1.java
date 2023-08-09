package ders3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase_1 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/login");

        WebElement userNameTextBox = driver.findElement(By.cssSelector("input[placeholder='UserName']"));
        WebElement passwordTextBox = driver.findElement(By.cssSelector("input[type='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));

        String username = "newdemo";
        String password = "Newdemotester@123";
        String expectedText = "Invalid username or password!";

        userNameTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);

        loginButton.click();

        WebElement result = driver.findElement(By.id("name"));
        String resultText = result.getText();

        if (resultText.equals(expectedText)){
            System.out.println("Test Başarılı");
        }else{
            System.out.println("Test Başarısız");
        }

        driver.close();
        driver.quit();


    }
}

package ders2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class F01_Example {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://selenium.dev");
        System.out.println(driver.getTitle());
        driver.navigate().to("https://google.com");
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();
        System.out.println(driver.getTitle());
        driver.navigate().refresh();

        driver.close();
        driver.quit();



    }

}

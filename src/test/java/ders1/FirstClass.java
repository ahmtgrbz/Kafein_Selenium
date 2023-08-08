package ders1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FirstClass {
    public static void main(String[] args) {

        //System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions().setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");

        WebDriver driver = new ChromeDriver(options);


        driver.get("https://google.com");


    }
}

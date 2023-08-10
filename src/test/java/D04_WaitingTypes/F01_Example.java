package D04_WaitingTypes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class F01_Example {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String removeButtonExpectedReturn = "It's gone!";
        String addButtonExpectedReturn = "It's back!";

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement removeButton = driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));

        removeButton.click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement goneMessage = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        if (goneMessage.isDisplayed() && goneMessage.getText().equals(removeButtonExpectedReturn)){
            System.out.println("Remove Testi başarılı");
        }else {
            System.out.println(goneMessage.getText());
            System.out.println("Remove Testi başarısız");
        }

        removeButton.click();


        WebElement backMessage = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        if (backMessage.isDisplayed() && backMessage.getText().equals(addButtonExpectedReturn)){
            System.out.println("Add Testi başarılı");
        }else {
            System.out.println(backMessage.getText());
            System.out.println("Add Testi başarısız");
        }

        driver.quit();
    }
}

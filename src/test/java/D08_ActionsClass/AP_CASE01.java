package D08_ActionsClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

public class AP_CASE01 {

    /*
     * Bir sürü locate yapmak yerin tab tuşu ile gezinmek bize hem kod okunurluğu hemde zaman kazandırabilir.
     * */

    WebDriver driver;

    @BeforeEach
    public void setup() {
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void tearDown() {
        //8. Close driver
        driver.close();
        driver.quit();
    }

    @Test
    public void test01() {

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Click on 'Signup / Login' button
        WebElement login_signup = driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
        Actions actions = new Actions(driver);
        actions.click(login_signup).perform();

        //4. Enter name and email address
        //5. Click 'Signup' button
        WebElement nameTextbox = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        actions.click(nameTextbox)
                .sendKeys("Ahmet")
                .sendKeys(Keys.TAB)
                .sendKeys("case0001@ben.com")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        //6. Fill details: Title, Name, Email, Password, Date of birth
        //7. Select checkbox 'Sign up for our newsletter!'
        //8. Select checkbox 'Receive special offers from our partners!'
        //9. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement titleRadioButton = driver.findElement(By.xpath("//div[@id='uniform-id_gender1']"));
        actions.click(titleRadioButton)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys("11")
                .sendKeys(Keys.TAB)
                .sendKeys("March")
                .sendKeys(Keys.TAB)
                .sendKeys("1980")
                .sendKeys(Keys.TAB)
                .click()
                .sendKeys(Keys.TAB)
                .click()
                .sendKeys(Keys.TAB)
                .sendKeys("Ahmet")
                .sendKeys(Keys.TAB)
                .sendKeys("Gurbuz")
                .sendKeys(Keys.TAB)
                .sendKeys("ben")
                .sendKeys(Keys.TAB)
                .sendKeys("deneme cad")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("United States")
                .sendKeys(Keys.TAB)
                .sendKeys("New York")
                .sendKeys(Keys.TAB)
                .sendKeys("Los Angeles")
                .sendKeys(Keys.TAB)
                .sendKeys("09178")
                .sendKeys(Keys.TAB)
                .sendKeys("45645112312")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        //10. Click 'Create Account button'
        //11. Verify that 'ACCOUNT CREATED!' is visible
        String expectedResult = "ACCOUNT CREATED!";
        String actualResult = driver.findElement(By.xpath("//h2[@data-qa='account-created']")).getText();
        assertEquals(expectedResult, actualResult);

    }

}

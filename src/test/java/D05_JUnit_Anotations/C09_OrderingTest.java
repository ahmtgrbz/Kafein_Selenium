package D05_JUnit_Anotations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class C09_OrderingTest {

    @BeforeAll
    public void setup(){
        System.out.println("setup çalıştı.");
    }

    @AfterAll
    public void tearDown(){
        System.out.println("tearDown çalıştı.");
    }

    @Test
    @Order(2)
    public void test01(){

        System.out.println("Test01 çalıştı.");

    }

    @Test
    @Order(1)
    public void test02(){

        System.out.println("Test02 çalıştı.");

    }

    @Test
    @Order(3)
    public void test03(){

        System.out.println("Test03 çalıştı.");

    }
}

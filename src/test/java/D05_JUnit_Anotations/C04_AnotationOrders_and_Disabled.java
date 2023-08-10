package D05_JUnit_Anotations;

import org.junit.jupiter.api.*;

public class C04_AnotationOrders_and_Disabled {

    @BeforeAll
    public static void beforeAll(){
        System.out.println(" beforeAll çalıştı. ");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println(" beforeEach çalıştı. ");
    }

    @Test
    public void test01(){
        System.out.println(" test01 çalıştı. ");
    }

    @Test
    public void test02(){
        System.out.println(" test02 çalıştı. ");
    }
    @Disabled
    @Test
    public void test03(){
        System.out.println(" test03 çalıştı. ");
    }

    @AfterEach
    public void afterEach(){
        System.out.println(" afterEach çalıştı. ");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println(" afterAll çalıştı. ");
    }
}

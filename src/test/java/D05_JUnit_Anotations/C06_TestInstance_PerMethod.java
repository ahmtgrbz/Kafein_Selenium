package D05_JUnit_Anotations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class C06_TestInstance_PerMethod {

    /*
    * @TestInstance sınıf içinde oluşturmuş olduğumuz test datalarının(örn. Counter)
    * her test için nasıl davranacağını belirlememize yarar.
    * Eğerki PER_METHOD dersek bu data her metod için yeniden oluşturularak metod içersine gönderilir.
    * */
    private int counter = 0;

    @Test
    public void testMethod1() {
        counter++;
        System.out.println("TestMethod1 - Counter: " + counter);
    }

    @Test
    public void testMethod2() {
        counter++;
        System.out.println("TestMethod2 - Counter: " + counter);
    }
}
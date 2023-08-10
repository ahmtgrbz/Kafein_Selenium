package D05_JUnit_Anotations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class C07_TestInstance_PerMethod {

    /*
     * @TestInstance sınıf içinde oluşturmuş olduğumuz test datalarının(örn. Counter)
     * her test için nasıl davranacağını belirlememize yarar.
     * Eğerki PER_CLASS dersek bu data her seferinde yeniden oluşturulmaz.
     * bu sınıf için değişkenin sadece 1 kez oluşturularak her motod içine gönderilir.
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
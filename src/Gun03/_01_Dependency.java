package Gun03;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_Dependency {


    @Test()
    void startCar() {
        System.out.println("startCar");
        Assert.fail();
    }

    @Test(dependsOnMethods = {"startCar"})
    void driveCar() {
        System.out.println("driveCar");
    }

    @Test(dependsOnMethods = {"driveCar", "driveCar"})
    void parkCar() {
        System.out.println("parkCar");
    }

    //alwaysRun true bağımlılıkları var ama hata çıkarsa da yine çalışır
    @Test(dependsOnMethods = {"parkCar"}, alwaysRun = true)
    void stopCar() {
        System.out.println("stopCar");
    }
    // aynı seviyedeki testler için priority verilebilir.
    // bağımlı testler, direkt metodundan çalıştırdığınızda bağımlı olduğu metod zincirinde
    // 2 üste kadar ototmatik çağırıp çalışabilir.
}

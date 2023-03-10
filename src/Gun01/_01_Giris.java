package Gun01;

import org.testng.annotations.Test;

public class _01_Giris {
    @Test(priority = 1)
    public void webSitesiniAc(){
        System.out.println("web sitesi açıldı");



    }
    @Test(priority = 2)
    public void loginIleminiYap(){
        System.out.println("login işlemini yap");





    }
    @Test (priority = 3)
    public void driveriKapat(){
        System.out.println("driver kapatıldı");
    }
}

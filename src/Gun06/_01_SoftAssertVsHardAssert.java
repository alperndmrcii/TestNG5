package Gun06;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _01_SoftAssertVsHardAssert {
    @Test
    void hardAssert() {
        String s1 = "Merhaba";
        System.out.println("Hard Assert Öncesi ");
        Assert.assertEquals("Merhaba", s1, "Oluşan ile beklenen eşit değil.");
        System.out.println("Hard Assert Sonrası ");
    }

    @Test
    void softAssert() {
        String strHomePage="www.facebook.com/homepage";
        String strCartPage="www.facebook.com/cartpage";
        String strEditAccount="www.facebook.com/editaccountpage";
        SoftAssert _softAssert=new SoftAssert();
        _softAssert.assertEquals("www.facebook.com/homepage", strHomePage); // true
        System.out.println("Assert 1 ");
        _softAssert.assertEquals("www.facebook.com/profile", strCartPage); // false
        System.out.println("Assert 2 ");
        _softAssert.assertEquals("www.facebook.com/settings", strEditAccount); // false
        System.out.println("Assert 3 ");
        _softAssert.assertAll(); // bütün sonuçları işleme koyuyor
        System.out.println("Soft Assert All aktiflik sonrası");
        // Bu Bölüm assertAll'dan sonra olduğu ve öncesinde hata oluştuğu için ekrana çıkmayacak.

    }
}

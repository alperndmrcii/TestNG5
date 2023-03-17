package Gun06;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_PlaceOrder extends BaseDriver {
    /*
   Senaryo :
   1- Siteyi açınız.
   2- Sitede "ipod" kelimesini aratınız
   3- Çıkan sonuçlardan ilkini sepete atınız.
   4- Shopping Chart a tıklatınız.
   5- Checkout yapınız.
   6- Continue butonalarına tıklatıp bilgileri giriniz.
   7- En confirm ile siparişi verdiğinizi doğrulayınız.
      doğrulamayı çıkan sayfadaki "Your order has been placed" yazısı ile yapınız.
*/

    @Test
    void Test1() {
        _03_PlaceOrderElements elements=new _03_PlaceOrderElements();

        elements.searchBox.sendKeys("ipod");
        elements.searchBtn.click();
        elements.addToCart.click();
        elements.shoppingCart.click();
        elements.checkOutBtn.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.continue1)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.continue2)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.continue3)).click();
        elements.termsCondition.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.continue4)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.confirmOrder)).click();

        wait.until(ExpectedConditions.urlContains("success"));
        Assert.assertEquals(elements.message.getText(), "Your order has been placed!", "Onay texti bulunamadı");


    }
}

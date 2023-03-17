package Gun06;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _02_PlaceOrder extends BaseDriver {
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
   void Test1(){
       WebElement searchBox= driver.findElement(By.name("search"));
       searchBox.sendKeys("ipod");
       WebElement searchBtn=driver.findElement(By.cssSelector("[class='btn btn-default btn-lg']"));
       searchBtn.click();
       WebElement addToCart= driver.findElement(By.xpath("//span[text()='Add to Cart']"));
       addToCart.click();
       WebElement shoppingCart=driver.findElement(By.linkText("Shopping Cart"));
       shoppingCart.click();
       WebElement checkOutBtn=driver.findElement(By.linkText("Checkout"));
       checkOutBtn.click();

       wait.until(ExpectedConditions.elementToBeClickable(By.id("button-payment-address")));

     WebElement continue1=driver.findElement(By.xpath("//*[@id='button-payment-address']"));
     continue1.click();
     WebElement continue2=driver.findElement(By.xpath("//*[@id='button-shipping-address']"));
     continue2.click();
     WebElement continue3=driver.findElement(By.xpath("//*[@id='button-shipping-method']"));
     continue3.click();
     WebElement termsCondition=driver.findElement(By.xpath("//*[@type='checkbox']"));
     termsCondition.click();
     WebElement continue4=driver.findElement(By.xpath("//*[@id='button-payment-method']"));
     continue4.click();
     WebElement confirmOrder=driver.findElement(By.xpath("//*[@id='button-confirm']"));
     confirmOrder.click();
     wait.until(ExpectedConditions.urlContains("success"));
     WebElement message=driver.findElement(By.cssSelector("[id='content']>h1"));
     Assert.assertEquals(message.getText(),"Your order has been placed!","Onay texti bulunamadı");


   }
}

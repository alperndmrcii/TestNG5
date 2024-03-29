package Gun07;

import Utility.BaseDriver;
import Utility.BaseDriverParameter;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class _01_WishList extends BaseDriver {
    /**
     * Senaryo ;
     * 1- Siteye gidiniz..
     *
     * 1.Test;
     * 2- "ipod" ürününü aratınız."ipod" u xml den gönderiniz
     * 3- çıkan elamnlardan random bir elelamnı Add Wish butonuna tıklayınız.
     * 4- Daha sonra WishList e tıklatınız
     * 5- Burada çıkan ürünle tıklanan ürünün isminin aynı olup olmadığını doğrulayınız.
     */
    @Test
    @Parameters("aranacakKelime")
    void addToWishList(String text){

        WebElement searchInput= driver.findElement(By.cssSelector("[name='search']"));
        searchInput.sendKeys(text);

        WebElement searchButton= driver.findElement(By.cssSelector("[class='btn btn-default btn-lg']"));
        searchButton.click();

        List<WebElement> searhResult=driver.findElements(By.cssSelector("div[class='caption']>h4>a"));
        int randomSecim= Tools.RandomGenerator(searhResult.size()); // 0,1,2,3
        String wishItemText=searhResult.get(randomSecim).getText(); // tıklatılacak elemanın ismini aldım
        System.out.println("wishItemText = " + wishItemText);

        List<WebElement> wishBtnList=driver.findElements(By.xpath("//button[@data-original-title='Add to Wish List']"));
        wishBtnList.get(randomSecim).click();  // random elementin wish listine tıklattım

        WebElement btnWisthProducts=driver.findElement(By.id("wishlist-total"));
        btnWisthProducts.click();

        List<WebElement> wishTableNames = driver.findElements(By.cssSelector("[class='text-left']>a"));

        // wishItemText  i  wishTableNames  ın gettext lerinde varmı diye kontrol edeceğim.
        Tools.listContainsString(wishTableNames, wishItemText);

    }





}

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
    void Test1(String text) {
        WebElement searchInput= driver.findElement(By.cssSelector("[name='search']"));
        searchInput.sendKeys(text);

        WebElement searchButton= driver.findElement(By.cssSelector("[class='btn btn-default btn-lg']"));
        searchButton.click();

        List<WebElement> searchResult = driver.findElements(By.cssSelector("div[class='caption']>h4>a"));

        int randomSecim=Tools.RandomGenerator(searchResult.size()); // 0-1-2-3
        String wishItemText=searchResult.get(randomSecim).getText(); // tıklatılacak elemanın ismini aldım
        System.out.println(wishItemText);

        List<WebElement> wishBtnList= driver.findElements(By.xpath("//button[@data-original-title='Add to Wish List']"));
        wishBtnList.get(randomSecim).click(); // random elementin wishlistine tıklattım.

        WebElement btnWishList=driver.findElement(By.id("wishlist-total"));
        btnWishList.click();
        List<WebElement> wishTableNames=driver.findElements(By.cssSelector("[class='text-left']>a"));





    }
}

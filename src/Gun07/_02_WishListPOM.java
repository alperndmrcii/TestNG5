package Gun07;

import Gun06._03_PlaceOrderElements;
import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _02_WishListPOM extends BaseDriver {
    @Test
    @Parameters("aranacakKelime")
    void addToWishList(String text){

        _03_PlaceOrderElements poe=new _03_PlaceOrderElements();
        poe.searchBox.sendKeys(text);
        poe.searchBtn.click();
        WishListElements wle=new WishListElements();
        int randomSecim= Tools.RandomGenerator(wle.searchResult.size());
        String wishItemText=wle.searchResult.get(randomSecim).getText();
        wle.wishBtnList.get(randomSecim).click();
        wle.btnWishProducts.click();
        Tools.listContainsString(wle.wishTableNames, wishItemText);

    }
}

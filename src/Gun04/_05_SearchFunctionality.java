package Gun04;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class _05_SearchFunctionality extends BaseDriver {
    @Test
    void SearchFuntion(){
        WebElement searchInput= driver.findElement(By.cssSelector("[name='search']"));
        searchInput.sendKeys("mac");
        WebElement searchButton=driver.findElement(By.cssSelector("[class='btn btn-default btn-lg'"));
        searchButton.click();

        List<WebElement> captions=driver.findElements(By.cssSelector("div[class='caption']>h4"));
        for (WebElement e : captions)
            Assert.assertTrue(e.getText().toLowerCase().contains("mac"));
    }
}

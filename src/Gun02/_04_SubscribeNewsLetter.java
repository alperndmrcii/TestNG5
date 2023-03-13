package Gun02;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class _04_SubscribeNewsLetter extends BaseDriver {
    /*
    1-Siteyi Açınız
    2- newsletter subscribe işlemii yapınız(YES)
     */
    By link=By.linkText("Newsletter");

    By subYes=By.xpath("//input[@value='1']");

    By subNo=By.xpath("//input[@value='0']");

    By cntBtn=By.xpath("//input[@value='Continue']");

    @Test(priority = 1)
    void sucscribeFunctionYes(){
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        WebElement email=driver.findElement(By.id("input-email"));
        email.sendKeys("asdasdasd123@gmail.com");
        WebElement password= driver.findElement(By.id("input-password"));
        password.sendKeys("asdasd123");
        WebElement loginBtn=driver.findElement(By.xpath("//input[@type='submit']"));
        loginBtn.click();
        Tools.Bekle(2);
        WebElement newsLetterLink= driver.findElement(link);
        newsLetterLink.click();
        WebElement subscribeYes=driver.findElement(subYes);
        subscribeYes.click();
        WebElement continueButton=driver.findElement(cntBtn);
        continueButton.click();

        Tools.successMessageValidation();

    }
    @Test(priority = 2)
    void subsscribeFunctionNo(){

        WebElement newsLetterLink= driver.findElement(link);
        newsLetterLink.click();
        WebElement subscribeNo=driver.findElement(subNo);
        subscribeNo.click();
        WebElement continueButton=driver.findElement(cntBtn);
        continueButton.click();

        Tools.successMessageValidation();
    }
    @Test(priority = 3)
    void subscribeFunctionForBoth(){


        WebElement newsLetterLink= driver.findElement(link);
        newsLetterLink.click();
        WebElement subscribeYes=driver.findElement(subYes);
        WebElement subscribeNo=driver.findElement(subNo);
        if (subscribeYes.isSelected())
            subscribeNo.click();
        else
            subscribeYes.click();

        WebElement continueButton=driver.findElement(cntBtn);
        continueButton.click();

       Tools.successMessageValidation();

    }
}

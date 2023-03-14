package Gun04;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _04_ContactUs extends BaseDriver {
    /*
  1- ContactUs a tıklayınız
  2- Mesaj kutusuna en az 10 karakterlik bir mesaj yazınız.
  3- Submit ettikten sonra Contact US yazısını doğrulayınız.
 */
    @Test
    @Parameters("mesaj")// xml deki parametre adı aynı olmak zorunda
    void contactUs(String gelenMesaj){
        // String gelenMesaj:metod için gerekli tanımlama aynı olmak zorunda değil
     //  driver.get("https://opencart.abstracta.us/index.php?route=account/login");
     //  WebElement email = driver.findElement(By.xpath("//*[@name='email']"));
     //  email.sendKeys("asdasdasd123@gmail.com");
     //  WebElement password = driver.findElement(By.xpath("//*[@name='password']"));
     //  password.sendKeys("asdasd123");
     //  WebElement loginBtn = driver.findElement(By.xpath("//*[@value='Login']"));
     //  loginBtn.click();
        WebElement contactUsBtn= driver.findElement(By.linkText("Contact Us"));
        contactUsBtn.click();

        WebElement enquiryArea= driver.findElement(By.id("input-enquiry"));
        enquiryArea.sendKeys(gelenMesaj);

        WebElement submitButton= driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("success"));
    }

    }


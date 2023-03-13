package Gun02;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_Ornek extends BaseDriver {
    @Test
    void LoginTest(){

        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        WebElement email=driver.findElement(By.id("input-email"));
        email.sendKeys("asdasdasd123@gmail.com");
        WebElement password= driver.findElement(By.id("input-password"));
        password.sendKeys("asdasd123");
        WebElement loginBtn=driver.findElement(By.xpath("//input[@type='submit']"));
        loginBtn.click();

        Assert.assertTrue(driver.getTitle().equals("My Account"));
    }
}

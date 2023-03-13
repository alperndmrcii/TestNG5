package Gun03;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

public class _02_AdressFunctionality extends BaseDriver {
    /*
       Senaryo;
       1- Siteyi açınız.
       2- Adress Ekleyiniz.
       3- En son adresi edit yaparak ad ve soyadı değiştirip kaydediniz.
       4- En son adresi siliniz.
 */
    @Test
    void addAddress() {
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        WebElement email = driver.findElement(By.xpath("//*[@name='email']"));
        email.sendKeys("asdasdasd123@gmail.com");
        WebElement password = driver.findElement(By.xpath("//*[@name='password']"));
        password.sendKeys("asdasd123");
        WebElement loginBtn = driver.findElement(By.xpath("//*[@value='Login']"));
        loginBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlToBe("https://opencart.abstracta.us/index.php?route=account/account"));
        WebElement addressBook = driver.findElement(By.xpath("//*[text()='Address Book']"));
        addressBook.click();
        WebElement newAddress = driver.findElement(By.xpath("//*[text()='New Address']"));
        newAddress.click();
        wait.until(ExpectedConditions.urlToBe("https://opencart.abstracta.us/index.php?route=account/address/add"));
        WebElement firstName = driver.findElement(By.xpath("//*[@name='firstname']"));
        firstName.sendKeys("Alperen");
        WebElement lastName = driver.findElement(By.xpath("//*[@name='lastname']"));
        lastName.sendKeys("Demirci");
        WebElement company = driver.findElement(By.xpath("//*[@name='company']"));
        company.sendKeys("Techno Study");
        WebElement adress1 = driver.findElement(By.xpath("//*[@name='address_1']"));
        adress1.sendKeys("Izmir /Karabaglar");
        WebElement city = driver.findElement(By.xpath("//*[@name='city']"));
        city.sendKeys("Izmir");
        WebElement postCode = driver.findElement(By.xpath("//*[@name='postcode']"));
        postCode.sendKeys("35150");
        WebElement country = driver.findElement(By.xpath("//*[@name='country_id']"));
        Select countrySelect = new Select(country);
        countrySelect.selectByVisibleText("Turkey");
        wait.until(ExpectedConditions.elementToBeClickable(country));
        WebElement region = driver.findElement(By.xpath("//*[@name='zone_id']"));
        Select regionSelect = new Select(region);
        regionSelect.selectByIndex(7);
        WebElement defaultAdress = driver.findElement(By.xpath("//input[@value='1']"));
        defaultAdress.click();
        // stale element hatası = tez buldum erken kaybettim.
        // selectByvisibleText, selectByValue : findelement bgibi çalıştığından implicitly waiti kullanır
        /// selectByIndex : implicitlyWait ile çalışmıyor ancak explicitlyWait ile çalışır.
        WebElement cntinueBtn = driver.findElement(By.xpath("//*[@value='Continue']"));
        cntinueBtn.click();
        Tools.successMessageValidation();
    }

    @Test(dependsOnMethods = {"addAddress"})
    void editAddress() {
        WebElement addressBook = driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        List<WebElement> editAll = driver.findElements(By.linkText("Edit"));
        WebElement sonEdit = editAll.get(editAll.size() - 1); // son edit
        sonEdit.click();

        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.clear();
        firstName.sendKeys("İsmet1");

        WebElement lastname = driver.findElement(By.id("input-lastname"));
        lastname.clear();
        lastname.sendKeys("Temur1");

        WebElement region = driver.findElement(By.xpath("//*[@name='zone_id']"));
        Select regionSelect = new Select(region);
        regionSelect.selectByIndex(7);

        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();

        Tools.successMessageValidation();


    }

    @Test(dependsOnMethods = {"editAddress"})
    void deleteAddress() {
        WebElement addressBook = driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        List<WebElement> editAll = driver.findElements(By.linkText("Delete"));
        WebElement silinebilirAdres = editAll.get(editAll.size() - 2);
        silinebilirAdres.click();
        Tools.successMessageValidation();

    }
}

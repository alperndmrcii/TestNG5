package Gun06;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class _03_PlaceOrderElements {
   // page object model
    // Bu sayfadaki bütün elemenalrın driverlar bağlantısı gerekiyor
    // bunun için aşağıdaki consructor eklendi ve için PageFatory ile
    // driver üzerinden bu (this) sayfadaki bütün elemnalar ilşkilendirildi.
    // Böylece Sayfadadan nesne türetildiği zaman değil, kullanıldığı
    // anda elemanların bulunması aktif oluyor.Bu yöntemle bütün sayfalarda
    // aynı isimde elemanlar var ise buradaki tanımlama hepsi için geçerli hale
    // gelmiş oluyor. buna yapıya Page Object Model (POM) adı veriliyor.
    public _03_PlaceOrderElements() {
        PageFactory.initElements(BaseDriver.driver,this);
        // driver.findElementi hepsi için yaptı
    }

    @FindBy(name="search")
    public WebElement searchBox;
    @FindBy(css = "[class='btn btn-default btn-lg']")
    public WebElement searchBtn;
    @FindBy(xpath = "//span[text()='Add to Cart']")
    public WebElement addToCart;
    @FindBy(linkText = "Shopping Cart")
    public WebElement shoppingCart;
    @FindBy(linkText = "Checkout")
    public WebElement checkOutBtn;
    @FindBy(xpath = "//*[@id='button-payment-address']")
    public WebElement continue1;
    @FindBy(xpath = "//*[@id='button-shipping-address']")
    public WebElement continue2;
    @FindBy(xpath = "//*[@id='button-shipping-method']")
    public WebElement continue3;
    @FindBy(xpath = "//*[@type='checkbox']")
    public WebElement termsCondition;
    @FindBy(xpath = "//*[@id='button-payment-method']")
    public WebElement continue4;
    @FindBy(xpath = "//*[@id='button-confirm']")
    public WebElement confirmOrder;
    @FindBy(css = "[id='content']>h1")
    public WebElement message;

}

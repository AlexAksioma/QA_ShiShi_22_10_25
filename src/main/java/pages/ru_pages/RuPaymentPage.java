package pages.ru_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import pages.BasePage;

public class RuPaymentPage extends BasePage {
    @FindBy(xpath = "//input[@type='email']")
    WebElement email;

    @FindBy(xpath = "//input[@name='first_name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@name='last_name']")
    WebElement lastName;

    @FindBy(xpath = "//input[@name='phone']")
    WebElement phoneNumber;

    @FindBy(xpath = "//input[@name='teuda']")
    WebElement ID;

    @FindBy(xpath = "//select[@name='payment_method']") //div[@class='large-12 cell']//select[@name='payment_method']
    WebElement paymentMethod; // <option value="PayPal">PayPal</option> ; <option value="Credit">Оплата кредитной картой</option>
    @FindBy(xpath = "//select[@name='payment_method']//option[@value='Credit']")
    WebElement creditCardOption;
    @FindBy(xpath = "//select[@name='payment_method']//option[@value='PayPal']")
    WebElement payPalOption;
   @FindBy(xpath = "//input[@type='submit']")
   WebElement btnSubmit;


    public RuPaymentPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(
                new AjaxElementLocatorFactory(driver,10), this);
    }
    // ??? how to choose payment methods
    public void buyTicketsToEvent(){
       // open list of payment options
        paymentMethod.click();
        // choose payment option: pay with creditCard -> approve
        creditCardOption.click();
        // click to Submit button and move to: 1- RuPayOptionPage; 2-PayPal website
        btnSubmit.click();
    }


}

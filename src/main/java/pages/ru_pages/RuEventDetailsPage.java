package pages.ru_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import pages.BasePage;

public class RuEventDetailsPage extends BasePage {

    int eventID;
    @FindBy(xpath = "//h1[@class='star']//span")
    WebElement starMarker;

    @FindBy(xpath = "//input[@name='count']")
    WebElement ticketsQuantity;
    @FindBy(xpath = "//select[@name='price']")
    WebElement priceType;  // value=1205 standart; value 1206 MASA
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnTakePart;



    public RuEventDetailsPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(
                new AjaxElementLocatorFactory(driver, 10), this);
    }
    // enter quantity of tickets into field  "ticketsQuantity"
    // choose type of price
    // click on btnTakePart
    // switch to RuPaymentPage - in test

    public void fillEventDetailes(int quantity){                         // !!! add parametre int type
        ticketsQuantity.clear();
        ticketsQuantity.sendKeys(String.valueOf(quantity));
        priceType.click();
        clickElement(btnTakePart);
    }



}

package pages.ru_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import pages.BasePage;

public class RuEventsPage extends BasePage {

    @FindBy(xpath = "//section[@id='content']//span")
    WebElement labelEventPage;

    @FindBy(xpath = "//a[@href='events/2485']//p")
    WebElement eventChoising;
  /*  move to RuEventDetailsPage
    @FindBy(xpath = "//input[@name='count']")
    WebElement ticketsQuantity;
    @FindBy(xpath = "//select[@name='price']")
    WebElement priceType;  // value=1205 standart; value 1206 MASA
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnTakePart;
  */



    public RuEventsPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(
                new AjaxElementLocatorFactory(driver, 20), this);
    }


    public  boolean isPageLoaded(){
        return isWebElementDisplaed(labelEventPage);
    }


   public void eventTakePart(){
         // choose event use event ID = 2485 and click => use WebElement of this event int eventID
       clickElement(eventChoising);
       // switch to new window: method switchToWindowByURL in BasePage => on eventDetailsPage

   }
}

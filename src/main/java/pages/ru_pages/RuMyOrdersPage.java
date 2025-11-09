package pages.ru_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;

public class RuMyOrdersPage extends BasePage {

    @FindBy(xpath = "//h1[@class='star']//span")
    WebElement labelMyOrdersPage;

    @FindBy(xpath = "//a[contains(@href,'auth/payment')]")
    WebElement btnPayment;


    public RuMyOrdersPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(
                new AjaxElementLocatorFactory(driver,10), this);

    }

    public  boolean isPageLoaded(){
       return isWebElementDisplaed(labelMyOrdersPage);
    }


    public  void clickBtnPayment(){
        clickElement(btnPayment);

    }

}




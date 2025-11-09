package pages.ru_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import pages.BasePage;
import utils.PropertiesReader;

public class RuPayOptionPage extends BasePage {
    @FindBy(xpath = "//div[@class='demo-container']//div[@id='credit_card_number']")
    WebElement cardNumber;
    @FindBy(xpath = "//div[@class='demo-container']//div[@id='card_holder_id_number']")
    // @FindBy(xpath = "//div[@class='container-for-hostedfield']")
    WebElement numberID;
    @FindBy(xpath = "//div[@class='demo-container']//div[@id='expiry']")
    WebElement expiryDate;

    @FindBy(xpath = "//div[@class='demo-container']//div[@id='cvv']")
    WebElement cVC;

    @FindBy(xpath = "//div[@class='demo-container']//input[@name='agreement']")
    WebElement agreementCheckBox;

   @FindBy(xpath = "//div[@class='large-6 cell text-right']//button[@type='submit']")
   WebElement btnSubmit;




    public RuPayOptionPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(
                new AjaxElementLocatorFactory(driver,10), this);
    }

    public void authenticateCard(){
        // fill fields:Номер кредитной карты, Удостоверение личности, Срок действия карты, Код на обратной стороне карты:
        // from user.properties
        cardNumber.sendKeys(PropertiesReader.getProperty("user.properties","cardNumber"));
        numberID.sendKeys(PropertiesReader.getProperty("user.properties","ID"));
        expiryDate.sendKeys(PropertiesReader.getProperty("user.properties","expiryDate"));
        cVC.sendKeys(PropertiesReader.getProperty("user.properties","CVC"));

        // check that check-box "Нажимая кнопку оплаты я соглашаюсь с политикой конфиденциальности" is V
        agreementCheckBox.click();
        // click PAY
        btnSubmit.click();




    }


}

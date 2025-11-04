package pages.ru_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import pages.BasePage;

public class RuContactsPage extends BasePage {

    public RuContactsPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(
                new AjaxElementLocatorFactory(driver, 20), this);
    }

    @FindBy(xpath = "//div[@class='large-8 cell']/h2[text()='ПИШИТЕ ПИСЬМА']")
    private WebElement heardForm;

    @FindBy(xpath = "//span[text()='Контактная информация']")
    private WebElement line1;

    public boolean isLine1Displayed(){
        return isElementDisplayed(line1);
    }

    public boolean isHeardFormDisplayed(){
        return isElementDisplayed(heardForm);
    }
}

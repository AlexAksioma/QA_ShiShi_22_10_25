package pages.ru_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import pages.BasePage;

public class RuAboutUsPage extends BasePage {

    public RuAboutUsPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(
                new AjaxElementLocatorFactory(driver, 20), this);
    }

    @FindBy(xpath = "//span[text()='Пресса о нас']")
    private WebElement pressHeader;
    //div[@class='large-12 cell']//h2//span[string-length()=12]

    @FindBy(xpath = "//span[text()='О нас']")
    private WebElement aboutHeader;
    //div[@class='large-12 cell text-center']//h1//span

    @FindBy(xpath = "//span[text()='Команда']")
    private WebElement teamHeader;
    //div[@class='large-12 cell']//h2//span[string-length()=7]

    public boolean isPressHeaderDisplayed() {
        return isElementDisplayed(pressHeader);
    }

    public boolean isAboutHeaderDisplayed() {
        return isElementDisplayed(aboutHeader);
    }

    public boolean isTeamHeaderDisplayed() {
        return isElementDisplayed(teamHeader);
    }



}

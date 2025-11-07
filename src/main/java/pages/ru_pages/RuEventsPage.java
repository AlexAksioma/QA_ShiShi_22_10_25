package pages.ru_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import pages.BasePage;

public class RuEventsPage extends BasePage {

    public RuEventsPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(
                new AjaxElementLocatorFactory(driver, 20), this);
    }

    @FindBy(xpath = "//div[@class='medium-8 large-8 cell text-center']/h1//span[string-length()=11]")
    WebElement eventsHeader;

    @FindBy(xpath = "//p[@class='archive_button']/a[@href='archive/']")
    WebElement buttonArchive;

    @FindBy(xpath = "//form[@action='events']//button[string-length()=5]")
    WebElement buttonSearch;

    public boolean isEventsHeaderDisplayed(){
        return isElementDisplayed(eventsHeader);
    }

    public boolean isButtonArchiveDisplayed(){
        return isElementDisplayed(buttonArchive);
    }

    public boolean isButtonSearchDisplayed(){
        return isElementDisplayed(buttonSearch);
    }
}

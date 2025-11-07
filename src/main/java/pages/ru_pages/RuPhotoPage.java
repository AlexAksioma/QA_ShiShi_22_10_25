package pages.ru_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import pages.BasePage;

public class RuPhotoPage extends BasePage {

    public RuPhotoPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(
                new AjaxElementLocatorFactory(driver, 20), this);
    }

    @FindBy(xpath = "//button[@class='sk-facebook-photo-albums-load-more-posts'][string-length()=13]")
    public WebElement buttonLoadMore;

    @FindBy(xpath = "//h1[@class='star']//span[string-length()=4]")
    public WebElement photoHeader;

//    public boolean isPhotoHeaderDisplayed(){
//        return isElementDisplayed(photoHeader);
//    }


}

package pages.ru_pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import pages.BasePage;

@Getter
public class RuVideoPage extends BasePage {

    public RuVideoPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(
                new AjaxElementLocatorFactory(driver, 20), this);
    }

    @FindBy(xpath = "//h1[@class='star']//span[string-length()=5]")
    WebElement videoHeader;

//    public WebElement getVideoHeader() {
//        return videoHeader;
//    }
}

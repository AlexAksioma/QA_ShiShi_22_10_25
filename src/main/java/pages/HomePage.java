package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static utils.PropertiesReader.*;

@Getter
public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        setDriver(driver);
        driver.get(getProperty("base.properties", "baseUrl"));
        PageFactory.initElements(
                new AjaxElementLocatorFactory(driver, 20), this);
    }

//    @FindBy(xpath = "//a[@href='https://www.jgive.com/new/en/usd/donation-targets/64189']")
    @FindBy(xpath = "//ul[@class='menu align-right  hide-for-small-only']//li//a[@href='https://www.jgive.com/new/en/usd/donation-targets/64189']")
    WebElement btnDonateHeader;



}

package pages.ru_pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import utils.PropertiesReader;

import java.time.Duration;

public class RuLoginPage extends BasePage {
   //@FindBy(xpath ="//section[@id='content']//p[1]//input[@name='identity']")
   @FindBy(xpath = "//input[@name='identity']")
    WebElement emailField;
    //@FindBy(xpath ="//section[@id='content']//p[2]//input[@name='password']")
    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordField;

        @FindBy(xpath ="//section[@id='content']//p[4]//input[@name='submit']")
    WebElement btnEnter;

    @FindBy(xpath ="//section[@id='content']//p[4]//input[@name='submit']")
    WebElement personalAccount;
    public RuLoginPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10), this);
    }

public  void logIn(String email, String password){
    emailField.sendKeys(email);
    passwordField.sendKeys(password);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(btnEnter));
    btnEnter.click();
}


}

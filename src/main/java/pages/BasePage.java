package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.en_pages.*;
import pages.ru_pages.*;
import utils.PropertiesReader;
import utils.enums.HeaderMenuItemsEn;
import utils.enums.HeaderMenuItemsRu;

import java.time.Duration;
import java.util.Set;

public abstract class BasePage {

    public static WebDriver driver;

    public static void setDriver(WebDriver wd) {
        driver = wd;
    }

    public static void pause(int time) {
        try {
            Thread.sleep(time * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T extends BasePage> T clickRuHeaderBtn(HeaderMenuItemsRu item) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(item.getLocator())));
        element.click();
        switch (item) {
            case LOGIN -> {
                return (T) new RuLoginPage(driver);
            }
            case CONTACTS -> {
                return (T) new RuContactsPage(driver);
            }
            case ABOUT_US -> {
                return (T) new RuAboutUsPage(driver);
            }
            case EVENTS -> {
                return (T) new RuEventsPage(driver);
            }
            case PHOTO -> {
                return (T) new RuPhotoPage(driver);
            }
            case VIDEO -> {
                return (T) new RuVideoPage(driver);
            }
            case BTN_CHANGE_LANGUAGE_EN -> {
                return (T) new EnHomePage(driver);
            }

            default -> throw new IllegalArgumentException("Invalid parameter RuHeaderMenuItem");
        }
    }

    public static <T extends BasePage> T clickEnHeaderBtn(HeaderMenuItemsEn item) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(item.getLocator())));
        element.click();
        switch (item) {
            case ABOUT_US -> {
                return (T) new EnAboutUsPage(driver);
            }
            case ACTIVITY_UPDATES -> {
                return (T) new EnActivityUpdatesPage(driver);
            }
            case TEAM -> {
                return (T) new EnTeamPage(driver);
            }
            case OUR_PARTNERS -> {
                return (T) new EnOurPartnersPage(driver);
            }
            case PHOTO -> {
                return (T) new EnPhotoPage(driver);
            }
            case VIDEO -> {
                return (T) new EnVideoPage(driver);
            }
            case CONTACTS -> {
                return (T) new EnContactsPage(driver);
            }
            case BTN_CHANGE_LANGUAGE_RU -> {
                return (T) new HomePage(driver);
            }
            default -> throw new IllegalArgumentException("Invalid parameter EnHeaderMenuItem");
        }
    }


    public  boolean isWebElementDisplaed(WebElement element){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickElement(WebElement element){
       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
       wait.until(ExpectedConditions.visibilityOf(element));
       element.click();
    }

    /**??????
     * switch WebDriver on new window, using URL with eventID.
     * @param expectedUrlSegment - part of URL = eventID ( "https://shishi.co.il/events/2485").
     *                                           baseURL (https://shishi.co.il/) + "events/"+"eventID"
     * @param timeoutInSeconds - max wait time.
     */
    public static void switchToPage(String pageName){
        // 1. String curPage = driver.getWindowHandle(); use curPage in test method for store pageDescriptor
        //2. Create Set contains all Pages
        Set<String> allPagesHandles = driver.getWindowHandles();
        for(String handle: allPagesHandles){
            if(! handle.equals(pageName)){
                driver.switchTo().window(handle);
            }
            break;
        }

    }




}

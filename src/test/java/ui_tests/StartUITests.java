package ui_tests;

import manager.AppManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.en_pages.EnHomePage;
import pages.en_pages.EnPhotoPage;
import pages.ru_pages.*;
import utils.PropertiesReader;
import utils.RetryAnalyzer;
import utils.TestNGListener;
import utils.enums.HeaderMenuItemsEn;
import utils.enums.HeaderMenuItemsRu;

import java.time.Duration;

import static pages.BasePage.*;
import static utils.enums.HeaderMenuItemsRu.EVENTS;
import static utils.enums.HeaderMenuItemsRu.LOGIN;

@Listeners(TestNGListener.class)
public class StartUITests extends AppManager {

    @Test
    public void startUITest(){
        HomePage homePage = new HomePage(getDriver());
        pause(5);
        RuEventsPage ruEventsPage = clickRuHeaderBtn(HeaderMenuItemsRu.EVENTS);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void startUITest1(){
        HomePage homePage = new HomePage(getDriver());
        pause(5);

        EnHomePage enHomePage = clickRuHeaderBtn(HeaderMenuItemsRu.BTN_CHANGE_LANGUAGE_EN);;
        EnPhotoPage enPhotoPage = clickEnHeaderBtn(HeaderMenuItemsEn.PHOTO);

        Assert.fail();
    }

    @Test
    public void takePartEventFull(){
        // click on Header ВХОД/LOGIN item:
        //  fill email and password from user.properties click on btn ENTER/ВХОД use method from RuLoginPage
     HomePage homePage = new HomePage(getDriver());
     clickRuHeaderBtn(LOGIN);
     pause(3);
     RuLoginPage ruLoginPage = new RuLoginPage(getDriver());
     String email = PropertiesReader.getProperty("user.properties", "email");
     String pwd = PropertiesReader.getProperty("user.properties", "password");
     ruLoginPage.logIn(email, pwd);
        RuMyOrdersPage ruMyOrdersPage = new RuMyOrdersPage(getDriver());
        // check that "Мои текущие заказы" open
        Assert.assertTrue(ruMyOrdersPage.isPageLoaded(),"Error of page load");
        // click "Мероприятия" open
        clickRuHeaderBtn(EVENTS);
        RuEventsPage ruEventsPage = new RuEventsPage(getDriver());
        Assert.assertTrue(ruEventsPage.isPageLoaded(),"Error of page load");
        // use method eventTakeParte from RuEventPage
        String curPage = driver.getWindowHandle(); // handle RuEventsPage
        ruEventsPage.eventTakePart();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       //  switch to RuEventDetailsPage
        switchToPage(curPage);
       // wait.until(ExpectedConditions.visibilityOf(starMarker)); // check that RuEventDetailsPage load
         // Количество билетов: 2
        // click btnTakePart
        RuEventDetailsPage ruEventDetailsPage = new RuEventDetailsPage(getDriver());
        curPage = driver.getWindowHandle(); // handle RuEventDetailsPage
        ruEventDetailsPage.fillEventDetailes(2);
        //  switch to RuMyOrderPage
        switchToPage(curPage);
        curPage = driver.getWindowHandle(); // handle RuMyOrdersPage
        //click btn Pay=> open RuPaymentPage
        RuMyOrdersPage ruMyOrdersPage1 = new RuMyOrdersPage(getDriver());
        ruMyOrdersPage1.clickBtnPayment();
        //  switch to RuPaymentPage
        switchToPage(curPage);
        // buy ticket with credit card
        RuPaymentPage ruPaymentPage = new RuPaymentPage(getDriver());
        curPage = driver.getWindowHandle();
        ruPaymentPage.buyTicketsToEvent(); // method from RuPaymentPage
        pause(3);
        switchToPage(curPage);
        RuPayOptionPage ruPayOptionPage = new RuPayOptionPage(getDriver());
        pause(3);
        //Error message "С обработкой вашей карты возникли сложности. Проверьте правильность введенных данных или используйте другую карту."
        //Click OK
        driver.close();
        //driver.switchTo().window();
    }



}

package ui_tests.lev_leon;


import manager.AppManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.ru_pages.*;
import utils.enums.HeaderMenuItemsRu;

import java.time.Duration;

import static pages.BasePage.*;

public class HomeTests_lev extends AppManager {

    HomePage homePage;
    String originalWindows;
    String originalUrl;

    @BeforeMethod
    public void ruHomePage(){
        homePage = new HomePage(getDriver());
        pause(1);
        originalWindows = getDriver().getWindowHandle();
        originalUrl = getDriver().getCurrentUrl();
        System.out.println("originalWindows:" + originalWindows);
    }

    @Test
    public  void ruAboutUs_Test(){
        RuAboutUsPage ruAboutUsPage = clickRuHeaderBtn(HeaderMenuItemsRu.ABOUT_US);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(ruAboutUsPage.isPressHeaderDisplayed(), "Заголовок 'Пресса о нас' не отображается");
        softAssert.assertTrue(ruAboutUsPage.isAboutHeaderDisplayed(), "Заголовок 'О нас' не отображается");
        softAssert.assertTrue(ruAboutUsPage.isTeamHeaderDisplayed(), "Заголовок 'Команда' не отображается");

        softAssert.assertAll();
    }

    @Test
    public void ruContacts_Test(){
        RuContactsPage ruContactsPage = clickRuHeaderBtn(HeaderMenuItemsRu.CONTACTS);
        Assert.assertTrue(ruContactsPage.isHeardFormDisplayed() &&
                ruContactsPage.isLine1Displayed());
    }

    @Test
    public void ruEvents_Test(){
        RuEventsPage ruEventsPage = clickRuHeaderBtn(HeaderMenuItemsRu.EVENTS);
        SoftAssert softAssert = new SoftAssert();
        Assert.assertTrue(ruEventsPage.isEventsHeaderDisplayed());
        Assert.assertTrue(ruEventsPage.isButtonArchiveDisplayed());
        Assert.assertTrue(ruEventsPage.isButtonSearchDisplayed());
        softAssert.assertAll();
    }

    @Test
    public void ruPhoto_Test(){
        RuPhotoPage ruPhotoPage = clickRuHeaderBtn(HeaderMenuItemsRu.PHOTO);
        SoftAssert softAssert = new SoftAssert();
        Assert.assertTrue(ElementIsDisplayed(ruPhotoPage.photoHeader));
        Assert.assertTrue(ElementIsDisplayed(ruPhotoPage.buttonLoadMore));
        softAssert.assertAll();
    }

    @Test
    public void ruVideo_Test(){
        RuVideoPage ruVideoPage = clickRuHeaderBtn(HeaderMenuItemsRu.VIDEO);
        Assert.assertTrue(ElementIsDisplayed(ruVideoPage.getVideoHeader()));
    }

    @Test
    public void ruDonate_Test(){
        SoftAssert softAssert = new SoftAssert();
        try {
            homePage.getBtnDonateHeader().click();
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlContains("jgive.com"));
            softAssert.assertTrue(getDriver().getCurrentUrl().contains("/new/en/usd/donation-targets/64189"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        getDriver().get(originalUrl);
        softAssert.assertAll();
    }
}

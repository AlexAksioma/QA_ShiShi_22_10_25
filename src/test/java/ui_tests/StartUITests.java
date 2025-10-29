package ui_tests;

import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage.*;
import pages.HomePage;
import pages.en_pages.EnHomePage;
import pages.en_pages.EnPhotoPage;
import pages.ru_pages.RuEventsPage;
import utils.RetryAnalyzer;
import utils.enums.HeaderMenuItemsEn;
import utils.enums.HeaderMenuItemsRu;

import static pages.BasePage.*;

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
        EnHomePage enHomePage = clickRuHeaderBtn(HeaderMenuItemsRu.BTN_CHANGE_LANGUAGE_RU);;
        EnPhotoPage enPhotoPage = clickEnHeaderBtn(HeaderMenuItemsEn.PHOTO);
        Assert.fail();
    }
}

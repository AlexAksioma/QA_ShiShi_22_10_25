package ui_tests.lev_leon;


import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.ru_pages.RuAboutUsPage;
import pages.ru_pages.RuContactsPage;
import utils.enums.HeaderMenuItemsRu;

import static pages.BasePage.clickRuHeaderBtn;
import static pages.BasePage.pause;

public class HomeTests_lev extends AppManager {

    HomePage homePage;

    @BeforeMethod
    public void ruHomePage(){
        HomePage homePage = new HomePage(getDriver());
        pause(1);
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
}

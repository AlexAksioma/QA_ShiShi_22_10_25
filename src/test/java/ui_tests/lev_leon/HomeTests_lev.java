package ui_tests.lev_leon;


import manager.AppManager;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.ru_pages.RuAboutUsPage;
import pages.ru_pages.RuEventsPage;
import utils.enums.HeaderMenuItemsRu;

import static pages.BasePage.clickRuHeaderBtn;
import static pages.BasePage.pause;

public class HomeTests_lev extends AppManager {

    @Test
    public  void AboutUs_Test(){
        HomePage homePage = new HomePage(getDriver());
        pause(1);
        RuAboutUsPage ruAboutUsPage = clickRuHeaderBtn(HeaderMenuItemsRu.ABOUT_US);
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(ruAboutUsPage.isPressHeaderDisplayed(), "Заголовок 'Пресса о нас' не отображается");
        softAssert.assertTrue(ruAboutUsPage.isAboutHeaderDisplayed(), "Заголовок 'О нас' не отображается");
        softAssert.assertTrue(ruAboutUsPage.isTeamHeaderDisplayed(), "Заголовок 'Команда' не отображается");

        softAssert.assertAll();
    }
}

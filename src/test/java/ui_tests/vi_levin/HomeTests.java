package ui_tests.vi_levin;

import manager.AppManager;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.ru_pages.RuContactsPage;
import utils.TestNGListener;
import utils.enums.HeaderMenuItemsRu;
import static pages.BasePage.clickRuHeaderBtn;
import static pages.BasePage.pause;

@Listeners(TestNGListener.class)

public class HomeTests extends AppManager {

    private SoftAssert softAssert;

    @Test
    public void firstTest(){
            HomePage homePage = new HomePage(getDriver());
    pause(5);
    RuContactsPage ruContactsPage = clickRuHeaderBtn(HeaderMenuItemsRu.CONTACTS);
    }

}

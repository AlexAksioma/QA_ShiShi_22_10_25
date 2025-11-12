package utils.enums;

public enum HeaderMenuItemsRu {
    EVENTS("//ul[@class='menu align-right hide-for-small-only']//li[@class=’first’][1]"),
    PHOTO("//ul[@class='menu align-right  hide-for-small-only']//li[@class=’first’][2]"),
    VIDEO("//ul[@class='menu align-right  hide-for-small-only']// li[@class=’first’][3]"),
    ABOUT_US("//ul[@class='menu align-right  hide-for-small-only']// li[@class=’first’][4]"),
    CONTACTS("//ul[@class='menu align-right  hide-for-small-only']// li[@class=’first’][5]"),
    BTN_CHANGE_LANGUAGE_EN("//section[@id='header']//li[last()-1]/a");
    private final String locator;

    HeaderMenuItemsRu(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return locator;
    }
}

package elements;

import actions.IBottomBar;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class BottomBarElements implements IBottomBar {
    public BookMarkElements bookMarkElements;

    public BottomBarElements(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        bookMarkElements = new BookMarkElements(driver);
    }

    @AndroidFindBy(id = "home")
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeTabBar[1]/XCUIElementTypeButton[1]")
    public MobileElement homeTab;

    @AndroidFindBy(id = "find")
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeTabBar[1]/XCUIElementTypeButton[2]")
    public MobileElement sectionTab;

    @iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeTabBar[1]/XCUIElementTypeButton[3]")
    public MobileElement searchTab;

    @AndroidFindBy(id = "bookmarks")
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeTabBar[1]/XCUIElementTypeButton[4]")
    public MobileElement bookMarkTab;

    @AndroidFindBy(id = "settings")
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeTabBar[1]/XCUIElementTypeButton[5]")
    public MobileElement settingTab;


    @Override
    public void homeTabClick() {
        homeTab.click();
    }

    @Override
    public void sectionTabClick() {
        sectionTab.click();
    }

    @Override
    public void searchTabClick() {
        if (!Utils.isAndroidPlatform()) {
            searchTab.click();
        }
    }

    @Override
    public void bookMarkTabClick() {
        bookMarkTab.click();
//        if (Utils.isAndroidPlatform()) {
//            bookMarkElements.clickLogin();
//        }
    }

    @Override
    public void settingTabClick() {
        settingTab.click();
    }
}

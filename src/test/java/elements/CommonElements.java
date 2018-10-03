package elements;

import actions.ICommon;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Utils;

public class CommonElements implements ICommon {

    public CommonElements(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "shareIC")
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeButton[3]")
    public MobileElement btnShare;

    @AndroidFindBy(id = "bookmarkIC")
    @iOSFindBy(xpath = "//XCUIElementTypeCell[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeButton[2]")
    public MobileElement btnBookmark;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Gmail']")
    @iOSFindBy(id = "Reminders")
    public MobileElement selectShareGmailItem;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'subject')]")
    public MobileElement shareGmailTitle;

    @AndroidFindBy(id = "com.google.android.gms:id/account_display_name")
    public MobileElement googleClientLogin;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Gmail']")
    public MobileElement gmailShareBox;

    //========================================================================================//
    //Bottom Bar Elements

    @iOSFindBy(xpath = "//XCUIElementTypeTabBar")
    public MobileElement bottomTab;

    @AndroidFindBy(id = "home")
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeTabBar[1]/XCUIElementTypeButton[1]")
    public MobileElement homeTab;

    @AndroidFindBy(id = "find")
    @iOSFindBy(xpath = "//XCUIElementTypeTabBar/XCUIElementTypeButton[2]")
    public MobileElement sectionTab;

    @AndroidFindBy(id = "bookmarks")
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeTabBar[1]/XCUIElementTypeButton[4]")
    public MobileElement bookMarkTab;

    @AndroidFindBy(id = "settings")
    @iOSFindBy(xpath = "//XCUIElementTypeTabBar/XCUIElementTypeButton[5]")
    public MobileElement settingTab;

    @iOSFindBy(xpath = "//XCUIElementTypeTabBar/XCUIElementTypeButton[3]")
    public MobileElement searchTab;
    //========================================================================================//


    @Override
    public void selectShareGmailItemClick() {
        selectShareGmailItem.click();
    }

    @Override
    public void assertTitleResult(String expected, String actual) {
        Assert.assertEquals(expected, actual);
    }

    @Override
    public String getShareGmailTitle() {
        return shareGmailTitle.getText();
    }

    @Override
    public void clickLogin() {
        if (googleClientLogin != null) {
            googleClientLogin.click();
        }
    }

    @Override
    public void buttonShareClick() {
        btnShare.click();
    }

    @Override
    public void buttonBookmarkClick() {
        btnBookmark.click();
        clickLogin();
    }

    @Override
    public void gmailShareBoxClick() {
        gmailShareBox.click();
    }


    //========================================================================================//
    //Bottom Bar Actions
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
        if (Utils.isAndroidPlatform()) {
            if(googleClientLogin.isDisplayed()==true){
                clickLogin();
            }

        }
    }

    @Override
    public void settingTabClick() {
        settingTab.click();
    }
    //========================================================================================//

}

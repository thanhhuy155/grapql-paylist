package elements;

import actions.ISetting;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Constants;

public class SettingElements implements ISetting {

    public SettingElements(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Notifications']")
    @iOSFindBy(id = "Notifications")
    public MobileElement notificationMenu;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Notifications')]")
    public MobileElement notificationSetting;

    @iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[1]/XCUIElementTypeSwitch[1]")
    public MobileElement allowNotification;

    @iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[3]/XCUIElementTypeStatusBar[1]/XCUIElementTypeOther[2]/XCUIElementTypeButton[1]")
    public MobileElement backPhilly;

    @iOSFindBy(id = "Off")
    public MobileElement notificationResult;

    @iOSFindBy(id = "About")
    public MobileElement about;

    @iOSFindBy(id = Constants.SETTING_TITLE.TERMS_OF_USE)
    public MobileElement termsofUse;

    @iOSFindBy(id = Constants.SETTING_TITLE.PRIVACY_POLICY)
    public MobileElement privacyPolicy;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='About Philadelphia Media Network']")
    @iOSFindBy(id = Constants.SETTING_TITLE.ABOUT_PHILADELPHIA_MEDIA_NETWORK)
    public MobileElement aboutPMN;

    @iOSFindBy(id = "More Apps From PMN")
    public MobileElement moreAppsFromPMN;

    @iOSFindBy(id = Constants.SETTING_TITLE.THE_PHILADELPHIA_INQUIRER)
    public MobileElement thePhiladelphiaInquirer;

    @iOSFindBy(id = Constants.SETTING_TITLE.PHILLY_SPORTS_NEWS)
    public MobileElement thePhillySportsNews;

    @iOSFindBy(id = Constants.SETTING_TITLE.THE_PHILADELPHIA_INQUIRER_REPLICA)
    public MobileElement thePhiladelphiaInquirerReplica;

    @iOSFindBy(id = Constants.SETTING_TITLE.THE_PHILADELPHIA_INQUIRER_REPLICA_NJ_EDITION)
    public MobileElement thePhiladelphiaInquirerReplicaNJEdition;

    @iOSFindBy(id = Constants.SETTING_TITLE.THE_PHILADELPHIA_DAILY_NEWS_REPLICA)
    public MobileElement thePhiladelphiaDailyNewsReplica;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@value='Philly.com 2.3.4 (127)  © Copyright 2018 Philadelphia Media Network (Digital), LLC']")
    public MobileElement versionApp;

    @Override
    public void notificationMenuClick() {
        notificationMenu.click();
    }

    @Override
    public void notificationSettingClick() {
        notificationSetting.click();
    }

    @Override
    public void allowNotificationClick() {
        allowNotification.click();
    }

    @Override
    public void backToPhillyApp() {
        backPhilly.click();
    }

    @Override
    public void aboutClick() {
        about.click();
    }

    @Override
    public void moreAppsFromPMNClick() {
        moreAppsFromPMN.click();
    }

    @Override
    public String getNotificationSettingTitle() {
        return notificationResult.getText();
    }

    @Override
    public String getAboutPMNTitle() {
        return aboutPMN.getText();
    }

    @Override
    public String getPrivacyPolicyTitle() {
        return privacyPolicy.getText();
    }

    @Override
    public String getTermsofUseTitle() {
        return termsofUse.getText();
    }

    @Override
    public String getPhiladelphiaInquirerTitle() {
        return thePhiladelphiaInquirer.getText();
    }

    @Override
    public String getPhillySportsNewsTitle() {
        return thePhillySportsNews.getText();
    }

    @Override
    public String getPhiladelphiaInquirerReplicaTitle() {
        return thePhiladelphiaInquirerReplica.getText();
    }

    @Override
    public String getPhiladelphiaInquirerReplicaNJEditionTitle() {
        return thePhiladelphiaInquirerReplicaNJEdition.getText();
    }

    @Override
    public String getPhiladelphiaDailyNewsReplicaTitle() {
        return thePhiladelphiaDailyNewsReplica.getText();
    }

    @Override
    public String getAppVersion() {
        return versionApp.getText();
    }

    @Override
    public void assertSettingResult(String expectedResult, String actualResult) {
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Override
    public void assertResult(String expectedResult, String actualResult) {
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}

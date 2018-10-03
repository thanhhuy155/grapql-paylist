package pages;

import elements.CommonElements;
import elements.SettingElements;
import io.appium.java_client.AppiumDriver;
import utils.Constants;
import utils.Utils;

import java.util.Date;

public class SettingTab extends BasePage {
    private SettingElements settingElements;
    private CommonElements commonElements;

    public SettingTab(AppiumDriver driver) {
        super(driver);
        settingElements = new SettingElements(driver);
        commonElements = new CommonElements(driver);
    }

    public void TestCaseNo1() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTabClick();
        settingElements.notificationMenuClick();
        if (!Utils.isAndroidPlatform()) {
            settingElements.notificationSettingClick();
            settingElements.allowNotificationClick();
            settingElements.backToPhillyApp();
            settingElements.assertSettingResult("Off", settingElements.getNotificationSettingTitle());
        }

        closeApp();
    }

    public void TestCaseNo4() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        if (!Utils.isAndroidPlatform()) {
            commonElements.settingTabClick();
            settingElements.aboutClick();
            settingElements.assertSettingResult(Constants.SETTING_TITLE.TERMS_OF_USE, settingElements.getTermsofUseTitle());
            settingElements.assertSettingResult(Constants.SETTING_TITLE.PRIVACY_POLICY, settingElements.getPrivacyPolicyTitle());
            settingElements.assertSettingResult(Constants.SETTING_TITLE.ABOUT_PHILADELPHIA_MEDIA_NETWORK, settingElements.getAboutPMNTitle());
        }

        closeApp();
    }

    public void TestCaseNo5() {

        if (!Utils.isAndroidPlatform()) {
            lauchApp();
            waitForVisibilityOf(commonElements.bottomTab);
            commonElements.settingTabClick();
            settingElements.moreAppsFromPMNClick();
            settingElements.assertSettingResult(Constants.SETTING_TITLE.THE_PHILADELPHIA_INQUIRER, settingElements.getPhiladelphiaInquirerTitle());
            settingElements.assertSettingResult(Constants.SETTING_TITLE.PHILLY_SPORTS_NEWS, settingElements.getPhillySportsNewsTitle());
            settingElements.assertSettingResult(Constants.SETTING_TITLE.THE_PHILADELPHIA_INQUIRER_REPLICA, settingElements.getPhiladelphiaInquirerReplicaTitle());
            settingElements.assertSettingResult(Constants.SETTING_TITLE.THE_PHILADELPHIA_INQUIRER_REPLICA_NJ_EDITION, settingElements.getPhiladelphiaInquirerReplicaNJEditionTitle());
            settingElements.assertSettingResult(Constants.SETTING_TITLE.THE_PHILADELPHIA_DAILY_NEWS_REPLICA, settingElements.getPhiladelphiaDailyNewsReplicaTitle());
            closeApp();
        }
    }

    public void TestCaseNo6() {

        if (!Utils.isAndroidPlatform()) {
            lauchApp();
            waitForVisibilityOf(commonElements.bottomTab);
            commonElements.settingTabClick();

            settingElements.assertResult(Utils.isAndroidPlatform()
                            ? Constants.APP_VERSION.ANDROID : Constants.APP_VERSION.IOS,
                    settingElements.getAppVersion());
            closeApp();
        }
    }

    public void TestCaseNo7() {

        if (!Utils.isAndroidPlatform()) {
            lauchApp();
            waitForVisibilityOf(commonElements.bottomTab);
            commonElements.settingTabClick();

            settingElements.assertResult(String.valueOf(new Date().getYear()),
                    settingElements.getAppVersion());
            closeApp();
        }
    }
}

package pages;

import elements.CommonElements;
import elements.SettingElements;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import utils.Constants;
import utils.Utils;

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
        settingElements.notificationClick();
        if (!Utils.isAndroidPlatform()) {
            Utils.waitForElementVisible(appiumDriver, settingElements.notificationSetting);

            settingElements.notificationSettingClick();
            settingElements.allowNotificationClick();
            settingElements.backToPhillyApp();

            Utils.waitForElementVisible(appiumDriver, settingElements.notificationResult);
            settingElements.assertSettingResult("Off", settingElements.getNotificationSettingTitle());
        }
    }

    public void TestCaseNo3(){
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);

        //Step: Click Settings Tab
        commonElements.settingTabClick();

        //Step: Click Submit Feedback
        settingElements.submitFeedbackLink.click();

        //Step: Click email option
        commonElements.selectGmail(appiumDriver,Constants.GOOGLEACCOUNT_USERNAME,Constants.GOOGLEACCOUNT_PASSWORD);

        Utils.sleep(Constants.SHORTTIME);


        //Verify point: email window opens
        Assert.assertTrue(Utils.checkElementExist(commonElements.gmailComposeScreen));


        //Verify point:
        Assert.assertTrue(commonElements.gmailTo.getText().contains("appteam@philly.com"));
        Assert.assertTrue(commonElements.gmailSubject.getText().contains("Philly.com Android App Support"));
        Assert.assertTrue(commonElements.gmailContent.getText().contains("Model:"));
        Assert.assertTrue(commonElements.gmailContent.getText().contains("Android SDK Number:"));
        Assert.assertTrue(commonElements.gmailContent.getText().contains("Android API Version:"));
        Assert.assertTrue(commonElements.gmailContent.getText().contains("App Version:"));
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
        }
    }

    public void TestCaseNo6() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTabClick();

        Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN, settingElements.appVersion);

        //Step: App Version reflects current app version tested
        settingElements.checkAppVersion(Constants.APP_VERSION.ANDROID, Constants.APP_VERSION.IOS);
    }

    public void TestCaseNo7() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTabClick();

        Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN, settingElements.pmnCopyrightYear);

        //Step: Copyright reflects current year and Philadelphia Media Network (Digital), LLC
        settingElements.checkAppCopyright("The Philadelphia Inquirer, LLC");
    }

    public void Draft(){
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTabClick();
        settingElements.submitFeedbackLink.click();
    }
}

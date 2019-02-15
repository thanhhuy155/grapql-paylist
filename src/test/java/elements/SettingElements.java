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
import utils.Utils;

public class SettingElements extends CommonElements implements ISetting {

    public SettingElements(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Notifications']")
    @iOSFindBy(id = "Notifications")
    public MobileElement notification;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[android.widget.RelativeLayout[android.widget.TextView[contains(@text,'About')]]]")
    @iOSFindBy(id = Constants.SETTING_TITLE.ABOUT_PHILADELPHIA_MEDIA_NETWORK)
    public MobileElement aboutPMN;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[android.widget.TextView[contains(@text,'Submit Feedback')]]")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Submit Feedback')]")
    public MobileElement submitFeedbackLink;

    //========================================================================================//
    @AndroidFindBy(xpath = "//android.view.View[@resource-id='lCol']//android.view.View[contains(@text,'About Philly.com')]")
    public MobileElement aboutPMNMenu;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Version and Build Number')]/following-sibling::android.widget.TextView")
    public MobileElement appVersion;

  // @AndroidFindBy(xpath = "//android.widget.LinearLayout[android.widget.RelativeLayout[android.widget.TextView[contains(@text,'Version and Build Number')]]]/following-sibling::android.widget.LinearLayout//android.widget.TextView[@resource-id='android:id/title']")
    @AndroidFindBy (xpath = "//android.widget.TextView[contains(@text,'Philadelphia Media Network (Digital), LLC')]")
    public MobileElement pmnName;

    //@AndroidFindBy(xpath = "//android.widget.LinearLayout[android.widget.RelativeLayout[android.widget.TextView[contains(@text,'Version and Build Number')]]]/following-sibling::android.widget.LinearLayout//android.widget.TextView[@resource-id='android:id/summary']")
    @AndroidFindBy (xpath = "//android.widget.TextView[contains(@text,'© Copyright')]")
    public MobileElement pmnCopyrightYear;

    @iOSFindBy(id = "Settings")
    @AndroidFindBy (xpath = "//android.widget.TextView[contains(@text,'Settings')]")
    public MobileElement settingsHeading;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Log In or Sign Up')]")
    @AndroidFindBy (xpath = "//android.widget.TextView[contains(@text,'Log In or Sign Up')]")
    public MobileElement logInOrSignUp;

    @AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='android:id/title']")
    public MobileElement signedUpAccount;

    @iOSFindBy(id = "View Account Details")
    @AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='android:id/summary']")
    public MobileElement viewAccountDetails;

    //========================================================================================//
    @iOSFindBy(id = "About")
    public MobileElement about;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Notifications')]")
    public MobileElement notificationSetting;

    @iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[1]/XCUIElementTypeSwitch[1]")
    public MobileElement allowNotification;

    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Return to Philly.com\"]")
    public MobileElement backPhilly;

    @iOSFindBy(id = "Off")
    public MobileElement notificationResult;

    @iOSFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeStaticText")
    public MobileElement appInfo;

    @iOSFindBy(id = Constants.SETTING_TITLE.TERMS_OF_USE)
    public MobileElement termsofUse;

    @iOSFindBy(id = Constants.SETTING_TITLE.PRIVACY_POLICY)
    public MobileElement privacyPolicy;

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

    //========================================================================================//
    @Override
    public void notificationClick() {
        notification.click();
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
        String appVersionNumber;
        if(!Utils.isAndroidPlatform()){
            appVersionNumber = appInfo.getText();
        }
        else {
            appVersionNumber = appVersion.getText();
        }
        return appVersionNumber;
    }

    @Override
    public void assertSettingResult(String expectedResult, String actualResult) {
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Override
    public void assertResult(String expectedResult, String actualResult) {
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Override
    public void checkAppVersion(String androidVersion, String iOSVersion){
        if(!Utils.isAndroidPlatform()){
            assertResult(iOSVersion,getAppVersion());
        }
        else {
            assertSettingResult(androidVersion, getAppVersion());
        }
    }

    @Override
    public void checkAppCopyright(String copyrightText){
        if(!Utils.isAndroidPlatform()){
            assertResult(Utils.getCurrentYear(),appInfo.getText());
            assertResult(copyrightText, appInfo.getText());
        }
        else {
            assertResult(Utils.getCurrentYear(), pmnCopyrightYear.getText());
            assertResult(copyrightText,pmnName.getText());
        }
    }


}

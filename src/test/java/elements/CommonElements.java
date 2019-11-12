package elements;

import actions.ICommon;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Constants;
import utils.Utils;

import java.time.Duration;

public class CommonElements implements ICommon {

    public CommonElements(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //Custom new feed
    @iOSFindBy(id= "What news do you want to see?")
    @AndroidFindBy(id = "banner_custom_news_feed")
    public MobileElement customNewsFeedBanner;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Log in or sign up to')]")
    @AndroidFindBy(id = "bottom_group_login")
    public MobileElement bottomLoginDrawer;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Customize your news feed according to your interests')]")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.TextView")
    public MobileElement bannerMessage;

    @AndroidFindBy(id = "customizeTv")
    public MobileElement customizeOnBannerButton;

    @AndroidFindBy(id = "notNowTv")
    public MobileElement notNowButton;

    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Customize']")
    @AndroidFindBy(id = "homeFeedToggleTv")
    public MobileElement customizeOnFeedButton;

    // @iOSFindBy(id= "What news do you want to see?")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'What news would')]")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tv_intro')]")
    public MobileElement customizeContentScreen;

    @iOSFindBy(id ="closeSmallOverlay")
    @AndroidFindBy(id = "btn_exit")
    public MobileElement customizeScreenExitButton;

    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name = 'Follow All']")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'follow_status_text')]")
    public MobileElement followAll;

    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name = 'Following All']")
    public MobileElement followingAll;

    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name = 'addTopicCard']")
//    @AndroidFindBy(id = "imv_follow_status_icon")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ImageView[contains (@id, 'mv_follow_status_icon')]")
    public MobileElement addTopic;

    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name = 'checkTopicCard']")
    @AndroidFindBy(id = "imv_follow_status_icon")
    public MobileElement checkTopic;

    @iOSFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeStaticText[1]")
    @AndroidFindBy(id = "tv_topic_title")
    public MobileElement topicTitle;

    @iOSFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeStaticText[2]")
    @AndroidFindBy(id = "tv_topic_description")
    public MobileElement topicDescription;

    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name = 'SIGN UP FOR FREE']")
    @AndroidFindBy(id = "btn_signup")
    public MobileElement signupButton;

    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name = 'LOG IN']")
    @AndroidFindBy(id = "btn_login")
    public MobileElement loginButton;

    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name = 'Not now ›']")
    @AndroidFindBy(id = "tv_not_now")
    public MobileElement notNowLink;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Gmail']")
    @iOSFindBy(id = "Reminders")
    public MobileElement gmail;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[android.widget.LinearLayout[android.widget.TextView[contains(@text,'Skype')]]]")
    public MobileElement skypeShareOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'philly.com')]")
    public MobileElement phillyLinkOnSkype;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'subject')]")
    public MobileElement shareGmailTitle;

    @AndroidFindBy(id = "com.google.android.gms:id/account_display_name")
    public MobileElement googleClientLogin;

//    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Gmail']")
//    public MobileElement gmailShareBox;

    @AndroidFindBy (xpath = "//android.widget.TextView[contains(@text,'Share This Article')]")
    public MobileElement shareDialog;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Skype')]")
    public MobileElement skypeShareScreen;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Checking info')]")
    public MobileElement infoCheckingScreen;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    public MobileElement googleAccountTextBox;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='signinconsentNext']")
    public MobileElement googleAccountIAgreeButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='identifierNext']")
    public MobileElement googleAccountNextButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='passwordNext']")
    public MobileElement googleAccountPasswordNextButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.google.android.gms:id/next_button']")
    public MobileElement googleAccountAcceptButton;

//    @AndroidFindBy(xpath = "//android.widget.LinearLayout[android.widget.LinearLayout[android.widget.TextView[contains(@text,'Gmail')]]]")
//    public MobileElement gmail;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[android.widget.TextView[@resource-id='com.google.android.gm:id/to_heading']]//android.widget.MultiAutoCompleteTextView[contains(@text,'appteam@philly.com')]")
    public MobileElement gmailTo;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.google.android.gm:id/subject']")
    public MobileElement gmailSubject;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@resource-id='com.google.android.gm:id/body_wrapper']//android.view.View")
    public MobileElement gmailContent;

   // @AndroidFindBy(xpath = "//android.view.ViewGroup[android.widget.FrameLayout[android.view.ViewGroup[android.widget.TextView[contains(@text,'Compose')]]]]")
    @AndroidFindBy(xpath = "//android.widget.ScrollView[@resource-id='com.google.android.gm:id/compose']")
    public MobileElement gmailComposeScreen;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[android.widget.LinearLayout[android.widget.TextView[contains(@text,'Send Email')]]]")
    public MobileElement sendEmaiPopup;

    //========================================================================================//
    //Gmail
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.google.android.gm:id/welcome_tour_skip']")
    public MobileElement gmailAppSkipBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.google.android.gm:id/action_done']")
    public MobileElement gmailAppTakeMetoGMBtn;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
    public MobileElement gmailAppSelectAccountOKBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.google.android.gm:id/setup_addresses_add_another']")
    public MobileElement gmailAppAddAccountBtn;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[android.widget.TextView[contains(@text,'Google')]]")
    public MobileElement gmailAppGoogleAccountBtn;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.android.vending:id/unauth_home_sign_in_button']")
    public MobileElement playStoreSignInBtn;

    //========================================================================================//

    //========================================================================================//
    //Bottom Bar Elements

    @AndroidFindBy(id="bottomBar")
    @iOSFindBy(xpath = "//XCUIElementTypeTabBar")
    public MobileElement bottomTab;

    @AndroidFindBy(id = "home")
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeTabBar[1]/XCUIElementTypeButton[1]")
    public MobileElement homeTab;

    @AndroidFindBy(id = "find")
    @iOSFindBy(xpath = "//XCUIElementTypeTabBar/XCUIElementTypeButton[2]")
    public MobileElement sectionTab;

    @AndroidFindBy(id = "bookmarks")
    @iOSFindBy(xpath = "//XCUIElementTypeTabBar/XCUIElementTypeButton[4]")
    public MobileElement bookMarkTab;

    @AndroidFindBy(id = "settings")
    @iOSFindBy(xpath = "//XCUIElementTypeTabBar/XCUIElementTypeButton[5]")
    public MobileElement settingTab;

    @iOSFindBy(xpath = "//XCUIElementTypeTabBar/XCUIElementTypeButton[3]")
    public MobileElement searchTab;

    @AndroidFindBy(id = "find")
    @iOSFindBy(xpath = "//XCUIElementTypeTabBar/XCUIElementTypeButton[2]")
    public MobileElement exploreTab;
    //========================================================================================//

    @Override
    public void selectGmail(AppiumDriver appiumDriver, String username, String password) {
        if (Utils.checkElementExist(gmailAppSkipBtn)==true){
            addAccountToGmail(appiumDriver,username, password);
            gmailAppTakeMetoGMBtn.click();
        }
        else {
            gmail.click();
            if (Utils.checkElementExist(gmailAppSkipBtn)==true){
                addAccountToGmail(appiumDriver,username, password);
                gmailAppTakeMetoGMBtn.click();
            }
        }
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

    public enum ShareOptions{
        SKYPE,
        GMAIL
    }

    @Override
    public void shareArticleOn(AppiumDriver appiumDriver, ShareOptions option){
        switch (option){
            case SKYPE:
                if(Utils.checkElementExist(skypeShareOption)==true){
                    skypeShareOption.click();
                }
                else {
                    Utils.scrollToElement(appiumDriver, Utils.DIRECTION.LEFT, skypeShareOption);
                    skypeShareOption.click();
                }
                break;
            case GMAIL:
                selectGmail(appiumDriver,Constants.GOOGLEACCOUNT_USERNAME, Constants.GOOGLEACCOUNT_PASSWORD);
                break;

            default:
                System.out.print("Not support that share option");
                break;
        }
    }

    @Override
    public void signInToGoogleAccount(AppiumDriver appiumDriver, String username, String password){
        Utils.sleep((Constants.SHORTTIME)*3);
        Utils.waitForElementVisible(appiumDriver, googleAccountTextBox);
        googleAccountTextBox.sendKeys(username);
        googleAccountNextButton.click();
        Utils.sleep((Constants.SHORTTIME)*2);
        googleAccountTextBox.sendKeys(password);
        Utils.waitForElementVisible(appiumDriver, googleAccountPasswordNextButton);
        googleAccountPasswordNextButton.click();
        Utils.sleep((Constants.SHORTTIME)*5);
        if (!Utils.checkElementExist(googleAccountIAgreeButton)){
            try {
                appiumDriver.runAppInBackground(Duration.ofSeconds(1));
            }catch (Exception e){

            }
            Utils.sleep((Constants.SHORTTIME)*2);
        }
        else {
            googleAccountIAgreeButton.click();
            Utils.waitForElementVisible(appiumDriver, googleAccountAcceptButton);
            googleAccountAcceptButton.click();
            if (!Utils.checkElementExist(bookMarkTab)&& !Utils.checkElementExist(gmailAppTakeMetoGMBtn)){
                googleAccountAcceptButton.click();
            }

        }
    }

    @Override
    public void addAccountToGmail(AppiumDriver appiumDriver, String username, String password){
            gmailAppSkipBtn.click();
            gmailAppAddAccountBtn.click();
            gmailAppGoogleAccountBtn.click();
            signInToGoogleAccount(appiumDriver, username, password);
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
    public void bookMarkTabClick(AppiumDriver appiumDriver) {
        bookMarkTab.click();
        Utils.sleep((Constants.SHORTTIME)*2);
        if(Utils.isAndroidPlatform()){
            if(Utils.checkElementExist(infoCheckingScreen)==true||Utils.checkElementExist(googleAccountTextBox)==true){
                signInToGoogleAccount(appiumDriver,Constants.GOOGLEACCOUNT_USERNAME, Constants.GOOGLEACCOUNT_PASSWORD);
            }
            else if(Utils.checkElementExist(googleClientLogin)==true){
                googleClientLogin.click();
            }
        }
        Utils.sleep((Constants.SHORTTIME*3));
    }

    @Override
    public void settingTabClick() {
        settingTab.click();
    }

   // public void closeBottomBar(AppiumDriver appiumDriver){
        //do{
            //Utils.scrollScreen(appiumDriver, Utils.DIRECTION.DOWN);
        //}
    //}
    //========================================================================================//
}

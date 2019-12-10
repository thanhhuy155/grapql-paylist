package pages;

import elements.*;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import utils.Constants;
import utils.Utils;

public class CustomizationPage extends BasePage {
    private ArticleDetailElements articleDetailElements;
    private FeedListElements feedListElements;
    private CommonElements commonElements;
    private LoginElements loginElements;
    private SettingElements settingElements;

    public CustomizationPage(AppiumDriver driver) {
        super(driver);
        feedListElements = new FeedListElements(driver);
        articleDetailElements = new ArticleDetailElements(driver);
        commonElements = new CommonElements(driver);
        loginElements = new LoginElements(driver);
        settingElements = new SettingElements(driver);
    }

    //C234
    public void S295_C24353_CU_001_VerifyBannerDisplaysWhenReOpeningApp() {
        //Step: Open the Philly.com App
        appiumDriver.launchApp();

        //Step kill app
        resetApp();

        //Step: Relaunch app
        appiumDriver.launchApp();
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);
        //Verify: banner appears
        Assert.assertTrue(Utils.checkElementExist(commonElements.bannerMessage));
        Assert.assertEquals(Constants.CUSTOMIZATION.BANNER_MESSAGE_ANDROID, commonElements.bannerMessage.getText());
    }

    //C309
    public void TestCaseNo2(){
        //Step: launch app
        appiumDriver.launchApp();
        Utils.sleep(1000);

        //Step:Tap any topics on Customization screen
        String topicId = "imv_follow_status_icon";

        commonElements.addTopic.click();

        //Step: Tap Login
        commonElements.loginButton.click();
        waitForVisibilityOf(loginElements.email);

        //Step: Log into the app with valid
        loginElements.setValue(loginElements.email, Constants.LOGIN_EMAIL);
        loginElements.setValue(loginElements.password, Constants.LOGIN_PASSWORD);
        loginElements.logInButton.click();

        //Step kill app
        resetApp();

        //Step: Relaunch app
        appiumDriver.launchApp();

        //Verify: banner appears
        Assert.assertTrue(Utils.checkElementExist(commonElements.bannerMessage));
        Assert.assertEquals(Constants.CUSTOMIZATION.BANNER_MESSAGE_ANDROID, commonElements.bannerMessage.getText());
    }

    //C310
    public void S295_C24354_CU_002_VerifyBannerDisplaysAfterLoggingInAndReOpeningApp(){
        //Step: launch app
        appiumDriver.launchApp();
        //Step:Tap Close(x) button on Customization screen
        if(Utils.checkElementExist(commonElements.customizeContentScreen)){
            commonElements.customizeScreenExitButton.click();
        }

        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);

        //Step:  Go to Settings tab
        feedListElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        //Step: Tap on "Log In or Sign Up"
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf(loginElements.email);

        //Step: Log into the app with valid
        loginElements.setValue(loginElements.email, Constants.LOGIN_EMAIL);
        loginElements.setValue(loginElements.password, Constants.LOGIN_PASSWORD);
        loginElements.logInButton.click();

        //Step kill app
        resetApp();

        //Step: Relaunch app
        appiumDriver.launchApp();
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);
        //Verify: banner appears
        Assert.assertTrue(Utils.checkElementExist(commonElements.bannerMessage));
        Assert.assertEquals(Constants.CUSTOMIZATION.BANNER_MESSAGE_ANDROID, commonElements.bannerMessage.getText());
    }

    //C12493
    public void S295_C32116_CU_003_VerifyLogInSignUpDrawerDismissesWhenNotLoggedUserUnSelectAllTopic() {
        //Step: Open the Philly.com App
        appiumDriver.launchApp();
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);
        
        //Step:Tap on Customize on banner.
        if(Utils.checkElementExist(commonElements.bannerMessage)) {
            commonElements.customizeOnBannerButton.click();
        }
        waitForVisibilityOf(commonElements.followAll);
        //Step: Tap on "Follow ALl" and  "Following All" on Customization screen
        if(Utils.checkElementExist(commonElements.customizeContentScreen)){
            commonElements.followAll.click();
            if(Utils.checkElementExist(commonElements.bottomLoginDrawer)) {
                Utils.sleep(1000);
                commonElements.followAll.click();
            }
        }

        //Verify:  Log In/Sign Up Drawer dismisses.
        Assert.assertTrue(Utils.checkElementExist(commonElements.customizeContentScreen));
        Assert.assertTrue(Utils.checkElementExist(commonElements.bottomLoginDrawer).equals(false));
    }

    //C240
    public void S295_C32123_CU_004_VerifyUsersCanNotFollowCategoryWithoutLogin () {
        //Step: Open the Philly.com App
        appiumDriver.launchApp();
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);

        //Step:Tap on Customize on banner.
        if(Utils.checkElementExist(commonElements.customizeOnFeedButton)) {
            commonElements.customizeOnFeedButton.click();
        }
        waitForVisibilityOf(commonElements.followAll);
        //Step: Tap on "Follow ALl" and  "Following All" on Customization screen
        if(Utils.checkElementExist(commonElements.customizeContentScreen)){
            commonElements.followAll.click();
        }

        //Verify:  Log In/Sign Up Drawer dismisses.
        Assert.assertTrue(Utils.checkElementExist(commonElements.customizeContentScreen));
        Assert.assertTrue(Utils.checkElementExist(commonElements.bottomLoginDrawer));
    }

    //C263
    public void S295_C32114_CU_005_VerifyBannerDisplaysAtTheTopOfTheScreen() {
        //Step: Open the Philly.com App
        appiumDriver.launchApp();
        //Step:Tap Close(x) button on Customization screen
        if(Utils.checkElementExist(commonElements.customizeContentScreen)){
            commonElements.customizeScreenExitButton.click();
        }
        //Step kill app
        resetApp();

        //Step: Relaunch app
        appiumDriver.launchApp();
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);
        //Verify: banner appears
        Assert.assertTrue(Utils.checkElementExist(commonElements.bannerMessage));
        Assert.assertEquals(Constants.CUSTOMIZATION.BANNER_MESSAGE_ANDROID, commonElements.bannerMessage.getText());
    }

    //C265
    public void S295_C32122_CU_006_VerifyBannerIsDismissedWhenTabOnCloseButtonOnBanner() {
        //Step: Open the Philly.com App
        appiumDriver.launchApp();
        //Step:Tap Close(x) button on Customization screen
        if(Utils.checkElementExist(commonElements.customizeContentScreen)){
            commonElements.customizeScreenExitButton.click();
        }
        //Step kill app
        resetApp();

        //Step: Relaunch app
        appiumDriver.launchApp();
        Utils.sleep(2000);
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);
        commonElements.notNowButton.click();

        //Verify: banner appears
        Assert.assertFalse(Utils.checkElementExist(commonElements.bannerMessage));
    }

    //C264
    public void S295_C32125_CU_007_VerifyCustomizationIsShowWhenTabOnCustomizeButtonOnBanner() {
        //Step: Open the Philly.com App
        appiumDriver.launchApp();
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);

        //Step kill app
        resetApp();

        //Step: Relaunch app
        appiumDriver.launchApp();
        Utils.sleep(2000);
        //Step:Tap on Customize on banner.
        waitForVisibilityOf(commonElements.bannerMessage);
        commonElements.customizeOnBannerButton.click();

        //Verify:   customization screen is show.
        Assert.assertTrue(Utils.checkElementExist(commonElements.customizeContentScreen));
    }

    //    C266
    public void S295_C32126_CU_008_VerifyGeneralBannerFlow () {
        //Step: Open the Philly.com App
        appiumDriver.launchApp();
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);

        //Step kill app
        resetApp();

        //Step: Relaunch app
        appiumDriver.launchApp();
        Utils.sleep(2000);

        //Verify:   customization screen is show.
        Assert.assertTrue(Utils.checkElementExist(commonElements.bannerMessage));
        Assert.assertEquals(Constants.CUSTOMIZATION.BANNER_MESSAGE_ANDROID, commonElements.bannerMessage.getText());
        Assert.assertTrue(Utils.checkElementExist(commonElements.customizeOnBannerButton));
        Assert.assertTrue(Utils.checkElementExist(commonElements.notNowButton));

        //Step:Tap on Customize on banner.
        commonElements.customizeOnBannerButton.click();

        //Verify:   customization screen is show.
        Assert.assertTrue(Utils.checkElementExist(commonElements.customizeContentScreen));

        //Step: Tap on "Follow ALl" and  "Following All" on Customization screen
        if(Utils.checkElementExist(commonElements.customizeContentScreen)){
            commonElements.followAll.click();
        }

        //Verify:  Log In/Sign Up Drawer dismisses.
        Assert.assertTrue(Utils.checkElementExist(commonElements.customizeContentScreen));
        Assert.assertTrue(Utils.checkElementExist(commonElements.bottomLoginDrawer));

        //Step:Tap Close(x) button on Customization screen
        if(Utils.checkElementExist(commonElements.customizeContentScreen)){
            commonElements.customizeScreenExitButton.click();
        }

        //Verify: banner disappears
        Assert.assertFalse(Utils.checkElementExist(commonElements.bannerMessage));
    }

    //    C339
    public void S295_C32132_CU_009_VerifyMyNewsHeaderWhenCustomizeTopicOnCustomizationScreenFromOnBoarding () {
        //Step: Open the Philly.com App
        appiumDriver.launchApp();
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);

        //Step kill app
        resetApp();

        //Step: Relaunch app
        appiumDriver.launchApp();

        waitForVisibilityOf(commonElements.customizeOnBannerButton);
        commonElements.customizeOnBannerButton.click();
        Utils.sleep(2000);

        //Step: Follow one topic on Customization screen
        if(Utils.checkElementExist(commonElements.customizeContentScreen)){
            commonElements.checkTopic.click();
        }

        commonElements.loginButton.click();
        waitForVisibilityOf(loginElements.email);

        //Step: Log into the app with valid
        loginElements.setValue(loginElements.email, Constants.LOGIN_EMAIL);
        loginElements.setValue(loginElements.password, Constants.LOGIN_PASSWORD);
        loginElements.logInButton.click();

        //Step: Tap on GetMyNews Button
        waitForVisibilityOf(commonElements.getMyNewsButton);
        commonElements.getMyNewsButton.click();
        Utils.sleep(5000);

        commonElements = new CommonElements(appiumDriver);

        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);
//        //Step: Relaunch app
//        appiumDriver.launchApp();
//        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);

        //Verify: MyNews on the Home Feed after customized .
        Assert.assertTrue(Utils.checkElementExist(commonElements.myNewsText),"MyNews not display");
    }

    //    C340
    public void S295_C32133_CU_010_VerifyMyNewsHeaderWhenCustomizeTopicOnCustomizationScreenFromSettings () {
        //Step kill app
        resetApp();

        //Step: Relaunch app
        appiumDriver.launchApp();

        //Step:Tap Close(x) button on Customization screen
        if(Utils.checkElementExist(commonElements.customizeContentScreen)){
            commonElements.customizeScreenExitButton.click();
        }

        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);

        //Step:  Go to Settings tab
        feedListElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        //Step:  Tab on Customize My News
        settingElements.customizeMyNews.click();
        waitForVisibilityOf(commonElements.checkTopic);

        //Step: Follow one topic on Customization screen
        if(Utils.checkElementExist(commonElements.customizeContentScreen)){
            commonElements.checkTopic.click();
        }

        commonElements.loginButton.click();
        waitForVisibilityOf(loginElements.email);

        //Step: Log into the app with valid
        loginElements.setValue(loginElements.email, Constants.LOGIN_EMAIL);
        loginElements.setValue(loginElements.password, Constants.LOGIN_PASSWORD);
        loginElements.logInButton.click();

        //Step: Tap on GetMyNews Button
        waitForVisibilityOf(commonElements.getMyNewsButton);
        commonElements.getMyNewsButton.click();
        //Utils.sleep(5000);
        settingElements = new SettingElements(appiumDriver);
        waitForVisibilityOf(settingElements.viewAccountDetails);

        // Verify: The user will directed to the Settings screen
        Assert.assertTrue(Utils.checkElementExist(settingElements.viewAccountDetails),"The user will not directed to the Settings screen");
        feedListElements.homeTab.click();

        //Verify: MyNews on the Home Feed after customized .
        Assert.assertTrue(Utils.checkElementExist(commonElements.myNewsText),"MyNews not display");
    }

    public void S295_C32134_CU_011_VerifyLogInScreenAppearsWhenTappingLogInButton() {
        //Step kill app
        resetApp();
        waitForVisibilityOf(commonElements.checkTopic);

        //Step: Follow one topic on Customization screen
        if(Utils.checkElementExist(commonElements.customizeContentScreen)){
            commonElements.checkTopic.click();
        }

        commonElements.loginButton.click();
        waitForVisibilityOf(loginElements.email);

        //Verify: Verify that Log In screen appears when tapping on "LOG IN" button
        Assert.assertTrue(Utils.checkElementExist(loginElements.email));
        Assert.assertTrue(Utils.checkElementExist(loginElements.password));
    }

    public void S295_C32135_CU_012_VerifySignUpScreenAppearsWhenTappingSignUpButton() {
        //Step kill app
        resetApp();
        waitForVisibilityOf(commonElements.checkTopic);

        //Step: Follow one topic on Customization screen
        if(Utils.checkElementExist(commonElements.customizeContentScreen)){
            commonElements.checkTopic.click();
        }

        commonElements.signupButton.click();
        waitForVisibilityOf(loginElements.signUpButton);

        //Verify: Verify that SignUp screen appears when tapping on "Sign Up" button
        Assert.assertTrue(Utils.checkElementExist(loginElements.confirmPassword));
        Assert.assertTrue(Utils.checkElementExist(loginElements.signUpButton));
    }
}

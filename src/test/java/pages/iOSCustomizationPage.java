package pages;

import elements.*;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import utils.Constants;
import utils.Utils;

public class iOSCustomizationPage extends BasePage {
    private ArticleDetailElements articleDetailElements;
    private FeedListElements feedListElements;
    private CommonElements commonElements;
    private LoginElements loginElements;
    private SettingElements settingElements;

    public iOSCustomizationPage(AppiumDriver driver) {
        super(driver);
        feedListElements = new FeedListElements(driver);
        articleDetailElements = new ArticleDetailElements(driver);
        commonElements = new CommonElements(driver);
        loginElements = new LoginElements(driver);
        settingElements = new SettingElements(driver);
    }

    //C234
    public void S296_C24355_CU_001_VerifyBannerDisplaysWhenReOpeningApp() {
        //Step: Open the Philly.com App
        appiumDriver.launchApp();

        //Step kill app
        resetApp();

        //Step: Relaunch app
        appiumDriver.launchApp();
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);
        //Verify: banner appears
        Assert.assertTrue(Utils.checkElementExist(commonElements.bannerMessage));
        Assert.assertEquals(Constants.CUSTOMIZATION.BANNER_MESSAGE_IOS, commonElements.bannerMessage.getText());
    }

    //C309
    public void TestCaseNo2(){
        //Step: launch app
        appiumDriver.launchApp();
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);

        //Step:Tap any topics on Customization screen
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
        Assert.assertEquals(Constants.CUSTOMIZATION.BANNER_MESSAGE_IOS, commonElements.bannerMessage.getText());
    }

    //C310
    public void S296_C24356_CU_002_VerifyBannerDisplaysAfterLoggingInAndReOpeningApp(){
        //Step: launch app
        appiumDriver.launchApp();
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);

        //Step:Tap Close(x) button on Customization screen
        if(Utils.checkElementExist(commonElements.customizeContentScreen)){
            commonElements.customizeScreenExitButton.click();
        }

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

        if(Utils.checkElementExist(commonElements.bannerNotification)){
            Assert.assertTrue(Utils.checkElementExist(commonElements.bannerNotificationMessage));
            Assert.assertEquals(Constants.CUSTOMIZATION.BANNER_NOTIFICATION_MESSAGE_IOS, commonElements.bannerNotificationMessage.getText());

        } else {
            //Verify: banner appears
            Assert.assertTrue(Utils.checkElementExist(commonElements.bannerMessage));
            Assert.assertEquals(Constants.CUSTOMIZATION.BANNER_MESSAGE_IOS, commonElements.bannerMessage.getText());
        }

    }

    //C12493
    public void S296_C32115_CU_003_VerifyLogInSignUpDrawerDismissesWhenNotLoggedUserUnSelectAllTopic() {
        //Step: Open the Philly.com App
        appiumDriver.launchApp();
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);

        //Step:Tap on Customize
        commonElements.customizeOnFeedButton.click();

        //Step: Tap on "Follow ALl" and  "Following All" on Customization screen
        if(Utils.checkElementExist(commonElements.customizeContentScreen)){
            if(Utils.checkElementExist(commonElements.followAll)) {
                commonElements.followAll.click();
            }
            if(Utils.checkElementExist(commonElements.bottomLoginDrawer)) {
                Utils.sleep(1000);
                commonElements.followingAll.click();
            }
        }

        //Verify:  Log In/Sign Up Drawer dismisses.
        Assert.assertTrue(Utils.checkElementExist(commonElements.customizeContentScreen));
        Assert.assertTrue(Utils.checkElementExist(commonElements.bottomLoginDrawer).equals(false));
    }

    //C240
    public void S296_C32118_CU_004_VerifyUsersCanNotFollowCategoryWithoutLogin () {
        //Step: Open the Philly.com App
        appiumDriver.launchApp();
        //Step:  Go to Settings tab
        feedListElements.settingTab.click();
        waitForVisibilityOf(settingElements.settingsHeading);

        if(Utils.checkElementExist(settingElements.viewAccountDetails)){
            //Click Account
            settingElements.viewAccountDetails.click();
            waitForVisibilityOf(loginElements.logOutButton);

            //Click Logout
            loginElements.logOutButton.click();
            loginElements.logoutDialogBtn.click();
        }
        //Step: Open the Philly.com App
        resetApp();
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
    public void S296_C32113_CU_005_VerifyBannerDisplaysAtTheTopOfTheScreen() {
        //Step: Open the Philly.com App
        appiumDriver.launchApp();
        //Step:Tap Close(x) button on Customization screen
        if(Utils.checkElementExist(commonElements.customizeContentScreen)){
            commonElements.customizeScreenExitButton.click();
        }

        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);
        //Verify: banner appears
        Assert.assertTrue(Utils.checkElementExist(commonElements.bannerMessage));
        Assert.assertEquals(Constants.CUSTOMIZATION.BANNER_MESSAGE_IOS, commonElements.bannerMessage.getText());
    }

    //C265
    public void S296_C32121_CU_006_VerifyBannerIsDismissedWhenTabOnCloseButtonOnBanner() {
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

        if(Utils.checkElementExist(commonElements.notNowButton)){
            commonElements.notNowButton.click();
        }

        //Verify: banner appears
        Assert.assertFalse(Utils.checkElementExist(commonElements.bannerMessage));
    }

    //C264
    public void S296_C32124_CU_007_VerifyCustomizationIsShowWhenTabOnCustomizeButtonOnBanner() {
        //Step: Open the Philly.com App
        resetApp();
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);
        //Step:Tap on Customize on banner.
        waitForVisibilityOf(commonElements.bannerMessage);
        commonElements.bannerMessage.click();

        //Verify:   customization screen is show.
        Assert.assertTrue(Utils.checkElementExist(commonElements.customizeContentScreen));
    }

    // C266
    public void S296_C32127_CU_008_VerifyGeneralBannerFlow () {
        //Step: Open the Philly.com App
        appiumDriver.launchApp();
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);
        //Step:  Go to Settings tab
        feedListElements.settingTab.click();
        waitForVisibilityOf(settingElements.settingsHeading);

        if(Utils.checkElementExist(settingElements.viewAccountDetails)){
            //Click Account
            settingElements.viewAccountDetails.click();
            waitForVisibilityOf(loginElements.logOutButton);

            //Click Logout
            loginElements.logOutButton.click();
            loginElements.logoutDialogBtn.click();
        }

        //Step kill app
        resetApp();

        //Step: Relaunch app
        appiumDriver.launchApp();
        Utils.sleep(2000);
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);


        //Step:Tap on Customize on banner.
        commonElements.customizeOnFeedButton.click();

        //Verify:   customization screen is show.
        Assert.assertTrue(Utils.checkElementExist(commonElements.customizeContentScreen));
        
        //Step: Tap on "Follow ALl" and  "Following All" on Customization screen
        if(Utils.checkElementExist(commonElements.followAll)){
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

    //C339
    public void S296_C32128_CU_009_VerifyMyNewsHeaderWhenCustomizeTopicOnCustomizationScreenFromOnBoarding () {
        //Step: Open the Philly.com App
        resetApp();
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);

        commonElements.customizeOnFeedButton.click();
        Utils.sleep(2000);

        //Step: Follow one topic on Customization screen
        if(Utils.checkElementExist(commonElements.addTopicCard)){
            commonElements.addTopicCard.click();
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

        //Step: Turn off notification alert
        if(Utils.checkElementExist(commonElements.getNotificationPopUpText)){
            commonElements.notNowButtonGetNotification.click();
        }

        commonElements = new CommonElements(appiumDriver);
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);

//        Assert.assertTrue(Utils.checkElementExist(commonElements.getNotificationPopUpText));

        //Verify: MyNews on the Home Feed after customized .
        Assert.assertTrue(Utils.checkElementExist(commonElements.myNewsText),"MyNews not display");

        //Step:  Go to Settings tab and logout after finished.
        feedListElements.settingTab.click();
        waitForVisibilityOf(settingElements.settingsHeading);

        if(Utils.checkElementExist(settingElements.viewAccountDetails)){
            //Click Account
            settingElements.viewAccountDetails.click();
            waitForVisibilityOf(loginElements.logOutButton);

            //Click Logout
            loginElements.logOutButton.click();
            loginElements.logoutDialogBtn.click();
        }
    }

    //    C340
    public void S296_C32129_CU_010_VerifyMyNewsHeaderWhenCustomizeTopicOnCustomizationScreenFromSettings () {
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

        if(Utils.checkElementExist(settingElements.viewAccountDetails)){
            //Click Account
            settingElements.viewAccountDetails.click();
            waitForVisibilityOf(loginElements.logOutButton);

            //Click Logout
            loginElements.logOutButton.click();
            loginElements.logoutDialogBtn.click();
        }

        waitForVisibilityOf(settingElements.settingsHeading);
        //Step:  Tab on Customize My News
        settingElements.customizeMyNews.click();

        if(Utils.checkElementExist(commonElements.addTopicCard)){
            commonElements.addTopicCard.click();
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

        //Step: Turn off notification alert
        if(Utils.checkElementExist(commonElements.getNotificationPopUpText)){
            commonElements.notNowButtonGetNotification.click();
        }

        settingElements = new SettingElements(appiumDriver);
        waitForVisibilityOf(settingElements.viewAccountDetails);

        // Verify: The user will directed to the Settings screen
        Assert.assertTrue(Utils.checkElementExist(settingElements.viewAccountDetails),"The user will not directed to the Settings screen");
        appiumDriver.launchApp();

        //Verify: MyNews on the Home Feed after customized .
        Assert.assertTrue(Utils.checkElementExist(commonElements.myNewsText),"MyNews not display");

        //Step:  Go to Settings tab
        feedListElements.settingTab.click();
        waitForVisibilityOf(settingElements.settingsHeading);

        if(Utils.checkElementExist(settingElements.viewAccountDetails)){
            //Click Account
            settingElements.viewAccountDetails.click();
            waitForVisibilityOf(loginElements.logOutButton);

            //Click Logout
            loginElements.logOutButton.click();
            loginElements.logoutDialogBtn.click();
        }
    }

    //C8778
    public void S296_C32130_CU_011_VerifyLogInScreenAppearsWhenTappingLogInButton() {
        //Step: Relaunch app
        appiumDriver.launchApp();

        //Step:  Go to Settings tab and sign out.
        feedListElements.settingTab.click();
        waitForVisibilityOf(settingElements.settingsHeading);

        if(Utils.checkElementExist(settingElements.viewAccountDetails)){
            //Click Account
            settingElements.viewAccountDetails.click();
            waitForVisibilityOf(loginElements.logOutButton);

            //Click Logout
            loginElements.logOutButton.click();
            loginElements.logoutDialogBtn.click();
        }

        //Step kill app
        resetApp();

        if(Utils.checkElementExist(commonElements.customizeOnFeedButton)) {
            commonElements.customizeOnFeedButton.click();
        } else {
            Utils.sleep(1000);
        }
        //Step: Follow one topic on Customization screen
        if(Utils.checkElementExist(commonElements.addTopicCard)){
            commonElements.addTopicCard.click();
        }

        waitForVisibilityOf(commonElements.loginButton);
        commonElements.loginButton.click();
        waitForVisibilityOf(loginElements.email);

        //Verify: Verify that Log In screen appears when tapping on "LOG IN" button
        Assert.assertTrue(Utils.checkElementExist(loginElements.email));
        Assert.assertTrue(Utils.checkElementExist(loginElements.password));
    }

    //C8779
    public void S296_C32131_CU_012_VerifySignUpScreenAppearsWhenTappingSignUpButton() {
        //Step kill app
        appiumDriver.launchApp();

        if(Utils.checkElementExist(commonElements.customizeOnFeedButton)) {
            commonElements.customizeOnFeedButton.click();
        } else {
            Utils.sleep(1000);
        }

        //Step: Follow one topic on Customization screen
        if(Utils.checkElementExist(commonElements.followAll)) {
            commonElements.followAll.click();
        }

        waitForVisibilityOf(commonElements.signupButton);
        commonElements.signupButton.click();
        waitForVisibilityOf(loginElements.signUpButton);

        //Verify: Verify that SignUp screen appears when tapping on "Sign Up" button
        Assert.assertTrue(Utils.checkElementExist(loginElements.confirmPassword));
        Assert.assertTrue(Utils.checkElementExist(loginElements.signUpButton));
    }

    //C35415
    public void S296_C35415_CU_015_VerifyDiscardPopUpShowWhenCloseCustomizeWithChanges() {
        //Step: Relaunch app
        appiumDriver.launchApp();

        //Step:  Go to Settings tab and sign out.
        feedListElements.settingTab.click();
        waitForVisibilityOf(settingElements.settingsHeading);

        if(Utils.checkElementExist(settingElements.viewAccountDetails)){
            //Click Account
            settingElements.viewAccountDetails.click();
            waitForVisibilityOf(loginElements.logOutButton);

            //Click Logout
            loginElements.logOutButton.click();
            loginElements.logoutDialogBtn.click();
        }
        waitForVisibilityOf(settingElements.settingsHeading);
        //Step kill app
        resetApp();

        if(Utils.checkElementExist(commonElements.customizeOnFeedButton)) {
            commonElements.customizeOnFeedButton.click();
        } else {
            Utils.sleep(200);
        }
        //Step: Follow one topic on Customization screen
        if(Utils.checkElementExist(commonElements.followAll)){
            commonElements.followAll.click();
        }

        commonElements.loginButton.click();
        waitForVisibilityOf(loginElements.email);
        //Step: Log into the app with valid
        loginElements.setValue(loginElements.email, Constants.LOGIN_EMAIL);
        loginElements.setValue(loginElements.password, Constants.LOGIN_PASSWORD);
        loginElements.logInButton.click();
        waitForVisibilityOf(commonElements.customizeScreenExitButton);

        // Click close.
        commonElements.customizeScreenExitButton.click();

        //Verify: Verify that 'discard changes' dialog should pop up show.
        Assert.assertTrue(Utils.checkElementExist(commonElements.discardChangeText));
        Assert.assertTrue(Utils.checkElementExist(commonElements.discardChangeButtonCancel));
        Assert.assertTrue(Utils.checkElementExist(commonElements.discardChangeButtonDiscard));
    }

    //C35416
    public void S296_C35416_CU_016_VerifyCustomizationKeepChangesWhenClickCancelCloseButton() {
        //Step: Relaunch app
        appiumDriver.launchApp();

        //Step:  Go to Settings tab and sign out.
        feedListElements.settingTab.click();
        waitForVisibilityOf(settingElements.settingsHeading);

        if(Utils.checkElementExist(settingElements.viewAccountDetails)){
            //Click Account
            settingElements.viewAccountDetails.click();
            waitForVisibilityOf(loginElements.logOutButton);

            //Click Logout
            loginElements.logOutButton.click();
            loginElements.logoutDialogBtn.click();
        }
        waitForVisibilityOf(settingElements.settingsHeading);
        //Step kill app
        resetApp();

        if(Utils.checkElementExist(commonElements.customizeOnFeedButton)) {
            commonElements.customizeOnFeedButton.click();
        } else {
            Utils.sleep(200);
        }
        //Step: Follow one topic on Customization screen
        if(Utils.checkElementExist(commonElements.followAll)){
            commonElements.followAll.click();
        }

        commonElements.loginButton.click();
        waitForVisibilityOf(loginElements.email);
        //Step: Log into the app with valid
        loginElements.setValue(loginElements.email, Constants.LOGIN_EMAIL);
        loginElements.setValue(loginElements.password, Constants.LOGIN_PASSWORD);
        loginElements.logInButton.click();
        waitForVisibilityOf(commonElements.customizeScreenExitButton);

        // Click close.
        commonElements.customizeScreenExitButton.click();
        waitForVisibilityOf(commonElements.discardChangeText);

        commonElements.discardChangeButtonCancel.click();

        //Verify: Verify that 'discard changes' dialog should pop up show.
        Assert.assertTrue(Utils.checkElementExist(commonElements.customizeContentScreen));
        Assert.assertTrue(Utils.checkElementExist(commonElements.followingAll));
    }

    //C35417
    public void S296_C35417_CU_017_DiscardChangesWhenClosingCustomizationScreenWithChanges() {
        //Step: Relaunch app
        appiumDriver.launchApp();

        //Step:  Go to Settings tab and sign out.
        feedListElements.settingTab.click();
        waitForVisibilityOf(settingElements.settingsHeading);

        if(Utils.checkElementExist(settingElements.viewAccountDetails)){
            //Click Account
            settingElements.viewAccountDetails.click();
            waitForVisibilityOf(loginElements.logOutButton);

            //Click Logout
            loginElements.logOutButton.click();
            loginElements.logoutDialogBtn.click();
        }
        waitForVisibilityOf(settingElements.settingsHeading);
        //Step kill app
        resetApp();

        if(Utils.checkElementExist(commonElements.customizeOnFeedButton)) {
            commonElements.customizeOnFeedButton.click();
        } else {
            Utils.sleep(200);
        }
        //Step: Follow one topic on Customization screen
        if(Utils.checkElementExist(commonElements.followAll)){
            commonElements.followAll.click();
        }

        commonElements.loginButton.click();
        waitForVisibilityOf(loginElements.email);
        //Step: Log into the app with valid
        loginElements.setValue(loginElements.email, Constants.LOGIN_EMAIL);
        loginElements.setValue(loginElements.password, Constants.LOGIN_PASSWORD);
        loginElements.logInButton.click();
        waitForVisibilityOf(commonElements.customizeScreenExitButton);

        // Click close.
        commonElements.customizeScreenExitButton.click();
        waitForVisibilityOf(commonElements.discardChangeText);
        commonElements.discardChangeButtonDiscard.click();

        feedListElements = new FeedListElements(appiumDriver);
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);

        //Verify: Discard changes and take the users back to Home Feed (their news won't be customized).
        Assert.assertTrue(Utils.checkElementExist(feedListElements.feedItemTitleTopStory));
//        Assert.assertTrue(Utils.checkElementExist(commonElements.myNewsText));

        //Step:  Go to Settings tab and sign out.
        feedListElements.settingTab.click();
        waitForVisibilityOf(settingElements.settingsHeading);

        if(Utils.checkElementExist(settingElements.viewAccountDetails)){
            //Click Account
            settingElements.viewAccountDetails.click();
            waitForVisibilityOf(loginElements.logOutButton);

            //Click Logout
            loginElements.logOutButton.click();
            loginElements.logoutDialogBtn.click();
        }
        waitForVisibilityOf(settingElements.settingsHeading);
        //Step:  Tab on Customize My News
        settingElements.customizeMyNews.click();

        if(Utils.checkElementExist(commonElements.followAll)){
            commonElements.followAll.click();
        }

        commonElements.loginButton.click();
        waitForVisibilityOf(loginElements.email);

        //Step: Log into the app with valid
        loginElements.setValue(loginElements.email, Constants.LOGIN_EMAIL);
        loginElements.setValue(loginElements.password, Constants.LOGIN_PASSWORD);
        loginElements.logInButton.click();

        //Step: Tap on GetMyNews Button
        waitForVisibilityOf(commonElements.getMyNewsButton);

        // Click close.
        commonElements.customizeScreenExitButton.click();
        waitForVisibilityOf(commonElements.discardChangeText);
        commonElements.discardChangeButtonDiscard.click();
        waitForVisibilityOf(settingElements.settingsHeading);

        //Verify: Verify that Discard changes and take the users back to Settings screen.
        Assert.assertTrue(Utils.checkElementExist(settingElements.settingsHeading));
    }

    //C35414
    public void S296_C35414_CU_014_VerifyTheNewSetOfTopicsWillOverwriteTheirCustomizedTopics() {
        //Step: Relaunch app
        appiumDriver.launchApp();

        //Step:  Go to Settings tab and sign out.
        feedListElements.settingTab.click();
        waitForVisibilityOf(settingElements.settingsHeading);

        if (Utils.checkElementExist(settingElements.viewAccountDetails)) {
            //Click Account
            settingElements.viewAccountDetails.click();
            waitForVisibilityOf(loginElements.logOutButton);

            //Click Logout
            loginElements.logOutButton.click();
            loginElements.logoutDialogBtn.click();
        }
        waitForVisibilityOf(settingElements.settingsHeading);

        //Step: Open the Philly.com App
        appiumDriver.launchApp();
        waitForVisibilityOf(commonElements.customizeOnFeedButton);

        commonElements.customizeOnFeedButton.click();
        Utils.sleep(2000);

        //Step: Follow one topic on Customization screen
        if (Utils.checkElementExist(commonElements.addTopicCard)) {
            commonElements.addTopicCard.click();
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

        //Step: Turn off notification alert
        if (Utils.checkElementExist(commonElements.getNotificationPopUpText)) {
            commonElements.notNowButtonGetNotification.click();
        }

        commonElements = new CommonElements(appiumDriver);
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);

        //Verify: MyNews on the Home Feed after customized .
        Assert.assertTrue(Utils.checkElementExist(commonElements.myNewsText), "MyNews not display");
    }

    //C35413
    public void S296_C35413_CU_013_VerifyUserAbleContinueCustomizationOnboardFlowAfterLogIn() {
        //Step: Relaunch app
        appiumDriver.launchApp();

        //Step:  Go to Settings tab and sign out.
        feedListElements.settingTab.click();
        waitForVisibilityOf(settingElements.settingsHeading);

        if (Utils.checkElementExist(settingElements.viewAccountDetails)) {
            //Click Account
            settingElements.viewAccountDetails.click();
            waitForVisibilityOf(loginElements.logOutButton);

            //Click Logout
            loginElements.logOutButton.click();
            loginElements.logoutDialogBtn.click();
        }
        waitForVisibilityOf(settingElements.settingsHeading);

        //Step: Open the Philly.com App
        resetApp();
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);

        commonElements.customizeOnFeedButton.click();
        Utils.sleep(2000);

        //Step: Follow one topic on Customization screen
        if (Utils.checkElementExist(commonElements.addTopicCard)) {
            commonElements.addTopicCard.click();
        }

        commonElements.loginButton.click();
        waitForVisibilityOf(loginElements.email);

        //Step: Log into the app with valid
        loginElements.setValue(loginElements.email, Constants.LOGIN_EMAIL);
        loginElements.setValue(loginElements.password, Constants.LOGIN_PASSWORD);
        loginElements.logInButton.click();

        //Step: Tap on GetMyNews Button
        waitForVisibilityOf(commonElements.getMyNewsButton);

        //Verify: MyNews on the Home Feed after customized .
        Assert.assertTrue(Utils.checkElementExist(commonElements.getMyNewsButton), "getMyNewsButton not display");
        Assert.assertTrue(Utils.checkElementExist(commonElements.customizeContentScreen), "customizeContentScreen not display");
    }

}

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

        //Verify: banner appears
        Assert.assertTrue(Utils.checkElementExist(commonElements.bannerMessage));
        Assert.assertEquals(Constants.CUSTOMIZATION.BANNER_MESSAGE_IOS, commonElements.bannerMessage.getText());
    }

    //C12493
    public void S296_C12493_CU_003_VerifyLogInSignUpDrawerDismissesWhenNotLoggedUserUnselectAllTopic() {
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
    public void S296_C240_CU_004_VerifyUsersCanNotFollowCategoryWithoutLogin () {
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
    public void S296_C263_CU_005_VerifyBannerDisplaysAtTheTopOfTheScreen() {
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
    public void S296_C265_CU_006_VerifyBannerIsDismissedWhenTabOnCloseButtonOnBanner() {
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
    public void S296_C264_CU_007_VerifyCustomizationIsShowWhenTabOnCustomizeButtonOnBanner() {
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
    public void S296_C266_CU_008_VerifyGeneralBannerFlow () {
        //Step: Open the Philly.com App
        appiumDriver.launchApp();
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);

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
    public void S296_C339_CU_009_VerifyMyNewsHeaderWhenCustomizeTopicOnCustomizationScreenFromOnBoarding () {
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

        commonElements = new CommonElements(appiumDriver);

        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);

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

    //    C340
    public void S296_C340_CU_010_VerifyMyNewsHeaderWhenCustomizeTopicOnCustomizationScreenFromSettings () {
        resetApp();

        //Step: Relaunch app
        appiumDriver.launchApp();

        //Step:Tap Close(x) button on Customization screen
        if(Utils.checkElementExist(commonElements.customizeContentScreen)){
            commonElements.customizeScreenExitButton.click();
        }

        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);
        feedListElements.settingTab.click();
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
        //Utils.sleep(5000);

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
    public void S296_C8778_CU_011_VerifyLogInScreenAppearsWhenTappingLogInButton() {
        //Step: Relaunch app
        appiumDriver.launchApp();

        //Step kill app
        resetApp();

        if(Utils.checkElementExist(commonElements.customizeOnFeedButton)) {
            commonElements.customizeOnFeedButton.click();
        } else {
            Utils.sleep(200);
        }
        //Step: Follow one topic on Customization screen
        if(Utils.checkElementExist(commonElements.addTopicCard)){
            commonElements.addTopicCard.click();
        }


        commonElements.loginButton.click();
        waitForVisibilityOf(loginElements.email);

        //Verify: Verify that Log In screen appears when tapping on "LOG IN" button
        Assert.assertTrue(Utils.checkElementExist(loginElements.email));
        Assert.assertTrue(Utils.checkElementExist(loginElements.password));
    }

    //C8779
    public void S296_C8779_CU_012_VerifySignUpScreenAppearsWhenTappingSignUpButton() {
        //Step kill app
        appiumDriver.launchApp();

        if(Utils.checkElementExist(commonElements.customizeOnFeedButton)) {
            commonElements.customizeOnFeedButton.click();
        } else {
            Utils.sleep(200);
        }

        //Step: Follow one topic on Customization screen
        if(Utils.checkElementExist(commonElements.followAll)) {
            commonElements.followAll.click();
        }

        commonElements.signupButton.click();
        waitForVisibilityOf(loginElements.signUpButton);

        //Verify: Verify that SignUp screen appears when tapping on "Sign Up" button
        Assert.assertTrue(Utils.checkElementExist(loginElements.confirmPassword));
        Assert.assertTrue(Utils.checkElementExist(loginElements.signUpButton));
    }
}

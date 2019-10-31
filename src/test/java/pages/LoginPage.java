package pages;

import elements.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.Assert;
import scenarios.AppiumController;
import utils.Constants;
import utils.Utils;

public class LoginPage extends BasePage {


    private CommonElements commonElements;
    private ExploreElements exploreElements;
    private BookMarkElements bookMarkElements;
    private SettingElements settingElements;
    private LoginElements loginElements;


    public LoginPage(AppiumDriver driver) {
        super(driver);

        commonElements = new CommonElements(driver);
        settingElements= new SettingElements(driver);
        exploreElements= new ExploreElements(driver);
        bookMarkElements= new BookMarkElements(driver);
        loginElements = new LoginElements(driver);

    }

    public void S234_C20187_LG_001_VerifyLoadLogInScreenFromSettingsScreen() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);
        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);

        //Check Login screen
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);
        Assert.assertTrue(Utils.checkElementExist(loginElements.closeActionButton),"Check Top App App - Left Action Close display: ");
        Assert.assertTrue(Utils.checkElementExist(loginElements.email), "Check Email text field displays");
        Assert.assertTrue(Utils.checkElementExist(loginElements.password), "Check Password field displays");
        Assert.assertTrue(Utils.checkElementExist(loginElements.showOrHidePasswordIcon), "Check Password icon show");
        Assert.assertTrue(Utils.checkElementExist(loginElements.logInButton), "Check Log In button displays");
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotEmailLink), "Check Forgot Email link displays");
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotPasswordLink), "Check Forgot Password link displays");
        Assert.assertTrue(Utils.checkElementExist(loginElements.signUpLink), "Check Sign Up link displays");
    }

    public void TestCasePCOM_004() {

        //Case 1
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);

        //Check Login screen
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);
        Assert.assertTrue(Utils.checkElementExist(loginElements.closeActionButton), "Check Top App App - Left Action Close display: ");

        //Click Close
        loginElements.closeActionButton.click();
        Utils.waitForElementVisible(appiumDriver, settingElements.settingsHeading);

        //Go to Setting tab;
        // Disconnect wifi

        if (loginElements.getWiFiConnectionStatus() == true) {
            turnOffWifi();
            Assert.assertFalse(loginElements.getWiFiConnectionStatus(), "Wifi connection didn't turn off");
        }

        Utils.sleep(Constants.SHORTTIME);

        // Click on "Log In or Sign Up" option
        settingElements.logInOrSignUp.click();

        //Check Log In screen appear
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);

        //Case 2
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();

        //Go to Setting tab;
        // Disconnect wifi connection
        if (loginElements.getWiFiConnectionStatus() == true) {
            turnOffWifi();
            Assert.assertFalse(loginElements.getWiFiConnectionStatus(), "Wifi connection didn't turn off");
        }
        Utils.sleep(Constants.SHORTTIME);

        // Click on "Log In or Sign Up" option
        settingElements.logInOrSignUp.click();

        //Check Log In screen appear
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);
    }

    public void S234_C20188_LG_002_VerifyCloseLogInScreenFromSettingsScreen() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);

        //Check Login screen displays
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);
        loginElements.closeActionButton.click();

        //Check Setting page appears
        Assert.assertEquals("Settings",settingElements.settingsHeading.getText().trim(), "Check Setting is being taken");
    }

    public void TestCasePCOM_009() {

        //Turn on wifi
        if (getWiFiConnectionStatus()==false) {
            turnOnWifi();
            Assert.assertTrue(loginElements.getWiFiConnectionStatus(), "Wifi connection didn't turn on");
        }
        Utils.sleep(Constants.SHORTTIME);

        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();

        settingElements.logInOrSignUp.click();
        loginElements.assertValue(loginElements.actionBarTitle,"Log In");

        lockDevice();
        unLockDevice();
        Utils.sleep(Constants.SHORTTIME);

        waitForVisibilityOf(loginElements.closeActionButton);
        loginElements.closeActionButton.click();

        //Check Setting page appears
        Assert.assertEquals("Settings",settingElements.settingsHeading.getText().trim(), "Check Setting is being taken");

        ///Navigate all tabs
        commonElements.homeTabClick();

        exploreElements.exploreTab.click();
        //Check Explore page appears
        Assert.assertEquals("Explore",exploreElements.headingTitle.getText().trim(), "Check Explore tab is being displayed");

        bookMarkElements.bookMarkTab.click();
        ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.HOME));
    }


    public void S234_C22243_LG_031_VerifyHomeFeedDisplayAfterKillingAppAndThanReopeningAppFromLogInScreen() {
        //Turn on Wifi connection
        if(loginElements.getWiFiConnectionStatus() == false){
            turnOnWifi();
            Assert.assertTrue(loginElements.getWiFiConnectionStatus(), "Wifi connection didn't turn on");
        }

        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();

        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();

        ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.HOME));

        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
    }

    public void S234_C20190_LG_004_VerifyLogInWithValidEmailAndPassword() {
        //Turn on Wifi connection
        if(loginElements.getWiFiConnectionStatus() == false){
            turnOnWifi();
            Assert.assertTrue(loginElements.getWiFiConnectionStatus(), "Wifi connection didn't turn on");
        }

        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();

        //check if account has not signed up
        if(!Constants.LOGIN_EMAIL.equals(settingElements.viewAccountDetails.getText().trim())) {
            settingElements.logInOrSignUp.click();

            loginElements.setValue(loginElements.email, Constants.LOGIN_EMAIL);

            loginElements.setValue(loginElements.password, Constants.LOGIN_PASSWORD);
            loginElements.logInButton.click();
        }

        waitForVisibilityOf(settingElements.settingsHeading);

        //Check Setting page appears
        Assert.assertEquals("Settings",settingElements.settingsHeading.getText().trim(), "Check Setting is being taken");

        //Check account display correctly
        Assert.assertEquals(settingElements.viewAccountDetails.getText().trim(), Constants.LOGIN_EMAIL,"Check Email address displays");
    }

    public void S234_C20191_LG_005_VerifyLogInWithInvalidEmailFormat() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);

        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf(loginElements.actionBarTitle);

        //Check Login screen displays
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);

        //Input invalid Email
        loginElements.setValue(loginElements.email, "fairlyenclave.vn");

        //Input valid password
        loginElements.setValue(loginElements.password, Constants.LOGIN_PASSWORD);
        loginElements.logInButton.click();

        //Check error message is being returned
        loginElements.assertValue(loginElements.messageEmail, Constants.LOGIN.INVALID_EMAIL_ERROR_MESSAGE);
    }

    public void S234_C20192_LG_006_VerifyLogInWithInvalidEmailFormatWhenClickOutsidePassword() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf(loginElements.actionBarTitle);

        //Check Login screen displays
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);

        //Input invalid Email
        loginElements.setValue(loginElements.email, "fairlyenclave.vn");

        //Click on Password field
        loginElements.password.click();

        //Check error message is being returned
        loginElements.assertValue(loginElements.messageEmail, Constants.LOGIN.INVALID_EMAIL_ERROR_MESSAGE);
    }

    public void S234_C20193_LG_007_VerifyLogInWithUnregisteredAccount() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf(loginElements.actionBarTitle);

        //Check Login screen displays
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);

        //Input invalid Email
        loginElements.setValue(loginElements.email, "mnguyen@philly.com");

        //Input valid Password
        loginElements.setValue(loginElements.password, "Philly123");

        loginElements.logInButton.click();
        waitForVisibilityOf(loginElements.dialogMessage);

        //Check dialog message is being returned
        loginElements.assertValue(loginElements.dialogMessage,Constants.LOGIN.UNMATCHED_ACCOUNT_DIALOG_MESSAGE);
        //Check dialog TRY AGAIN button displays
        loginElements.assertValue(loginElements.tryAgainDialogButton,Constants.LOGIN.TRY_AGAIN_DIALOG_BUTTON);
    }

    public void S234_C20194_LG_008_VerifyLogInWithIncorrectPassword() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf(loginElements.actionBarTitle);

        //Check Login screen displays
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);

        //Input valid Email
        loginElements.setValue(loginElements.email, Constants.LOGIN_EMAIL);

        //Input invalid Password
        loginElements.setValue(loginElements.password, "InvalidPass");
        loginElements.logInButton.click();

        waitForVisibilityOf(loginElements.dialogMessage);
        //Check dialog message is being returned
        loginElements.assertValue(loginElements.dialogMessage,Constants.LOGIN.UNMATCHED_ACCOUNT_DIALOG_MESSAGE);
        //Check dialog TRY AGAIN button displays
        loginElements.assertValue(loginElements.tryAgainDialogButton,Constants.LOGIN.TRY_AGAIN_DIALOG_BUTTON);
    }

    public void S234_C20195_LG_009_VerifyDismissAlert() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf(loginElements.actionBarTitle);

        //Check Login screen displays
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);

        //Case 1: Input invalid email
        //Input invalid Email
        loginElements.setValue(loginElements.email, "failry@enclave.com");
        //Input valid Password
        loginElements.setValue(loginElements.password, Constants.LOGIN_PASSWORD);
        loginElements.logInButton.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.dialogMessage);

        //Check dialog message is being returned
        loginElements.assertValue(loginElements.dialogMessage,Constants.LOGIN.UNMATCHED_ACCOUNT_DIALOG_MESSAGE);

        loginElements.tryAgainDialogButton.click();

        //check dialog is disappeared
        Assert.assertFalse(Utils.checkElementExist(loginElements.dialogMessage), "Check dialog is closed");

        loginElements.assertFocused(loginElements.email,"false");
        loginElements.assertFocused(loginElements.password,"true");


        //case 2: Input invalid password
        //Input valid Email
        loginElements.setValue(loginElements.email, "failry@enclave.vn");
        //Input invalid Password
        loginElements.setValue(loginElements.password, "invalid");
        loginElements.logInButton.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.dialogMessage);

        //Check dialog message is being returned
        loginElements.assertValue(loginElements.dialogMessage,Constants.LOGIN.UNMATCHED_ACCOUNT_DIALOG_MESSAGE);

        loginElements.tryAgainDialogButton.click();

        //check dialog is disappeared
        Assert.assertFalse(Utils.checkElementExist(loginElements.dialogMessage), "Check dialog is closed");

        loginElements.assertFocused(loginElements.email,"false");
        loginElements.assertFocused(loginElements.password,"true");
    }

    public void S234_C20196_LG_010_VerifyLogInWithoutInputEmailAndPassword() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();

        //Leave Email and Password as blank

        //Click Login
        loginElements.logInButton.click();

        //Check error messages returned
        loginElements.assertValue(loginElements.messageEmail, Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);
        loginElements.assertValue(loginElements.messagePassword, Constants.LOGIN.BLANK_PASSWORD_ERROR_MESSAGE);
    }

    public void TestCasePCOM_025() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf(loginElements.actionBarTitle);

        //Check Login screen displays
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);

        //click and leave Email as blank
        loginElements.email.click();

        //Click on password
        loginElements.password.click();

        //Check error message returned
        loginElements.assertValue(loginElements.messageEmail, Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);
    }

    public void TestCasePCOM_026() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf(loginElements.actionBarTitle);

        //Check Login screen displays
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);

        //Click and leave Email as blank
        loginElements.email.click();

        //Click and leave on password as blank
        loginElements.password.click();

        //Click Login
        loginElements.logInButton.click();

        waitForVisibilityOf(loginElements.messageEmail);
        //Check error message returned
        loginElements.assertValue(loginElements.messageEmail, Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);
        loginElements.assertValue(loginElements.messagePassword, Constants.LOGIN.BLANK_PASSWORD_ERROR_MESSAGE);
    }

    public void S234_C20199_LG_013_VerifyNoEmailErrorMessageDisplaysWhenClickingPassword() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf(loginElements.actionBarTitle);

        //Check Login screen displays
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);

        //Don't click and leave Email as blank

        //Click on password
        loginElements.password.click();

        //Check no error messages returned
        loginElements.assertVisible(loginElements.messageEmail, false);
        loginElements.assertVisible(loginElements.messagePassword, false);
    }

    public void S234_C20200_LG_014_VerifyEmailErrorMessageDisplaysWhenLeavingEmailAndClickingLogIn() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf(loginElements.actionBarTitle);

        //Check Login screen displays
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);

        //Don't click and leave Email

        //Enter valid password
        loginElements.setValue(loginElements.password, Constants.LOGIN_PASSWORD);

        //Click Log In
        loginElements.logInButton.click();

        waitForVisibilityOf(loginElements.messageEmail);
        //Check error message returned
        loginElements.assertValue(loginElements.messageEmail,Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);
    }

    public void TestCasePCOM_029() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        settingElements.logInOrSignUp.click();

        //Click and leave Email as blank
        loginElements.email.click();

        //Enter valid Password
        loginElements.setValue(loginElements.password, Constants.LOGIN_PASSWORD);

        //Click Log In button
        loginElements.logInButton.click();

        //Check error message returned
        loginElements.assertValue(loginElements.messageEmail,Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);
    }

    public void TestCasePCOM_030() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        settingElements.logInOrSignUp.click();

        //Click and leave Email as blank
        loginElements.email.click();

        //Enter valid Password
        loginElements.setValue(loginElements.password, Constants.LOGIN_PASSWORD);

        //Click Email field
        loginElements.email.click();

        //Check error message returned
        loginElements.assertValue(loginElements.messageEmail,Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);
    }

    public void S234_C20203_LG_017_VerifyPasswordErrorMessageDisplayWhenPasswordIsBlankAndClickingLogIn() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        settingElements.logInOrSignUp.click();

        //Enter valid Email
        loginElements.setValue(loginElements.email, Constants.LOGIN_EMAIL);

        //Don' t click and leave Password

        //Click Log In button
        loginElements.logInButton.click();

        waitForVisibilityOf(loginElements.messagePassword);
        //Check error message returned
        loginElements.assertValue(loginElements.messagePassword,Constants.LOGIN.BLANK_PASSWORD_ERROR_MESSAGE);
    }

    public void S234_C20204_LG_018_VerifyPasswordErrorMessageDisplayWhenPasswordIsBlankAndClickingEmail() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        settingElements.logInOrSignUp.click();

        //Enter valid Email
        loginElements.setValue(loginElements.email, Constants.LOGIN_EMAIL);

        //Click and leave Password
        loginElements.password.click();

        //Click Email
        loginElements.email.click();

        //Check error message returned
        loginElements.assertValue(loginElements.messagePassword,Constants.LOGIN.BLANK_PASSWORD_ERROR_MESSAGE);
    }

    public void S234_C20205_LG_019_VerifyErrorMessagesDisplayWhenEnteringInvalidFieldsAndClickingLogIn() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        settingElements.logInOrSignUp.click();

        //Enter invalid email format
        loginElements.setValue(loginElements.email, "fairlyenclave.vn");

        //Leave Password field as blank

        //Click Log In
        loginElements.logInButton.click();

        waitForVisibilityOf(loginElements.messageEmail);
        //Check error messages returned
        loginElements.assertValue(loginElements.messageEmail,Constants.LOGIN.INVALID_EMAIL_ERROR_MESSAGE);
        loginElements.assertValue(loginElements.messagePassword,Constants.LOGIN.BLANK_PASSWORD_ERROR_MESSAGE);
    }

    public void S234_C20206_LG_020_VerifyNoEmailErrorMessageDisplayWhenEnteringEmail() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();

        settingElements.logInOrSignUp.click();

        //Leave Email as blank

        //Enter valid Password
        loginElements.setValue(loginElements.password, "Philly123");

        //Click Log In
        loginElements.logInButton.click();

        waitForVisibilityOf(loginElements.messageEmail);
        //Check error message returned
        loginElements.assertValue(loginElements.messageEmail,Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);


        //Enter valid Email
        loginElements.setValue(loginElements.email, "mnguyen@philly.com");

        //Click Log In button
        loginElements.logInButton.click();

        //Check no error message return
        loginElements.assertVisible(loginElements.messageEmail, false);
    }

    public void TestCasePCOM_037() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();

        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();

        //Click and leave Email field
        loginElements.email.click();

        //Enter valid Password
        loginElements.setValue(loginElements.password, "123");

        //Check error message returned
        loginElements.assertValue(loginElements.messageEmail,Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);


        //Click Email field
        loginElements.email.click();

        //Enter valid Email
        loginElements.setValue(loginElements.email, Constants.LOGIN_EMAIL);

        //Click Log In button
        loginElements.logInButton.click();

        //Check no error message return
        loginElements.assertVisible(loginElements.messageEmail, false);
    }

    public void S234_C20208_LG_022_VerifyNoEmailErrorMessageDisplayWhenEnteringEmailAndClickingLogIn() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();

        //Enter invalid Email format
        loginElements.setValue(loginElements.email, "fairlyenclave.vn");

        //Leave Password as blank

        //Click Log In button
        loginElements.logInButton.click();

        waitForVisibilityOf(loginElements.messageEmail);
        //Check error messages returned
        loginElements.assertValue(loginElements.messageEmail,Constants.LOGIN.INVALID_EMAIL_ERROR_MESSAGE);
        loginElements.assertValue(loginElements.messagePassword,Constants.LOGIN.BLANK_PASSWORD_ERROR_MESSAGE);


        //Enter valid Email
        loginElements.setValue(loginElements.email, Constants.LOGIN_EMAIL);

        //Click Log In button
        loginElements.logInButton.click();

        //Check no error messages returned on Email field
        loginElements.assertVisible(loginElements.messageEmailForInvalid,false);

        //Check error message is still on Password
        loginElements.assertValue(loginElements.messagePassword,Constants.LOGIN.BLANK_PASSWORD_ERROR_MESSAGE);
    }

    public void S234_C20209_LG_023_VerifyNoPasswordErrorMessageDisplayWhenEnteringPasswordAndClickingLogIn() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();

        //Enter invalid Email format
        loginElements.setValue(loginElements.email, "fairlyenclave.vn");

        //Leave Password as blank

        //Click Log In button
        loginElements.logInButton.click();

        waitForVisibilityOf(loginElements.messageEmail);
        //Check error messages returned
        loginElements.assertValue(loginElements.messageEmail,Constants.LOGIN.INVALID_EMAIL_ERROR_MESSAGE);
        loginElements.assertValue(loginElements.messagePassword,Constants.LOGIN.BLANK_PASSWORD_ERROR_MESSAGE);


        //Enter a value on Password
        loginElements.setValue(loginElements.password, "Philly123");

        //Click Log In button
        loginElements.logInButton.click();

        //Check error message is still on Email field
        loginElements.assertValue(loginElements.messageEmailForInvalid,Constants.LOGIN.INVALID_EMAIL_ERROR_MESSAGE);

        //Check no error message on Password field
        loginElements.assertVisible(loginElements.messagePassword,false);
    }

    public void S234_C20210_LG_024_VerifyNoPasswordErrorMessageDisplayAfterClickingLogInAndEnteringPassword() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();

        //Enter valid Email
        loginElements.setValue(loginElements.email, Constants.LOGIN_EMAIL);

        // Leave Password as blank

        //Click Log In button
        loginElements.logInButton.click();

        //Check error message returned
        loginElements.assertValue(loginElements.messagePassword,Constants.LOGIN.BLANK_PASSWORD_ERROR_MESSAGE);


        //Enter Password
        loginElements.setValue(loginElements.password, "123");

        //Click Log In button
        loginElements.logInButton.click();

        //Check no error message return
        loginElements.assertVisible(loginElements.messagePassword, false);
    }

    public void TestCasePCOM_040() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        settingElements.logInOrSignUp.click();

        //Enter valid Email format
        loginElements.setValue(loginElements.email, Constants.LOGIN_EMAIL);

        // Click and leave Password as blank
        loginElements.password.click();

        //Click Email field
        loginElements.email.click();

        //Check error message returned
        loginElements.assertValue(loginElements.messagePassword,Constants.LOGIN.BLANK_PASSWORD_ERROR_MESSAGE);

        //Click Password field
        loginElements.password.click();

        //Enter Password
        loginElements.setValue(loginElements.password, Constants.LOGIN_PASSWORD);

        //Click Log In button
        loginElements.logInButton.click();

        //Check no error message return
        loginElements.assertVisible(loginElements.messagePassword, false);
    }

    public void S234_C20212_LG_026_VerifyPasswordUnActivateWhenTappingIconShowOrHidden() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);

        //Check show/hide password has default value is checked = false
        loginElements.assertShowPasswordIconSelected(loginElements.showOrHidePasswordIcon, "false");

        //Click on the show/hide password icon
        loginElements.showOrHidePasswordIcon.click();

        //Check show/hide password icon is active
        loginElements.assertShowPasswordIconSelected(loginElements.showOrHidePasswordIcon, "true");
        //Check Password field is not focus
        loginElements.assertFocused(loginElements.password, "false");
    }

    public void S234_C20213_LG_027_VerifyPasswordValueShowOrHiddenWhenTappingIconShowOrHidden() {

        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();

        //Enter Password
        loginElements.setValue(loginElements.password, Constants.LOGIN_PASSWORD);

        //Click on show/hidden password icon
        loginElements.showOrHidePasswordIcon.click();

        //Check password is shown or hidden
        //Check show/hide password icon is active
        loginElements.assertShowPasswordIconSelected(loginElements.showOrHidePasswordIcon, "true");
        loginElements.assertValue(loginElements.password, Constants.LOGIN_PASSWORD);

    }

    public void TestCasePCOM_043() {

        if(!AppiumController.OS.ANDROID_BROWSERSTACK.equals(AppiumController.executionOS)) {

            lauchApp();

            waitForVisibilityOf(commonElements.bottomTab);
            commonElements.settingTab.click();
            waitForVisibilityOf(settingElements.logInOrSignUp);

            settingElements.logInOrSignUp.click();
            //Enter valid Email
            loginElements.setValue(loginElements.email, "mnguyen@philly.com");

            //Enter valid Password
            loginElements.setValue(loginElements.password, "Philly123");

            //Disconnect wifi
            if (loginElements.getWiFiConnectionStatus() == true) {
                turnOffWifi();
                Assert.assertFalse(loginElements.getWiFiConnectionStatus());
            }


            //Click Log In
            loginElements.logInButton.click();

            //Check messages returned
            loginElements.assertValue(loginElements.dialogTitle, Constants.LOGIN.NETWORK_ERROR_TITLE);
            loginElements.assertValue(loginElements.dialogMessage, Constants.LOGIN.NETWORK_ERROR_MESSAGE);

            Assert.assertTrue(Utils.checkElementExist(loginElements.tryAgainDialogButton));
        }
    }

    public void TestCasePCOM_044() {

        if(!AppiumController.OS.ANDROID_BROWSERSTACK.equals(AppiumController.executionOS)) {
            lauchApp();

            waitForVisibilityOf(commonElements.bottomTab);
            commonElements.settingTab.click();
            waitForVisibilityOf(settingElements.logInOrSignUp);

            settingElements.logInOrSignUp.click();

            //Enter valid Email
            loginElements.setValue(loginElements.email, "mnguyen@philly.com");

            //Enter valid Password
            loginElements.setValue(loginElements.password, "Philly123");


            //Disconnect wifi or Cellular
            if (loginElements.getWiFiConnectionStatus() == true) {
                turnOffWifi();
                Assert.assertFalse(loginElements.getWiFiConnectionStatus());
            }


            //Click Log In
            loginElements.logInButton.click();

            //Check messages returned
            loginElements.assertValue(loginElements.dialogTitle, Constants.LOGIN.NETWORK_ERROR_TITLE);
            loginElements.assertValue(loginElements.dialogMessage, Constants.LOGIN.NETWORK_ERROR_MESSAGE);

            //Click OK button
            loginElements.tryAgainDialogButton.click();

            //Check Log In screen returned
            loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);
            loginElements.assertValue(loginElements.email, "mnguyen@philly.com");
            loginElements.assertValue(loginElements.password, "Philly123");
        }
    }

    public void S234_C20216_LG_028_VerifyForgotPasswordScreenDisplayWhenTappingForgotPasswordLink() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();

        //Click Forgot Password link
        loginElements.forgotPasswordLink.click();

        //Check Forgot Password screen appears
        loginElements.assertValue(loginElements.actionBarTitle, "Reset Password");
    }

    public void S234_C20217_LG_029_VerifyEmailValueIsTakenFromLogInToSignUpScreenWhenClickingSignUpLink() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();

        //Enter valid email
        loginElements.setValue(loginElements.email, "mnguyen@philly.com");

        appiumDriver.hideKeyboard();

        //Click Sign Up link
        loginElements.clickSignUpLink(appiumDriver,loginElements.signUpLink);

        Utils.sleep(Constants.SHORTTIME);
        waitForVisibilityOf(loginElements.actionBarTitle);

        //Check Sign Up screen appears
        loginElements.assertValue(loginElements.actionBarTitle, "Sign Up");

        //Check Email field has data which bring up from Login screen
        loginElements.assertValue(loginElements.email, "mnguyen@philly.com");

        //Click Log In Link
        loginElements.clickSignUpLink(appiumDriver,loginElements.logInLink);

        //Check Log In screen is being returned
        waitForVisibilityOf(loginElements.actionBarTitle);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);
    }

    //C12491
    public void S234_C20218_LG_030_VerifyLogInScreenIsNotChangedWhenScrollUp() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        settingElements.logInOrSignUp.click();
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);

        //Scroll to bottom
        Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN, loginElements.signUpLink);
        System.out.println(loginElements.signUpLink.getText());
        Assert.assertTrue(loginElements.signUpLink.getText().contains("Sign Up."));
    }



}

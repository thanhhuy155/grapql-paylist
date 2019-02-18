package pages;

import elements.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.Assert;
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

    public void TestCasePCOM_002() {
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
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);

        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);

        //Check Login screen
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);
        Assert.assertTrue(Utils.checkElementExist(loginElements.closeActionButton),"Check Top App App - Left Action Close display: ");

        //Click Close
        loginElements.closeActionButton.click();
        Utils.waitForElementVisible(appiumDriver,settingElements.settingsHeading);

        //Go to Setting tab;
        // Disconnect wifi
        if(loginElements.getCellularConnectionStatus()==true) {
            turnOffCellularConnection();
            Assert.assertFalse(loginElements.getCellularConnectionStatus(), "Cellular connection didn't turn off");
        }
        if(loginElements.getWiFiConnectionStatus()==true){
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
        // Disconnect wifi, Cellular connection
        if(loginElements.getCellularConnectionStatus()==true) {
            turnOffCellularConnection();
            Assert.assertFalse(loginElements.getCellularConnectionStatus(), "Cellular connection didn't turn off");
        }
        if(loginElements.getWiFiConnectionStatus()==true){
            turnOffWifi();
            Assert.assertFalse(loginElements.getWiFiConnectionStatus(), "Wifi connection didn't turn off");
        }
        Utils.sleep(Constants.SHORTTIME);

        // Click on "Log In or Sign Up" option
        settingElements.logInOrSignUp.click();

        //Check Log In screen appear
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);

    }

    public void TestCasePCOM_007() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);

        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);

        //Check Login screen displays
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);
        loginElements.closeActionButton.click();

        //Check Setting page appears
        Assert.assertEquals("Settings",settingElements.settingsHeading.getText().trim(), "Check Setting is being taken");

    }

    //For Android only
    public void TestCasePCOM_009() {

        //Turn on wifi or Cellular
        if (getWiFiConnectionStatus()==false) {
            turnOnWifi();
        }
        if (getCellularConnectionStatus()==false) {
            turnOnCellularConnection();
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

    //For Android only
    public void TestCasePCOM_017() {
        //Turn on Cellular connection
        if(loginElements.getCellularConnectionStatus()==false) {
            turnOnCellularConnection();
            Assert.assertTrue(loginElements.getCellularConnectionStatus(), "Cellular connection didn't turn on");
        }
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

    public void TestCasePCOM_018() {

        //Turn on Cellular connection
        if(loginElements.getCellularConnectionStatus()==false) {
            turnOnCellularConnection();
            Assert.assertTrue(loginElements.getCellularConnectionStatus(), "Cellular connection didn't turn on");
        }
        //Turn on Wifi connection
        if(loginElements.getWiFiConnectionStatus() == false){
            turnOnWifi();
            Assert.assertTrue(loginElements.getWiFiConnectionStatus(), "Wifi connection didn't turn on");
        }

        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();

        //check if account has not signed up
        if(!Utils.checkElementExist(settingElements.viewAccountDetails)) {
            settingElements.logInOrSignUp.click();

            loginElements.setValue(loginElements.email, Constants.LOGIN_EMAIL);

            loginElements.setValue(loginElements.password, Constants.LOGIN_PASSWORD);
            loginElements.logInButton.click();


            waitForVisibilityOf(settingElements.settingsHeading);

            //Check Setting page appears
            Assert.assertEquals("Settings",settingElements.settingsHeading.getText().trim(), "Check Setting is being taken");
           //Check account display correctly
            Assert.assertTrue(Utils.checkElementExist(settingElements.viewAccountDetails), "Check account logged in successfully");
            Assert.assertEquals(Constants.SETTING_TITLE.VIEW_ACCOUNT_DETAILS,settingElements.viewAccountDetails.getText().trim(), "Check View Account Details displays");

        }else{
            Assert.assertEquals(Constants.SETTING_TITLE.VIEW_ACCOUNT_DETAILS,settingElements.viewAccountDetails.getText().trim(), "Check View Account Details displays");

        }
    }

    public void TestCasePCOM_019() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);

        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);
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

    public void TestCasePCOM_020() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);
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

    public void TestCasePCOM_021() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);
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

    public void TestCasePCOM_022() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);
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

    public void TestCasePCOM_023() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);
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

    public void TestCasePCOM_024() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();

        //Check Login screen displays
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);

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

        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);
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

        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);
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

    public void TestCasePCOM_027() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);
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

    public void TestCasePCOM_028() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);
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

    public void TestCasePCOM_032() {
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

    public void TestCasePCOM_033() {
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

    public void TestCasePCOM_035() {
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

    public void TestCasePCOM_036() {
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

    public void TestCasePCOM_038_001() {
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

    public void TestCasePCOM_038_002() {
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

    public void TestCasePCOM_039() {
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

    public void TestCasePCOM_041() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);

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

    public void TestCasePCOM_042() {

        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        settingElements.logInOrSignUp.click();
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);

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
        if(loginElements.getWiFiConnectionStatus()==true) {
            turnOffWifi();
        }
        if(loginElements.getCellularConnectionStatus()==true){
            turnOffCellularConnection();
        }

        //Click Log In
        loginElements.logInButton.click();

        //Check messages returned
        loginElements.assertValue(loginElements.dialogTitle, Constants.LOGIN.NETWORK_ERROR_TITLE);
        loginElements.assertValue(loginElements.dialogMessage, Constants.LOGIN.NETWORK_ERROR_MESSAGE);

        Assert.assertTrue(Utils.checkElementExist(loginElements.tryAgainDialogButton));
    }

    public void TestCasePCOM_044() {
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
        if(loginElements.getWiFiConnectionStatus()==true) {
            turnOffWifi();
        }
        if(loginElements.getCellularConnectionStatus()==true){
            turnOffCellularConnection();
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

    public void TestCasePCOM_045() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        settingElements.logInOrSignUp.click();
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);

        //Click Forgot Password link
        loginElements.forgotPasswordLink.click();

        //Check Forgot Password screen appears
        loginElements.assertValue(loginElements.actionBarTitle, "Reset Password");

    }

    public void TestCasePCOM_046() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        settingElements.logInOrSignUp.click();
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);

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

}

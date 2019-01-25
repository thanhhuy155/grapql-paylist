package pages;

import elements.*;
import io.appium.java_client.AppiumDriver;
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

    public void TestCaseNo1() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);
        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.loginTopTitle);

        //Check Login screen
        loginElements.assertValue(loginElements.loginTopTitle, Constants.LOGIN.LOG_IN_TITLE);
        Assert.assertTrue(Utils.checkElementExist(loginElements.closeAction),"Check Top App App - Left Action Close display: ");
        Assert.assertTrue(Utils.checkElementExist(loginElements.email), "Check Email text field displays");
        Assert.assertTrue(Utils.checkElementExist(loginElements.password), "Check Password field displays");
        Assert.assertTrue(Utils.checkElementExist(loginElements.showOrHidePasswordIcon), "Check Password icon show");
        Assert.assertTrue(Utils.checkElementExist(loginElements.logInButton), "Check Log In button displays");
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotEmailLink), "Check Forgot Email link displays");
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotPasswordLink), "Check Forgot Password link displays");
        Assert.assertTrue(Utils.checkElementExist(loginElements.signUpLink), "Check Sign Up link displays");

    }

    public void TestCaseNo2() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);

        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.loginTopTitle);

        //Check Login screen displays
        loginElements.assertValue(loginElements.loginTopTitle, Constants.LOGIN.LOG_IN_TITLE);
        loginElements.closeAction.click();

        //Check Setting page appears
        Assert.assertEquals("Settings",settingElements.settingsHeading.getText().trim(), "Check Setting is being taken");

    }

    public void TestCaseNo3() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();

        settingElements.logInOrSignUp.click();
        loginElements.assertValue(loginElements.loginTopTitle,"Log In");

        lockDevice();
        unLockDevice();
        Utils.sleep(Constants.SHORTTIME);
        activateApp();

        loginElements.closeAction.click();
        //Check Setting page appears
        Assert.assertEquals("Settings",settingElements.settingsHeading.getText().trim(), "Check Setting is being taken");

        ///navigate all tabs
        commonElements.homeTabClick();

        exploreElements.exploreTab.click();
        //Check Explore page appears
        Assert.assertEquals("Explore",exploreElements.headingTitle.getText().trim(), "Check Explore tab is being displayed");

        bookMarkElements.bookMarkTab.click();

    }
    public void TestCaseNo4() {
    }

    public void TestCaseNo5() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();

        //check if account has not signed up
        if(!Utils.checkElementExist(settingElements.viewAccountDetails)) {
            settingElements.logInOrSignUp.click();

            loginElements.setValue(loginElements.email, Constants.LOGIN_EMAIL);
            loginElements.assertValue(loginElements.email, Constants.LOGIN_EMAIL);

            loginElements.setValue(loginElements.password, Constants.LOGIN_PASSWORD);
            loginElements.assertValue(loginElements.password, Constants.LOGIN_PASSWORD);
            loginElements.logInButton.click();
            waitForVisibilityOf(settingElements.settingsHeading);

            //Check Setting page appears
            Assert.assertEquals("Settings",settingElements.settingsHeading.getText().trim(), "Check Setting is being taken");
           //Check account display correctly
            Assert.assertTrue(Utils.checkElementExist(settingElements.signedUpAccount), "Check account logged in successfully");
            Assert.assertTrue(Utils.checkElementExist(settingElements.viewAccountDetails), "Check account logged in successfully");
            Assert.assertEquals(Constants.SETTING_TITLE.VIEW_ACCOUNT_DETAILS,settingElements.viewAccountDetails.getText().trim(), "Check View Account Details displays");

        }else{
            Assert.assertEquals(Constants.SETTING_TITLE.VIEW_ACCOUNT_DETAILS,settingElements.viewAccountDetails.getText().trim(), "Check View Account Details displays");

        }
    }
    public void TestCaseNo6() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);

        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf(loginElements.loginTopTitle);

        //Check Login screen displays
        loginElements.assertValue(loginElements.loginTopTitle, Constants.LOGIN.LOG_IN_TITLE);

        //Input invalid Email
        loginElements.setValue(loginElements.email, "fairlyenclave.vn");
        loginElements.setValue(loginElements.password, Constants.LOGIN_PASSWORD);
        loginElements.logInButton.click();

        //Check error message is being returned
        loginElements.assertValue(loginElements.messageEmail, Constants.LOGIN.INVALID_EMAIL_ERROR_MESSAGE);
    }
    public void TestCaseNo7() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf(loginElements.loginTopTitle);

        //Check Login screen displays
        loginElements.assertValue(loginElements.loginTopTitle, Constants.LOGIN.LOG_IN_TITLE);

        //Input invalid Email
        loginElements.setValue(loginElements.email, "fairlyenclave.vn");
        loginElements.setValue(loginElements.password, "");

        //Check error message is being returned
        loginElements.assertValue(loginElements.messageEmail, Constants.LOGIN.INVALID_EMAIL_ERROR_MESSAGE);

    }
    public void TestCaseNo8() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf(loginElements.loginTopTitle);

        //Check Login screen displays
        loginElements.assertValue(loginElements.loginTopTitle, Constants.LOGIN.LOG_IN_TITLE);

        //Input invalid Email
        loginElements.setValue(loginElements.email, "mnguyen@philly.com");
        //Input valid Password
        loginElements.setValue(loginElements.password, "123");
        loginElements.logInButton.click();

        //Check dialog message is being returned
        loginElements.assertValue(loginElements.dialogMessage,Constants.LOGIN.UNMATCHED_ACCOUNT_DIALOG_MESSAGE);
        //Check dialog TRY AGAIN button displays
        loginElements.assertValue(loginElements.tryAgaindialogButton,Constants.LOGIN.TRY_AGAIN_DIALOG_BUTTON);

    }

    public void TestCaseNo9() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf(loginElements.loginTopTitle);

        //Check Login screen displays
        loginElements.assertValue(loginElements.loginTopTitle, Constants.LOGIN.LOG_IN_TITLE);

        //Input valid Email
        loginElements.setValue(loginElements.email, Constants.LOGIN_EMAIL);
        //Input invalid Password
        loginElements.setValue(loginElements.password, "InvalidPass");
        loginElements.logInButton.click();

        //Check dialog message is being returned
        loginElements.assertValue(loginElements.dialogMessage,Constants.LOGIN.UNMATCHED_ACCOUNT_DIALOG_MESSAGE);
        //Check dialog TRY AGAIN button displays
        loginElements.assertValue(loginElements.tryAgaindialogButton,Constants.LOGIN.TRY_AGAIN_DIALOG_BUTTON);
    }

    public void TestCaseNo10() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf(loginElements.loginTopTitle);

        //Check Login screen displays
        loginElements.assertValue(loginElements.loginTopTitle, Constants.LOGIN.LOG_IN_TITLE);

        //Case 1: Input invalid email
        //Input invalid Email
        loginElements.setValue(loginElements.email, "failry@enclave.com");
        //Input valid Password
        loginElements.setValue(loginElements.password, Constants.LOGIN_PASSWORD);
        loginElements.logInButton.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.dialogMessage);

        //Check dialog message is being returned
        loginElements.assertValue(loginElements.dialogMessage,Constants.LOGIN.UNMATCHED_ACCOUNT_DIALOG_MESSAGE);

        loginElements.tryAgaindialogButton.click();

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

        loginElements.tryAgaindialogButton.click();

        //check dialog is disappeared
        Assert.assertFalse(Utils.checkElementExist(loginElements.dialogMessage), "Check dialog is closed");

        loginElements.assertFocused(loginElements.email,"false");
        loginElements.assertFocused(loginElements.password,"true");
    }


    public void TestCaseNo11() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);
        settingElements.logInOrSignUp.click();

        //Check Login screen displays
        loginElements.assertValue(loginElements.loginTopTitle, Constants.LOGIN.LOG_IN_TITLE);

        //leave Email and Password as blank
        //Click Login
        loginElements.logInButton.click();

        //Check error messages returned  <<<
        loginElements.assertValue(loginElements.messageEmail, Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);
        loginElements.assertValue(loginElements.messagePassword, Constants.LOGIN.BLANK_PASSWORD_ERROR_MESSAGE);
    }

    public void TestCaseNo12() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf(loginElements.loginTopTitle);

        //Check Login screen displays
        loginElements.assertValue(loginElements.loginTopTitle, Constants.LOGIN.LOG_IN_TITLE);

        //click and leave Email as blank
        loginElements.setValue(loginElements.email,"");

        //Click on password
        loginElements.setValue(loginElements.password,"");

        //Check error message returned
        loginElements.assertValue(loginElements.messageEmail, Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);

    }

    public void TestCaseNo13() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf(loginElements.loginTopTitle);

        //Check Login screen displays
        loginElements.assertValue(loginElements.loginTopTitle, Constants.LOGIN.LOG_IN_TITLE);

        //click and leave Email as blank
        loginElements.setValue(loginElements.email,"");

        //Click on password
        loginElements.setValue(loginElements.password,"");

        //Click Login
        loginElements.logInButton.click();

        //Check error message returned
        loginElements.assertValue(loginElements.messageEmail, Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);
        loginElements.assertValue(loginElements.messagePassword, Constants.LOGIN.BLANK_PASSWORD_ERROR_MESSAGE);

    }

    public void TestCaseNo14() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf(loginElements.loginTopTitle);

        //Check Login screen displays
        loginElements.assertValue(loginElements.loginTopTitle, Constants.LOGIN.LOG_IN_TITLE);


        //Click on password
        loginElements.setValue(loginElements.password,"");


        //Check no error messages returned
        loginElements.assertVisible(appiumDriver ,loginElements.messageEmail, false);
        loginElements.assertVisible(appiumDriver ,loginElements.messagePassword, false);
    }

    public void TestCaseNo15() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf(loginElements.loginTopTitle);

        //Check Login screen displays
        loginElements.assertValue(loginElements.loginTopTitle, Constants.LOGIN.LOG_IN_TITLE);


        //Enter valid password
        loginElements.setValue(loginElements.password, Constants.LOGIN_PASSWORD);


        //Check no error message returned
        loginElements.assertValue(loginElements.messageEmail,Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);

    }
}

package pages;

import elements.*;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import utils.Constants;
import utils.Utils;

public class iOSForgotEmailPage extends BasePage {


    private CommonElements commonElements;
    private ExploreElements exploreElements;
    private BookMarkElements bookMarkElements;
    private SettingElements settingElements;
    private LoginElements loginElements;


    public iOSForgotEmailPage(AppiumDriver driver) {
        super(driver);

        commonElements = new CommonElements(driver);
        settingElements= new SettingElements(driver);
        exploreElements= new ExploreElements(driver);
        bookMarkElements= new BookMarkElements(driver);
        loginElements = new LoginElements(driver);

    }


    public void TestCasePCOM_001() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);


        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);
        //Check Login screen
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotEmailLink), "Check Forgot Email link displays");


        //Click Forgot Email link
        loginElements.forgotEmailLink.click();
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotEmailMessage),"Check forgot message display: ");
        loginElements.assertValue(loginElements.forgotEmailMessage, Constants.LOGIN.FORGOT_EMAIL_MESSAGE);

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
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotEmailLink), "Check Forgot email link exist");

        //Click Forgot Email link
        loginElements.forgotEmailLink.click();
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotEmailMessage),"Check forgot email information message display: ");
        loginElements.assertValue(loginElements.forgotEmailMessage, Constants.LOGIN.FORGOT_EMAIL_MESSAGE);


        //Click on phone number on the message
        loginElements.clickCustomerServiceNumber(appiumDriver, loginElements.forgotEmailMessage);
        Assert.assertTrue(Utils.checkElementExist(loginElements.callButton));
        Assert.assertTrue(Utils.checkElementExist(loginElements.cancelButton));


        //Click Call
        loginElements.callButton.click();
        Assert.assertFalse(Utils.checkElementExist(loginElements.endCallButton));

        if(Utils.checkElementExist(loginElements.OKButton)) {
        //Click OK to end Call in iPhone 6S Plus
            loginElements.OKButton.click();
            Utils.sleep(Constants.SHORTTIME);

            //Click Cancel to back Login page
            loginElements.cancelButton.click();
        }

        //Check Login page
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);

    }

    public void TestCasePCOM_004() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);


        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);
        //Check Login screen
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotEmailLink), "Check Forgot email link exist");

        //Click Forgot Email link
        loginElements.forgotEmailLink.click();
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotEmailMessage),"Check forgot email information message display: ");
        loginElements.assertValue(loginElements.forgotEmailMessage, Constants.LOGIN.FORGOT_EMAIL_MESSAGE);


        //Click on phone number on the message
        loginElements.clickCustomerServiceNumber(appiumDriver, loginElements.forgotEmailMessage);
        Assert.assertTrue(Utils.checkElementExist(loginElements.callButton));
        Assert.assertTrue(Utils.checkElementExist(loginElements.cancelButton));


        //Click Cancel
        loginElements.cancelButton.click();
        Assert.assertFalse(Utils.checkElementExist(loginElements.callButton));

    }


    public void TestCasePCOM_005_001() {

        //Case 3
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);


        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);
        //Check Login screen
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);

        //Click Forgot Email link
        loginElements.forgotEmailLink.click();
        loginElements.assertValue(loginElements.forgotEmailMessage, Constants.LOGIN.FORGOT_EMAIL_MESSAGE);


        //Click on phone number on the message
        loginElements.clickCustomerServiceNumber(appiumDriver, loginElements.forgotEmailMessage);
        Assert.assertTrue(Utils.checkElementExist(loginElements.callButton));

        //Click Call
        loginElements.callButton.click();
        Utils.sleep(Constants.SHORTTIME*2);

        if(Utils.checkElementExist(loginElements.cancelButton)){
            loginElements.cancelButton.click();
            Utils.sleep(Constants.SHORTTIME);
        }

        Assert.assertTrue(Utils.checkElementExist(loginElements.exitResetEmailButton));


        //Click Close
        loginElements.exitResetEmailButton.click();
        //Check Forgot email information message is disabled
        Assert.assertFalse(Utils.checkElementExist(loginElements.exitResetEmailButton),"Check Forgot email information message is closed ");
    }


    public void TestCasePCOM_005_002() {

        //Case 3
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);


        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);
        //Check Login screen
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);

        //Click Forgot Email link
        loginElements.forgotEmailLink.click();
        loginElements.assertValue(loginElements.forgotEmailMessage, Constants.LOGIN.FORGOT_EMAIL_MESSAGE);


        //Click on phone number on the message
        loginElements.clickCustomerServiceNumber(appiumDriver, loginElements.forgotEmailMessage);
        Assert.assertTrue(Utils.checkElementExist(loginElements.callButton));
        Assert.assertTrue(Utils.checkElementExist(loginElements.cancelButton));

        //Click Cancel
        loginElements.cancelButton.click();
        Assert.assertFalse(Utils.checkElementExist(loginElements.callButton));

        //Click Close
        loginElements.exitResetEmailButton.click();
        //Check Forgot email information message is disabled
        Assert.assertFalse(Utils.checkElementExist(loginElements.exitResetEmailButton),"Check Forgot email information message is closed ");
    }


    public void TestCasePCOM_006() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);


        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);
        //Check Login screen
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);


        //Click Email field
        loginElements.email.click();


        //Click Password field
        loginElements.password.click();


        //Click Forgot Email link
        loginElements.forgotEmailLink.click();

        Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN, loginElements.forgotEmailLink);

        //Click Forgot email link
        loginElements.forgotEmailLink.click();
        //Check forgot email information message displays
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotEmailMessage),"Check forgot email information message display: ");
        loginElements.assertValue(loginElements.forgotEmailMessage, Constants.LOGIN.FORGOT_EMAIL_MESSAGE);
    }
}

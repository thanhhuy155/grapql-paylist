package pages;

import elements.*;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import utils.Constants;
import utils.Utils;

public class iOSForgotEmailPage extends BasePage {


    private CommonElements commonElements;
    private SettingElements settingElements;
    private LoginElements loginElements;


    public iOSForgotEmailPage(AppiumDriver driver) {
        super(driver);

        commonElements = new CommonElements(driver);
        settingElements= new SettingElements(driver);
        loginElements = new LoginElements(driver);
    }


    public void TestCasePCOM_001() {
        //1. Open the Philly.com app to "Log In" screen
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);

        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotEmailLink), "Check Forgot Email link displays");


        //2. Click "Forgot email?" link
        loginElements.forgotEmailLink.click();
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotEmailMessage),"Check forgot message display: ");
        loginElements.assertValue(loginElements.forgotEmailMessage, Constants.LOGIN.FORGOT_EMAIL_MESSAGE);
    }

    public void TestCasePCOM_002() {
        //1. Open the Philly.com app to "Log In" screen
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);

        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotEmailLink), "Check Forgot email link exist");


        //2. Click "Forgot email?" link
        loginElements.forgotEmailLink.click();
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotEmailMessage),"Check forgot email information message display: ");
        loginElements.assertValue(loginElements.forgotEmailMessage, Constants.LOGIN.FORGOT_EMAIL_MESSAGE);


        //3. Click on the phone number on the message
        loginElements.clickCustomerServiceNumber(appiumDriver, loginElements.forgotEmailMessage);
        Assert.assertTrue(Utils.checkElementExist(loginElements.callButton));
        Assert.assertTrue(Utils.checkElementExist(loginElements.cancelButton));


        //4. Click Call button
        loginElements.callButton.click();
        Assert.assertFalse(Utils.checkElementExist(loginElements.endCallButton));


        //5. End call and return to the app
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
        //1. Open the Philly.com app to "Log In" screen
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);

        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotEmailLink), "Check Forgot email link exist");


        //2. Click "Forgot email?" link
        loginElements.forgotEmailLink.click();
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotEmailMessage),"Check forgot email information message display: ");
        loginElements.assertValue(loginElements.forgotEmailMessage, Constants.LOGIN.FORGOT_EMAIL_MESSAGE);


        //3. Click on the phone number on the message
        loginElements.clickCustomerServiceNumber(appiumDriver, loginElements.forgotEmailMessage);
        Assert.assertTrue(Utils.checkElementExist(loginElements.callButton));
        Assert.assertTrue(Utils.checkElementExist(loginElements.cancelButton));


        //4. Click Cancel button
        loginElements.cancelButton.click();
        Assert.assertFalse(Utils.checkElementExist(loginElements.callButton));
    }


    public void TestCasePCOM_005_001() {
        //1. Open the Philly.com app to "Log In" screen
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);

        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);


        //2. Click "Forgot email?" link
        loginElements.forgotEmailLink.click();
        loginElements.assertValue(loginElements.forgotEmailMessage, Constants.LOGIN.FORGOT_EMAIL_MESSAGE);


        //3. Click on the phone number on the message
        loginElements.clickCustomerServiceNumber(appiumDriver, loginElements.forgotEmailMessage);
        Assert.assertTrue(Utils.checkElementExist(loginElements.callButton));


        //4. Click Call button
        loginElements.callButton.click();
        Utils.sleep(Constants.SHORTTIME*2);

        //5. Return to the app
        if(Utils.checkElementExist(loginElements.cancelButton)){
            loginElements.cancelButton.click();
            Utils.sleep(Constants.SHORTTIME);
        }

        Assert.assertTrue(Utils.checkElementExist(loginElements.exitResetEmailButton));


        //6. Click Close(x) button
        loginElements.exitResetEmailButton.click();
        Assert.assertFalse(Utils.checkElementExist(loginElements.exitResetEmailButton),"Check Forgot email information message is closed ");
    }


    public void TestCasePCOM_005_002() {
        //1. Open the Philly.com app to "Log In" screen
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);

        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);


        //2. Click "Forgot email?" link
        loginElements.forgotEmailLink.click();
        loginElements.assertValue(loginElements.forgotEmailMessage, Constants.LOGIN.FORGOT_EMAIL_MESSAGE);


        //3. Click on the phone number on the message
        loginElements.clickCustomerServiceNumber(appiumDriver, loginElements.forgotEmailMessage);
        Assert.assertTrue(Utils.checkElementExist(loginElements.callButton));
        Assert.assertTrue(Utils.checkElementExist(loginElements.cancelButton));


        //4. Click Cancel buttonl
        loginElements.cancelButton.click();
        Assert.assertFalse(Utils.checkElementExist(loginElements.callButton));


        //5. Click Close(x) button
        loginElements.exitResetEmailButton.click();
        Assert.assertFalse(Utils.checkElementExist(loginElements.exitResetEmailButton),"Check Forgot email information message is closed ");
    }


    public void TestCasePCOM_006() {
        //1. Open the Philly.com app to "Log In" screen
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);

        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);


        //2. Click Email/ Password field
        loginElements.email.click();
        loginElements.password.click();


        //3. Click "Forgot email?" link
        loginElements.forgotEmailLink.click();
        Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN, loginElements.forgotEmailLink);
        loginElements.forgotEmailLink.click();
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotEmailMessage),"Check forgot email information message display: ");
        loginElements.assertValue(loginElements.forgotEmailMessage, Constants.LOGIN.FORGOT_EMAIL_MESSAGE);
    }
}

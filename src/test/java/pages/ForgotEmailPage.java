package pages;

import elements.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.Assert;
import utils.Constants;
import utils.Utils;

public class ForgotEmailPage extends BasePage {


    private CommonElements commonElements;
    private SettingElements settingElements;
    private LoginElements loginElements;


    public ForgotEmailPage(AppiumDriver driver) {
        super(driver);

        commonElements = new CommonElements(driver);
        settingElements= new SettingElements(driver);
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

    public void TestCasePCOM_003() {
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

        String currentDeviceVersion = Utils.getDeviceVersion(appiumDriver);
        switch (currentDeviceVersion){
            case Constants.DEVICE_VERSION.GALAXY_S5_5_0:
                //Click on phone number on the message
                loginElements.clickCustomerServiceNumber(appiumDriver, loginElements.forgotEmailMessage);
                waitForVisibilityOf(loginElements.dialerWindow);
                Assert.assertTrue(Utils.checkElementExist(loginElements.dialerWindow),"Check dialer window display: ");
                loginElements.assertValue(loginElements.customerServiceNumber, Constants.LOGIN.CUSTOMER_SERVICE_NUMBER);

                //Click Back button on device to return app
                ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.BACK));
                Utils.sleep(Constants.SHORTTIME);
                break;

            case Constants.DEVICE_VERSION.GALAXY_S8_8_0:
                //Click on phone number on the message
                loginElements.clickCustomerServiceNumber(appiumDriver, loginElements.forgotEmailMessage);

                loginElements.assertValue(loginElements.customerServiceNumber, Constants.LOGIN.CUSTOMER_SERVICE_NUMBER_GALAXY_S8);

                //Click Back button twice to return app
                ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.BACK));
                ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.BACK));
                Utils.sleep(Constants.SHORTTIME);
                break;

            case Constants.DEVICE_VERSION.GALAXY_NOTE9_8_1:
                break;

        }

        //Check Log In screen is being returned
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);
    }


    public void TestCasePCOM_005() {

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


        //Click Cancel button
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

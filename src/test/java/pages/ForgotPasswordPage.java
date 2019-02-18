package pages;

import elements.CommonElements;
import elements.FeedListElements;
import elements.LoginElements;
import elements.SettingElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;
import org.testng.Assert;
import utils.Constants;
import utils.Utils;

public class ForgotPasswordPage extends BasePage {


    private CommonElements commonElements;
    private FeedListElements feedListElements;
    private SettingElements settingElements;
    private LoginElements loginElements;


    public ForgotPasswordPage(AppiumDriver driver) {
        super(driver);

        commonElements = new CommonElements(driver);
        settingElements= new SettingElements(driver);
        feedListElements= new FeedListElements(driver);
        loginElements = new LoginElements(driver);

    }


    public void TestCasePCOM_001() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        //Click Log In or Sign Up
        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);
        //Check Login screen
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);


        //Click Forgot Password link
        loginElements.forgotPasswordLink.click();
        //Check Forgot Password screen
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotPasswordMessage),"Check forgot message displays");
        loginElements.assertValue(loginElements.forgotPasswordMessage, Constants.LOGIN.FORGOT_PASSWORD_MESSAGE);
        Assert.assertTrue(Utils.checkElementExist(loginElements.email),"Check Email field displays ");
        Assert.assertTrue(Utils.checkElementExist(loginElements.sendEmailButton),"Check SEND EMAIL button displays ");

        //Extra step to hidden keyboard
        loginElements.hiddenKeyboard(appiumDriver,loginElements.email);

        loginElements.assertValue(loginElements.forgotEmailMessage, Constants.LOGIN.FORGOT_EMAIL_ADDRESS_MESSAGE);
    }


    public void TestCasePCOM_002() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        //Click Log In or Sign Up
        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);
        //Check Login screen
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);


        //Click Forgot Password link
        loginElements.forgotPasswordLink.click();
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotPasswordMessage),"Check forgot message displays");

        lockDevice();
        unLockDevice();
        Utils.sleep(Constants.SHORTTIME);

        //Click Back button to return Log In screen
        loginElements.closeActionButton.click();
        //Check Login screen
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);

        //Click close Log In screen
        loginElements.closeActionButton.click();
        //Check Setting screen displays
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);

        //Click all tabs
        commonElements.homeTab.click();
        commonElements.exploreTab.click();
        commonElements.settingTab.click();
        commonElements.bookMarkTab.click();

        ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.HOME));
    }

    public void TestCasePCOM_006() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        Utils.sleep(Constants.SHORTTIME);
        waitForVisibilityOf(settingElements.logInOrSignUp);

        //Click Log In or Sign Up
        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);
        //Check Login screen
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);


        //Click Forgot Password link
        loginElements.forgotPasswordLink.click();

        //Check Reset Password screen displays
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotPasswordMessage),"Check forgot message displays");

        //Click Home to terminate
        ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.HOME));

        //Open app
        lauchApp();
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);
        Assert.assertTrue(Utils.checkElementExist(feedListElements.feedItemTitleTopStory));
    }


    public void TestCasePCOM_007() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);

        //Click Log In or Sign Up
        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);
        //Check Login screen
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);


        //Click Forgot Password link
        loginElements.forgotPasswordLink.click();
        //Check Reset Password screen displays
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotPasswordMessage),"Check forgot message displays");

        //Leave Email as blank

        //Click Send Email
        loginElements.sendEmailButton.click();
        //Check Error message displays
        Assert.assertTrue(Utils.checkElementExist(loginElements.messageEmail));
        loginElements.assertValue(loginElements.messageEmail, Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);
    }


    public void TestCasePCOM_008() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);

        //Click Log In or Sign Up
        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);
        //Check Login screen
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);


        //Click Forgot Password link
        loginElements.forgotPasswordLink.click();
        //Check Reset Password screen displays
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotPasswordMessage),"Check forgot message displays");

        //Leave Email as blank

        //Click outside Email file
        loginElements.hiddenKeyboard(appiumDriver, loginElements.sendEmailButton);
        //Check Error message displays
        Assert.assertTrue(Utils.checkElementExist(loginElements.messageEmail));
        loginElements.assertValue(loginElements.messageEmail, Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);
    }


    public void TestCasePCOM_009() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);

        //Click Log In or Sign Up
        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);
        //Check Login screen
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);


        //Click Forgot Password link
        loginElements.forgotPasswordLink.click();
        //Check Reset Password screen displays
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotPasswordMessage),"Check forgot message displays");

        //Enter invalid Email
        loginElements.setValue(loginElements.email, "fairlyenclave.vn");

        //Click Send Email
        loginElements.sendEmailButton.click();
        //Check Error message displays
        Assert.assertTrue(Utils.checkElementExist(loginElements.messageEmail));
        loginElements.assertValue(loginElements.messageEmail, Constants.LOGIN.INVALID_EMAIL_ERROR_MESSAGE);
    }

    public void TestCasePCOM_010() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);

        //Click Log In or Sign Up
        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);
        //Check Login screen
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);


        //Click Forgot Password link
        loginElements.forgotPasswordLink.click();
        //Check Reset Password screen displays
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotPasswordMessage),"Check forgot message displays");

        //Enter invalid Email format
        loginElements.setValue(loginElements.email, "fairlyenclave.vn");

        //Click outside Email
        loginElements.hiddenKeyboard(appiumDriver,loginElements.email);

        //Check Error message displays
        Assert.assertTrue(Utils.checkElementExist(loginElements.messageEmail));
        loginElements.assertValue(loginElements.messageEmail, Constants.LOGIN.INVALID_EMAIL_ERROR_MESSAGE);
    }


    public void TestCasePCOM_011() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);

        //Click Log In or Sign Up
        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);
        //Check Login screen
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);


        //Click Forgot Password link
        loginElements.forgotPasswordLink.click();
        //Check Reset Password screen displays
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotPasswordMessage),"Check forgot message displays");

        //Enter valid Email format
        loginElements.setValue(loginElements.email, Constants.LOGIN_EMAIL);

        //Click Send Email Email
        loginElements.sendEmailButton.click();
        Utils.sleep(Constants.SHORTTIME);
        //Check Success screen display
        Assert.assertTrue(Utils.checkElementExist(loginElements.successImage));
        loginElements.assertValue(loginElements.successMessage, Constants.LOGIN.SEND_EMAIL_SUCCESS_MESSAGE);
    }


    public void TestCasePCOM_013() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);

        //Click Log In or Sign Up
        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);
        //Check Login screen
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);


        //Click Forgot Password link
        loginElements.forgotPasswordLink.click();
        //Check Reset Password screen displays
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotPasswordMessage),"Check forgot message displays");

        //Click hidden keyboard
        loginElements.hiddenKeyboard(appiumDriver, loginElements.email);

        //Click the phone number on the message on Reset Password
        TouchAction touchAction = new TouchAction(appiumDriver);
        Point point = loginElements.forgotEmailMessage.getLocation();

        int pointX= point.x + (int)(0.2 * loginElements.forgotEmailMessage.getSize().width);
        int pointY= point.y + loginElements.forgotEmailMessage.getSize().height-1;

        touchAction.tap(PointOption.point(pointX,pointY)).perform();


        //Check Dialer screen displays
        waitForVisibilityOf(loginElements.dialerWindow);
        Assert.assertTrue(Utils.checkElementExist(loginElements.dialerWindow),"Check dialer window display: ");
        //Check dialer with the Number filled in
        loginElements.assertValue(loginElements.customerServiceNumber, Constants.LOGIN.CUSTOMER_SERVICE_NUMBER);

        //Return app by click back button
        ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.BACK));
        Utils.sleep(Constants.SHORTTIME);
        //Check Reset Password screen is being returned
        Assert.assertTrue(Utils.checkElementExist(loginElements.sendEmailButton));
    }


    public void TestCasePCOM_015() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);

        //Click Log In or Sign Up
        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);
        //Check Login screen
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);


        //Click Forgot Password link
        loginElements.forgotPasswordLink.click();
        //Check Reset Password screen displays
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotPasswordMessage),"Check forgot message displays");

        //Enter valid Email format
        loginElements.setValue(loginElements.email, Constants.LOGIN_EMAIL);

        //Click Send Email Email
        loginElements.sendEmailButton.click();
        Utils.sleep(Constants.SHORTTIME);
        //Check Success screen display
        Assert.assertTrue(Utils.checkElementExist(loginElements.successImage));
        loginElements.assertValue(loginElements.successMessage, Constants.LOGIN.SEND_EMAIL_SUCCESS_MESSAGE);

        //Click Back icon
        loginElements.closeActionButton.click();
        //Check Login screen
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);
    }
}

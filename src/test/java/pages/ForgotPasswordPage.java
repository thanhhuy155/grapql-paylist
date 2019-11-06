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
import scenarios.AppiumController;
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


    public void S236_C20219_FP_001_VerifyResetPasswordScreenDisplayWhenClickingForgotPasswordLink() {
        //1. Open the Philly.com app to "Log In" screen
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);


        //2. Click "Forgot password?" link
        loginElements.forgotPasswordLink.click();
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotPasswordMessage),"Check forgot message displays");
        loginElements.assertValue(loginElements.forgotPasswordMessage, Constants.LOGIN.FORGOT_PASSWORD_MESSAGE);
        Assert.assertTrue(Utils.checkElementExist(loginElements.email),"Check Email field displays ");
        Assert.assertTrue(Utils.checkElementExist(loginElements.sendEmailButton),"Check SEND EMAIL button displays ");

        //Extra step to hidden keyboard
        loginElements.hiddenKeyboard(appiumDriver,loginElements.email);
        loginElements.assertValue(loginElements.forgotEmailMessage, Constants.LOGIN.FORGOT_EMAIL_ADDRESS_MESSAGE);
    }


    public void S236_C20220_FP_002_VerifyResetPasswordScreenDisplayWhenClickingForgotPasswordLink() {
        //1. Open the Philly.com app to Log In screen from Settings tab.
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);


        //2. Click on "Forgot password?" link
        loginElements.forgotPasswordLink.click();
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotPasswordMessage),"Check forgot message displays");


        //3. Put the device to sleep with Philly.com app on the screen.
        lockDevice();


        //4. Wake the device and unlock (if applicable)
        //5. Observe the Philly.com app opened to "Reset Password" screen.
        unLockDevice();
        Utils.sleep(Constants.SHORTTIME);

        activateApp();


        //6. Return to Log In screen and cancel Log In.
        loginElements.closeActionButton.click();
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);
        loginElements.closeActionButton.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);


        //7. Click all tabs in navigation
        //8. Observe the tabs load without crashing.
        commonElements.homeTab.click();
        Assert.assertTrue(commonElements.homeTab.isSelected());
        commonElements.exploreTab.click();
        Assert.assertTrue(commonElements.exploreTab.isSelected());
        commonElements.settingTab.click();
        Assert.assertTrue(commonElements.settingTab.isSelected());
        commonElements.bookMarkTab.click();


        //9. Terminate the app by double clicking the home button and swiping up.
        ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.HOME));
         Assert.assertFalse(Utils.checkElementExist(commonElements.homeTab));
    }

    public void S236_C20222_FP_003_VerifySignUpScreenDoesNotDisplayWhenReopeningApp() {

        //1. Open the Philly.com app to Settings tab.
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        Utils.sleep(Constants.SHORTTIME);
        waitForVisibilityOf(settingElements.logInOrSignUp);


        //2. Click "Log In or Sign Up" option
        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);


        //3. Click "Forgot Password?" link
        //4. Observe "Reset Password" screen display
        loginElements.forgotPasswordLink.click();
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotPasswordMessage),"Check forgot message displays");


        //5. Terminate the app by double clicking the home button and swiping up
        ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.HOME));


        //6. Open the Philly.com app from home screen
        lauchApp();
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);
        Assert.assertTrue(Utils.checkElementExist(feedListElements.feedItemTitleTopStory));
    }


    public void S236_C20223_FP_004_VerifyErrorDisplaysWhenClickingSendEmailButtonWithEmptyEmail() {
        //1. Open the Philly.com app to "Log In" screen
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);

        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);


        //2. Click "Forgot Password?" link
        loginElements.forgotPasswordLink.click();
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotPasswordMessage),"Check forgot message displays");

        //3. Leave Email field as blank


        //4. Click on "Send Email" button
        loginElements.sendEmailButton.click();
        Assert.assertTrue(Utils.checkElementExist(loginElements.messageEmail));
        loginElements.assertValue(loginElements.messageEmail, Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);
    }


    public void S236_C20224_FP_005_VerifyErrorDisplaysWhenClickingOutsideEmailFieldWithEmptyEmail() {
        //1. Open the Philly.com app to "Log In" screen
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);

        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);


        //2. Click "Forgot Password?" link
        loginElements.forgotPasswordLink.click();
        //Check Reset Password screen displays
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotPasswordMessage),"Check forgot message displays");


        //3. Leave Email field as blank


        //4. Click outside
        loginElements.hiddenKeyboard(appiumDriver, loginElements.sendEmailButton);
        Assert.assertTrue(Utils.checkElementExist(loginElements.messageEmail));
        loginElements.assertValue(loginElements.messageEmail, Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);
    }


    public void S236_C20225_FP_006_VerifyErrorDisplaysWhenResettingInvalidEmail() {
        //1. Open the Philly.com app to "Log In" screen
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);

        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);


        //2. Click "Forgot Password?" link
        loginElements.forgotPasswordLink.click();
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotPasswordMessage),"Check forgot message displays");


        //3. Enter invalid email format to Email field
        loginElements.setValue(loginElements.email, "fairlyenclave.vn");


        //4. Click on "Send Email" button
        loginElements.sendEmailButton.click();
        Assert.assertTrue(Utils.checkElementExist(loginElements.messageEmail));
        loginElements.assertValue(loginElements.messageEmail, Constants.LOGIN.INVALID_EMAIL_ERROR_MESSAGE);
    }


    public void S236_C20226_FP_007_VerifyErrorDisplaysWhenClickingOutsideInvalidEmailField() {
        //1. Open the Philly.com app to "Log In" screen
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);

        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);


        //2. Click "Forgot Password?" link
        loginElements.forgotPasswordLink.click();
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotPasswordMessage),"Check forgot message displays");


        //3. Enter invalid email format to Email field
        loginElements.setValue(loginElements.email, "fairlyenclave.vn");


        //4. Click outside
        loginElements.hiddenKeyboard(appiumDriver,loginElements.email);
        Assert.assertTrue(Utils.checkElementExist(loginElements.messageEmail));
        loginElements.assertValue(loginElements.messageEmail, Constants.LOGIN.INVALID_EMAIL_ERROR_MESSAGE);
    }


    public void S236_C20227_FP_008_VerifySuccessScreenDisplaysWhenInputValidEmailField() {
        //1. Open the Philly.com app to "Log In" screen
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);

        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);


        //2. Click "Forgot Password?" link
        loginElements.forgotPasswordLink.click();
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotPasswordMessage),"Check forgot message displays");


        //3. Enter valid email to Email field
        loginElements.setValue(loginElements.email, Constants.LOGIN_EMAIL);


        //4. Click on "Send Email" button
        loginElements.sendEmailButton.click();
        Utils.sleep(Constants.SHORTTIME);
        Assert.assertTrue(Utils.checkElementExist(loginElements.successImage));
        loginElements.assertValue(loginElements.successMessage, Constants.LOGIN.SEND_EMAIL_SUCCESS_MESSAGE);
    }


    public void S236_C20228_FP_009_VerifyPreviousScreenBeReturnedAfterClickingPhoneNumber() {
        //1. Open the Philly.com app to "Log In" screen
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);
        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);


        //2. Click "Forgot password?" link
        loginElements.forgotPasswordLink.click();
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotPasswordMessage),"Check forgot message displays");

        //3. Hide the keyboard
        loginElements.hiddenKeyboard(appiumDriver, loginElements.email);


        //4. Click the phone number on the message at bottom
        TouchAction touchAction = new TouchAction(appiumDriver);
        Point point = loginElements.forgotEmailMessage.getLocation();

        int pointX= point.x + (int)(0.2 * loginElements.forgotEmailMessage.getSize().width);
        int pointY= point.y + loginElements.forgotEmailMessage.getSize().height-1;

        touchAction.tap(PointOption.point(pointX,pointY)).perform();

         if(!AppiumController.executionOS.equals(AppiumController.OS.ANDROID_BROWSERSTACK)) {
            //Check Dialer screen displays
            waitForVisibilityOf(loginElements.dialerWindow);
            Assert.assertTrue(Utils.checkElementExist(loginElements.dialerWindow), "Check dialer window display: ");
            //Check dialer with the Number filled in
            loginElements.assertValue(loginElements.customerServiceNumber, Constants.LOGIN.CUSTOMER_SERVICE_NUMBER);


            //5. Return to the app
            ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.BACK));
            Utils.sleep(Constants.SHORTTIME);
            //Check Reset Password screen is being returned
            Assert.assertTrue(Utils.checkElementExist(loginElements.sendEmailButton));
        }
    }


    public void S236_C20230_FP_010_VerifyLogInScreenDisplayWhenClickingBackFromSuccessScreen() {
        //1. Open the Philly.com app to "Log In" screen
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);

        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);


        //2. Click "Forgot password?" link
        loginElements.forgotPasswordLink.click();
        //Check Reset Password screen displays
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotPasswordMessage),"Check forgot message displays");


        //3. Enter valid email to Email field
        loginElements.setValue(loginElements.email, Constants.LOGIN_EMAIL);


        //4. Click "Send Mail" button
        loginElements.sendEmailButton.click();
        Utils.sleep(Constants.SHORTTIME);
        Assert.assertTrue(Utils.checkElementExist(loginElements.successImage));
        loginElements.assertValue(loginElements.successMessage, Constants.LOGIN.SEND_EMAIL_SUCCESS_MESSAGE);


        //5. Click "Back" icon button on left top app bar.
        loginElements.closeActionButton.click();
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);
    }
}

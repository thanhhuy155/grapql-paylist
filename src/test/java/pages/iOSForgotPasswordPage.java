package pages;

import elements.CommonElements;
import elements.FeedListElements;
import elements.LoginElements;
import elements.SettingElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;
import org.testng.Assert;
import utils.Constants;
import utils.Utils;

import java.time.Duration;

public class iOSForgotPasswordPage extends BasePage {


    private CommonElements commonElements;
    private FeedListElements feedListElements;
    private SettingElements settingElements;
    private LoginElements loginElements;


    public iOSForgotPasswordPage(AppiumDriver driver) {
        super(driver);

        commonElements = new CommonElements(driver);
        settingElements= new SettingElements(driver);
        feedListElements= new FeedListElements(driver);
        loginElements = new LoginElements(driver);

    }


    public void S265_C22255_FP_001_VerifyResetPasswordScreenDisplayWhenClickingForgotPasswordLink() {
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


    public void S265_C22256_FP_003_VerifySignUpScreenDoesNotDisplayWhenReopeningApp() {
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
        // 4. Observe "Reset Password" screen display
        loginElements.forgotPasswordLink.click();
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotPasswordMessage),"Check forgot message displays");


        //5. Terminate the app by double clicking the home button and swiping up
        appiumDriver.runAppInBackground(Duration.ofSeconds(-1));


        //6. Open the Philly.com app from home screen
        lauchApp();
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);
        Assert.assertTrue(Utils.checkElementExist(feedListElements.feedItemTitleTopStory));
    }


    public void S265_C22257_FP_004_VerifyErrorDisplaysWhenClickingSendEmailButtonWithEmptyEmail() {
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
        String emailMsg = loginElements.email.getAttribute("name");//.getText();
        String [] emailMsgParts = emailMsg.split(":");
        String emailMsgPart2 = emailMsgParts[1].trim();
        Assert.assertEquals(emailMsgPart2, Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);
    }


    public void S265_C22258_FP_005_VerifyErrorDisplaysWhenClickingOutsideEmailFieldWithEmptyEmail() {
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


        //4. Click outside
        loginElements.hiddenKeyboard(appiumDriver, loginElements.sendEmailButton);
        String emailMsg = loginElements.email.getAttribute("name");//.getText();
        String [] emailMsgParts = emailMsg.split(":");
        String emailMsgPart2 = emailMsgParts[1].trim();
        Assert.assertEquals(emailMsgPart2, Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);
    }


    public void S265_C22259_FP_006_VerifyErrorDisplaysWhenResettingInvalidEmail() {
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
        Assert.assertTrue(Utils.checkElementExist(loginElements.email));

        //3. Enter invalid email format to Email field
        //work around to input value
        loginElements.setValue(loginElements.email, "fairlyenclave.vn");


        //4. Click on "Send Email" button
        loginElements.sendEmailButton.click();
        String message = loginElements.email.getAttribute("name");//.getText();
        String [] parts = message.split(":");
        String part2 = parts[1].trim();
        Assert.assertEquals(part2, Constants.LOGIN.INVALID_EMAIL_ERROR_MESSAGE);
    }

    public void S265_C24345_FP_007_VerifyErrorDisplaysWhenClickingOutsideInvalidEmailField() {
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


        //3. Enter invalid email format to Email field
        loginElements.setValue(loginElements.email, "fairlyenclave.vn");


        //4. Click outside
        loginElements.hiddenKeyboard(appiumDriver,loginElements.email);
        String message = loginElements.email.getAttribute("name");//.getText();
        String [] parts = message.split(":");
        String part2 = parts[1].trim();
        Assert.assertEquals(part2, Constants.LOGIN.INVALID_EMAIL_ERROR_MESSAGE);
    }


    public void S265_C22260_FP_008_VerifySuccessScreenDisplaysWhenInputValidEmailField() {
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
        loginElements.assertValue(loginElements.successMessage, Constants.LOGIN.SEND_EMAIL_SUCCESS_MESSAGE);
    }


    public void S265_C20229_FP_010_VerifyResetPasswordScreenDisplaysWhenClickingCancel() {
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
        //Click hidden keyboard
        loginElements.hiddenKeyboard(appiumDriver, loginElements.email);


        //3. Click the phone number on the message at bottom
        TouchAction touchAction = new TouchAction(appiumDriver);
        Point point = loginElements.forgotEmailMessage.getLocation();

        int pointX= point.x + (int)(0.2 * loginElements.forgotEmailMessage.getSize().width);
        int pointY= point.y + loginElements.forgotEmailMessage.getSize().height-1;

        touchAction.tap(PointOption.point(pointX,pointY)).perform();

        Assert.assertTrue(Utils.checkElementExist(loginElements.callButton));
        Assert.assertTrue(Utils.checkElementExist(loginElements.cancelButton));


        //4. Click Cancel button
        loginElements.cancelButton.click();
        Utils.waitForElementVisible(appiumDriver,loginElements.sendEmailButton);
        Assert.assertTrue(Utils.checkElementExist(loginElements.sendEmailButton));
    }


    public void S265_C22261_FP_011_VerifyLogInScreenDisplayWhenClickingBackFromSuccessScreen() {
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


        //3. Enter valid email to Email field
        loginElements.setValue(loginElements.email, Constants.LOGIN_EMAIL);


        //4. Click "Send Mail" button
        loginElements.sendEmailButton.click();
        Utils.sleep(Constants.SHORTTIME*2);
        loginElements.assertValue(loginElements.successMessage, Constants.LOGIN.SEND_EMAIL_SUCCESS_MESSAGE);

        //5. Click "Back" icon button on left top app bar.
        loginElements.backButton.click();
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);
    }
}

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
        appiumDriver.runAppInBackground(Duration.ofSeconds(-1));

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
        String emailMsg = loginElements.email.getText();
        String [] emailMsgParts = emailMsg.split(":");
        String emailMsgPart2 = emailMsgParts[1].trim();

        Assert.assertEquals(emailMsgPart2, Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);
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
        String emailMsg = loginElements.email.getText();
        String [] emailMsgParts = emailMsg.split(":");
        String emailMsgPart2 = emailMsgParts[1].trim();

        Assert.assertEquals(emailMsgPart2, Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);
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
        Assert.assertTrue(Utils.checkElementExist(loginElements.email));

        //Enter invalid Email
        //work around to input value
        loginElements.setValue(loginElements.email, "fairlyenclave.vn");


        //Click Send Email
        loginElements.sendEmailButton.click();

        //Check Error message displays
        String message = loginElements.email.getText();
        String [] parts = message.split(":");
        String part2 = parts[1].trim();
        Assert.assertEquals(part2, Constants.LOGIN.INVALID_EMAIL_ERROR_MESSAGE);
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
        String emailElement = "//XCUIElementTypeTextField";

        loginElements.setValue(loginElements.email, "fairlyenclave.vn");

        //Click outside Email
        loginElements.hiddenKeyboard(appiumDriver,loginElements.email);

        //Check Error message displays
        String message = loginElements.email.getText();
        String [] parts = message.split(":");
        String part2 = parts[1].trim();
        Assert.assertEquals(part2, Constants.LOGIN.INVALID_EMAIL_ERROR_MESSAGE);
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
        loginElements.assertValue(loginElements.successMessage, Constants.LOGIN.SEND_EMAIL_SUCCESS_MESSAGE);
    }


    public void TestCasePCOM_014() {
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
        Assert.assertTrue(Utils.checkElementExist(loginElements.callButton));
        Assert.assertTrue(Utils.checkElementExist(loginElements.cancelButton));

        //Click Cancel
        loginElements.cancelButton.click();

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
        Utils.sleep(Constants.SHORTTIME*2);
        //Check Success screen display
        loginElements.assertValue(loginElements.successMessage, Constants.LOGIN.SEND_EMAIL_SUCCESS_MESSAGE);

        //Click Back icon
        loginElements.backButton.click();
        //Check Login screen
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);
    }
}

package pages;

import elements.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.Assert;
import utils.Constants;
import utils.Utils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class iOSSignUpPage extends BasePage {


    private CommonElements commonElements;
    private SettingElements settingElements;
    private LoginElements loginElements;
    private BookMarkElements bookMarkElements;
    private ExploreElements exploreElements;



    public iOSSignUpPage(AppiumDriver driver) {
        super(driver);

        commonElements = new CommonElements(driver);
        settingElements= new SettingElements(driver);
        loginElements = new LoginElements(driver);
        exploreElements= new ExploreElements(driver);
        bookMarkElements= new BookMarkElements(driver);
    }

    public void TestCasePCOM_001() {

        //1. Launch the app
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);

        //2. Go to Settings tab
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        //3. Click on "Log In or Sign Up" option
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf( loginElements.actionBarTitle);

        //4. Click on "Sign Up" link at the bottom
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);

        //Check SignUp screen
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);
        Assert.assertTrue(Utils.checkElementExist(loginElements.email));
        Assert.assertTrue(Utils.checkElementExist(loginElements.password));
        Assert.assertTrue(Utils.checkElementExist(loginElements.confirmPassword));
        Assert.assertTrue(Utils.checkElementExist(loginElements.signUpButton));
        loginElements.assertValue(loginElements.termAndPolicy, Constants.LOGIN.SIGN_UP_TERM_AND_POLICY);
    }


    public void TestCasePCOM_003() {
        //1. Launch the app
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);


        //2. Go to Settings tab
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);


        //3. Click on "Log In or Sign Up" option
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf( loginElements.actionBarTitle);


        //4. Click on "Sign Up" link at the bottomk
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);


        //5. Click Cancel button on top left bar
        loginElements.closeActionButton.click();
        //Check Settings screen is being returned
        loginElements.assertValue(settingElements.settingsHeading,"Settings");
    }



    public void TestCasePCOM_005() {
        //1. Open the Philly.com app to Sign Up screen from Settings tab.
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf( loginElements.actionBarTitle);
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);

        //2. Double click the home screen button and select another app.
        appiumDriver.runAppInBackground(Duration.ofSeconds(-1));
        Assert.assertFalse(Utils.checkElementExist(commonElements.settingTab));
        //Open another app. Launch Settings app
        Utils.launchSettingsApp(appiumDriver);


        //3. Double click the home screen button and reopen the Philly.com app.
        //4. Observe the Philly.com app opened to "Sign Up" screen.
        ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.HOME));
        //Reopen Philly app and navigate to Sign Up screen
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf( loginElements.actionBarTitle);
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);


        //5. Click on Cancel button
        loginElements.closeActionButton.click();
        loginElements.assertValue(settingElements.settingsHeading,"Settings");


        //6. Click all tabs in navigation
        //7. Observe the tabs load without crashing.
        commonElements.homeTabClick();
        exploreElements.exploreTab.click();
        loginElements.assertValue(exploreElements.headingTitle,"Explore");
        bookMarkElements.bookMarkTab.click();


        //8. Terminate the app by double clicking the home button and swiping up.
        ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.HOME));
        Assert.assertFalse(Utils.checkElementExist(commonElements.settingTab));
    }

    public void TestCasePCOM_006() {
        //1. Open the Philly.com app to Sign Up screen from Settings tab.
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf( loginElements.actionBarTitle);
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);

        //2. Click the home screen button and return to the home screen.
        ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.HOME));
        Assert.assertFalse(Utils.checkElementExist(commonElements.settingTab));


        //3. Open another app.
        Utils.launchSettingsApp(appiumDriver);


        //4. Click the home screen button and return to the home screen.
        ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.HOME));


        //TODO
        //5. Open the Philly.com app using multitasking
        ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
        ((AndroidDriver) appiumDriver).longPressKey(new KeyEvent(AndroidKey.APP_SWITCH));
        Utils.sleep(Constants.SHORTTIME);


        //6. Observe the Philly.com app opened to "Sign Up" screen.
        System.out.println("displayed: "+loginElements.phillyApp.isDisplayed());
        loginElements.phillyApp.click();
        System.out.println("selected: "+loginElements.phillyApp.isSelected());
        Utils.sleep(Constants.SHORTTIME*3);
        waitForVisibilityOf( loginElements.closeActionButton);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);


        //7. Click on Cancel button
        loginElements.closeActionButton.click();
        loginElements.assertValue(settingElements.settingsHeading,"Settings");


        //8. Click all tabs in navigation
        //9. Observe the tabs load without crashing.
        commonElements.homeTabClick();
        exploreElements.exploreTab.click();
        loginElements.assertValue(exploreElements.headingTitle,"Explore");
        bookMarkElements.bookMarkTab.click();


        //10. Terminate the app by double clicking the Android home button and swiping up.
        ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.HOME));
        Assert.assertFalse(Utils.checkElementExist(commonElements.settingTab));
    }


    public void TestCasePCOM_007() {
        //1. Open the Philly.com app using Test Case #1.
        lauchApp();

        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf( loginElements.actionBarTitle);
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);

        //2. Click the home screen button and return to the home screen.
        ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.HOME));
        Assert.assertFalse(Utils.checkElementExist(commonElements.bottomTab));

        //3. Open another app.
        Utils.launchSettingsApp(appiumDriver);

        //4. Click the home screen button and return to the home screen.
        ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.HOME));

        //5. Open the Philly.com app from home screen
        //6. Observe the Philly.com app opened to "Sign Up" screen.
        lauchApp();
        commonElements.settingTab.click();
        settingElements.logInOrSignUp.click();
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);

        //7. Click on Cancel button
        loginElements.closeActionButton.click();
        loginElements.assertValue(settingElements.settingsHeading,"Settings");

        //8. Click all tabs in navigation
        //9. Observe the tabs load without crashing.
        commonElements.homeTabClick();
        exploreElements.exploreTab.click();
        loginElements.assertValue(exploreElements.headingTitle,"Explore");
        bookMarkElements.bookMarkTab.click();

        //10. Terminate the app by double clicking the Android home button and swiping up.
        ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.HOME));
    }

    public void TestCasePCOM_008() {
        //1. Open the Philly.com app to Settings tab.
        lauchApp();

        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        //2. Click "Log In or Sign Up" option
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf( loginElements.actionBarTitle);

        //3. Click "Sign Up" link at the bottom
        //4. Observe "Sign Up" screen display
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);

        //5. Terminate the app by double clicking the home button and swiping up.
        appiumDriver.runAppInBackground(Duration.ofSeconds(-1));
        Assert.assertFalse(Utils.checkElementExist(commonElements.bottomTab));

        //6. Open the Philly.com app from home screen
        lauchApp();
        commonElements.settingTab.click();
        settingElements.logInOrSignUp.click();
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);
        loginElements.assertValue(loginElements.signUpTitle, Constants.LOGIN.SIGN_UP_TITLE);
    }

    public void TestCasePCOM_009() {


        //1. Open the Philly.com app to "Sign Up" screen
        lauchApp();
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf( loginElements.actionBarTitle);
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);

        //2. Enter valid email to Email field
        String emailAddress = Utils.generateEmailAddress();
        loginElements.setValue(loginElements.email, emailAddress);


        //3. Enter valid password to Password field
        loginElements.setValue(loginElements.password,Constants.SIGN_UP_PASSWORD);
        Assert.assertTrue(Utils.checkElementExist(loginElements.validatePassword));
        Assert.assertTrue(Utils.checkElementExist(loginElements.validateMinCharacters));
        Assert.assertTrue(Utils.checkElementExist(loginElements.validateLowercase));
        Assert.assertTrue(Utils.checkElementExist(loginElements.validateUppercase));
        Assert.assertTrue(Utils.checkElementExist(loginElements.validateNumber));

        //4. Enter password to Confirm Password field
        loginElements.setValue(loginElements.confirmPassword, Constants.SIGN_UP_PASSWORD);

        //5. Click "Sign Up" button
        loginElements.signUpButton.click();
        waitForVisibilityOf(settingElements.settingsHeading);
        Assert.assertEquals(settingElements.signedUpAccount.getAttribute("value"),emailAddress);
    }

    public void TestCasePCOM_010() {
        //1. Open the Philly.com app to "Sign Up" screen
        lauchApp();
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf( loginElements.actionBarTitle);
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);

        //2. Enter invalid email format to Email field
        loginElements.setValue(loginElements.email, "STEST01@gmail");


        //3. Enter valid password to Password field
        loginElements.setValue(loginElements.password, Constants.SIGN_UP_PASSWORD);

        //4. Enter password to Confirm Password field
        loginElements.setValue(loginElements.confirmPassword, Constants.SIGN_UP_PASSWORD);

        //5. Click "Sign Up" button
        loginElements.signUpButton.click();
        waitForVisibilityOf(loginElements.messageEmail);

        String emailMsg = loginElements.messageEmail.getText();
        String [] emailMsgParts = emailMsg.split(":");
        String emailMsgPart2 = emailMsgParts[1].trim();
        Assert.assertEquals(emailMsgPart2, Constants.LOGIN.INVALID_EMAIL_ERROR_MESSAGE);
    }

    public void TestCasePCOM_011() {
        //1. Open the Philly.com app to "Sign Up" screen
        lauchApp();
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf( loginElements.actionBarTitle);
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);

        //2. Enter registered email to Email field
        loginElements.setValue(loginElements.email, Constants.SIGN_UP_EMAIL);


        //3. Enter valid password to Password field
        loginElements.setValue(loginElements.password, Constants.SIGN_UP_PASSWORD);

        //4. Enter password to Confirm Password field
        loginElements.setValue(loginElements.confirmPassword, Constants.SIGN_UP_PASSWORD);

        //5. Click "Sign Up" button
        loginElements.signUpButton.click();
        waitForVisibilityOf(loginElements.messageEmail);

        String emailMsg = loginElements.messageEmail.getText();
        String [] emailMsgParts = emailMsg.split(":");
        String emailMsgPart2 = emailMsgParts[1].trim();
        Assert.assertEquals(emailMsgPart2, Constants.LOGIN.SIGN_UP_EMAIL_ERROR_MESSAGE);
    }

    public void TestCasePCOM_026() {
        //1. Open the Philly.com app to "Sign Up" screen
        lauchApp();
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf( loginElements.actionBarTitle);
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);

        //2. Enter valid email format to Email field
        loginElements.setValue(loginElements.email, Constants.SIGN_UP_EMAIL);


        //3. Enter valid password to Password field
        loginElements.setValue(loginElements.password, Constants.SIGN_UP_PASSWORD);

        //4. Enter invalid Confirm Password field
        loginElements.setValue(loginElements.confirmPassword, "TTTest1234");

        //5. Click "Sign Up" button
        loginElements.signUpButton.click();

        //Check error message on Confirm Password field
        String passwordMsg = loginElements.messageConfirmPassword.getText();
        String [] passwordMsgParts = passwordMsg.split(":");
        String passwordMsgPart2 = passwordMsgParts[1].trim();
        Assert.assertEquals(passwordMsgPart2, Constants.LOGIN.SIGN_UP_PASSWORD_ERROR_MESSAGE);
    }

    public void TestCasePCOM_027() {
        //1. Open the Philly.com app to "Sign Up" screen
        lauchApp();
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf( loginElements.actionBarTitle);
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);

        //2. Leave Email, Password and Confirm Password fields as blank


        //3. Click "Sign Up" button
        loginElements.signUpButton.click();

        String emailMsg = loginElements.messageEmail.getText();
        String [] emailMsgParts = emailMsg.split(":");
        String emailMsgPart2 = emailMsgParts[1].trim();
        Assert.assertEquals(emailMsgPart2, Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);
    }

    public void TestCasePCOM_028() {
        //1. Open the Philly.com app to "Sign Up" screen
        lauchApp();
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf( loginElements.actionBarTitle);
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);

        //2. Don't click and leave Email field as blank


        //3. Don't click and leave Password field as blank


        //4. Click Confirm Password field
        loginElements.confirmPassword.click();
        Assert.assertFalse(Utils.checkElementExist(loginElements.messageEmail));
        Assert.assertFalse(Utils.checkElementExist(loginElements.messagePassword));
    }

    public void TestCasePCOM_031() {
        //1. Open the Philly.com app to "Sign Up" screen
        lauchApp();
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf( loginElements.actionBarTitle);
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);


        //2. Click and leave Email field as blank
        loginElements.email.click();


        //3. Click on Password field
        loginElements.password.click();

        String emailMsg = loginElements.messageEmail.getText();
        String [] emailMsgParts = emailMsg.split(":");
        String emailMsgPart2 = emailMsgParts[1].trim();
        Assert.assertEquals(emailMsgPart2, Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);

        Assert.assertTrue(Utils.checkElementExist(loginElements.validateMinCharacters));
        Assert.assertTrue(Utils.checkElementExist(loginElements.validateLowercase));
        Assert.assertTrue(Utils.checkElementExist(loginElements.validateUppercase));
        Assert.assertTrue(Utils.checkElementExist(loginElements.validateNumber));

    }

    public void TestCasePCOM_032() {
        //1. Open the Philly.com app to "Sign Up" screen
        lauchApp();
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf( loginElements.actionBarTitle);
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);


        //2. Don't click and leave Email field as blank


        //3. Click on Password field
        loginElements.password.click();

        Assert.assertFalse(Utils.checkElementExist(loginElements.messagePassword));
        Assert.assertTrue(Utils.checkElementExist(loginElements.validateMinCharacters));
        Assert.assertTrue(Utils.checkElementExist(loginElements.validateLowercase));
        Assert.assertTrue(Utils.checkElementExist(loginElements.validateUppercase));
        Assert.assertTrue(Utils.checkElementExist(loginElements.validateNumber));
    }

    public void TestCasePCOM_033() {
        //1. Open the Philly.com app to "Sign Up" screen
        lauchApp();
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf( loginElements.actionBarTitle);
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);


        //2. Don't click and leave Email field as blank


        //3. Enter valid password to Password field
        loginElements.setValue(loginElements.password, Constants.SIGN_UP_PASSWORD);


        //4. Enter valid confirm password to Confirm Password field
        loginElements.setValue(loginElements.confirmPassword, Constants.SIGN_UP_PASSWORD);


        //5. Click "Sign Up" button
        loginElements.signUpButton.click();

        String emailMsg = loginElements.messageEmail.getText();
        String [] emailMsgParts = emailMsg.split(":");
        String emailMsgPart2 = emailMsgParts[1].trim();
        Assert.assertEquals(emailMsgPart2, Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);
    }

    public void TestCasePCOM_034() {
        //1. Open the Philly.com app to "Sign Up" screen
        lauchApp();
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf( loginElements.actionBarTitle);
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);


        //2. Click and leave Email field as blank
        loginElements.email.click();


        //3. Enter valid password to Password field
        loginElements.setValue(loginElements.password, Constants.SIGN_UP_PASSWORD);


        //4. Enter valid confirm password to Confirm Password field
        loginElements.setValue(loginElements.confirmPassword, Constants.SIGN_UP_PASSWORD);


        //5. Click outside to dismiss keyboard or "Sign Up" button
        loginElements.hiddenKeyboard(appiumDriver,loginElements.confirmPassword);

        String emailMsg = loginElements.messageEmail.getText();
        String [] emailMsgParts = emailMsg.split(":");
        String emailMsgPart2 = emailMsgParts[1].trim();
        Assert.assertEquals(emailMsgPart2, Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);
    }


    public void TestCasePCOM_035() {
        //1. Open the Philly.com app to "Sign Up" screen
        lauchApp();
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf( loginElements.actionBarTitle);
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);


        //2. Click and leave Email field as blank
        loginElements.email.click();


        //3. Enter valid password to Password field
        loginElements.setValue(loginElements.password, Constants.SIGN_UP_PASSWORD);


        //4. Click Email field
        loginElements.email.click();

        String emailMsg = loginElements.messageEmail.getText();
        String [] emailMsgParts = emailMsg.split(":");
        String emailMsgPart2 = emailMsgParts[1].trim();
        Assert.assertEquals(emailMsgPart2, Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);

    }

    public void TestCasePCOM_039() {
        //1. Open the Philly.com app to "Sign Up" screen
        lauchApp();
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf( loginElements.actionBarTitle);
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);


        //2. Enter valid email to Email field
        loginElements.setValue(loginElements.email, Constants.SIGN_UP_EMAIL);


        //3. Enter valid password to Password field
        loginElements.setValue(loginElements.password, Constants.SIGN_UP_PASSWORD);


        //4. Don't click and leave Confirm Password field as blank


        //Add extra step to get Sign Up button  display
        loginElements.hiddenKeyboard(appiumDriver, loginElements.confirmPassword);


        //5. Click "Sign Up" button
        loginElements.signUpButton.click();

        String confirmPasswprdMsg = loginElements.messageConfirmPassword.getText();
        String [] confirmPasswordMsgParts = confirmPasswprdMsg.split(":");
        String confirmPasswordMsgPart2 = confirmPasswordMsgParts[1].trim();
        Assert.assertEquals(confirmPasswordMsgPart2, Constants.LOGIN.SIGN_UP_CONFIRM_PASSWORD_ERROR_MESSAGE);
    }

    public void TestCasePCOM_040() {
        //1. Open the Philly.com app to "Sign Up" screen
        lauchApp();
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf( loginElements.actionBarTitle);
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);


        //2. Enter valid email to Email field
        loginElements.setValue(loginElements.email, Constants.SIGN_UP_EMAIL);


        //3. Enter valid password to Password field
        loginElements.setValue(loginElements.password, Constants.SIGN_UP_PASSWORD);


        //4. Click and leave Confirm Password field as blank
        loginElements.confirmPassword.click();


        //5. Click another field or "Sign Up" button
        loginElements.signUpButton.click();

        String confirmPasswprdMsg = loginElements.messageConfirmPassword.getText();
        String [] confirmPasswordMsgParts = confirmPasswprdMsg.split(":");
        String confirmPasswordMsgPart2 = confirmPasswordMsgParts[1].trim();
        Assert.assertEquals(confirmPasswordMsgPart2, Constants.LOGIN.SIGN_UP_CONFIRM_PASSWORD_ERROR_MESSAGE);
    }

    public void TestCasePCOM_045() {
        //1. Open the Philly.com app to "Sign Up" screen
        lauchApp();
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf( loginElements.actionBarTitle);
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);


        //2. Leave Email field as blank


        //3. Enter valid password to Password field
        loginElements.setValue(loginElements.password, Constants.SIGN_UP_PASSWORD);


        //4. Enter valid password to Confirm Password field
        loginElements.setValue(loginElements.confirmPassword, Constants.SIGN_UP_PASSWORD);


        //5. Click another field or "Sign Up" button
        loginElements.signUpButton.click();

        String emailMsg = loginElements.messageEmail.getText();
        String [] emailMsgParts = emailMsg.split(":");
        String emailMsgPart2 = emailMsgParts[1].trim();
        Assert.assertEquals(emailMsgPart2, Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);


        //6. Enter a value to Email field
        loginElements.setValue(loginElements.email, Utils.generateEmailAddress());


        //7. Click other field
        loginElements.password.click();

        emailMsg = loginElements.messageEmail.getText();
        emailMsgParts = emailMsg.split(":");
        emailMsgPart2 = emailMsgParts[1].trim();
        Assert.assertEquals(emailMsgPart2, "");
    }

    public void TestCasePCOM_046() {
        //1. Open the Philly.com app to "Sign Up" screen
        lauchApp();
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf( loginElements.actionBarTitle);
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);


        //2. Click and leave Email field as blank
        loginElements.email.click();


        //3. Enter valid password to Password field
        loginElements.setValue(loginElements.password, Constants.SIGN_UP_PASSWORD);


        //4. Enter valid password to Confirm Password field
        loginElements.setValue(loginElements.confirmPassword, Constants.SIGN_UP_PASSWORD);


        //5. Click another field or "Sign Up" button
        loginElements.signUpButton.click();

        String emailMsg = loginElements.messageEmail.getText();
        String [] emailMsgParts = emailMsg.split(":");
        String emailMsgPart2 = emailMsgParts[1].trim();
        Assert.assertEquals(emailMsgPart2, Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);


        //6. Enter a value to Email field
        loginElements.setValue(loginElements.email, Utils.generateEmailAddress());


        //7. Click other field
        loginElements.password.click();

        emailMsg = loginElements.messageEmail.getText();
        emailMsgParts = emailMsg.split(":");
        emailMsgPart2 = emailMsgParts[1].trim();
        Assert.assertEquals(emailMsgPart2, "");
    }


    public void TestCasePCOM_047() {
        //1. Open the Philly.com app to "Sign Up" screen
        lauchApp();
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf( loginElements.actionBarTitle);
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);


        //2. Enter invalid email format to Email field
        loginElements.setValue(loginElements.email, "invalidFormatEmail.com");


        //3. Enter valid password to Password field
        loginElements.setValue(loginElements.password, Constants.SIGN_UP_PASSWORD);


        //4. Enter valid password to Confirm Password field
        loginElements.setValue(loginElements.confirmPassword, Constants.SIGN_UP_PASSWORD);


        //5. Click another field or "Sign Up" button
        loginElements.signUpButton.click();

        String emailMsg = loginElements.messageEmail.getText();
        String [] emailMsgParts = emailMsg.split(":");
        String emailMsgPart2 = emailMsgParts[1].trim();
        Assert.assertEquals(emailMsgPart2, Constants.LOGIN.INVALID_EMAIL_ERROR_MESSAGE);


        //6. Enter a value to Email field
        loginElements.setValue(loginElements.email, Utils.generateEmailAddress());


        //7. Click other field
        loginElements.password.click();

        emailMsg = loginElements.messageEmail.getText();
        emailMsgParts = emailMsg.split(":");
        emailMsgPart2 = emailMsgParts[1].trim();
        Assert.assertEquals(emailMsgPart2, "");
    }

    public void TestCasePCOM_051() {
        //1. Open the Philly.com app to "Sign Up" screen
        lauchApp();
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf( loginElements.actionBarTitle);
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);


        //2. Enter valid email format to Email field
        loginElements.setValue(loginElements.email, Utils.generateEmailAddress());


        //3. Enter valid password to Password field
        loginElements.setValue(loginElements.password, Constants.SIGN_UP_PASSWORD);


        //4. Leave Confirm Password field as blank


        //Add extra step to get Sign Up button  display
       loginElements.hiddenKeyboard(appiumDriver, loginElements.password);


        //5. Click "Sign Up" button
        loginElements.signUpButton.click();

        String confirmPasswordMsg = loginElements.messageConfirmPassword.getText();
        String [] confirmPasswordMsgParts = confirmPasswordMsg.split(":");
        String confirmPasswordMsgPart2 = confirmPasswordMsgParts[1].trim();
        Assert.assertEquals(confirmPasswordMsgPart2, Constants.LOGIN.SIGN_UP_CONFIRM_PASSWORD_ERROR_MESSAGE);


        //6. Enter a value to Confirm Password field
        loginElements.setValue(loginElements.confirmPassword, Constants.SIGN_UP_PASSWORD);


        //7. Click other field
        loginElements.password.click();
        Assert.assertFalse(Utils.checkElementExist(loginElements.messageConfirmPassword));
    }

    public void TestCasePCOM_052() {
        //1. Open the Philly.com app to "Sign Up" screen
        lauchApp();
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf( loginElements.actionBarTitle);
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);


        //2. Enter valid email format to Email field
        loginElements.setValue(loginElements.email, Utils.generateEmailAddress());


        //3. Enter valid password to Password field
        loginElements.setValue(loginElements.password, Constants.SIGN_UP_PASSWORD);


        //4. Click and leave Confirm Password field
        loginElements.confirmPassword.click();


        //5. Click Password field
        loginElements.password.click();
        String confirmPasswordMsg = loginElements.messageConfirmPassword.getText();
        String [] confirmPasswordMsgParts = confirmPasswordMsg.split(":");
        String confirmPasswordMsgPart2 = confirmPasswordMsgParts[1].trim();
        Assert.assertEquals(confirmPasswordMsgPart2, Constants.LOGIN.SIGN_UP_CONFIRM_PASSWORD_ERROR_MESSAGE);


        //6. Click Confirm Password field
        //7. Enter a value to Confirm Password field
        loginElements.setValue(loginElements.confirmPassword, Constants.SIGN_UP_PASSWORD);


        //8. Click other field
        loginElements.password.click();
        Assert.assertFalse(Utils.checkElementExist(loginElements.messageConfirmPassword));
    }

    public void TestCasePCOM_053() {
        //1. Open the Philly.com app to "Sign Up" screen
        lauchApp();
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf( loginElements.actionBarTitle);
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);


        //2. Enter valid email format to Email field
        loginElements.setValue(loginElements.email, Utils.generateEmailAddress());


        //3. Enter valid password to Password field
        loginElements.setValue(loginElements.password, Constants.SIGN_UP_PASSWORD);


        //4. Enter invalid password to Confirm Password field
        loginElements.setValue(loginElements.confirmPassword, "test12");


        //5. Click "Sign Up" button
        loginElements.signUpButton.click();
        appiumDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String confirmPasswprdMsg = loginElements.messageConfirmPassword.getText();
        String [] confirmPasswordMsgParts = confirmPasswprdMsg.split(":");
        String confirmPasswordMsgPart2 = confirmPasswordMsgParts[1].trim();
        Assert.assertEquals(confirmPasswordMsgPart2, Constants.LOGIN.SIGN_UP_PASSWORD_ERROR_MESSAGE);


        //6. Enter valid value to Confirm Password field
        loginElements.setValue(loginElements.confirmPassword, Constants.SIGN_UP_PASSWORD);


        //8. Click other field
        loginElements.password.click();
        Assert.assertFalse(Utils.checkElementExist(loginElements.messageConfirmPassword));
    }

    public void TestCasePCOM_056() {
        //1. Open the Philly.com app to "Sign Up" screen
        lauchApp();
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf( loginElements.actionBarTitle);
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);


        //2. Enter password to Password and Confirm fields
        loginElements.setValue(loginElements.password, Constants.SIGN_UP_PASSWORD);
        loginElements.setValue(loginElements.confirmPassword, Constants.SIGN_UP_PASSWORD);


        //3. Click on the show/hide password icon on Password field
        loginElements.signUpShowOrHiddenPasswordIcon.click();
        loginElements.assertValue(loginElements.password, Constants.SIGN_UP_PASSWORD);
        loginElements.assertValue(loginElements.confirmPassword, Constants.SIGN_UP_PASSWORD);
    }

    public void TestCasePCOM_057() {
        //1. Open the Philly.com app to "Sign Up" screen
        lauchApp();
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf( loginElements.actionBarTitle);
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);


        //2. Enter password to Password and Confirm fields
        loginElements.setValue(loginElements.password, Constants.SIGN_UP_PASSWORD);
        loginElements.setValue(loginElements.confirmPassword, Constants.SIGN_UP_PASSWORD);


        //3. Click on the show/hide password icon on Confirm Password field
        loginElements.signUpShowOrHiddenConfirmPasswordIcon.click();
        loginElements.assertValue(loginElements.password, Constants.SIGN_UP_PASSWORD);
        loginElements.assertValue(loginElements.confirmPassword, Constants.SIGN_UP_PASSWORD);
    }

    public void TestCasePCOM_060() {
        String termsOfService = "Privacy Policy & Terms of Use";

        //1. Open the Philly.com app to "Sign Up" screen
        lauchApp();
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf( loginElements.actionBarTitle);
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);


        //2. Click "Term Of Use" link
        loginElements.clickTermOfUseLink(appiumDriver,loginElements.termAndPolicy);
        Utils.sleep(Constants.SHORTTIME*3);

        waitForVisibilityOf(loginElements.termsOfService);
        Assert.assertTrue(termsOfService.contains(loginElements.termsOfService.getText()));
        //Check Term Of Use screen display in new browser
//        String url = appiumDriver.getCurrentUrl();
//        Assert.assertEquals(url,"Philly.com");
//        //back to native app
//        appiumDriver.navigate().back();
    }

    public void TestCasePCOM_061() {
        //1. Open the Philly.com app to "Sign Up" screen
        lauchApp();
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf( loginElements.actionBarTitle);
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);


        //2. Click "Privacy Policy" link
        loginElements.clickPrivacyPolicyLink(appiumDriver,loginElements.termAndPolicy);
        //Check TPrivacy Policy screen display

    }

    public void TestCasePCOM_062() {
        //1. Open the Philly.com app to "Log In" screen
        lauchApp();
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf( loginElements.actionBarTitle);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);


        //2. Enter valid email to Email field on "Log In" screen
        String validEmail = Utils.generateEmailAddress();
        loginElements.setValue(loginElements.email,validEmail);
        loginElements.hiddenKeyboard(appiumDriver, loginElements.email);


        //3. Click "Sign Up" link at the bottom
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);
        loginElements.assertValue(loginElements.email,validEmail);
    }

    public void TestCasePCOM_063() {
        //1. Open the Philly.com app to "Log In" screen
        lauchApp();
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf( loginElements.actionBarTitle);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);


        //2. Enter invalid email to Email field on "Log In" screen
        String invalidEmail = "Invalid@a";
        loginElements.setValue(loginElements.email,invalidEmail);
        loginElements.hiddenKeyboard(appiumDriver, loginElements.email);


        //3. Click "Sign Up" link at the bottom
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);
        loginElements.assertValue(loginElements.email,"Email"); //Email is default value
    }

}

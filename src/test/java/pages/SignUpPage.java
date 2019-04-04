package pages;

import elements.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.Assert;
import scenarios.AppiumController;
import utils.Constants;
import utils.Utils;

import java.util.concurrent.TimeUnit;

public class SignUpPage extends BasePage {


    private CommonElements commonElements;
    private SettingElements settingElements;
    private LoginElements loginElements;
    private BookMarkElements bookMarkElements;
    private ExploreElements exploreElements;



    public SignUpPage(AppiumDriver driver) {
        super(driver);

        Utils.turnOffSamsungAutofillService(driver);

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


    public void TestCasePCOM_004() {
        //1. Open the Philly.com app to Sign Up screen from Settings tab.
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf( loginElements.actionBarTitle);
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);


        //2. Put the device to sleep with Philly.com app on the screen.
        lockDevice();


        //3. Wake the device and unlock (if applicable)
        unLockDevice();


        //4. Observe the Philly.com app opened to "Sign Up"screen.
        if(AppiumController.executionOS.equals(AppiumController.OS.ANDROID_BROWSERSTACK)) {
            activateApp();
        }
        waitForVisibilityOf( loginElements.confirmPassword);

        //5. Click on Cancel button
        loginElements.closeActionButton.click();
        //Check Setting page appears
        loginElements.assertValue(settingElements.settingsHeading,"Settings");


        //6. Click all tabs in navigation
        //7. Observe the tabs load without crashing.
        commonElements.homeTabClick();
        exploreElements.exploreTab.click();
        //Check Explore page appears
        loginElements.assertValue(exploreElements.headingTitle,"Explore");
        bookMarkElements.bookMarkTab.click();


        //8. Terminate the app by double clicking the home button and swiping up
        ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.HOME));
        Assert.assertFalse(Utils.checkElementExist(commonElements.settingTab));
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
        ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.HOME));
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
        ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.HOME));
        Assert.assertFalse(Utils.checkElementExist(commonElements.bottomTab));

        //6. Open the Philly.com app from home screen
        lauchApp();
        commonElements.settingTab.click();
        settingElements.logInOrSignUp.click();
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);
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
        Assert.assertFalse(Utils.checkElementExist(loginElements.validatePassword));

        String emailAddress = Utils.generateEmailAddress();
        System.out.println("emailAddress: " + emailAddress);
        loginElements.setValue(loginElements.email, emailAddress  );


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
        Assert.assertEquals(settingElements.signedUpAccount.getText(),emailAddress);
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
        Assert.assertFalse(Utils.checkElementExist(loginElements.validatePassword));
        loginElements.setValue(loginElements.email, "STEST01@gmail");


        //3. Enter valid password to Password field
        loginElements.setValue(loginElements.password, Constants.SIGN_UP_PASSWORD);

        //4. Enter password to Confirm Password field
        loginElements.setValue(loginElements.confirmPassword, Constants.SIGN_UP_PASSWORD);

        //5. Click "Sign Up" button
        loginElements.signUpButton.click();
        waitForVisibilityOf(loginElements.messageEmail);
        Assert.assertEquals(loginElements.messageEmail.getText(),Constants.LOGIN.INVALID_EMAIL_ERROR_MESSAGE);
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
        Assert.assertFalse(Utils.checkElementExist(loginElements.validatePassword));
        loginElements.setValue(loginElements.email, Constants.SIGN_UP_EMAIL);


        //3. Enter valid password to Password field
        loginElements.setValue(loginElements.password, Constants.SIGN_UP_PASSWORD);

        //4. Enter password to Confirm Password field
        loginElements.setValue(loginElements.confirmPassword, Constants.SIGN_UP_PASSWORD);

        //5. Click "Sign Up" button
        loginElements.signUpButton.click();
        waitForVisibilityOf(loginElements.messageEmail);
        Assert.assertEquals(loginElements.messageEmail.getText(),Constants.LOGIN.SIGN_UP_EMAIL_ERROR_MESSAGE);
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
        Assert.assertFalse(Utils.checkElementExist(loginElements.validatePassword));
        loginElements.setValue(loginElements.email, Constants.SIGN_UP_EMAIL);


        //3. Enter valid password to Password field
        loginElements.setValue(loginElements.password, Constants.SIGN_UP_PASSWORD);

        //4. Enter invalid Confirm Password field
        loginElements.setValue(loginElements.confirmPassword, "TTTest1234");

        //5. Click "Sign Up" button
        loginElements.signUpButton.click();
        Assert.assertEquals(loginElements.messageEmail.getText(),Constants.LOGIN.SIGN_UP_PASSWORD_ERROR_MESSAGE);
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
        Assert.assertEquals(loginElements.messageEmail.getText(),Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);
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
        loginElements.assertFocused(loginElements.email, "true");


        //3. Click on Password field
        loginElements.password.click();
        loginElements.assertFocused(loginElements.password, "true");
        Assert.assertEquals(loginElements.messageEmail.getText(),Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);
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
        loginElements.assertFocused(loginElements.password, "true");
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
        loginElements.assertValue(loginElements.messageEmail,Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);
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
        loginElements.assertFocused(loginElements.email, "true");

        //3. Enter valid password to Password field
        loginElements.setValue(loginElements.password, Constants.SIGN_UP_PASSWORD);


        //4. Enter valid confirm password to Confirm Password field
        loginElements.setValue(loginElements.confirmPassword, Constants.SIGN_UP_PASSWORD);


        //5. Click outside to dismiss keyboard or "Sign Up" button
        loginElements.hiddenKeyboard(appiumDriver,loginElements.confirmPassword);
        Assert.assertEquals(loginElements.messageEmail.getText(),Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);
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
        loginElements.assertFocused(loginElements.email, "true");


        //3. Enter valid password to Password field
        loginElements.setValue(loginElements.password, Constants.SIGN_UP_PASSWORD);


        //4. Click Email field
        loginElements.email.click();
        Assert.assertEquals(loginElements.messageEmail.getText(),Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);
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
        Assert.assertEquals(loginElements.messageConfirmPassword.getText(),Constants.LOGIN.SIGN_UP_CONFIRM_PASSWORD_ERROR_MESSAGE);
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
        loginElements.assertFocused(loginElements.confirmPassword, "true");


        //5. Click another field or "Sign Up" button
        loginElements.signUpButton.click();
        Assert.assertEquals(loginElements.messageConfirmPassword.getText(),Constants.LOGIN.SIGN_UP_CONFIRM_PASSWORD_ERROR_MESSAGE);
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
        Assert.assertEquals(loginElements.messageEmail.getText(),Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);


        //6. Enter a value to Email field
        loginElements.setValue(loginElements.email, Utils.generateEmailAddress());


        //7. Click other field
        loginElements.password.click();
        Assert.assertFalse(Utils.checkElementExist(loginElements.messageEmail));
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
        loginElements.assertFocused(loginElements.email, "true");


        //3. Enter valid password to Password field
        loginElements.setValue(loginElements.password, Constants.SIGN_UP_PASSWORD);


        //4. Enter valid password to Confirm Password field
        loginElements.setValue(loginElements.confirmPassword, Constants.SIGN_UP_PASSWORD);


        //5. Click another field or "Sign Up" button
        loginElements.signUpButton.click();
        Assert.assertEquals(loginElements.messageEmail.getText(),Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);


        //6. Enter a value to Email field
        loginElements.setValue(loginElements.email, Utils.generateEmailAddress());


        //7. Click other field
        loginElements.password.click();
        Assert.assertFalse(Utils.checkElementExist(loginElements.messageEmail));
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
        Assert.assertEquals(loginElements.messageEmail.getText(),Constants.LOGIN.INVALID_EMAIL_ERROR_MESSAGE);


        //6. Enter a value to Email field
        loginElements.setValue(loginElements.email, Utils.generateEmailAddress());


        //7. Click other field
        loginElements.password.click();
        Assert.assertFalse(Utils.checkElementExist(loginElements.messageEmail));
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
        Assert.assertEquals(loginElements.messageConfirmPassword.getText(),Constants.LOGIN.SIGN_UP_CONFIRM_PASSWORD_ERROR_MESSAGE);


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
        loginElements.assertFocused(loginElements.confirmPassword, "true");


        //5. Click Password field
        loginElements.password.click();
        Assert.assertEquals(loginElements.messageConfirmPassword.getText(),Constants.LOGIN.SIGN_UP_CONFIRM_PASSWORD_ERROR_MESSAGE);


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
        Assert.assertEquals(loginElements.messageConfirmPassword.getText(),Constants.LOGIN.SIGN_UP_PASSWORD_ERROR_MESSAGE);


        //6. Enter valid value to Confirm Password field
        loginElements.setValue(loginElements.confirmPassword, Constants.SIGN_UP_PASSWORD);


        //8. Click other field
        loginElements.password.click();
        Assert.assertFalse(Utils.checkElementExist(loginElements.messageConfirmPassword));
    }

    public void TestCasePCOM_054() {
        //1. Open the Philly.com app to "Sign Up" screen
        lauchApp();
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf( loginElements.actionBarTitle);
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);


        //2. Click on the show/hide password icon on Confirm Password
        loginElements.signUpShowOrHiddenPasswordIcon.click();
        loginElements.assertFocused(loginElements.password, "false");
    }

    public void TestCasePCOM_055() {
        //1. Open the Philly.com app to "Sign Up" screen
        lauchApp();
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf( loginElements.actionBarTitle);
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);


        //2. Click on the show/hide password icon on Confirm Password
        loginElements.signUpShowOrHiddenConfirmPasswordIcon.click();
        loginElements.assertFocused(loginElements.confirmPassword, "false");
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


        //3.Click on the show/hide password icon on Confirm Password
        loginElements.signUpShowOrHiddenConfirmPasswordIcon.click();
        loginElements.assertValue(loginElements.password, Constants.SIGN_UP_PASSWORD);
    }

    public void TestCasePCOM_060() {
        //1. Open the Philly.com app to "Sign Up" screen
        lauchApp();
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf( loginElements.actionBarTitle);
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        waitForVisibilityOf( loginElements.confirmPassword);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);

        //2. Click "Terms of Service" link
        //TODO
    }



}
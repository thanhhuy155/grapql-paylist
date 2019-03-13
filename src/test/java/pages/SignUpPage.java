package pages;

import elements.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.Assert;
import utils.Constants;
import utils.Utils;

public class SignUpPage extends BasePage {


    private CommonElements commonElements;
    private SettingElements settingElements;
    private LoginElements loginElements;
    private BookMarkElements bookMarkElements;
    private ExploreElements exploreElements;

    public SignUpPage(AppiumDriver driver) {
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
        Assert.assertEquals("Settings",settingElements.settingsHeading.getText().trim(), "Check Setting is being returned");
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
        Utils.sleep(Constants.SHORTTIME);

        //4. Observe the Philly.com app opened to "Sign Up"screen.
        activateApp();
        waitForVisibilityOf(loginElements.closeActionButton );

        //5. Click on Cancel button
        loginElements.closeActionButton.click();
        //Check Setting page appears
        Assert.assertEquals("Settings",settingElements.settingsHeading.getText().trim(), "Check Setting is being taken");

        //6. Click all tabs in navigation
        //7. Observe the tabs load without crashing.
        commonElements.homeTabClick();
        exploreElements.exploreTab.click();
        //Check Explore page appears
        Assert.assertEquals("Explore",exploreElements.headingTitle.getText().trim(), "Check Explore tab is being displayed");
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
        Assert.assertEquals("Settings",settingElements.settingsHeading.getText().trim(), "Check Setting is being taken");

        //6. Click all tabs in navigation
        //7. Observe the tabs load without crashing.
        commonElements.homeTabClick();
        exploreElements.exploreTab.click();
        Assert.assertEquals("Explore",exploreElements.headingTitle.getText().trim(), "Check Explore tab is being displayed");
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

        //5. Open the Philly.com app using multitasking
        //6. Observe the Philly.com app opened to "Sign Up" screen.

        //TODO

        //7. Click on Cancel button
        loginElements.closeActionButton.click();
        Assert.assertEquals("Settings",settingElements.settingsHeading.getText().trim(), "Check Setting is being taken");

        //8. Click all tabs in navigation
        //9. Observe the tabs load without crashing.
        commonElements.homeTabClick();
        exploreElements.exploreTab.click();
        Assert.assertEquals("Explore",exploreElements.headingTitle.getText().trim(), "Check Explore tab is being displayed");
        bookMarkElements.bookMarkTab.click();

        //10. Terminate the app by double clicking the Android home button and swiping up.
        ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.HOME));
        Assert.assertFalse(Utils.checkElementExist(commonElements.settingTab));
    }



}

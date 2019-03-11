package pages;

import elements.CommonElements;
import elements.LoginElements;
import elements.SettingElements;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import utils.Constants;
import utils.Utils;

public class SignUpPage extends BasePage {


    private CommonElements commonElements;
    private SettingElements settingElements;
    private LoginElements loginElements;


    public SignUpPage(AppiumDriver driver) {
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
        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);

        //Click Sign Up link
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        Utils.waitForElementVisible(appiumDriver, loginElements.confirmPassword);

        //Check SignUp screen
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);

        Assert.assertTrue(Utils.checkElementExist(loginElements.email));
        Assert.assertTrue(Utils.checkElementExist(loginElements.password));
        Assert.assertTrue(Utils.checkElementExist(loginElements.confirmPassword));
        Assert.assertTrue(Utils.checkElementExist(loginElements.signUpButton));
        loginElements.assertValue(loginElements.termAndPolicy, Constants.LOGIN.SIGN_UP_TERM_AND_POLICY);
    }

    public void TestCasePCOM_003() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);

        //Click Sign Up link
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        Utils.waitForElementVisible(appiumDriver, loginElements.confirmPassword);

        //Check SignUp screen
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);

        loginElements.closeActionButton.click();

        //Check Settings screen is being returned
        Assert.assertEquals("Settings",settingElements.settingsHeading.getText().trim(), "Check Setting is being returned");

    }

    public void TestCasePCOM_005() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);

        //Click Sign Up link
        loginElements.clickSignUpLink(appiumDriver, loginElements.signUpLink);
        Utils.waitForElementVisible(appiumDriver, loginElements.confirmPassword);

        //Check SignUp screen
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.SIGN_UP_TITLE);

        loginElements.closeActionButton.click();

        //Check Settings screen is being returned
        Assert.assertEquals("Settings",settingElements.settingsHeading.getText().trim(), "Check Setting is being returned");

    }
}

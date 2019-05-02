package pages;

import elements.*;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import utils.Constants;
import utils.Utils;

public class iOSLoginPage extends BasePage {


    private CommonElements commonElements;
    private ExploreElements exploreElements;
    private BookMarkElements bookMarkElements;
    private SettingElements settingElements;
    private LoginElements loginElements;


    public iOSLoginPage(AppiumDriver driver) {
        super(driver);

        commonElements = new CommonElements(driver);
        settingElements= new SettingElements(driver);
        exploreElements= new ExploreElements(driver);
        bookMarkElements= new BookMarkElements(driver);
        loginElements = new LoginElements(driver);

    }

    public void TestCasePCOM_002() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);
        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);

        //Check Login screen
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);
        Assert.assertTrue(Utils.checkElementExist(loginElements.closeActionButton),"Check Top App App - Left Action Close display: ");
        Assert.assertTrue(Utils.checkElementExist(loginElements.email), "Check Email text field displays");
        Assert.assertTrue(Utils.checkElementExist(loginElements.password), "Check Password field displays");
        Assert.assertTrue(Utils.checkElementExist(loginElements.showOrHidePasswordIcon), "Check Password icon show");
        Assert.assertTrue(Utils.checkElementExist(loginElements.logInButton), "Check Log In button displays");
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotEmailLink), "Check Forgot Email link displays");
        Assert.assertTrue(Utils.checkElementExist(loginElements.forgotPasswordLink), "Check Forgot Password link displays");
        Assert.assertTrue(Utils.checkElementExist(loginElements.signUpLink), "Check Sign Up link displays");

    }

    public void TestCasePCOM_007() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);

        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);

        //Check Login screen displays
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);
        loginElements.closeActionButton.click();

        //Check Setting page appears
        Assert.assertEquals("Settings",settingElements.settingsHeading.getText().trim(), "Check Setting is being taken");

    }

    public void TestCasePCOM_018() {

        //Turn on Cellular connection
        if(loginElements.getCellularConnectionStatus()==false) {
            turnOnCellularConnection();
            Assert.assertTrue(loginElements.getCellularConnectionStatus(), "Cellular connection didn't turn on");
        }
        //Turn on Wifi connection
        if(loginElements.getWiFiConnectionStatus() == false){
            turnOnWifi();
            Assert.assertTrue(loginElements.getWiFiConnectionStatus(), "Wifi connection didn't turn on");
        }

        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();

        //check if account has not signed up
        if(!Utils.checkElementExist(settingElements.viewAccountDetails)) {
            settingElements.logInOrSignUp.click();

            loginElements.setValue(loginElements.email, Constants.LOGIN_EMAIL);
            loginElements.setValue(loginElements.password, Constants.LOGIN_PASSWORD);
            loginElements.logInButton.click();


            waitForVisibilityOf(settingElements.settingsHeading);

            //Check Setting page appears
            Assert.assertEquals("Settings",settingElements.settingsHeading.getText().trim(), "Check Setting is being taken");
            //Check account display correctly
            Assert.assertTrue(Utils.checkElementExist(settingElements.viewAccountDetails), "Check account logged in successfully");
            Assert.assertEquals(Constants.SETTING_TITLE.VIEW_ACCOUNT_DETAILS,settingElements.viewAccountDetails.getText().trim(), "Check View Account Details displays");

        }else{
            Assert.assertEquals(Constants.SETTING_TITLE.VIEW_ACCOUNT_DETAILS,settingElements.viewAccountDetails.getText().trim(), "Check View Account Details displays");

        }
    }

    public void TestCasePCOM_019() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);

        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf(loginElements.actionBarTitle);

        //Check Login screen displays
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);


        //Input invalid Email
        loginElements.setValue(loginElements.email, "fairlyenclave.vn");

        //Input valid password
        loginElements.setValue(loginElements.password, Constants.LOGIN_PASSWORD);
        loginElements.logInButton.click();


        //Check error message is being returned
        String message = loginElements.email.getText();
        String [] parts = message.split(":");
        String part2 = parts[1].trim();
        Assert.assertEquals(part2, Constants.LOGIN.INVALID_EMAIL_ERROR_MESSAGE);

    }

    public void TestCasePCOM_020() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf(loginElements.actionBarTitle);

        //Check Login screen displays
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);

        //Input invalid Email
        loginElements.setValue(loginElements.email, "fairlyenclave.vn");

        //Click on Password field
        loginElements.password.click();

        //Check error message is being returned
        String message = loginElements.email.getText();
        String [] parts = message.split(":");
        String part2 = parts[1].trim();
        Assert.assertEquals(part2, Constants.LOGIN.INVALID_EMAIL_ERROR_MESSAGE);

    }

    public void TestCasePCOM_021() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf(loginElements.actionBarTitle);

        //Check Login screen displays
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);

        //Input invalid Email
        loginElements.setValue(loginElements.email, "mnguyen@philly.com");

        //Input valid Password
        loginElements.setValue(loginElements.password, "Philly123");

        loginElements.logInButton.click();
        waitForVisibilityOf(loginElements.dialogMessage);

        //Check dialog message is being returned
        loginElements.assertValue(loginElements.dialogMessage,Constants.LOGIN.UNMATCHED_ACCOUNT_DIALOG_MESSAGE);

        //Check dialog TRY AGAIN button displays
        loginElements.assertValue(loginElements.tryAgainDialogButton, Constants.LOGIN.TRY_AGAIN_DIALOG_BUTTON);

    }

    public void TestCasePCOM_022() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf(loginElements.actionBarTitle);

        //Check Login screen displays
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);

        //Input valid Email
        loginElements.setValue(loginElements.email, Constants.LOGIN_EMAIL);

        //Input invalid Password
        loginElements.setValue(loginElements.password, "InvalidPass");
        loginElements.logInButton.click();

        waitForVisibilityOf(loginElements.dialogMessage);
        //Check dialog message is being returned
        loginElements.assertValue(loginElements.dialogMessage,Constants.LOGIN.UNMATCHED_ACCOUNT_DIALOG_MESSAGE);

        //Check dialog TRY AGAIN button displays
        loginElements.assertValue(loginElements.tryAgainDialogButton, Constants.LOGIN.TRY_AGAIN_DIALOG_BUTTON);

    }

    public void TestCasePCOM_023() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf(loginElements.actionBarTitle);

        //Check Login screen displays
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);


        //Case 1: Input invalid email
        //Input invalid Email
        loginElements.setValue(loginElements.email, "failry@enclave.com");

        //Input valid Password
        loginElements.setValue(loginElements.password, Constants.LOGIN_PASSWORD);

        loginElements.logInButton.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.dialogMessage);

        //Check dialog message is being returned
        loginElements.assertValue(loginElements.dialogMessage,Constants.LOGIN.UNMATCHED_ACCOUNT_DIALOG_MESSAGE);

        loginElements.tryAgainDialogButton.click();

        //check dialog is disappeared
        Assert.assertFalse(Utils.checkElementExist(loginElements.dialogMessage), "Check dialog is closed");

        //close Login dialog
        loginElements.closeActionButton.click();
        //Re-open Log In
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf(loginElements.actionBarTitle);


        //case 2: Input invalid password
        //Input valid Email
        loginElements.setValue(loginElements.email, "fairly@enclave.vn");

        //Input invalid Password
        loginElements.setValue(loginElements.password, "invalid");

        loginElements.logInButton.click();

        //Check dialog message is being returned
        loginElements.assertValue(loginElements.dialogMessage,Constants.LOGIN.UNMATCHED_ACCOUNT_DIALOG_MESSAGE);

        loginElements.tryAgainDialogButton.click();

        //check dialog is disappeared
        Assert.assertFalse(Utils.checkElementExist(loginElements.dialogMessage), "Check dialog is closed");
    }

    public void TestCasePCOM_024() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();

        //Check Login screen displays
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);

        //Leave Email and Password as blank

        //Click Login
        loginElements.logInButton.click();

        //Check error messages returned
        String emailMsg = loginElements.email.getText();
        String [] emailMsgParts = emailMsg.split(":");
        String emailMsgPart2 = emailMsgParts[1].trim();

        String passwordMsg = loginElements.password.getText();
        String [] passwordMsgParts = passwordMsg.split(":");
        String passwordMsgPart2 = passwordMsgParts[1].trim();


        Assert.assertEquals(emailMsgPart2, Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);
        Assert.assertEquals(passwordMsgPart2, Constants.LOGIN.BLANK_PASSWORD_ERROR_MESSAGE);

    }

    public void TestCasePCOM_025() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf(loginElements.actionBarTitle);

        //Check Login screen displays
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);

        //click and leave Email as blank
        loginElements.email.click();

        //Click on password
        loginElements.password.click();

        //Check error message is being returned
        String message = loginElements.email.getText();
        String [] parts = message.split(":");
        String part2 = parts[1].trim();
        Assert.assertEquals(part2, Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);

    }

    public void TestCasePCOM_026() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf(loginElements.actionBarTitle);

        //Check Login screen displays
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);

        //Click and leave Email as blank
        loginElements.email.click();

        //Click and leave on password as blank
        loginElements.password.click();

        //Click Login
        loginElements.logInButton.click();


        //Check error messages returned
        String emailMsg = loginElements.email.getText();
        String [] emailMsgParts = emailMsg.split(":");
        String emailMsgPart2 = emailMsgParts[1].trim();

        String passwordMsg = loginElements.password.getText();
        String [] passwordMsgParts = passwordMsg.split(":");
        String passwordMsgPart2 = passwordMsgParts[1].trim();


        Assert.assertEquals(emailMsgPart2, Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);
        Assert.assertEquals(passwordMsgPart2, Constants.LOGIN.BLANK_PASSWORD_ERROR_MESSAGE);

    }

    public void TestCasePCOM_027() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);
        settingElements.logInOrSignUp.click();
        waitForVisibilityOf(loginElements.actionBarTitle);

        //Check Login screen displays
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);

        //Don't click and leave Email as blank

        //Click on password
        loginElements.password.click();


        //Check error messages returned
        String emailMsg = loginElements.email.getText();
        String passwordMsg = loginElements.password.getText();

        Assert.assertFalse(emailMsg.contains(":"));
        Assert.assertFalse(passwordMsg.contains(":"));

    }

    public void TestCasePCOM_028() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);
        settingElements.logInOrSignUp.click();

        waitForVisibilityOf(loginElements.actionBarTitle);
        //Check Login screen displays
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);

        //Don't click and leave Email

        //Enter valid password
        loginElements.setValue(loginElements.password, Constants.LOGIN_PASSWORD);

        //Click Log In
        loginElements.logInButton.click();


        //Check error message is being returned
        String message = loginElements.email.getText();
        String [] parts = message.split(":");
        String part2 = parts[1].trim();
        Assert.assertEquals(part2, Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);

    }

    public void TestCasePCOM_029() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        settingElements.logInOrSignUp.click();

        //Click and leave Email as blank
        loginElements.email.click();

        //Enter valid Password
        loginElements.setValue(loginElements.password, Constants.LOGIN_PASSWORD);

        //Click Log In button
        loginElements.logInButton.click();

        //Check error message is being returned
        String message = loginElements.email.getText();
        String [] parts = message.split(":");
        String part2 = parts[1].trim();
        Assert.assertEquals(part2, Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);

    }

    public void TestCasePCOM_030() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        settingElements.logInOrSignUp.click();

        //Click and leave Email as blank
        loginElements.email.click();

        //Enter valid Password
        loginElements.setValue(loginElements.password, Constants.LOGIN_PASSWORD);

        //Click Email field
        loginElements.email.click();

        //Check error message is being returned
        String message = loginElements.email.getText();
        String [] parts = message.split(":");
        String part2 = parts[1].trim();
        Assert.assertEquals(part2, Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);

    }

    public void TestCasePCOM_032() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        settingElements.logInOrSignUp.click();

        //Enter valid Email
        loginElements.setValue(loginElements.email, Constants.LOGIN_EMAIL);

        //Don' t click and leave Password

        //Click Log In button
        loginElements.logInButton.click();


        //Check error message returned
        String message = loginElements.password.getText();
        String [] parts = message.split(":");
        String part2 = parts[1].trim();
        Assert.assertEquals(part2, Constants.LOGIN.BLANK_PASSWORD_ERROR_MESSAGE);
    }

    public void TestCasePCOM_033() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        settingElements.logInOrSignUp.click();

        //Enter valid Email
        loginElements.setValue(loginElements.email, Constants.LOGIN_EMAIL);

        //Click and leave Password
        loginElements.password.click();

        //Click Email
        loginElements.email.click();

        //Check error message returned
        String message = loginElements.password.getText();
        String [] parts = message.split(":");
        String part2 = parts[1].trim();
        Assert.assertEquals(part2, Constants.LOGIN.BLANK_PASSWORD_ERROR_MESSAGE);

    }

    public void TestCasePCOM_035() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        settingElements.logInOrSignUp.click();

        //Enter invalid email format
        loginElements.setValue(loginElements.email, "fairlyenclave.vn");

        //Leave Password field as blank

        //Click Log In
        loginElements.logInButton.click();


        //Check error messages returned
        String emailMsg = loginElements.email.getText();
        String [] emailMsgParts = emailMsg.split(":");
        String emailMsgPart2 = emailMsgParts[1].trim();

        String passwordMsg = loginElements.password.getText();
        String [] passwordMsgParts = passwordMsg.split(":");
        String passwordMsgPart2 = passwordMsgParts[1].trim();


        Assert.assertEquals(emailMsgPart2, Constants.LOGIN.INVALID_EMAIL_ERROR_MESSAGE);
        Assert.assertEquals(passwordMsgPart2, Constants.LOGIN.BLANK_PASSWORD_ERROR_MESSAGE);

    }

    public void TestCasePCOM_036() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();

        settingElements.logInOrSignUp.click();

        //Leave Email as blank

        //Enter valid Password
        loginElements.setValue(loginElements.password, "Philly123");

        //Click Log In
        loginElements.logInButton.click();

        //Check error message returned
        String message = loginElements.email.getText();
        String [] parts = message.split(":");
        String part2 = parts[1].trim();
        Assert.assertEquals(part2, Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);



        //Enter valid Email
        loginElements.setValue(loginElements.email, "mnguyen@philly.com");

        //Click Log In button
        loginElements.logInButton.click();

        //Check no error message return
        String emailMsg = loginElements.email.getText();
        Assert.assertFalse(emailMsg.contains(":"));


    }

    public void TestCasePCOM_037() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();

        waitForVisibilityOf(settingElements.logInOrSignUp);
        settingElements.logInOrSignUp.click();

        //Click and leave Email field
        loginElements.email.click();

        //Enter valid Password
        loginElements.setValue(loginElements.password, "123");

        //Check error message returned
        String message = loginElements.email.getText();
        String [] parts = message.split(":");
        String part2 = parts[1].trim();
        Assert.assertEquals(part2, Constants.LOGIN.BLANK_EMAIL_ERROR_MESSAGE);



        //Click Email field
        loginElements.email.click();

        //Enter valid Email
        loginElements.setValue(loginElements.email, Constants.LOGIN_EMAIL);

        //Click Log In button
        loginElements.logInButton.click();

        //Check no error message return
        String emailMsg = loginElements.email.getText();
        Assert.assertFalse(emailMsg.contains(":"));

    }

    public void TestCasePCOM_038_001() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        settingElements.logInOrSignUp.click();

        //Enter invalid Email format
        loginElements.setValue(loginElements.email, "fairlyenclave.vn");

        //Leave Password as blank

        //Click Log In button
        loginElements.logInButton.click();



        //Check error messages returned
        String emailMsg = loginElements.email.getText();
        String [] emailMsgParts = emailMsg.split(":");
        String emailMsgPart2 = emailMsgParts[1].trim();

        String passwordMsg = loginElements.password.getText();
        String [] passwordMsgParts = passwordMsg.split(":");
        String passwordMsgPart2 = passwordMsgParts[1].trim();


        Assert.assertEquals(emailMsgPart2, Constants.LOGIN.INVALID_EMAIL_ERROR_MESSAGE);
        Assert.assertEquals(passwordMsgPart2, Constants.LOGIN.BLANK_PASSWORD_ERROR_MESSAGE);

        //Enter valid Email
        loginElements.setValue(loginElements.email, Constants.LOGIN_EMAIL);

        //Click Log In button
        loginElements.logInButton.click();


        emailMsg = loginElements.email.getText();

        passwordMsg = loginElements.password.getText();
        passwordMsgParts = passwordMsg.split(":");
        passwordMsgPart2 = passwordMsgParts[1].trim();

        //Check no error messages returned on Email field
        Assert.assertFalse(emailMsg.contains(":"));

        //Check error message is still on Password
        Assert.assertEquals(passwordMsgPart2, Constants.LOGIN.BLANK_PASSWORD_ERROR_MESSAGE);

    }

    public void TestCasePCOM_038_002() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        settingElements.logInOrSignUp.click();

        //Enter invalid Email format
        loginElements.setValue(loginElements.email, "fairlyenclave.vn");

        //Leave Password as blank

        //Click Log In button
        loginElements.logInButton.click();

        //Check error messages returned
        String emailMsg = loginElements.email.getText();
        String [] emailMsgParts = emailMsg.split(":");
        String emailMsgPart2 = emailMsgParts[1].trim();

        String passwordMsg = loginElements.password.getText();
        String [] passwordMsgParts = passwordMsg.split(":");
        String passwordMsgPart2 = passwordMsgParts[1].trim();


        Assert.assertEquals(emailMsgPart2, Constants.LOGIN.INVALID_EMAIL_ERROR_MESSAGE);
        Assert.assertEquals(passwordMsgPart2, Constants.LOGIN.BLANK_PASSWORD_ERROR_MESSAGE);


        //Enter a value on Password
        loginElements.setValue(loginElements.password, "Philly123");

        //Click Log In button
        loginElements.logInButton.click();


        emailMsg = loginElements.email.getText();
        emailMsgParts = emailMsg.split(":");
        emailMsgPart2 = emailMsgParts[1].trim();

        passwordMsg = loginElements.password.getText();

        //Check error message is still on Email field
        Assert.assertEquals(emailMsgPart2, Constants.LOGIN.INVALID_EMAIL_ERROR_MESSAGE);

        //Check no error message on Password field
        Assert.assertFalse(passwordMsg.contains(":"));

    }

    public void TestCasePCOM_039() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        settingElements.logInOrSignUp.click();

        //Enter valid Email
        loginElements.setValue(loginElements.email, Constants.LOGIN_EMAIL);

        // Leave Password as blank

        //Click Log In button
        loginElements.logInButton.click();

        //Check error message returned
        String passwordMsg = loginElements.password.getText();
        String [] passwordMsgParts = passwordMsg.split(":");
        String passwordMsgPart2 = passwordMsgParts[1].trim();


        Assert.assertEquals(passwordMsgPart2, Constants.LOGIN.BLANK_PASSWORD_ERROR_MESSAGE);


        //Enter Password
        loginElements.setValue(loginElements.password, "123");

        //Click Log In button
        loginElements.logInButton.click();

        //Check no error message return
        passwordMsg = loginElements.password.getText();
        Assert.assertFalse(passwordMsg.contains(":"));

    }

    public void TestCasePCOM_040() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        settingElements.logInOrSignUp.click();

        //Enter valid Email format
        loginElements.setValue(loginElements.email, Constants.LOGIN_EMAIL);

        // Click and leave Password as blank
        loginElements.password.click();

        //Click Email field
        loginElements.email.click();

        //Check error message returned
        String passwordMsg = loginElements.password.getText();
        String [] passwordMsgParts = passwordMsg.split(":");
        String passwordMsgPart2 = passwordMsgParts[1].trim();
        Assert.assertEquals(passwordMsgPart2,Constants.LOGIN.BLANK_PASSWORD_ERROR_MESSAGE);

        //Click Password field
        loginElements.password.click();

        //Enter Password
        loginElements.setValue(loginElements.password, Constants.LOGIN_PASSWORD);

        //Click outside Log In button
        loginElements.hiddenKeyboard(appiumDriver, loginElements.logInButton);
//        loginElements.logInButton.click();

        //Check no error message return
        passwordMsg = loginElements.password.getText();
        Assert.assertFalse(passwordMsg.contains(":"));

    }

    public void TestCasePCOM_041() {
        lauchApp();
        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);
        loginElements.assertValue(settingElements.logInOrSignUp, Constants.LOGIN.LOG_IN_OR_SIGN_UP);

        settingElements.logInOrSignUp.click();
        Utils.waitForElementVisible(appiumDriver, loginElements.actionBarTitle);


        //Click on the show/hide password icon
        loginElements.showOrHidePasswordIcon.click();

        //Check Password field doesn't active
        Assert.assertFalse(Utils.isKeyboardPresent(appiumDriver));
    }

    public void TestCasePCOM_042() {

        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        settingElements.logInOrSignUp.click();
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);

        //Enter Password
        loginElements.setValue(loginElements.password, Constants.LOGIN_PASSWORD);

        //Click on show/hidden password icon
        loginElements.showOrHidePasswordIcon.click();


        //Check password is shown or hidden
        //Check show/hide password icon is active
        System.out.println("Pwd value: "+loginElements.passwordValue.getAttribute("value"));
        Assert.assertEquals(loginElements.passwordValue.getAttribute("value"),Constants.LOGIN_PASSWORD);
//        loginElements.assertValue(loginElements.passwordValue, Constants.LOGIN_PASSWORD);

    }

    public void TestCasePCOM_045() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        settingElements.logInOrSignUp.click();
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);

        //Click Forgot Password link
        loginElements.forgotPasswordLink.click();

        //Check Forgot Password screen appears
        loginElements.assertValue(loginElements.resetPasswordTitle, "Reset Password");

    }

    public void TestCasePCOM_046() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTab.click();
        waitForVisibilityOf(settingElements.logInOrSignUp);

        settingElements.logInOrSignUp.click();
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);

        //Enter valid email
        loginElements.setValue(loginElements.email, "mnguyen@philly.com");

        loginElements.hiddenKeyboard(appiumDriver, loginElements.email);


        //Click Sign Up link
        loginElements.clickSignUpLink(appiumDriver,loginElements.signUpLink);

        Utils.sleep(Constants.SHORTTIME);
        waitForVisibilityOf(loginElements.signUpTitle);

        //Check Sign Up screen appears
        loginElements.assertValue(loginElements.signUpTitle, "Sign Up");

        //Check Email field has data which bring up from Login screen
        loginElements.assertValue(loginElements.email, "mnguyen@philly.com");

        //Click Log In Link
        loginElements.clickSignUpLink(appiumDriver,loginElements.logInLink);

        //Check Log In screen is being returned
        waitForVisibilityOf(loginElements.actionBarTitle);
        loginElements.assertValue(loginElements.actionBarTitle, Constants.LOGIN.LOG_IN_TITLE);
    }

}


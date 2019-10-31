package tests;

import org.testng.annotations.Test;

public class TM_LoginPage extends BaseTestClass {
    @Test(priority = 1)
    public void S234_C20187_LG_001_VerifyLoadLogInScreenFromSettingsScreen() {
       loginPage.S234_C20187_LG_001_VerifyLoadLogInScreenFromSettingsScreen();
    }

    @Test(priority = 2)
    public void S234_C20188_LG_002_VerifyCloseLogInScreenFromSettingsScreen() {
        loginPage.S234_C20188_LG_002_VerifyCloseLogInScreenFromSettingsScreen();
    }


    @Test(priority = 3)
    public void S234_C20191_LG_005_VerifyLogInWithInvalidEmailFormat() {
        loginPage.S234_C20191_LG_005_VerifyLogInWithInvalidEmailFormat();
    }

    @Test(priority = 4)
    public void S234_C20192_LG_006_VerifyLogInWithInvalidEmailFormatWhenClickOutsidePassword() {
        loginPage.S234_C20192_LG_006_VerifyLogInWithInvalidEmailFormatWhenClickOutsidePassword();
    }

    @Test(priority = 5)
    public void S234_C20193_LG_007_VerifyLogInWithUnregisteredAccount() {
        loginPage.S234_C20193_LG_007_VerifyLogInWithUnregisteredAccount();
    }

    @Test(priority = 6)
    public void S234_C20194_LG_008_VerifyLogInWithIncorrectPassword() {
        loginPage.S234_C20194_LG_008_VerifyLogInWithIncorrectPassword();
    }

    @Test(priority = 7)
    public void S234_C20195_LG_009_VerifyDismissAlert() {
        loginPage.S234_C20195_LG_009_VerifyDismissAlert();
    }

    @Test(priority = 8)
    public void S234_C20196_LG_010_VerifyLogInWithoutInputEmailAndPassword() {
        loginPage.S234_C20196_LG_010_VerifyLogInWithoutInputEmailAndPassword();
    }


    @Test(priority = 11)
    public void S234_C20199_LG_013_VerifyNoEmailErrorMessageDisplaysWhenClickingPassword() {
        loginPage.S234_C20199_LG_013_VerifyNoEmailErrorMessageDisplaysWhenClickingPassword();
    }

    @Test(priority = 12)
    public void S234_C20200_LG_014_VerifyEmailErrorMessageDisplaysWhenLeavingEmailAndClickingLogIn() {
        loginPage.S234_C20200_LG_014_VerifyEmailErrorMessageDisplaysWhenLeavingEmailAndClickingLogIn();
    }

    @Test(priority = 15)
    public void S234_C20203_LG_017_VerifyPasswordErrorMessageDisplayWhenPasswordIsBlankAndClickingLogIn() {
        loginPage.S234_C20203_LG_017_VerifyPasswordErrorMessageDisplayWhenPasswordIsBlankAndClickingLogIn();
    }

    @Test(priority = 16)
    public void S234_C20204_LG_018_VerifyPasswordErrorMessageDisplayWhenPasswordIsBlankAndClickingEmail() {
        loginPage.S234_C20204_LG_018_VerifyPasswordErrorMessageDisplayWhenPasswordIsBlankAndClickingEmail();
    }

    @Test(priority = 17)
    public void S234_C20205_LG_019_VerifyErrorMessagesDisplayWhenEnteringInvalidFieldsAndClickingLogIn() {
        loginPage.S234_C20205_LG_019_VerifyErrorMessagesDisplayWhenEnteringInvalidFieldsAndClickingLogIn();
    }

    @Test(priority = 18)
    public void S234_C20206_LG_020_VerifyNoEmailErrorMessageDisplayWhenEnteringEmail() {
        loginPage.S234_C20206_LG_020_VerifyNoEmailErrorMessageDisplayWhenEnteringEmail();
    }

    @Test(priority = 20)
    public void S234_C20208_LG_022_VerifyNoEmailErrorMessageDisplayWhenEnteringEmailAndClickingLogIn() {
        loginPage.S234_C20208_LG_022_VerifyNoEmailErrorMessageDisplayWhenEnteringEmailAndClickingLogIn();
    }

    @Test(priority = 21)
    public void S234_C20209_LG_023_VerifyNoPasswordErrorMessageDisplayWhenEnteringPasswordAndClickingLogIn() {
        loginPage.S234_C20209_LG_023_VerifyNoPasswordErrorMessageDisplayWhenEnteringPasswordAndClickingLogIn();
    }

    @Test(priority = 22)
    public void S234_C20210_LG_024_VerifyNoPasswordErrorMessageDisplayAfterClickingLogInAndEnteringPassword() {
        loginPage.S234_C20210_LG_024_VerifyNoPasswordErrorMessageDisplayAfterClickingLogInAndEnteringPassword();
    }

    @Test(priority = 24)
    public void S234_C20212_LG_026_VerifyPasswordUnActivateWhenTappingIconShowOrHidden() {
        loginPage.S234_C20212_LG_026_VerifyPasswordUnActivateWhenTappingIconShowOrHidden();
    }

    @Test(priority = 25)
    public void S234_C20213_LG_027_VerifyPasswordValueShowOrHiddenWhenTappingIconShowOrHidden() {
        loginPage.S234_C20213_LG_027_VerifyPasswordValueShowOrHiddenWhenTappingIconShowOrHidden();
    }

    @Test(priority = 26)
    public void S234_C20216_LG_028_VerifyForgotPasswordScreenDisplayWhenTappingForgotPasswordLink() {
        loginPage.S234_C20216_LG_028_VerifyForgotPasswordScreenDisplayWhenTappingForgotPasswordLink();
    }

    @Test(priority = 27)
    public void S234_C20217_LG_029_VerifyEmailValueIsTakenFromLogInToSignUpScreenWhenClickingSignUpLink() {
        loginPage.S234_C20217_LG_029_VerifyEmailValueIsTakenFromLogInToSignUpScreenWhenClickingSignUpLink();
    }

    @Test(priority = 28)
    public void S234_C20218_LG_030_VerifyLogInScreenIsNotChangedWhenScrollUp() {
        loginPage.S234_C20218_LG_030_VerifyLogInScreenIsNotChangedWhenScrollUp();
    }

    //Put tests here to avoid affected to another tests
    @Test(priority = 32)
    public void S234_C22243_LG_031_VerifyHomeFeedDisplayAfterKillingAppAndThanReopeningAppFromLogInScreen() {
        loginPage.S234_C22243_LG_031_VerifyHomeFeedDisplayAfterKillingAppAndThanReopeningAppFromLogInScreen();
    }

    @Test(priority = 33)
    public void S234_C20190_LG_004_VerifyLogInWithValidEmailAndPassword() {
        loginPage.S234_C20190_LG_004_VerifyLogInWithValidEmailAndPassword();
    }

}

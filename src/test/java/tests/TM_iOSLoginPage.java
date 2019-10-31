package tests;

import org.testng.annotations.Test;

public class TM_iOSLoginPage extends BaseTestClass {

    @Test(priority = 1)
    public void S263_C22212_LG_001_VerifyLoadLogInScreenFromSettingsScreen() {
        iOS_LoginPage.S263_C22212_LG_001_VerifyLoadLogInScreenFromSettingsScreen();
    }

    @Test(priority = 2)
    public void S263_C22213_LG_002_VerifyCloseLogInScreenFromSettingsScreen() {
        iOS_LoginPage.S263_C22213_LG_002_VerifyCloseLogInScreenFromSettingsScreen();
    }


    @Test(priority = 3)
    public void S263_C22215_LG_005_VerifyLogInWithInvalidEmailFormat() {
        iOS_LoginPage.S263_C22215_LG_005_VerifyLogInWithInvalidEmailFormat();
    }

    @Test(priority = 4)
    public void S263_C22216_LG_006_VerifyLogInWithInvalidEmailFormatWhenClickOutsidePassword() {
        iOS_LoginPage.S263_C22216_LG_006_VerifyLogInWithInvalidEmailFormatWhenClickOutsidePassword();
    }

    @Test(priority = 5)
    public void S263_C22217_LG_007_VerifyLogInWithUnregisteredAccount() {
        iOS_LoginPage.S263_C22217_LG_007_VerifyLogInWithUnregisteredAccount();
    }

    @Test(priority = 6)
    public void S263_C22218_LG_008_VerifyLogInWithIncorrectPassword() {
        iOS_LoginPage.S263_C22218_LG_008_VerifyLogInWithIncorrectPassword();
    }

    @Test(priority = 7)
    public void S263_C22219_LG_009_VerifyLoginScreenWhenDismissingAlert() {
        iOS_LoginPage.S263_C22221_LG_010_VerifyLogInWithoutInputEmailAndPassword(); }

    @Test(priority = 8)
    public void S263_C22220_LG_010_VerifyErrorMessagesDisplayWhenLeavingEmailAndPassword() {
        iOS_LoginPage.S263_C22220_LG_010_VerifyErrorMessagesDisplayWhenLeavingEmailAndPassword();
    }

    @Test(priority =9)
    public void S263_C22221_LG_011_VerifyEmailErrorMessageDisplaysWhenClickingEmailAndClickPassword() {
        iOS_LoginPage.S263_C22221_LG_011_VerifyEmailErrorMessageDisplaysWhenClickingEmailAndClickPassword();
    }

    @Test(priority = 10)
    public void S263_C22222_LG_012_VerifyErrorMessageDisplayWhenClickingLogIn() {
        iOS_LoginPage.S263_C22222_LG_012_VerifyErrorMessageDisplayWhenClickingLogIn();
    }

    @Test(priority = 11)
    public void S263_C22223_LG_013_VerifyNoEmailErrorMessageDisplaysWhenClickingPassword() {
        iOS_LoginPage.S263_C22223_LG_013_VerifyNoEmailErrorMessageDisplaysWhenClickingPassword();
    }

    @Test(priority = 12)
    public void S263_C22224_LG_014_VerifyEmailErrorMessageDisplaysWhenLeavingEmailAndClickingLogIn() {
        iOS_LoginPage.S263_C22224_LG_014_VerifyEmailErrorMessageDisplaysWhenLeavingEmailAndClickingLogIn();
    }

    @Test(priority = 13)
    public void S263_C22225_LG_015_VerifyEmailErrorMessageDisplaysWhenPasswordEnteredAndClickingLogIn() {
        iOS_LoginPage.S263_C22225_LG_015_VerifyEmailErrorMessageDisplaysWhenPasswordEnteredAndClickingLogIn();
    }

    @Test(priority = 14)
    public void S263_C22226_LG_016_VerifyNoEmailErrorMessageDisplayWhenClickingEmailAgain() {
        iOS_LoginPage.S263_C22226_LG_016_VerifyNoEmailErrorMessageDisplayWhenClickingEmailAgain();
    }

    @Test(priority = 15)
    public void S263_C22227_LG_017_VerifyPasswordErrorMessageDisplayWhenPasswordIsBlankAndClickingLogIn() {
        iOS_LoginPage.S263_C22227_LG_017_VerifyPasswordErrorMessageDisplayWhenPasswordIsBlankAndClickingLogIn();
    }

    @Test(priority = 16)
    public void S263_C22228_LG_018_VerifyPasswordErrorMessageDisplayWhenPasswordIsBlankAndClickingEmail() {
        iOS_LoginPage.S263_C22228_LG_018_VerifyPasswordErrorMessageDisplayWhenPasswordIsBlankAndClickingEmail();
    }

    @Test(priority = 17)
    public void S263_C22229_LG_019_VerifyErrorMessagesDisplayWhenEnteringInvalidFieldsAndClickingLogIn() {
        iOS_LoginPage.S263_C22229_LG_019_VerifyErrorMessagesDisplayWhenEnteringInvalidFieldsAndClickingLogIn();
    }

    @Test(priority = 18)
    public void S263_C22230_LG_020_VerifyNoEmailErrorMessageDisplayWhenEnteringEmail() {
        iOS_LoginPage.S263_C22230_LG_020_VerifyNoEmailErrorMessageDisplayWhenEnteringEmail();
    }

    @Test(priority = 19)
    public void S263_C22231_LG_021_VerifyNoEmailErrorMessageDisplayWhenActivatingEmail() {
        iOS_LoginPage.S263_C22231_LG_021_VerifyNoEmailErrorMessageDisplayWhenActivatingEmail();
    }

    @Test(priority = 20)
    public void S263_C22232_LG_022_VerifyNoEmailErrorMessageDisplayWhenEnteringEmailAndClickingLogIn() {
        iOS_LoginPage.S263_C22232_LG_022_VerifyNoEmailErrorMessageDisplayWhenEnteringEmailAndClickingLogIn();
    }

    @Test(priority = 21)
    public void S263_C22233_LG_023_VerifyNoPasswordErrorMessageDisplayWhenEnteringPasswordAndClickingLogIn() {
        iOS_LoginPage.S263_C22233_LG_023_VerifyNoPasswordErrorMessageDisplayWhenEnteringPasswordAndClickingLogIn();
    }

    @Test(priority = 22)
    public void S263_C22234_LG_024_VerifyNoPasswordErrorMessageDisplayAfterClickingLogInAndEnteringPassword() {
        iOS_LoginPage.S263_C22234_LG_024_VerifyNoPasswordErrorMessageDisplayAfterClickingLogInAndEnteringPassword();   }

    @Test(priority = 23)
    public void S263_C22235_LG_025_VerifyNoPasswordErrorMessageDisplayAfterActivationPassword() {
        iOS_LoginPage.S263_C22235_LG_025_VerifyNoPasswordErrorMessageDisplayAfterActivationPassword();
    }

    @Test(priority = 24)
    public void S263_C22236_LG_026_VerifyPasswordUnActivateWhenTappingIconShowOrHidden() {
        iOS_LoginPage.S263_C22236_LG_026_VerifyPasswordUnActivateWhenTappingIconShowOrHidden();
    }

    @Test(priority = 25)
    public void S263_C22237_LG_027_VerifyPasswordValueShowOrHiddenWhenTappingIconShowOrHidden() {
        iOS_LoginPage.S263_C22237_LG_027_VerifyPasswordValueShowOrHiddenWhenTappingIconShowOrHidden();
    }

    @Test(priority = 26)
    public void S263_C22240_LG_028_VerifyForgotPasswordScreenDisplayWhenTappingForgotPasswordLink() {
        iOS_LoginPage.S263_C22240_LG_028_VerifyForgotPasswordScreenDisplayWhenTappingForgotPasswordLink();
    }

    //Still Failed
    @Test(priority = 27)
    public void S263_C22241_LG_029_VerifyEmailValueIsTakenFromLogInToSignUpScreenWhenClickingSignUpLink() {
        iOS_LoginPage.S263_C22241_LG_029_VerifyEmailValueIsTakenFromLogInToSignUpScreenWhenClickingSignUpLink();
    }

    @Test(priority = 28)
    public void S263_C22242_LG_030_VerifyLogInScreenIsNotChangedWhenScrollUp() {
        iOS_LoginPage.S263_C22242_LG_030_VerifyLogInScreenIsNotChangedWhenScrollUp();
    }

   // @Test(priority = 28)
    public void LoginPageTCPCOM_048() { iOS_LoginPage.TestCasePCOM_048();
    }

    //Put tests here to avoid affected to another tests
    @Test(priority = 50)
    public void S263_C22214_LG_004_VerifyLogInWithValidEmailAndPassword() {
        iOS_LoginPage.S263_C22214_LG_004_VerifyLogInWithValidEmailAndPassword();
    }



}


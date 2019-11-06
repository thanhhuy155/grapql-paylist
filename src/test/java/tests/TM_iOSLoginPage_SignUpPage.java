package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TM_iOSLoginPage_SignUpPage extends BaseTestClass {


    @Test(priority = 1)
    @Description("Load Sign Up screen from Settings")
    public void S287_C24288_SU_001_VerifyLoadSignUpScreen() {
       iOS_SignUpPage.S287_C24288_SU_001_VerifyLoadSignUpScreen();
    }

    @Test(priority = 2)
    @Description("Close Sign Up screen from Settings")
    public void S287_C24289_SU_002_VerifyCloseSignUpScreen() {
        iOS_SignUpPage.S287_C24289_SU_002_VerifyCloseSignUpScreen();
    }

   // @Test(priority = 4) //Getting issue when running on BrowserStack
    @Description("Switch to another app using multitasking and then switch back")
    public void SignUpPageTCPCOM_005() { iOS_SignUpPage.TestCasePCOM_005(); }

   // @Test(priority = 6) //Getting issue when running on BrowserStack
    @Description("Go back to the home screen, open another app, return to the home screen and open the app from home screen")
    public void SignUpPageTCPCOM_007() { iOS_SignUpPage.TestCasePCOM_007(); }

    @Test(priority = 7)
    @Description("Go back to the home screen, open another app, return to the home screen and open the app from home screen")
    public void S287_C24290_SU_003_VerifyReopenAfterKillingApp() {
     iOS_SignUpPage.S287_C24290_SU_003_VerifyReopenAfterKillingApp(); }

    @Test(priority = 9)
    @Description("Enter invalid email format")
    public void S287_C24291_SU_023_VerifyErrorReturnedWhenInputInvalidEmailAndValidPassword() {
     iOS_SignUpPage.S287_C24291_SU_023_VerifyErrorReturnedWhenInputInvalidEmailAndValidPassword(); }

    @Test(priority = 10)
    @Description("Enter registered email")
    public void S287_C24292_SU_005_VerifySignUpWithRegisteredAccount() {
     iOS_SignUpPage.S287_C24292_SU_005_VerifySignUpWithRegisteredAccount(); }


    // Note: Unable to automate from TC12 to TC25 because there is noway to check bullet icons is being changed


    @Test(priority = 11)
    @Description("Enter invalid confirm password")
    public void S287_C24293_SU_006_VerifySignUpWithInvalidConfirmPassword() {
     iOS_SignUpPage.S287_C24293_SU_006_VerifySignUpWithInvalidConfirmPassword(); }

    @Test(priority = 12)
    @Description("Leave Email and Password fields as blank and then click Sign Up button")
    public void S287_C24294_SU_007_VerifySignUpWithoutInputDataIntoFields() {
     iOS_SignUpPage.S287_C24294_SU_007_VerifySignUpWithoutInputDataIntoFields(); }

    @Test(priority = 13)
    @Description("Leave Email and Password fields as blank and then click Confirm Password field")
    public void S287_C24295_SU_008_VerifySignUpWhenEmailAndPasswordAreBlank() {
     iOS_SignUpPage.S287_C24295_SU_008_VerifySignUpWhenEmailAndPasswordAreBlank(); }

    @Test(priority = 14)
    @Description("Click Password field/ outside when clicking and leave Email as blank")
    public void S287_C24296_SU_009_VerifySignUpWhenBlankEmailAndClickingOutsidePassword() {
     iOS_SignUpPage.S287_C24296_SU_009_VerifySignUpWhenBlankEmailAndClickingOutsidePassword(); }

    @Test(priority = 15)
    @Description("Click Password field when not activating and leaving Email as blank")
    public void S287_C24297_SU_010_VerifySignUpWhenBlankEmailAndClickingPassword() {
     iOS_SignUpPage.S287_C24297_SU_010_VerifySignUpWhenBlankEmailAndClickingPassword(); }

    @Test(priority = 16)
    @Description("Click Sign Up button when not activating and leaving Email as blank")
    public void S287_C24298_SU_011_VerifySignUpWhenBlankEmailAndClickingSignUpButton() {
     iOS_SignUpPage.S287_C24298_SU_011_VerifySignUpWhenBlankEmailAndClickingSignUpButton(); }

    @Test(priority = 17)
    @Description("Click outside to dismiss keyboard or Sign Up button when clicking and leave Email as blank")
    public void S287_C24299_SU_012_VerifySignUpWhenBlankEmailAndClickingOutsideEmail() {
     iOS_SignUpPage.S287_C24299_SU_012_VerifySignUpWhenBlankEmailAndClickingOutsideEmail(); }

    @Test(priority = 18)
    @Description("Re-click Email field when clicking and leave Email as blank")
    public void S287_C24300_SU_013_VerifySignUpWhenBlankEmailAndReClickingEmailField() {
     iOS_SignUpPage.S287_C24300_SU_013_VerifySignUpWhenBlankEmailAndReClickingEmailField(); }

    // Note: Unable to automate from TC36 to TC38 because there is noway to check bullet icons is being changed

    @Test(priority = 19)
    @Description("Click Sign Up button when leaving Password as blank")
    public void S287_C24301_SU_014_VerifySignUpWhenBlankPassword() {
     iOS_SignUpPage.S287_C24301_SU_014_VerifySignUpWhenBlankPassword(); }

    @Test(priority = 20)
    @Description("Click another field or Sign Up button when activating and leaving Password as blank")
    public void S287_C24302_SU_015_VerifySignUpWhenBlankPasswordAndClickSignUpButton() {
     iOS_SignUpPage.S287_C24302_SU_015_VerifySignUpWhenBlankPasswordAndClickSignUpButton(); }

    @Test(priority = 21)
    @Description("Dismiss error message on Email field when entering valid value to Email field after clicking Sign Up button")
    public void S287_C24303_SU_017_01_VerifyEmailMessageWhenInputValidValueAndClickSignUp() {
     iOS_SignUpPage.S287_C24303_SU_017_01_VerifyEmailMessageWhenInputValidValueAndClickSignUp(); }

    @Test(priority = 22)
    @Description("Dismiss error message on Email field when returning and entering valid value to Email field after activating Email field")
    public void S287_C24304_SU_017_02_VerifyEmailMessageWhenInputValidValueAndClickOtherField() {
     iOS_SignUpPage.S287_C24304_SU_017_02_VerifyEmailMessageWhenInputValidValueAndClickOtherField(); }

    @Test(priority = 23)
    @Description("Dismiss error message on Email field when entering valid value format to Email field after clicking Sign Up button")
    public void S287_C24305_SU_017_03_VerifyEmailMessageWhenInputValidValueAndClickSignUp() {
     iOS_SignUpPage.S287_C24305_SU_017_03_VerifyEmailMessageWhenInputValidValueAndClickSignUp(); }

    @Test(priority = 24)
    @Description("Dismiss error message on Confirm Password field when entering valid value to Confirm Password field after clicking Sign Up button")
    public void S287_C24309_SU_018_VerifyConfirmPasswordMessageWhenInputValidValue() {
     iOS_SignUpPage.S287_C24309_SU_018_VerifyConfirmPasswordMessageWhenInputValidValue(); }

    @Test(priority = 25)
    @Description("Dismiss error message on Confirm Password field when entering valid value to Confirm Password field after activating Password field")
    public void S287_C24310_SU_019_VerifyConfirmPasswordMessageWhenInputValidValueAndClickOtherField() {
     iOS_SignUpPage.S287_C24310_SU_019_VerifyConfirmPasswordMessageWhenInputValidValueAndClickOtherField(); }

    @Test(priority = 26)
    @Description("Dismiss error message on Confirm Password field when entering valid value to Confirm Password field")
    public void S287_C24311_SU_020_VerifyConfirmPasswordMessageWhenInputValidValue() {
     iOS_SignUpPage.S287_C24311_SU_020_VerifyConfirmPasswordMessageWhenInputValidValue(); }

    @Test(priority = 27)
    @Description("Password and Confirm Password shows or hides the password in both fields simultaneously when tapping on the show/hide password icon in Password fields")
    public void S287_C24312_SU_021_01_VerifyShowOrHidePasswordIcon() {
     iOS_SignUpPage.S287_C24312_SU_021_01_VerifyShowOrHidePasswordIcon(); }

    @Test(priority = 28)
    @Description("Confirm Password field does not activate when tapping on the show/hide password icon")
    public void S287_C24313_SU_021_02_VerifyShowOrHidePasswordIcon() {
     iOS_SignUpPage.S287_C24313_SU_021_02_VerifyShowOrHidePasswordIcon(); }

   //Skip TC58, TC59 due to BrowserStack doesn't allow us to disconnect Wi-Fi


   //Skip T60 and TC61 due to Apple Instruments does not allow us to send commands to more than one app per session
   // That means we are unable to switch app to browser.

    @Test(priority = 31)
    @Description("The same email will be filled if the email field in the previous screen was filled and the value is valid")
    public void S287_C24314_SU_022_VerifyEmailDataBePassedFromLoginScreen() {
     iOS_SignUpPage.S287_C24314_SU_022_VerifyEmailDataBePassedFromLoginScreen(); }

    @Test(priority = 32)
    @Description("No email will be filled if the email field in the previous screen was filled and the value is invalid")
    public void S287_C24315_SU_023_VerifyEmptyEmailBePassedFromLoginScreen() {
     iOS_SignUpPage.S287_C24315_SU_023_VerifyEmptyEmailBePassedFromLoginScreen(); }

    //This test will cause Log In and Sign Up button being disabled so put it here to avoid affecting to the rest test cases
    @Test(priority = 33)
    @Description("Enter valid email and password")
    public void S287_C24291_SU_04_VerifySignUpWhenInputValidEmailAndPassword() {
     iOS_SignUpPage.S287_C24291_SU_04_VerifySignUpWhenInputValidEmailAndPassword(); }
}

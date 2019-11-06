package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TM_LoginPage_SignUpPage extends BaseTestClass {


    @Test(priority = 1)
    @Description("Load Sign Up screen from Settings")
    public void S237_C20231_SU_001_VerifyLoadSignUpScreen() {
        signUpPage.S237_C20231_SU_001_VerifyLoadSignUpScreen();
    }

    @Test(priority = 2)
    @Description("Close Sign Up screen from Settings")
    public void S237_C20232_SU_002_VerifyCloseSignUpScreen() {
        signUpPage.S237_C20232_SU_002_VerifyCloseSignUpScreen();
    }

    @Test(priority = 3)
    @Description("Go back to the home screen, open another app, return to the home screen and open the app from home screen")
    public void S237_C20233_SU_003_VerifyReopenAfterKillingApp() {
        signUpPage.S237_C20233_SU_003_VerifyReopenAfterKillingApp(); }

    @Test(priority = 4)
    @Description("Enter registered email")
    public void S237_C20236_SU_005_VerifySignUpWithRegisteredAccount() {
        signUpPage.S237_C20236_SU_005_VerifySignUpWithRegisteredAccount(); }


    @Test(priority = 5)
    @Description("Leave Email and Password fields as blank and then click Sign Up button")
    public void S237_C20238_SU_007_VerifySignUpWithoutInputDataIntoFields() {
        signUpPage.S237_C20238_SU_007_VerifySignUpWithoutInputDataIntoFields(); }

    @Test(priority = 6)
    @Description("Leave Email and Password fields as blank and then click Confirm Password field")
    public void S237_C20239_SU_008_VerifySignUpWhenEmailAndPasswordAreBlank() {
        signUpPage.S237_C20239_SU_008_VerifySignUpWhenEmailAndPasswordAreBlank(); }

    @Test(priority = 7)
    @Description("Click Password field/ outside when clicking and leave Email as blank")
    public void S237_C20240_SU_009_VerifySignUpWhenBlankEmailAndClickingOutsidePassword() {
        signUpPage.S237_C20240_SU_009_VerifySignUpWhenBlankEmailAndClickingOutsidePassword(); }

    //Samsung Pass autofill issue
    @Test(priority = 8)
    @Description("Click Password field when not activating and leaving Email as blank")
    public void S237_C20241_SU_010_VerifySignUpWhenBlankEmailAndClickingPassword() {
        signUpPage.S237_C20241_SU_010_VerifySignUpWhenBlankEmailAndClickingPassword(); }

    @Test(priority = 9)
    @Description("Click Sign Up button when not activating and leaving Email as blank")
    public void S237_C20242_SU_011_VerifySignUpWhenBlankEmailAndClickingSignUpButton() {
        signUpPage.S237_C20242_SU_011_VerifySignUpWhenBlankEmailAndClickingSignUpButton(); }

    @Test(priority = 10)
    @Description("Click outside to dismiss keyboard or Sign Up button when clicking and leave Email as blank")
    public void S237_C20243_SU_012_VerifySignUpWhenBlankEmailAndClickingOutsideEmail() {
        signUpPage.S237_C20243_SU_012_VerifySignUpWhenBlankEmailAndClickingOutsideEmail(); }

    @Test(priority = 11)
    @Description("Re-click Email field when clicking and leave Email as blank")
    public void S237_C20244_SU_013_VerifySignUpWhenBlankEmailAndReClickingEmailField() {
        signUpPage.S237_C20244_SU_013_VerifySignUpWhenBlankEmailAndReClickingEmailField(); }

    // Note: Unable to automate from TC36 to TC38 because there is noway to check bullet icons is being changed

    @Test(priority = 12)
    @Description("Click Sign Up button when leaving Password as blank")
    public void S237_C20245_SU_014_VerifySignUpWhenBlankPassword() {
        signUpPage.S237_C20245_SU_014_VerifySignUpWhenBlankPassword(); }

    @Test(priority = 13)
    @Description("Click another field or Sign Up button when activating and leaving Password as blank")
    public void S237_C20246_SU_015_VerifySignUpWhenBlankPasswordAndClickSignUpButton() {
        signUpPage.S237_C20246_SU_015_VerifySignUpWhenBlankPasswordAndClickSignUpButton(); }

    @Test(priority = 14)
    @Description("Dismiss error message on Email field when entering valid value to Email field after clicking Sign Up button")
    public void S237_C20248_SU_017_01_VerifyEmailMessageWhenInputValidValueAndClickSignUp() {
        signUpPage.S237_C20248_SU_017_01_VerifyEmailMessageWhenInputValidValueAndClickSignUp(); }

    @Test(priority = 15)
    @Description("Dismiss error message on Email field when returning and entering valid value to Email field after activating Email field")
    public void S237_C20249_SU_017_02_VerifyEmailMessageWhenInputValidValueAndClickOtherField() {
        signUpPage.S237_C20249_SU_017_02_VerifyEmailMessageWhenInputValidValueAndClickOtherField(); }

    @Test(priority = 16)
    @Description("Dismiss error message on Email field when entering valid value format to Email field after clicking Sign Up button")
    public void S237_C20250_SU_017_03_VerifyEmailMessageWhenInputValidValueAndClickSignUp() {
        signUpPage.S237_C20250_SU_017_03_VerifyEmailMessageWhenInputValidValueAndClickSignUp(); }

    @Test(priority = 17)
    @Description("Dismiss error message on Confirm Password field when entering valid value to ConfirmPassword field after clicking Sign Up button")
    public void S237_C20251_SU_018_VerifyConfirmPasswordMessageWhenInputValidValue() {
        signUpPage.S237_C20251_SU_018_VerifyConfirmPasswordMessageWhenInputValidValue(); }


    @Test(priority = 18)
    @Description("Dismiss error message on Confirm Password field when entering valid value to Confirm Password field after activating Password field")
    public void S237_C20252_SU_019_VerifyConfirmPasswordMessageWhenInputValidValueAndClickOtherField() {
        signUpPage.S237_C20252_SU_019_VerifyConfirmPasswordMessageWhenInputValidValueAndClickOtherField(); }

    @Test(priority = 19)
    @Description("Dismiss error message on Confirm Password field when entering valid value to Confirm Password field")
    public void S237_C20253_SU_020_VerifyConfirmPasswordMessageWhenInputValidValue() {
        signUpPage.S237_C20253_SU_020_VerifyConfirmPasswordMessageWhenInputValidValue(); }

    @Test(priority = 20)
    @Description("Password and Confirm Password shows or hides the password in both fields simultaneously when tapping on the show/hide password icon in Password fields")
    public void S237_C20254_SU_021_01_VerifyShowOrHidePasswordIcon() {
        signUpPage.S237_C20254_SU_021_01_VerifyShowOrHidePasswordIcon(); }

    @Test(priority = 21)
    @Description("Confirm Password field does not activate when tapping on the show/hide password icon")
    public void S237_C20255_SU_021_02_VerifyShowOrHidePasswordIcon() {
        signUpPage.S237_C20255_SU_021_02_VerifyShowOrHidePasswordIcon(); }

    @Test(priority = 22)
    @Description("The same email will be filled if the email field in the previous screen was filled and the value is valid")
    public void S237_C24306_SU_022_VerifyEmailDataBePassedFromLoginScreen() {
        signUpPage.S237_C24306_SU_022_VerifyEmailDataBePassedFromLoginScreen(); }


    @Test(priority = 23)
    @Description("No email will be filled if the email field in the previous screen was filled and the value is invalid")
    public void S237_C24307_SU_023_VerifyEmptyEmailBePassedFromLoginScreen() {
        signUpPage.S237_C24307_SU_023_VerifyEmptyEmailBePassedFromLoginScreen(); }

    @Test(priority = 24)
    @Description("Go back to the home screen, open another app, return to the home screen and open the app from home screen")
    public void S237_C20235_SU_024_VerifySignUpWithInvalidEmailFormat() {
        signUpPage.S237_C20235_SU_024_VerifySignUpWithInvalidEmailFormat(); }

    @Test(priority = 25)
    @Description("Put phone to sleep on Sign Up screen and wake phone up to home screen")
    public void S237_C24308_SU_025_VerifySignUpScreenReturnsFromSleep() {
        signUpPage.S237_C24308_SU_025_VerifySignUpScreenReturnsFromSleep(); }

    @Test(priority = 26)
    @Description("Switch to another app using multitasking and then switch back")
    public void S237_C24347_SU_026_VerifySwitchApps() {
        signUpPage.S237_C24347_SU_026_VerifySwitchApps(); }

    @Test(priority = 27)
    @Description("Switch to another app using multitasking and then switch back")
    public void S237_C20237_SU_006_VerifySignUpWithInvalidConfirmPassword() {
        signUpPage.S237_C20237_SU_006_VerifySignUpWithInvalidConfirmPassword(); }

    //This test will cause Log In and Sign Up button being disabled so put it here to avoid affecting to the rest test cases
    @Test(priority = 50)
    @Description("Enter valid email and password")
    public void S237_C20234_SU_04_VerifySignUpWhenInputValidEmailAndPassword() {
        signUpPage.S237_C20234_SU_04_VerifySignUpWhenInputValidEmailAndPassword(); }
}

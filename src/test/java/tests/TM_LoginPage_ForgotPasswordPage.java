package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TM_LoginPage_ForgotPasswordPage extends BaseTestClass {
    @Test(priority = 1)
    @Description("Load Reset Password screen")
    public void S236_C20219_FP_001_VerifyResetPasswordScreenDisplayWhenClickingForgotPasswordLink() {
       forgotPasswordPage.S236_C20219_FP_001_VerifyResetPasswordScreenDisplayWhenClickingForgotPasswordLink();
    }

    @Test(priority = 2)
    @Description("Put phone to sleep on Reset Password screen and wake phone up to home screen")
    public void S236_C20220_FP_002_VerifyResetPasswordScreenDisplayWhenClickingForgotPasswordLink() {
        forgotPasswordPage.S236_C20220_FP_002_VerifyResetPasswordScreenDisplayWhenClickingForgotPasswordLink();
    }


    @Test(priority = 3)
    @Description("No Sign Up screen shows when reopening after killing the app")
    public void S236_C20222_FP_003_VerifySignUpScreenDoesNotDisplayWhenReopeningApp() {
        forgotPasswordPage.S236_C20222_FP_003_VerifySignUpScreenDoesNotDisplayWhenReopeningApp();
    }

    @Test(priority = 4)
    @Description("Error message should be shown when clicking Send Email button with empty email")
    public void S236_C20223_FP_004_VerifyErrorDisplaysWhenClickingSendEmailButtonWithEmptyEmail() {
        forgotPasswordPage.S236_C20223_FP_004_VerifyErrorDisplaysWhenClickingSendEmailButtonWithEmptyEmail();
    }

    @Test(priority = 5)
    @Description("Error message should be shown when clicking outside with empty email")
    public void S236_C20224_FP_005_VerifyErrorDisplaysWhenClickingOutsideEmailFieldWithEmptyEmail() {
        forgotPasswordPage.S236_C20224_FP_005_VerifyErrorDisplaysWhenClickingOutsideEmailFieldWithEmptyEmail();
    }

    @Test(priority = 6)
    @Description("Error message should be shown when resetting password with invalid email")
    public void S236_C20225_FP_006_VerifyErrorDisplaysWhenResettingInvalidEmail() {
        forgotPasswordPage.S236_C20225_FP_006_VerifyErrorDisplaysWhenResettingInvalidEmail();
    }

    @Test(priority = 7)
    @Description("Error message should be shown when clicking outside with invalid email")
    public void S236_C20226_FP_007_VerifyErrorDisplaysWhenClickingOutsideInvalidEmailField() {
        forgotPasswordPage.S236_C20226_FP_007_VerifyErrorDisplaysWhenClickingOutsideInvalidEmailField();
    }


    @Test(priority = 8)
    @Description("Take user to Success screen when entering valid email")
    public void S236_C20227_FP_008_VerifySuccessScreenDisplaysWhenInputValidEmailField() {
        forgotPasswordPage.S236_C20227_FP_008_VerifySuccessScreenDisplaysWhenInputValidEmailField();
    }


    // This test will skip checking Dialer screen appear when running on BrowserStack
    // because the Dialer screen is automatically closed then caused automated is not able to catch element Dialer
    @Test(priority = 9)
    @Description("Call the phone number in the link")
    public void S236_C20228_FP_009_VerifyPreviousScreenBeReturnedAfterClickingPhoneNumber() {
        forgotPasswordPage.S236_C20228_FP_009_VerifyPreviousScreenBeReturnedAfterClickingPhoneNumber();
    }

    @Test(priority = 10)
    @Description("Back from Success screen")
    public void S236_C20230_FP_010_VerifyLogInScreenDisplayWhenClickingBackFromSuccessScreen() {
        forgotPasswordPage.S236_C20230_FP_010_VerifyLogInScreenDisplayWhenClickingBackFromSuccessScreen();
    }
}

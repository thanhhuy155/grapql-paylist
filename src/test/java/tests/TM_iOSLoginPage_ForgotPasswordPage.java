package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TM_iOSLoginPage_ForgotPasswordPage extends BaseTestClass {
    @Test(priority = 1)
    @Description("Load Reset Password screen")
    public void S265_C22255_FP_001_VerifyResetPasswordScreenDisplayWhenClickingForgotPasswordLink() {
       iOS_ForgotPasswordPage.S265_C22255_FP_001_VerifyResetPasswordScreenDisplayWhenClickingForgotPasswordLink();
    }


    @Test(priority = 3)
    @Description("No Sign Up screen shows when reopening after killing the app")
    public void S265_C22256_FP_003_VerifySignUpScreenDoesNotDisplayWhenReopeningApp() {
        iOS_ForgotPasswordPage.S265_C22256_FP_003_VerifySignUpScreenDoesNotDisplayWhenReopeningApp();
    }

    @Test(priority = 4)
    @Description("Error message should be shown when clicking Send Email button with empty email")
    public void S265_C22257_FP_004_VerifyErrorDisplaysWhenClickingSendEmailButtonWithEmptyEmail() {
        iOS_ForgotPasswordPage.S265_C22257_FP_004_VerifyErrorDisplaysWhenClickingSendEmailButtonWithEmptyEmail();
    }

    @Test(priority = 5)
    @Description("Error message should be shown when clicking outside with empty email")
    public void S265_C22258_FP_005_VerifyErrorDisplaysWhenClickingOutsideEmailFieldWithEmptyEmail() {
        iOS_ForgotPasswordPage.S265_C22258_FP_005_VerifyErrorDisplaysWhenClickingOutsideEmailFieldWithEmptyEmail();
    }

    @Test(priority = 6)
    @Description("Error message should be shown when resetting password with invalid email")
    public void S265_C22259_FP_006_VerifyErrorDisplaysWhenResettingInvalidEmail() {
        iOS_ForgotPasswordPage.S265_C22259_FP_006_VerifyErrorDisplaysWhenResettingInvalidEmail();
    }

    @Test(priority = 7)
    @Description("Error message should be shown when clicking outside with invalid email")
    public void S265_C24345_FP_007_VerifyErrorDisplaysWhenClickingOutsideInvalidEmailField() {
        iOS_ForgotPasswordPage.S265_C24345_FP_007_VerifyErrorDisplaysWhenClickingOutsideInvalidEmailField();
    }


    @Test(priority = 8)
    @Description("Take user to Success screen when entering valid email")
    public void S265_C22260_FP_008_VerifySuccessScreenDisplaysWhenInputValidEmailField() {
        iOS_ForgotPasswordPage.S265_C22260_FP_008_VerifySuccessScreenDisplaysWhenInputValidEmailField();
    }


    @Test(priority = 9)
    @Description("Cancel calling the phone number in the link")
    public void S265_C20229_FP_010_VerifyResetPasswordScreenDisplaysWhenClickingCancel() {
        iOS_ForgotPasswordPage.S265_C20229_FP_010_VerifyResetPasswordScreenDisplaysWhenClickingCancel();
    }

    @Test(priority = 10)
    @Description("Back from Success screen")
    public void S265_C22261_FP_011_VerifyLogInScreenDisplayWhenClickingBackFromSuccessScreen() {
        iOS_ForgotPasswordPage.S265_C22261_FP_011_VerifyLogInScreenDisplayWhenClickingBackFromSuccessScreen();
    }
}

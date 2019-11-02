package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TM_iOSLoginPage_ForgotEmailPage extends BaseTestClass {

    @Test(priority = 1)
    @Description("Load Recover Email tooltip")
    public void S264_C22250_FE_001_VerifyRecoverEmailTooltipDisplay() {
       iOS_ForgotEmailPage.S264_C22250_FE_001_VerifyRecoverEmailTooltipDisplay();
    }

    @Test(priority = 2)
    @Description("Load Recover Email message and call the number in the link")
    public void S264_C20182_FE_002_VerifyCallButtonOnPhoneNumberOnTooltipWork() {
        iOS_ForgotEmailPage.S264_C20182_FE_002_VerifyCallButtonOnPhoneNumberOnTooltipWork();
    }

    @Test(priority = 3)
    @Description("Load Recover Email message and cancel calling the number in the link")
    public void S264_C22251_FE_004_VerifyLogInScreenReturnedAfterClickingCancelButton() {
        iOS_ForgotEmailPage.S264_C22251_FE_004_VerifyLogInScreenReturnedAfterClickingCancelButton();
    }


    @Test(priority = 4)
    @Description("Close the recover email tooltip")
    public void S264_C22252_FE_005_01_VerifyRecoverEmailTooltipIsCloseWhenClickingCloseXButton() {
        iOS_ForgotEmailPage.S264_C22252_FE_005_01_VerifyRecoverEmailTooltipIsCloseWhenClickingCloseXButton();
    }

    @Test(priority = 5)
    @Description("Close the recover email tooltip")
    public void S264_C22253_FE_005_02_VerifyRecoverEmailTooltipIsCloseWhenClickingCloseXButton() {
        iOS_ForgotEmailPage.S264_C22253_FE_005_02_VerifyRecoverEmailTooltipIsCloseWhenClickingCloseXButton();
    }

    @Test(priority = 6)
    @Description("Tapping the forgot email link will hide the keyboard")
    public void S264_C22254_FE_006_VerifyTappingForgotEmailLinkWillHiddenKeyboard() {
        iOS_ForgotEmailPage.S264_C22254_FE_006_VerifyTappingForgotEmailLinkWillHiddenKeyboard();
    }


}

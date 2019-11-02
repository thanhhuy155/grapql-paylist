package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TM_LoginPage_ForgotEmailPage extends BaseTestClass {
    @Test(priority = 1)
    @Description("Load Recover Email tootip")
    public void S235_C20181_FE_001_VerifyRecoverEmailTooltipDisplay() {
       forgotEmailPage.S235_C20181_FE_001_VerifyRecoverEmailTooltipDisplay();
    }

    // This test will skip checking Dialer screen appear when running on BrowserStack
    // because the Dialer screen is automatically closed then caused automated is not able to catch element Dialer
    @Test(priority = 2)
    @Description("Load Recover Email message and call the number in the link")
    public void S235_C20184_FE_003_VerifyCancelCallingPhonenNumberWorksWell() {
        forgotEmailPage.S235_C20184_FE_003_VerifyCancelCallingPhonenNumberWorksWell();
    }

    @Test(priority = 3)
    @Description("Close the recover email tooltip")
    public void S235_C20185_FE_005_VerifyRecoverEmailTooltipIsCloseWhenClickingCloseXButton() {
        forgotEmailPage.S235_C20185_FE_005_VerifyRecoverEmailTooltipIsCloseWhenClickingCloseXButton(); }

    @Test(priority = 4)
    @Description("Tapping the forgot email link will hide the keyboard")
    public void S235_C20186_FE_006_VerifyTappingForgotEmailLinkWillHiddenKeyboard() {
        forgotEmailPage.S235_C20186_FE_006_VerifyTappingForgotEmailLinkWillHiddenKeyboard();
    }

}

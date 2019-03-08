package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TM_iOSLoginPage_ForgotPasswordPage extends BaseTestClass {
    @Test(priority = 1)
    @Description("Load Reset Password screen")
    public void ForgotPasswordPageTCPCOM_001() {
       iOS_ForgotPasswordPage.TestCasePCOM_001();
    }


    @Test(priority = 3)
    @Description("No Sign Up screen shows when reopening after killing the app")
    public void ForgotPasswordPageTCPCOM_006() {
        iOS_ForgotPasswordPage.TestCasePCOM_006();
    }

    @Test(priority = 4)
    @Description("Error message should be shown when clicking Send Email button with empty email")
    public void ForgotPasswordPageTCPCOM_007() {
        iOS_ForgotPasswordPage.TestCasePCOM_007();
    }

    @Test(priority = 5)
    @Description("Error message should be shown when clicking outside with empty email")
    public void ForgotPasswordPageTCPCOM_008() {
        iOS_ForgotPasswordPage.TestCasePCOM_008();
    }

    @Test(priority = 6)
    @Description("Error message should be shown when resetting password with invalid email")
    public void ForgotPasswordPageTCPCOM_009() {
        iOS_ForgotPasswordPage.TestCasePCOM_009();
    }

    @Test(priority = 7)
    @Description("Error message should be shown when clicking outside with invalid email")
    public void ForgotPasswordPageTCPCOM_010() {
        iOS_ForgotPasswordPage.TestCasePCOM_010();
    }


    @Test(priority = 8)
    @Description("Take user to Success screen when entering valid email")
    public void ForgotPasswordPageTCPCOM_011() {
        iOS_ForgotPasswordPage.TestCasePCOM_011();
    }


    @Test(priority = 9)
    @Description("Cancel calling the phone number in the link")
    public void ForgotPasswordPageTCPCOM_014() {
        iOS_ForgotPasswordPage.TestCasePCOM_014();
    }

    @Test(priority = 10)
    @Description("Back from Success screen")
    public void ForgotPasswordPageTCPCOM_015() {
        iOS_ForgotPasswordPage.TestCasePCOM_015();
    }
}

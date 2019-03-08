package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TM_LoginPage_ForgotPasswordPage extends BaseTestClass {
    @Test(priority = 1)
    @Description("Load Reset Password screen")
    public void ForgotEmailPageTCPCOM_001() {
       forgotPasswordPage.TestCasePCOM_001();
    }

    @Test(priority = 2)
    @Description("Put phone to sleep on Reset Password screen and wake phone up to home screen")
    public void ForgotEmailPageTCPCOM_002() {
        forgotPasswordPage.TestCasePCOM_002();
    }


    @Test(priority = 3)
    @Description("No Sign Up screen shows when reopening after killing the app")
    public void ForgotPasswordPageTCPCOM_006() {
        forgotPasswordPage.TestCasePCOM_006();
    }

    @Test(priority = 4)
    @Description("Error message should be shown when clicking Send Email button with empty email")
    public void ForgotPasswordPageTCPCOM_007() {
        forgotPasswordPage.TestCasePCOM_007();
    }

    @Test(priority = 5)
    @Description("Error message should be shown when clicking outside with empty email")
    public void ForgotPasswordPageTCPCOM_008() {
        forgotPasswordPage.TestCasePCOM_008();
    }

    @Test(priority = 6)
    @Description("Error message should be shown when resetting password with invalid email")
    public void ForgotPasswordPageTCPCOM_009() {
        forgotPasswordPage.TestCasePCOM_009();
    }

    @Test(priority = 7)
    @Description("Error message should be shown when clicking outside with invalid email")
    public void ForgotPasswordPageTCPCOM_010() {
        forgotPasswordPage.TestCasePCOM_010();
    }


    @Test(priority = 8)
    @Description("Take user to Success screen when entering valid email")
    public void ForgotPasswordPageTCPCOM_011() {
        forgotPasswordPage.TestCasePCOM_011();
    }


    @Test(priority = 9)
    @Description("Call the phone number in the link")
    public void ForgotPasswordPageTCPCOM_013() {
        forgotPasswordPage.TestCasePCOM_013();
    }

    @Test(priority = 10)
    @Description("Back from Success screen")
    public void ForgotPasswordPageTCPCOM_015() {
        forgotPasswordPage.TestCasePCOM_015();
    }
}

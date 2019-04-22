package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TM_LoginPage_ForgotEmailPage extends BaseTestClass {
    @Test(priority = 1)
    @Description("Load Recover Email tootip")
    public void ForgotEmailPageTCPCOM_001() {
       forgotEmailPage.TestCasePCOM_001();
    }

    // This test will skip checking Dialer screen appear when running on BrowserStack
    // because the Dialer screen is automatically closed then caused automated is not able to catch element Dialer
    @Test(priority = 2)
    @Description("Load Recover Email message and call the number in the link")
    public void ForgotEmailPageTCPCOM_003() {
        forgotEmailPage.TestCasePCOM_003();
    }

    @Test(priority = 3)
    @Description("Close the recover email tooltip")
    public void ForgotEmailPageTCPCOM_005() { forgotEmailPage.TestCasePCOM_005(); }

    @Test(priority = 4)
    @Description("Tapping the forgot email link will hide the keyboard")
    public void ForgotEmailPageTCPCOM_006() {
        forgotEmailPage.TestCasePCOM_006();
    }

}

package tests;

import org.testng.annotations.Test;

public class TM_LoginPage_ForgotEmailPage extends BaseTestClass {
    @Test(priority = 1)
    public void ForgotEmailPageTCPCOM_001() {
       forgotEmailPage.TestCasePCOM_001();
    }

    @Test(priority = 2)
    public void ForgotEmailPageTCPCOM_003() {
        forgotEmailPage.TestCasePCOM_003();
    }

    @Test(priority = 3)
    public void ForgotEmailPageTCPCOM_005() { forgotEmailPage.TestCasePCOM_005(); }

    @Test(priority = 4)
    public void ForgotEmailPageTCPCOM_006() {
        forgotEmailPage.TestCasePCOM_006();
    }




}

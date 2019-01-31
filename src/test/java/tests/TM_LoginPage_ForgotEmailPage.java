package tests;

import org.testng.annotations.Test;

public class TM_LoginPage_ForgotEmailPage extends BaseTestClass {
    @Test(priority = 1, description = "Load 'Recover Email' tootip")
    //Note: Implemented for both iOS and Android
    public void ForgotEmailPageTCPCOM_001() {
       forgotEmailPage.TestCasePCOM_001();
    }

    @Test(priority = 2, description = "Call the phone number")
    public void ForgotEmailPageTCPCOM_003() {
        forgotEmailPage.TestCasePCOM_003();
    }


    @Test(priority = 3, description = "Close the tooltip")
    public void LoginPageTCPCOM_005() {
        forgotEmailPage.TestCasePCOM_005();
    }

    @Test(priority = 4, description = "Tapping the forgot email link will hide the keyboard")
    public void LoginPageTCPCOM_006() {
        forgotEmailPage.TestCasePCOM_006();
    }




}

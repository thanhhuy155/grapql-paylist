package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TM_iOSLoginPage_ForgotEmailPage extends BaseTestClass {

    @Test(priority = 1)
    @Description("Load Recover Email tootip")
    public void ForgotEmailPageTCPCOM_001() {
       iOS_ForgotEmailPage.TestCasePCOM_001();
    }

    @Test(priority = 2)
    @Description("Load Recover Email message and call the number in the link")
    public void ForgotEmailPageTCPCOM_002() {
        iOS_ForgotEmailPage.TestCasePCOM_002();
    }

    @Test(priority = 3)
    @Description("Load Recover Email message and cancel calling the number in the link")
    public void ForgotEmailPageTCPCOM_004() {
        iOS_ForgotEmailPage.TestCasePCOM_004();
    }


    @Test(priority = 4)
    @Description("Close the recover email tooltip")
    public void ForgotEmailPageTCPCOM_005_001() {
        iOS_ForgotEmailPage.TestCasePCOM_005_001();
    }

    @Test(priority = 5)
    @Description("Close the recover email tooltip")
    public void ForgotEmailPageTCPCOM_005_002() {
        iOS_ForgotEmailPage.TestCasePCOM_005_002();
    }

    @Test(priority = 6)
    @Description("Tapping the forgot email link will hide the keyboard")
    public void ForgotEmailPageTCPCOM_006() {
        iOS_ForgotEmailPage.TestCasePCOM_006();
    }


}

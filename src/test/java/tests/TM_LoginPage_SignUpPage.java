package tests;

import org.testng.annotations.Test;

public class TM_LoginPage_SignUpPage extends BaseTestClass {


    @Test(priority = 1)
    public void SignUpPageTCPCOM_001() {
       signUpPage.TestCasePCOM_001();
    }

    @Test(priority = 2)
    public void SignUpPageTCPCOM_003() {
        signUpPage.TestCasePCOM_003();
    }

    @Test(priority = 3)
    public void SignUpPageTCPCOM_005() { signUpPage.TestCasePCOM_005(); }

}

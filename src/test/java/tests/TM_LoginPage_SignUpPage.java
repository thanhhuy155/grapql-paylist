package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TM_LoginPage_SignUpPage extends BaseTestClass {


//    @Test(priority = 1)
    @Test
    @Description("Load Sign Up screen from Settings")
    public void SignUpPageTCPCOM_001() {
       signUpPage.TestCasePCOM_001();
    }

//    @Test(priority = 2)
    @Test
    @Description("Close Sign Up screen from Settings")
    public void SignUpPageTCPCOM_003() {
        signUpPage.TestCasePCOM_003();
    }

//    @Test(priority = 3)
    @Test
    @Description("Put phone to sleep on Sign Up screen and wake phone up to home screen")
    public void SignUpPageTCPCOM_004() { signUpPage.TestCasePCOM_004(); }

//    @Test(priority = 4)
    @Test
    @Description("Put phone to sleep on Sign Up screen and wake phone up to home screen")
    public void SignUpPageTCPCOM_005() { signUpPage.TestCasePCOM_005(); }
    
}

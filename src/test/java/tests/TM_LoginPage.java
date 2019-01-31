package tests;

import org.testng.annotations.Test;

public class TM_LoginPage extends BaseTestClass {
    @Test(priority = 1, description = "Load 'Log In' screen from Settings")
    //Note: Implemented for both iOS and Android
    public void LoginPageTCPCOM_002() {
       loginPage.TestCasePCOM_002();
    }

    @Test(priority = 2, description = "Close 'Log In' screen from Settings")
    public void LoginPageTCPCOM_007() {
        loginPage.TestCasePCOM_007();
    }


    @Test(priority = 3, description = "Login with invalid email format")
    public void LoginPageTCPCOM_019() {
        loginPage.TestCasePCOM_019();
    }

    @Test(priority = 4, description = "Click outside/ Password field when invalid format on Email field")
    public void LoginPageTCPCOM_020() {
        loginPage.TestCasePCOM_020();
    }

    @Test(priority = 5, description = "Login with invalid account")
    public void LoginPageTCPCOM_021() {
        loginPage.TestCasePCOM_021();
    }

    @Test(priority = 6, description = "Login with incorrect password")
    public void LoginPageTCPCOM_022() {
        loginPage.TestCasePCOM_022();
    }

    @Test(priority = 7, description = "Dismiss 'The email and password you entered don't match' alert")
    public void LoginPageTCPCOM_023() {
        loginPage.TestCasePCOM_023();
    }

    @Test(priority = 8, description = "Leave Email and Password fields as blank")
    public void LoginPageTCPCOM_024() {
        loginPage.TestCasePCOM_024();
    }

    @Test(priority =9, description = "Click on each field and leave Email and Password fields as blank")
    public void LoginPageTCPCOM_025() {
        loginPage.TestCasePCOM_025();
    }

    @Test(priority = 10, description = "Click on each field and leave Email and Password fields as blank")
    public void LoginPageTCPCOM_026() {
        loginPage.TestCasePCOM_026();
    }

    @Test(priority = 11, description = "Click Password field when not activating and leaving Email as blank")
    public void LoginPageTCPCOM_027() {
        loginPage.TestCasePCOM_027();
    }

    @Test(priority = 12, description = "Click 'Log In' button when leaving Email as blank")
    public void LoginPageTCPCOM_028() {
        loginPage.TestCasePCOM_028();
    }

    @Test(priority = 13, description = "Click outside to dismiss keyboard or 'Log In' button when clicking and leave Email as blank")
    public void LoginPageTCPCOM_029() {
        loginPage.TestCasePCOM_029();
    }

    @Test(priority = 14, description = "Re-click 'Email' field when clicking and leave Email as blank")
    public void LoginPageTCPCOM_030() {
        loginPage.TestCasePCOM_030();
    }

    @Test(priority = 15, description = "Click 'Log In' button when leaving Password as blank")
    public void LoginPageTCPCOM_032() {
        loginPage.TestCasePCOM_032();
    }

    @Test(priority = 16, description = "Click Email field or 'Log In' button when clicking and leave Password as blank")
    public void LoginPageTCPCOM_033() {
        loginPage.TestCasePCOM_033();
    }

    @Test(priority = 17, description = "Enter invalid Email and leave Password field as blank")
    public void LoginPageTCPCOM_035() {
        loginPage.TestCasePCOM_035();
    }

    @Test(priority = 18, description = "Dismiss 'Please enter your email address' on Email field when entering the value to Email field after clicking 'Log In' button")
    public void LoginPageTCPCOM_036() {
        loginPage.TestCasePCOM_036();
    }

    @Test(priority = 19, description = "Dismiss 'Please enter your email address' on Email field when returning and entering the value to Email field after activating Email field")
    public void LoginPageTCPCOM_037() {
        loginPage.TestCasePCOM_037();
    }

    @Test(priority = 20, description = "Dismiss 'Please enter a valid email address.' message on Email field when entering the value to Email field after clicking 'Log In' button")
    public void LoginPageTCPCOM_038_001() {
        loginPage.TestCasePCOM_038_001();
    }

    @Test(priority = 21, description = "Dismiss 'Please enter your password.' message on Password field when entering the value to Password field after clicking 'Log In' button")
    public void LoginPageTCPCOM_038_002() {
        loginPage.TestCasePCOM_038_002();
    }

    @Test(priority = 22, description = "Dismiss 'Please enter your password.' message on Password field when entering the value to Password field after clicking 'Log In' button")
    public void LoginPageTCPCOM_039() {
        loginPage.TestCasePCOM_039();
    }

    @Test(priority = 23, description = "Dismiss 'Please enter your password.' message on Password field when returning and entering the value to Password field after activating Password field")
    public void LoginPageTCPCOM_040() {
        loginPage.TestCasePCOM_040();
    }

    @Test(priority = 24, description = "Tapping on the show/hide password icon does not activate the field")
    public void LoginPageTCPCOM_041() {
        loginPage.TestCasePCOM_041();
    }

    @Test(priority = 25, description = "Tapping on the show/hide password icon shows or hides the password")
    public void LoginPageTCPCOM_042() {
        loginPage.TestCasePCOM_042();
    }

    @Test(priority = 26, description = "Take the user to 'Forgot Password' screen when they tap the “Forgot Password?” link at anytime during login")
    public void LoginPageTCPCOM_045() {
        loginPage.TestCasePCOM_045();
    }

    //Still Failed
    @Test(priority = 27, description = "The same email will be filled if the email field in the previous screen was filled and the value is valid")
    public void LoginPageTCPCOM_046() {
        loginPage.TestCasePCOM_046();
    }

    @Test(priority = 28,description = "Load 'Log In' screen from Settings without network connection")
    public void LoginPageTCPCOM_004() {
        loginPage.TestCasePCOM_004();
    }

    //Disconnect wiki/cellular test cases
    @Test(priority = 29)
    public void LoginPageTCPCOM_043() {
        loginPage.TestCasePCOM_043();
    }

    @Test(priority = 30)
    public void LoginPageTCPCOM_044() {
        loginPage.TestCasePCOM_044();
    }

    //Put tests here to avoid affected to another tests
    @Test(priority = 31, description = "Settings 'Log In' screen return from sleep")
    public void LoginPageTCPCOM_009() {
        loginPage.TestCasePCOM_009();
    }

    @Test(priority = 32, description = "Settings - Reopen after killing the app from Log In screen")
    public void LoginPageTCPCOM_017() {
        loginPage.TestCasePCOM_017();
    }

    @Test(priority = 33, description = "Login with valid email and password")
    public void LoginPageTCPCOM_018() {
        loginPage.TestCasePCOM_018();
    }


}

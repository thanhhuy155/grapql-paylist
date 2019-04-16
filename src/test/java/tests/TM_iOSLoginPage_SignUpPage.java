package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TM_iOSLoginPage_SignUpPage extends BaseTestClass {


    @Test(priority = 1)
    @Description("Load Sign Up screen from Settings")
    public void SignUpPageTCPCOM_001() {
       iOS_SignUpPage.TestCasePCOM_001();
    }

    @Test(priority = 2)
    @Description("Close Sign Up screen from Settings")
    public void SignUpPageTCPCOM_003() {
        iOS_SignUpPage.TestCasePCOM_003();
    }

   // @Test(priority = 4)
    @Description("Switch to another app using multitasking and then switch back")
    public void SignUpPageTCPCOM_005() { iOS_SignUpPage.TestCasePCOM_005(); }

   // @Test(priority = 6)
    @Description("Go back to the home screen, open another app, return to the home screen and open the app from home screen")
    public void SignUpPageTCPCOM_007() { iOS_SignUpPage.TestCasePCOM_007(); }

    @Test(priority = 7)
    @Description("Go back to the home screen, open another app, return to the home screen and open the app from home screen")
    public void SignUpPageTCPCOM_008() { iOS_SignUpPage.TestCasePCOM_008(); }



    @Test(priority = 9)
    @Description("Enter invalid email format")
    public void SignUpPageTCPCOM_010() { iOS_SignUpPage.TestCasePCOM_010(); }

    @Test(priority = 10)
    @Description("Enter registered email")
    public void SignUpPageTCPCOM_011() { iOS_SignUpPage.TestCasePCOM_011(); }


    // Note: Unable to automate from TC12 to TC25 because there is noway to check bullet icons is being changed


    @Test(priority = 11)
    @Description("Enter invalid confirm password")
    public void SignUpPageTCPCOM_026() { iOS_SignUpPage.TestCasePCOM_026(); }


    @Test(priority = 12)
    @Description("Leave Email and Password fields as blank and then click Sign Up button")
    public void SignUpPageTCPCOM_027() { iOS_SignUpPage.TestCasePCOM_027(); }

    @Test(priority = 13)
    @Description("Leave Email and Password fields as blank and then click Confirm Password field")
    public void SignUpPageTCPCOM_028() { iOS_SignUpPage.TestCasePCOM_028(); }

    @Test(priority = 14)
    @Description("Click Password field/ outside when clicking and leave Email as blank")
    public void SignUpPageTCPCOM_031() { iOS_SignUpPage.TestCasePCOM_031(); }

    //Samsung Pass autofill issue
    @Test(priority = 15)
    @Description("Click Password field when not activating and leaving Email as blank")
    public void SignUpPageTCPCOM_032() { iOS_SignUpPage.TestCasePCOM_032(); }

    @Test(priority = 16)
    @Description("Click Sign Up button when not activating and leaving Email as blank")
    public void SignUpPageTCPCOM_033() { iOS_SignUpPage.TestCasePCOM_033(); }

    @Test(priority = 17)
    @Description("Click outside to dismiss keyboard or Sign Up button when clicking and leave Email as blank")
    public void SignUpPageTCPCOM_034() { iOS_SignUpPage.TestCasePCOM_034(); }

    @Test(priority = 18)
    @Description("Re-click Email field when clicking and leave Email as blank")
    public void SignUpPageTCPCOM_035() { iOS_SignUpPage.TestCasePCOM_035(); }

    // Note: Unable to automate from TC36 to TC38 because there is noway to check bullet icons is being changed

    @Test(priority = 19)
    @Description("Click Sign Up button when leaving Password as blank")
    public void SignUpPageTCPCOM_039() { iOS_SignUpPage.TestCasePCOM_039(); }

    @Test(priority = 20)
    @Description("Click another field or Sign Up button when activating and leaving Password as blank")
    public void SignUpPageTCPCOM_040() { iOS_SignUpPage.TestCasePCOM_040(); }

    @Test(priority = 21)
    @Description("Dismiss error message on Email field when entering valid value to Email field after clicking Sign Up button")
    public void SignUpPageTCPCOM_045() { iOS_SignUpPage.TestCasePCOM_045(); }

    @Test(priority = 22)
    @Description("Dismiss error message on Email field when returning and entering valid value to Email field after activating Email field")
    public void SignUpPageTCPCOM_046() { iOS_SignUpPage.TestCasePCOM_046(); }

    @Test(priority = 23)
    @Description("Dismiss error message on Email field when entering valid value format to Email field after clicking Sign Up button")
    public void SignUpPageTCPCOM_047() { iOS_SignUpPage.TestCasePCOM_047(); }

    @Test(priority = 24)
    @Description("Dismiss error message on Confirm Password field when entering valid value to Confirm Password field after clicking Sign Up button")
    public void SignUpPageTCPCOM_051() { iOS_SignUpPage.TestCasePCOM_051(); }


    @Test(priority = 25)
    @Description("Dismiss error message on Confirm Password field when entering valid value to Confirm Password field after activating Password field")
    public void SignUpPageTCPCOM_052() { iOS_SignUpPage.TestCasePCOM_052(); }

    @Test(priority = 26)
    @Description("Dismiss error message on Confirm Password field when entering valid value to Confirm Password field")
    public void SignUpPageTCPCOM_053() { iOS_SignUpPage.TestCasePCOM_053(); }

    @Test(priority = 27)
    @Description("Password and Confirm Password shows or hides the password in both fields simultaneously when tapping on the show/hide password icon in Password fields")
    public void SignUpPageTCPCOM_056() { iOS_SignUpPage.TestCasePCOM_056(); }

    @Test(priority = 28)
    @Description("Confirm Password field does not activate when tapping on the show/hide password icon")
    public void SignUpPageTCPCOM_057() { iOS_SignUpPage.TestCasePCOM_057(); }

    // @Test(priority = 29) Not completed yet
    @Description("Take the user to \"Terms of Service\" screen when they tap the “Terms of Service” link at anytime during sign up")
    public void SignUpPageTCPCOM_060() { iOS_SignUpPage.TestCasePCOM_060(); }


   // @Test(priority = 30) Not completed yet
    @Description("Take the user to \"Privacy Policy\" screen when they tap the “Privacy Policy” link at anytime during sign up")
    public void SignUpPageTCPCOM_061() { iOS_SignUpPage.TestCasePCOM_062(); }

    @Test(priority = 31)
    @Description("The same email will be filled if the email field in the previous screen was filled and the value is valid")
    public void SignUpPageTCPCOM_062() { iOS_SignUpPage.TestCasePCOM_062(); }


    @Test(priority = 32)
    @Description("No email will be filled if the email field in the previous screen was filled and the value is invalid")
    public void SignUpPageTCPCOM_063() { iOS_SignUpPage.TestCasePCOM_063(); }

    //This test will cause Log In and Sign Up button being disabled so put it here to avoid affecting to the rest test cases
    @Test(priority = 33)
    @Description("Enter valid email and password")
    public void SignUpPageTCPCOM_009() { iOS_SignUpPage.TestCasePCOM_009(); }
}

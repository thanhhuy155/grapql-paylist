package tests;

import org.testng.annotations.Test;

public class TM_CustomizationPage extends BaseTestClass {
    //C234
    @Test(priority = 1)
    public void S295_C24353_CU_001_VerifyBannerDisplaysWhenReOpeningApp() {
        customizationPage.S295_C24353_CU_001_VerifyBannerDisplaysWhenReOpeningApp();
    }

    //C309
//    @Test(priority = 2)
    public void CustomizationTCNo2() {
        customizationPage.TestCaseNo2();
    }

    //C310
    @Test(priority = 3)
    public void S295_C24353_CU_002_VerifyBannerDisplaysAfterLoggingInAndReOpeningApp() {
        customizationPage.S295_C24353_CU_002_VerifyBannerDisplaysAfterLoggingInAndReOpeningApp();
    }

    //C12493
    @Test(priority = 4)
    public void S295_C12493_CU_003_VerifyLogInSignUpDrawerDismissesWhenNotLoggedUserUnselectAllTopic() {
        customizationPage.S295_C12493_CU_003_VerifyLogInSignUpDrawerDismissesWhenNotLoggedUserUnselectAllTopic();
    }

}

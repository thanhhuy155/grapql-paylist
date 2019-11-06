package tests;

import org.testng.annotations.Test;

public class TM_iOSCustomizationPage extends BaseTestClass {
    //C234
    @Test(priority = 1)
    public void S296_C24355_CU_001_VerifyBannerDisplaysWhenReOpeningApp() {
        iOS_CustomizationPage.S296_C24355_CU_001_VerifyBannerDisplaysWhenReOpeningApp();
    }

    //C309
//    @Test(priority = 2)
    public void CustomizationTCNo2() {
        iOS_CustomizationPage.TestCaseNo2();
    }

    //C310
    @Test(priority = 3)
    public void S296_C24356_CU_002_VerifyBannerDisplaysAfterLoggingInAndReOpeningApp() {
        iOS_CustomizationPage.S296_C24356_CU_002_VerifyBannerDisplaysAfterLoggingInAndReOpeningApp();
    }

}

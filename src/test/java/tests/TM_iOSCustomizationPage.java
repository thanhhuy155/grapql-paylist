package tests;

import org.testng.annotations.Test;

public class TM_iOSCustomizationPage extends BaseTestClass {
    //C234
    @Test(priority = 1)
    public void S296_C24355_CU_001_VerifyBannerDisplaysWhenReOpeningApp() {
        iOS_CustomizationPage.S296_C24355_CU_001_VerifyBannerDisplaysWhenReOpeningApp();
    }

    //C263
    @Test(priority = 2)
    public void S296_C32113_CU_005_VerifyBannerDisplaysAtTheTopOfTheScreen() {
        iOS_CustomizationPage.S296_C32113_CU_005_VerifyBannerDisplaysAtTheTopOfTheScreen();
    }

    //C310
    @Test(priority = 3)
    public void S296_C24356_CU_002_VerifyBannerDisplaysAfterLoggingInAndReOpeningApp() {
        iOS_CustomizationPage.S296_C24356_CU_002_VerifyBannerDisplaysAfterLoggingInAndReOpeningApp();
    }

    //C240
    @Test(priority = 4)
    public void S296_C32118_CU_004_VerifyUsersCanNotFollowCategoryWithoutLogin() {
        iOS_CustomizationPage.S296_C32118_CU_004_VerifyUsersCanNotFollowCategoryWithoutLogin();
    }

    //C309
//    @Test(priority = 5)
    public void CustomizationTCNo2() {
        iOS_CustomizationPage.TestCaseNo2();
    }
    //C264
    @Test(priority = 6)
    public void S296_C32124_CU_007_VerifyCustomizationIsShowWhenTabOnCustomizeButtonOnBanner() {
        iOS_CustomizationPage.S296_C32124_CU_007_VerifyCustomizationIsShowWhenTabOnCustomizeButtonOnBanner();
    }

    //C266
    @Test(priority = 7)
    public void S296_C32127_CU_008_VerifyGeneralBannerFlow() {
        iOS_CustomizationPage.S296_C32127_CU_008_VerifyGeneralBannerFlow();
    }

    //C12493
    @Test(priority = 8)
    public void S296_C32115_CU_003_VerifyLogInSignUpDrawerDismissesWhenNotLoggedUserUnSelectAllTopic() {
        iOS_CustomizationPage.S296_C32115_CU_003_VerifyLogInSignUpDrawerDismissesWhenNotLoggedUserUnSelectAllTopic();
    }

    //C339
    @Test(priority = 9)
    public void S296_C32128_CU_009_VerifyMyNewsHeaderWhenCustomizeTopicOnCustomizationScreenFromOnBoarding() {
        iOS_CustomizationPage.S296_C32128_CU_009_VerifyMyNewsHeaderWhenCustomizeTopicOnCustomizationScreenFromOnBoarding();
    }

    //C340
    @Test(priority = 10)
    public void S296_C32129_CU_010_VerifyMyNewsHeaderWhenCustomizeTopicOnCustomizationScreenFromSettings() {
        iOS_CustomizationPage.S296_C32129_CU_010_VerifyMyNewsHeaderWhenCustomizeTopicOnCustomizationScreenFromSettings();
    }

    //C8778
    @Test(priority = 11)
    public void S296_C32130_CU_011_VerifyLogInScreenAppearsWhenTappingLogInButton() {
        iOS_CustomizationPage.S296_C32130_CU_011_VerifyLogInScreenAppearsWhenTappingLogInButton();
    }

    //C8779
    @Test(priority = 12)
    public void S296_C32131_CU_012_VerifySignUpScreenAppearsWhenTappingSignUpButton() {
        iOS_CustomizationPage.S296_C32131_CU_012_VerifySignUpScreenAppearsWhenTappingSignUpButton();
    }

    //C265
    @Test(priority = 13)
    public void S296_C32121_CU_006_VerifyBannerIsDismissedWhenTabOnCloseButtonOnBanner() {
        iOS_CustomizationPage.S296_C32121_CU_006_VerifyBannerIsDismissedWhenTabOnCloseButtonOnBanner();
    }

}

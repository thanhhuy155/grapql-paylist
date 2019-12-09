package tests;

import org.testng.annotations.Test;

public class TM_CustomizationPage extends BaseTestClass {
    //C234
    @Test(priority = 1)
    public void S295_C24353_CU_001_VerifyBannerDisplaysWhenReOpeningApp() {
        customizationPage.S295_C24353_CU_001_VerifyBannerDisplaysWhenReOpeningApp();
    }

    //C263
    @Test(priority = 2)
    public void S295_C263_CU_005_VerifyBannerDisplaysAtTheTopOfTheScreen() {
        customizationPage.S295_C263_CU_005_VerifyBannerDisplaysAtTheTopOfTheScreen();
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

    //C240
    @Test(priority = 5)
    public void S295_C240_CU_004_VerifyUsersCanNotFollowCategoryWithoutLogin() {
        customizationPage.S295_C240_CU_004_VerifyUsersCanNotFollowCategoryWithoutLogin();
    }

    //C264
    @Test(priority = 6)
    public void S295_C264_CU_007_VerifyCustomizationIsShowWhenTabOnCustomizeButtonOnBanner() {
        customizationPage.S295_C264_CU_007_VerifyCustomizationIsShowWhenTabOnCustomizeButtonOnBanner();
    }

    //C266
    @Test(priority = 7)
    public void S295_C266_CU_008_VerifyGeneralBannerFlow() {
        customizationPage.S295_C266_CU_008_VerifyGeneralBannerFlow();
    }

    //C339
    @Test(priority = 8)
    public void S295_C339_CU_009_VerifyMyNewsHeaderWhenCustomizeTopicOnCustomizationScreenFromOnBoarding() {
        customizationPage.S295_C339_CU_009_VerifyMyNewsHeaderWhenCustomizeTopicOnCustomizationScreenFromOnBoarding();
    }

    //C340
    @Test(priority = 9)
    public void S295_C340_CU_010_VerifyMyNewsHeaderWhenCustomizeTopicOnCustomizationScreenFromSettings() {
        customizationPage.S295_C340_CU_010_VerifyMyNewsHeaderWhenCustomizeTopicOnCustomizationScreenFromSettings();
    }

    //C8778
    @Test(priority = 10)
    public void S295_C8778_CU_011_VerifyLogInScreenAppearsWhenTappingLogInButton() {
        customizationPage.S295_C8778_CU_011_VerifyLogInScreenAppearsWhenTappingLogInButton();
    }

    //C8779
    @Test(priority = 11)
    public void S295_C8779_CU_012_VerifySignUpScreenAppearsWhenTappingSignUpButton() {
        customizationPage.S295_C8779_CU_012_VerifySignUpScreenAppearsWhenTappingSignUpButton();
    }

    //C265
    @Test(priority = 12)
    public void S295_C265_CU_006_VerifyBannerIsDismissedWhenTabOnCloseButtonOnBanner() {
        customizationPage.S295_C265_CU_006_VerifyBannerIsDismissedWhenTabOnCloseButtonOnBanner();
    }

}

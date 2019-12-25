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
    public void S295_C32114_CU_005_VerifyBannerDisplaysAtTheTopOfTheScreen() {
        customizationPage.S295_C32114_CU_005_VerifyBannerDisplaysAtTheTopOfTheScreen();
    }

    //C309
//    @Test(priority = 2)
    public void CustomizationTCNo2() {
        customizationPage.TestCaseNo2();
    }

    //C310
    @Test(priority = 3)
    public void S295_C24354_CU_002_VerifyBannerDisplaysAfterLoggingInAndReOpeningApp() {
        customizationPage.S295_C24354_CU_002_VerifyBannerDisplaysAfterLoggingInAndReOpeningApp();
    }

    //C12493
    @Test(priority = 4)
    public void S295_C32116_CU_003_VerifyLogInSignUpDrawerDismissesWhenNotLoggedUserUnSelectAllTopic() {
        customizationPage.S295_C32116_CU_003_VerifyLogInSignUpDrawerDismissesWhenNotLoggedUserUnSelectAllTopic();
    }

    //C240
    @Test(priority = 5)
    public void S295_C32123_CU_004_VerifyUsersCanNotFollowCategoryWithoutLogin() {
        customizationPage.S295_C32123_CU_004_VerifyUsersCanNotFollowCategoryWithoutLogin();
    }

    //C264
    @Test(priority = 6)
    public void S295_C32125_CU_007_VerifyCustomizationIsShowWhenTabOnCustomizeButtonOnBanner() {
        customizationPage.S295_C32125_CU_007_VerifyCustomizationIsShowWhenTabOnCustomizeButtonOnBanner();
    }

    //C266
    @Test(priority = 7)
    public void S295_C32126_CU_008_VerifyGeneralBannerFlow() {
        customizationPage.S295_C32126_CU_008_VerifyGeneralBannerFlow();
    }

    //C339
    @Test(priority = 8)
    public void S295_C32132_CU_009_VerifyMyNewsHeaderWhenCustomizeTopicOnCustomizationScreenFromOnBoarding() {
        customizationPage.S295_C32132_CU_009_VerifyMyNewsHeaderWhenCustomizeTopicOnCustomizationScreenFromOnBoarding();
    }

    //C340
    @Test(priority = 9)
    public void S295_C32133_CU_010_VerifyMyNewsHeaderWhenCustomizeTopicOnCustomizationScreenFromSettings() {
        customizationPage.S295_C32133_CU_010_VerifyMyNewsHeaderWhenCustomizeTopicOnCustomizationScreenFromSettings();
    }

    //C8778
    @Test(priority = 10)
    public void S295_C32134_CU_011_VerifyLogInScreenAppearsWhenTappingLogInButton() {
        customizationPage.S295_C32134_CU_011_VerifyLogInScreenAppearsWhenTappingLogInButton();
    }

    //C8779
    @Test(priority = 11)
    public void S295_C32135_CU_012_VerifySignUpScreenAppearsWhenTappingSignUpButton() {
        customizationPage.S295_C32135_CU_012_VerifySignUpScreenAppearsWhenTappingSignUpButton();
    }

    //C265
    @Test(priority = 12)
    public void S295_C32122_CU_006_VerifyBannerIsDismissedWhenTabOnCloseButtonOnBanner() {
        customizationPage.S295_C32122_CU_006_VerifyBannerIsDismissedWhenTabOnCloseButtonOnBanner();
    }

    //C35420
    @Test(priority = 13)
    public void S295_C35420_CU_015_VerifyDiscardPopUpShowWhenCloseCustomizeWithChanges() {
        customizationPage.S295_C35420_CU_015_VerifyDiscardPopUpShowWhenCloseCustomizeWithChanges();
    }

    //C35421
    @Test(priority = 14)
    public void S295_C35421_CU_016_VerifyCustomizationKeepChangesWhenClickCancelCloseButton() {
        customizationPage.S295_C35421_CU_016_VerifyCustomizationKeepChangesWhenClickCancelCloseButton();
    }

    //C35422
    @Test(priority = 15)
    public void S295_C35422_CU_017_CU_017_DiscardChangesWhenClosingCustomizationScreenWithChanges() {
        customizationPage.S295_C35422_CU_017_CU_017_DiscardChangesWhenClosingCustomizationScreenWithChanges();
    }

    //C35419
    @Test(priority = 16)
    public void S295_C35419_CU_014_VerifyTheNewSetOfTopicsWillOverwriteTheirCustomizedTopics() {
        customizationPage.S295_C35419_CU_014_VerifyTheNewSetOfTopicsWillOverwriteTheirCustomizedTopics();
    }

    //C35418
    @Test(priority = 17)
    public void S295_C35418_CU_013_VerifyUserAbleContinueCustomizationOnboardFlowAfterLogIn() {
        customizationPage.S295_C35418_CU_013_VerifyUserAbleContinueCustomizationOnboardFlowAfterLogIn();
    }
}

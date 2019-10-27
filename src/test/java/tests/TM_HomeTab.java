package tests;

import org.testng.annotations.Test;

public class TM_HomeTab extends BaseTestClass {
    @Test(priority = 1)
    //Note: Implemented for both iOS and Android
    public void S203_C18616_HT_TC_001_VerifyTopCaroulselArticle() {
        homeTab.S203_C20164_HT_HF_001_VerifyHomeFeedArticleClick();
    }

    @Test(priority =2 )
    //Note: Implemented for both iOS and Android
    public void S203_C20164_HT_HF_001_VerifyHomeFeedArticleClick() {
        homeTab.S203_C20164_HT_HF_001_VerifyHomeFeedArticleClick();
    }

//    @Test(priority = 3)
//    //Note: Unable to implement on iOS since Appium cannot catch system element on Share pop-up
//    public void HomeTabTCNo8() {
//        homeTab.TestCaseNo8();
//    }
}

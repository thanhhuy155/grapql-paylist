package tests;

import org.testng.annotations.Test;

public class TM_iOSHomeTab extends BaseTestClass {
    @Test(priority = 1)
    //Note: Implemented for both iOS and Android
    public void S240_C20266_HT_TC_001_VerifyTopCarouselArticle() {
        iOS_HomeTab.S240_C20266_HT_TC_001_VerifyTopCarouselArticle();
    }

    @Test(priority =2 )
    //Note: Implemented for both iOS and Android
    public void S240_C20267_HT_HF_001_VerifyHomeFeedArticleClick() {
        iOS_HomeTab.S240_C20267_HT_HF_001_VerifyHomeFeedArticleClick();
    }
}

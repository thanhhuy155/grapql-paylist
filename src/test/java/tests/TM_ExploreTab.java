package tests;

import org.testng.annotations.Test;

public class TM_ExploreTab extends BaseTestClass {

    @Test(priority = 1 )
    //Note: Implemented for both iOS and Android
    public void S230_C22262_ET_001_01_VerifyNewsSections() {
        exploreTab.S230_C22262_ET_001_01_VerifyNewsSections();
    }

    @Test(priority = 2 )
    //Note: Implemented for both iOS and Android
    public void S230_C22263_ET_001_02_VerifySportsSections() {
        exploreTab.S230_C22263_ET_001_02_VerifySportsSections();
    }

    @Test(priority = 3 )
    //Note: Implemented for both iOS and Android
    public void S230_C22264_ET_001_03_VerifyBusinessSections() {
        exploreTab.S230_C22264_ET_001_03_VerifyBusinessSections();
    }

    @Test(priority = 4 )
    //Note: Implemented for both iOS and Android
    public void S230_C22265_ET_001_04_VerifyOpinionSections() {
        exploreTab.S230_C22265_ET_001_04_VerifyOpinionSections();
    }

    @Test(priority = 5 )
    //Note: Implemented for both iOS and Android
    public void S230_C22266_ET_001_05_VerifyPoliticsSections() {
        exploreTab.S230_C22266_ET_001_05_VerifyPoliticsSections();
    }

    @Test(priority = 6 )
    //Note: Implemented for both iOS and Android
    public void S230_C22267_ET_001_06_VerifyEntertainmentsSections() {
        exploreTab.S230_C22267_ET_001_06_VerifyEntertainmentsSections();
    }

    @Test(priority = 7 )
    //Note: Implemented for both iOS and Android
    public void S230_C22268_ET_001_07_VerifyFoodSections() {
        exploreTab.S230_C22268_ET_001_07_VerifyFoodSections();
    }

    @Test(priority = 8 )
    //Note: Implemented for both iOS and Android
    public void S230_C22269_ET_001_08_VerifyHealthAndWellnessSections() {
        exploreTab.S230_C22269_ET_001_08_VerifyHealthAndWellnessSections();
    }

    @Test(priority = 9 )
    //Note: Implemented for both iOS and Android
    public void S230_C22270_ET_001_09_VerifyRealEstateSections() {
        exploreTab.S230_C22270_ET_001_09_VerifyRealEstateSections();
    }

    @Test(priority = 10 )
    //Note: Implemented for both iOS and Android
    public void S230_C22271_ET_001_10_VerifyObituariesSections() {
        exploreTab.S230_C22271_ET_001_10_VerifyObituariesSections();
    }

    @Test(priority = 11 )
    //Note: Implemented for both iOS and Android
    public void S230_C22272_ET_001_11_VerifyJobsSections() {
        exploreTab.S230_C22272_ET_001_11_VerifyJobsSections();
    }

    @Test(priority = 12 )
    //Note: Implemented for both iOS and Android
    public void S230_C22273_ET_001_12_VerifyLifeSections() {
        exploreTab.S230_C22273_ET_001_12_VerifyLifeSections();
    }

    @Test(priority = 13)
    //Note: Implemented for both iOS and Android
    public void S230_C22274_ET_002_VerifyExploreTabReturnAfterSleeping() {
        exploreTab.S230_C22274_ET_002_VerifyExploreTabReturnAfterSleeping();
    }

    @Test(priority = 14 )
    //Note: Implemented for both iOS and Android
    public void S230_C22275_ET_003_VerifyArticlePageWhenClickingFeedArticle() {
        exploreTab.S230_C22275_ET_003_VerifyArticlePageWhenClickingFeedArticle();
    }

    //@Test(priority = 15 )
    //Disable running this test due to problem communicating with Google Servers
    //Note: Unable to implement on iOS since Appium cannot catch system element on share pop-up
    public void S230_C22276_ET_004_VerifyArticlePageWhenSharingFeedArticle() {
        exploreTab.S230_C22276_ET_004_VerifyArticlePageWhenSharingFeedArticle();
    }
    @Test(priority = 16 )
    //Note: Implemented for both iOS and Android
    public void S230_C22277_ET_005_VerifyArticlePageWhenSwitchingFeedArticle() {
        exploreTab.S230_C22277_ET_005_VerifyArticlePageWhenSwitchingFeedArticle();
    }

    @Test(priority = 17 )
    //Note: As current researching, Unable to automatically lock and unlock iOS device from iOS 10.
    public void S230_C22278_ET_006_VerifyArticlePageWhenSleepingFeedArticle() {
        exploreTab.S230_C22278_ET_006_VerifyArticlePageWhenSleepingFeedArticle();
    }

    @Test(priority = 18 )
    public void S230_C24249_ET_007_VerifyMyMostReadSections() {
        exploreTab.S230_C24249_ET_007_VerifyMyMostReadSections();
    }
}

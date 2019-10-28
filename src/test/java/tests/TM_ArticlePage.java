package tests;

import org.testng.annotations.Test;

public class TM_ArticlePage extends BaseTestClass {
    @Test(priority = 1)
    public void S232_C20434_ART_001_VerifyArticleDisplay() {
        articlePage.S232_C20434_ART_001_VerifyArticleDisplay();
    }

    @Test(priority = 2)
    public void S232_C20435_ART_002_VerifyArticleRecirculation(){
        articlePage.S232_C20435_ART_002_VerifyArticleRecirculation();
    }

    @Test(priority = 3)
    public void S232_C20436_ART_003_VerifyArticleFeedShare() {
        articlePage.S232_C20436_ART_003_VerifyArticleFeedShare();
    }

    @Test(priority = 4)
    public void S232_C20437_ART_004_VerifyArticleFeedReturnFromSleep(){
        articlePage.S232_C20437_ART_004_VerifyArticleFeedReturnFromSleep();
    }



}

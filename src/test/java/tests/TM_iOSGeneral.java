package tests;

import org.testng.annotations.Test;

public class TM_iOSGeneral extends BaseTestClass {
    @Test(priority = 1)
    //Note: Implemented for both iOS and Android
    public void S239_C20265_GN_ART_001_VerifyAppWorksFineWhenClickingOnArticle() {
        iOS_General.S239_C20265_GN_ART_001_VerifyAppWorksFineWhenClickingOnArticle();
    }
}

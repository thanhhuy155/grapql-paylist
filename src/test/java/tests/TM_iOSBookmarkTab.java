package tests;

import org.testng.annotations.Test;

public class TM_iOSBookmarkTab extends BaseTestClass {

    @Test(priority = 1)
    //Note: Implemented for both iOS and Android
    public void S231_C20441_BT_001_VerifyBookMarkTabArticle() {
        iOS_BookmarkTab.S231_C20441_BT_001_VerifyBookMarkTabArticle();
    }

    @Test(priority = 2)
    public void S231_C20442_BT_002_VerifyBookMarkCancel() {
        iOS_BookmarkTab.S231_C20442_BT_002_VerifyBookMarkCancel();
    }

    @Test(priority = 4)
    //Note: Implemented for both iOS and Android
    public void S231_C20443_BT_003_VerifyEditAndDeleteBookMark(){
        iOS_BookmarkTab.S231_C20443_BT_003_VerifyEditAndDeleteBookMark();
    }

    @Test(priority = 5)
    //Note: Implemented for both iOS and Android
    public void S231_C20444_BT_004_VerifyBookMarkArticleFeed() {
        iOS_BookmarkTab.S231_C20444_BT_004_VerifyBookMarkArticleFeed();
    }

}

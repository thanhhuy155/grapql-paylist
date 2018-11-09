package tests;

import org.testng.annotations.Test;

public class TM_BookmarkTab extends BaseTestClass {

    @Test(priority = 1)
    //Note: Implemented for both iOS and Android
    public void BookMarkTCNo2() {
        bookmarkTab.TestCaseNo2();
    }

    @Test(priority = 2)
    //Note: As current researching, Unable to automatically lock and unlock iOS device from iOS 10.
    public void BookMarkTCNo3() {
        bookmarkTab.TestCaseNo3();
    }

    @Test(priority = 3)
    //Note: Implemented for both iOS and Android
    public void BookMarkTCNo11() {
        bookmarkTab.TestCaseNo11();
    }

    @Test(priority = 4)
    //Note: Implemented for both iOS and Android
    public void BookMarkTCNo12(){
        bookmarkTab.TestCaseNo12();
    }

    @Test(priority = 5)
    //Note: Implemented for both iOS and Android
    public void BookMarkTCNo14() {
        bookmarkTab.TestCaseNo14();
    }

    @Test(priority = 6)
    //Note: Unable to implement on iOS since Appium cannot catch system elements on Share pop-up
    public void BookMarkTCNo16(){
        bookmarkTab.TestCaseNo16();
    }
}

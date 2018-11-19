package tests;

import org.testng.annotations.Test;

public class TM_ArticlePage extends BaseTestClass {
    @Test(priority = 1)
    //Note: Implemented for both iOS and Android
    public void ArticleTCNo1() {
        articlePage.TestCaseNo1();
    }

    @Test(priority = 2)
    //Note: Unable to implement on iOS since Appium cannot catch system element on Share pop-up.
    public void ArticleTCNo4() {
        articlePage.TestCaseNo4();
    }

    @Test(priority = 3)
    //Note: As current researching, Unable to automatically lock and unlock iOS device from iOS 10.
    public void ArticleTCNo5(){
        articlePage.TestCaseNo5();
    }

    @Test(priority = 4)
    //Note: Recirculation Module is not a feature on iOS.
    public void ArticleTCNo30(){
        articlePage.TestCaseNo30();
    }

}

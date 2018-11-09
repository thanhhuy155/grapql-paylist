package tests;

import org.testng.annotations.Test;

public class TM_SectionTab extends BaseTestClass {

    @Test(priority =1 )
    //Note: Implemented for both iOS and Android
    public void SectionTabTCNo2() {
        sectionTab.TestCaseNo2();
    }

    @Test(priority = 2)
    //Note: As current researching, Unable to automatically lock and unlock iOS device from iOS 10.
    public void SectionTabTCNo3() {
        sectionTab.TestCaseNo3();
    }

    @Test(priority =3 )
    //Note: Implemented for both iOS and Android
    public void SectionTabTCNo4() {
        sectionTab.TestCaseNo4();
    }

    @Test(priority = 4)
    //Note: Implemented for both iOS and Android
    public void SectionTabTCNo6() {
        sectionTab.TestCaseNo6();
    }

    @Test(priority = 5)
    //Note: Unable to implement on iOS since Appium cannot catch system element on share pop-up
    public void SectionTabTCNo8() {
        sectionTab.TestCaseNo8();
    }

    @Test(priority = 6)
    //Note: Implemented for both iOS and Android
    public void SectionTabTCNo11() {
        sectionTab.TestCaseNo11();
    }

    @Test(priority = 7)
    //Note: As current researching, Unable to automatically lock and unlock iOS device from iOS 10.
    public void SectionTabTCNo12() {
        sectionTab.TestCaseNo12();
    }
}

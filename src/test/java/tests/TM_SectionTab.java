package tests;

import org.testng.annotations.Test;

public class TM_SectionTab extends BaseTestClass {

    @Test
    //Note: Implemented for both iOS and Android
    public void SectionTabTCNo2() {
        sectionTab.TestCaseNo2();
    }

    @Test
    //Note: As current researching, Unable to automatically lock and unlock iOS device from iOS 9.
    public void SectionTabTCNo3() {
        sectionTab.TestCaseNo3();
    }

    @Test
    //Note: Implemented for both iOS and Android
    public void SectionTabTCNo4() {
        sectionTab.TestCaseNo4();
    }

    @Test
    //Note: Implemented for both iOS and Android
    public void SectionTabTCNo6() {
        sectionTab.TestCaseNo6();
    }

    @Test
    //Note: Unable to implement on iOS since Appium cannot catch system element on share pop-up
    public void SectionTabTCNo8() {
        sectionTab.TestCaseNo8();
    }

    @Test
    //Note: Implemented for both iOS and Android
    public void SectionTabTCNo11() {
        sectionTab.TestCaseNo11();
    }

    @Test
    //Note: As current researching, Unable to automatically lock and unlock iOS device from iOS 9.
    public void SectionTabTCNo12() {
        sectionTab.TestCaseNo12();
    }
}

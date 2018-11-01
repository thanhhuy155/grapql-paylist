package tests;

import org.testng.annotations.Test;

public class TM_HomeTab extends BaseTestClass {
    @Test
    public void HomeTabTCNo2() {
        homeTab.TestCaseNo2();
    }

    @Test
    public void HomeTabTCNo6() {
        homeTab.TestCaseNo6();
    }

    //Note: Unable to implement on iOS since Appium cannot catch system element on share pop-up
    @Test
    public void HomeTabTCNo8() {
        homeTab.TestCaseNo8();
    }
}

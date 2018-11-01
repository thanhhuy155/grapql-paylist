package tests;

import org.testng.annotations.Test;

public class TM_HomeTab extends BaseTestClass {
    @Test(priority = 1)
    public void HomeTabTCNo2() {
        homeTab.TestCaseNo2();
    }

    @Test(priority =2 )
    public void HomeTabTCNo6() {
        homeTab.TestCaseNo6();
    }

    @Test(priority = 3)
    //Note: Unable to implement on iOS since Appium cannot catch system element on share pop-up
    public void HomeTabTCNo8() {
        homeTab.TestCaseNo8();
    }
}

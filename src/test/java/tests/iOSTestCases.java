package tests;

import org.testng.annotations.Test;

public class iOSTestCases extends BaseTestClass {
    // ============== HOME TAB ============== //
    @Test
    public void HomeTabTCNo2() {
        homeTab.TestCaseNo2();
    }

    @Test
    public void HomeTabTCNo6() {
        homeTab.TestCaseNo6();
    }

    // ============== SECTION TAB ============== //
    @Test
    public void SectionTabTCNo4() {
        sectionTab.TestCaseNo4();
    }

    @Test
    public void SectionTabTCNo6() {
        sectionTab.TestCaseNo6();
    }

    @Test
    public void SectionTabTCNo11() {
        sectionTab.TestCaseNo11();
    }

    // ============== SETTING TAB ============== //
    @Test
    public void SettingTabTCNo1() {
        // check xpath notification setting
        settingTab.TestCaseNo1();
    }

    @Test
    public void SettingTabTCNo4() {
        settingTab.TestCaseNo4();
    }

    @Test
    public void SettingTabTCNo5() {
        settingTab.TestCaseNo5();
    }

    // ============== BOOKMARK TAB ============== //
    @Test
    public void BookMarkTCNo1() {
        bookmarkTab.TestCaseNo2();
    }

    @Test
    public void BookMarkTCNo14() {
        bookmarkTab.TestCaseNo14();
    }

    // ============== ARTICLE PAGE ============== //
    @Test
    public void ArticleTCNo1() {
        articlePage.TestCaseNo1();
    }
}

package tests;

import org.testng.annotations.Test;

public class TM_SettingTab extends BaseTestClass {

    @Test(priority = 1)
    //Note: Implemented for both iOS and Android
    public  void S229_C20176_ST_001_VerifyNotificationsOnOffWorksWell(){
        settingTab.S229_C20176_ST_001_VerifyNotificationsOnOffWorksWell();
    }

//    @Test(priority = 2)
//    //Note: Cannot create email on iOS device because cannot sign in to iPhone on BrowserStack/Simulator
//    //Can only be tested on real device at ourselves.
//    public void SettingTCNo3(){settingTab.TestCaseNo3();}

    @Test(priority = 3)
    //Note: Implemented for both iOS and Android
    public  void S229_C20177_ST_002_VerifyMenuAboutDisplayWhenClickingAbout(){
        settingTab.S229_C20177_ST_002_VerifyMenuAboutDisplayWhenClickingAbout();
    }

    @Test(priority = 4)
    //Note: Implemented for both iOS and Android
    public  void S229_C20178_ST_003_VerifyAppsAppearsWhenClickMoreApss(){
        settingTab.S229_C20178_ST_003_VerifyAppsAppearsWhenClickMoreApss();
    }

    @Test(priority = 5)
    //Note: Implemented for both iOS and Android
    public void S229_C20179_ST_004_VerifyInquirerAppVersion(){
        settingTab.S229_C20179_ST_004_VerifyInquirerAppVersion();
    }

    @Test(priority = 6)
    //Note: Implemented for both iOS and Android
    public void S229_C20180_ST_005_VerifyInquirerCopyright(){
        settingTab.S229_C20180_ST_005_VerifyInquirerCopyright();
    }
}

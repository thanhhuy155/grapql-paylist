package tests;

import org.testng.annotations.Test;

public class TM_iOSSettingTab extends BaseTestClass {
    @Test(priority = 1)
    //Note: Implemented for both iOS and Android
    public  void S241_C20268_ST_002_VerifyMenuAboutDisplayWhenClickingAbout(){
        iOS_SettingTab.S241_C20268_ST_002_VerifyMenuAboutDisplayWhenClickingAbout();
    }

    @Test(priority = 2)
    //Note: Implemented for both iOS and Android
    public  void S241_C20269_ST_003_VerifyAppsAppearsWhenClickMoreApss(){
        iOS_SettingTab.S241_C20269_ST_003_VerifyAppsAppearsWhenClickMoreApss();
    }

    @Test(priority = 3)
    //Note: Implemented for both iOS and Android
    public void S241_C20270_ST_004_VerifyInquirerAppVersion(){
        iOS_SettingTab.S241_C20270_ST_004_VerifyInquirerAppVersion();
    }

    @Test(priority = 4)
    //Note: Implemented for both iOS and Android
    public void S241_C20271_ST_005_VerifyInquirerCopyright(){
        iOS_SettingTab.S241_C20271_ST_005_VerifyInquirerCopyright();
    }
}

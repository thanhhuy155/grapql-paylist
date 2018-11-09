package tests;

import org.testng.annotations.Test;

public class TM_SettingTab extends BaseTestClass {

    @Test(priority = 1)
    //Note: Implemented for both iOS and Android
    public  void SettingTCNo1(){
        settingTab.TestCaseNo1();
    }

    @Test(priority = 2)
    //Note: Cannot create email on iOS device because cannot sign in to iPhone on BrowserStack/Simulator
    //Can only be tested on real device at ourselves.
    public void SettingTCNo3(){settingTab.TestCaseNo3();}

    @Test(priority = 3)
    //Note: Implemented for both iOS and Android
    public  void SettingTCNo4(){
        settingTab.TestCaseNo4();
    }

    @Test(priority = 4)
    //Note: Implemented for both iOS and Android
    public  void SettingTCNo5(){
        settingTab.TestCaseNo5();
    }

    @Test(priority = 5)
    //Note: Implemented for both iOS and Android
    public void SettingTCNo6(){
        settingTab.TestCaseNo6();
    }

    @Test(priority = 6)
    //Note: Implemented for both iOS and Android
    public void SettingTCNo7(){
        settingTab.TestCaseNo7();
    }
}

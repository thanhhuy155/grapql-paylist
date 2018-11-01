package tests;

import org.testng.annotations.Test;

public class TM_SettingTab extends BaseTestClass {

    @Test(priority = 1)
    //Note: Implemented for both iOS and Android
    public  void SettingTCNo1(){
        settingTab.TestCaseNo1();
    }

    @Test(priority = 2)
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
    public void SettingTCNo6(){
        settingTab.TestCaseNo6();
    }

    @Test(priority = 6)
    public void SettingTCNo7(){
        settingTab.TestCaseNo7();
    }
}

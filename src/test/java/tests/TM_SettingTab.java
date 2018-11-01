package tests;

import org.testng.annotations.Test;

public class TM_SettingTab extends BaseTestClass {

    @Test
    //Note: Implemented for both iOS and Android
    public  void SettingTCNo1(){
        settingTab.TestCaseNo1();
    }

    @Test
    public void SettingTCNo3(){settingTab.TestCaseNo3();}

    @Test
    //Note: Implemented for both iOS and Android
    public  void SettingTCNo4(){
        settingTab.TestCaseNo4();
    }

    @Test
    //Note: Implemented for both iOS and Android
    public  void SettingTCNo5(){
        settingTab.TestCaseNo5();
    }

    @Test
    public void SettingTCNo6(){
        settingTab.TestCaseNo6();
    }

    @Test
    public void SettingTCNo7(){
        settingTab.TestCaseNo7();
    }
}

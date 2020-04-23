package tests;

import org.testng.annotations.Test;

public class TM_iOSSearchTab extends BaseTestClass {
    @Test(priority = 1)
    public  void S233_C20428_SET_001_VerifyLoadSearchScreen(){
        iOS_SearchTab.S233_C20428_SET_001_VerifyLoadSearchScreen();
    }
//    @Test(priority = 2)
//    public  void S233_C20429_SET_002_VerifyQuickSearch(){
//
//        iOS_SearchTab.S233_C20429_SET_002_VerifyQuickSearch();
//    }

    @Test(priority = 3)
    public void S233_C20430_SET_003_VerifyAutoSuggestSearch(){
        iOS_SearchTab.S233_C20430_SET_003_VerifyAutoSuggestSearch();
    }
    @Test(priority = 4)
    public void S233_C20431_SET_004_VerifySearchByTyping(){
        iOS_SearchTab.S233_C20431_SET_004_VerifySearchByTyping();
    }
}

package tests;

import org.testng.annotations.Test;

public class TM_SearchTab extends BaseTestClass {
    @Test(priority = 1)
    public  void SearchTabTCNo1(){
        searchTab.TestCaseNo1();
    }
    @Test(priority = 2)
    public  void SearchTabTCNo2(){
        searchTab.TestCaseNo2();
    }
    @Test(priority = 3)
    public void SearchTabTCNo4(){
        searchTab.TestCaseNo4();
    }
    @Test(priority = 4)
    public void SearchTabTCNo5(){
        searchTab.TestCaseNo5();
    }
}

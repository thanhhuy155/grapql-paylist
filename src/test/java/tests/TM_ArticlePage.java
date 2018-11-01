package tests;

import org.testng.annotations.Test;

public class TM_ArticlePage extends BaseTestClass {
    @Test(priority = 1)
    public void ArticleTCNo1() {
        articlePage.TestCaseNo1();
    }

    @Test(priority = 2)
    public void ArticleTCNo5() {
        articlePage.TestCaseNo5();
    }

    @Test(priority = 3)
    public void ArticleTCNo4(){
        articlePage.TestCaseNo4();
    }

    @Test(priority = 4)
    public void ArticleTCNo30(){
        articlePage.TestCaseNo30();
    }

}

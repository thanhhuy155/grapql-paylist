package tests;

import org.testng.annotations.Test;

public class TM_iOSCustomizationPage extends BaseTestClass {
    //C234
    @Test(priority = 1)
    public void CustomizationTCNo1() {
        iOS_CustomizationPage.TestCaseNo1();
    }

    //C309
//    @Test(priority = 2)
    public void CustomizationTCNo2() {
        iOS_CustomizationPage.TestCaseNo2();
    }

    //C310
    @Test(priority = 3)
    public void CustomizationTCNo3() {
        iOS_CustomizationPage.TestCaseNo3();
    }

}

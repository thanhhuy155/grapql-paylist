package tests;

import org.testng.annotations.Test;

public class TM_GeneralTest extends BaseTestClass {
    @Test(priority = 1)
    //Note: As current researching, Unable to automatically lock and unlock iOS device from iOS 10.
    public void GeneralTCNo1() {
        generalTest.TestCaseNo1();
    }

    @Test(priority = 2)
    //Note: As current researching, Unable to automatically lock and unlock iOS device from iOS 10.
    public void GeneralTCNo2() {
        generalTest.TestCaseNo2();
    }

    @Test(priority =3 )
    //Note: As current researching, Unable to automatically lock and unlock iOS device from iOS 10.
    public void GeneralTCNo3() {
        generalTest.TestCaseNo3();
    }

    @Test(priority = 4)
    //Note: As current researching, Unable to automatically lock and unlock iOS device from iOS 10.
    public void GeneralTCNo4() {
        generalTest.TestCaseNo4();
    }

    @Test(priority = 5)
    //Note: As current researching, Unable to automatically lock and unlock iOS device from iOS 10.
    public void GeneralTCNo7() {
        generalTest.TestCaseNo7();
    }

    @Test(priority = 6)
    //Note: Implemented for both iOS and Android
    public void GeneralTCNo11() {
        generalTest.TestCaseNo11();
    }
}

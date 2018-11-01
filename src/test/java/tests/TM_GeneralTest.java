package tests;

import org.testng.annotations.Test;

public class TM_GeneralTest extends BaseTestClass {
    @Test
    //Note: As current researching, Unable to automatically lock and unlock iOS device from iOS 9.
    public void GeneralTCNo1() {
        generalTest.TestCaseNo1();
    }

    @Test
    //Note: As current researching, Unable to automatically lock and unlock iOS device from iOS 9.
    public void GeneralTCNo2() {
        generalTest.TestCaseNo2();
    }

    @Test
    //Note: As current researching, Unable to automatically lock and unlock iOS device from iOS 9.
    public void GeneralTCNo3() {
        generalTest.TestCaseNo3();
    }

    @Test
    //Note: As current researching, Unable to automatically lock and unlock iOS device from iOS 9.
    public void GeneralTCNo4() {
        generalTest.TestCaseNo4();
    }

    @Test
    //Note: As current researching, Unable to automatically lock and unlock iOS device from iOS 9.
    public void GeneralTCNo7() {
        generalTest.TestCaseNo7();
    }

    @Test
    //Note: Implemented for both iOS and Android
    public void GeneralTCNo11() {
        generalTest.TestCaseNo11();
    }
}

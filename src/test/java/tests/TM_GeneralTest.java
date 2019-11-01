package tests;

import org.testng.annotations.Test;

public class TM_GeneralTest extends BaseTestClass {
   // @Test(priority = 1) // Disable running on BrowserStack
    //Note: As current researching, Unable to automatically lock and unlock iOS device from iOS 10.
    public void S228_C20166_GN_LA_001_VerifyAppBeAbleToLaunchOnCellConnection() {
        generalTest.S228_C20166_GN_LA_001_VerifyAppBeAbleToLaunchOnCellConnection();
    }

  //  @Test(priority = 2) // Disable running on BrowserStack
    //Note: As current researching, Unable to automatically lock and unlock iOS device from iOS 10.
    public void S228_C20167_GN_LA_002_VerifyAppBeAbleToLaunchWithoutConnectivity() {
        generalTest.S228_C20167_GN_LA_002_VerifyAppBeAbleToLaunchWithoutConnectivity();
    }

   // @Test(priority =3 ) // Disable running on BrowserStack
    //Note: As current researching, Unable to automatically lock and unlock iOS device from iOS 10.
    public void S228_C20168_GN_LA_003_VerifyAppBeAbleToLaunchWithoutConnectivityAndNoCache() {
        generalTest.S228_C20168_GN_LA_003_VerifyAppBeAbleToLaunchWithoutConnectivityAndNoCache();
    }

    @Test(priority = 4)
    //Note: As current researching, Unable to automatically lock and unlock iOS device from iOS 10.
    public void S228_C20169_GN_LA_004_VerifyAppBeAbleToLaunchOnWifi() {
        generalTest.S228_C20169_GN_LA_004_VerifyAppBeAbleToLaunchOnWifi();
    }

    @Test(priority = 5)
    //Note: As current researching, Unable to automatically lock and unlock iOS device from iOS 10.
    public void S228_C20170_GN_LA_005_VerifyAppBeAbleToLOpenViaComingOutOfSleepMode() {
        generalTest.S228_C20170_GN_LA_005_VerifyAppBeAbleToLOpenViaComingOutOfSleepMode();
    }

    @Test(priority = 6)
    //Note: Implemented for both iOS and Android
    public void S228_C20171_GN_ART_001_VerifyAppWorksFineWhenClickingOnArticle() {
        generalTest._VerifyAppWorksFineWhenClickingOnArticle();
    }
}

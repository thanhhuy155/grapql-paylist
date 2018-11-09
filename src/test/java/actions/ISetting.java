package actions;

public interface ISetting {
    void notificationClick();

    void notificationSettingClick();

    void allowNotificationClick();

    void backToPhillyApp();

    void aboutClick();

    void moreAppsFromPMNClick();

    void assertSettingResult(String expectedResult, String actualResult);

    void assertResult(String expectedResult, String actualResult);

    void checkAppVersion(String androidVersion, String iOSVersion);

    void checkAppCopyright(String copyrightText);

    String getNotificationSettingTitle();

    String getAboutPMNTitle();

    String getPrivacyPolicyTitle();

    String getTermsofUseTitle();

    String getPhiladelphiaInquirerTitle();

    String getPhillySportsNewsTitle();

    String getPhiladelphiaInquirerReplicaTitle();

    String getPhiladelphiaInquirerReplicaNJEditionTitle();

    String getPhiladelphiaDailyNewsReplicaTitle();

    String getAppVersion();
}

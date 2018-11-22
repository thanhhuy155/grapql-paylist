package actions;

import elements.CommonElements;
import io.appium.java_client.AppiumDriver;

public interface ICommon {
    void selectGmail(AppiumDriver appiumDriver,String username, String password);

    void assertTitleResult(String expected, String actual);

    void clickLogin();

//    void gmailShareBoxClick();

    void homeTabClick();

    void sectionTabClick();

    void searchTabClick();

    void bookMarkTabClick(AppiumDriver appiumDriver);

    void settingTabClick();

    void shareArticleOn(AppiumDriver appiumDriver, CommonElements.ShareOptions option);

    void signInToGoogleAccount(AppiumDriver appiumDriver, String username, String password);

    void addAccountToGmail(AppiumDriver appiumDriver, String username, String password);

    String getShareGmailTitle();
}

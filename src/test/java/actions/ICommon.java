package actions;

import elements.CommonElements;
import io.appium.java_client.AppiumDriver;

public interface ICommon {
    void selectGmail(String username, String password);

    void assertTitleResult(String expected, String actual);

    void clickLogin();

//    void gmailShareBoxClick();

    void homeTabClick();

    void sectionTabClick();

    void searchTabClick();

    void bookMarkTabClick();

    void settingTabClick();

    void shareArticleOn(AppiumDriver appiumDriver, CommonElements.ShareOptions option);

    void signInToGoogleAccount(String username, String password);

    void addAccountToGmail(String username, String password);

    String getShareGmailTitle();
}

package actions;

public interface ICommon {
    void selectShareGmailItemClick();

    void assertTitleResult(String expected, String actual);

    void clickLogin();

    void buttonShareClick();

    void buttonBookmarkClick();

    void gmailShareBoxClick();

    void homeTabClick();

    void sectionTabClick();

    void searchTabClick();

    void bookMarkTabClick();

    void settingTabClick();

    String getShareGmailTitle();
}

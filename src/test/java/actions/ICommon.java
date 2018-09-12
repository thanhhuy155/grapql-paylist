package actions;

public interface ICommon {
    void selectShareGmailItemClick();

    void assertTitleResult(String expected, String actual);

    void clickLogin();

    void buttonShareClick();

    void buttonBookmarkClick();

    void gmailShareBoxClick();

    String getShareGmailTitle();
}

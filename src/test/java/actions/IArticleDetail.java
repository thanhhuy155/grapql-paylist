package actions;

public interface IArticleDetail {
    void bookmarkClick();

    void assertTitleResult(String titleExpected, String titleActual);

    void back();

    String getTitleArticleDetail();
}

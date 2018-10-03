package actions;

public interface IBookMark {
    void bookMarkItemClick();

    void assertTitleResult(String titleExpected, String titleActual);

    void actionEditClick();

    void bookmarkCheckboxClick();

    void back();

    String getBookMarkTitle();

    String clickAndGetArticleTitle();


}

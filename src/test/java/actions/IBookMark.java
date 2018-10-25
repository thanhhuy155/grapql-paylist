package actions;

import java.util.List;

public interface IBookMark {
    void bookMarkItemClick();

    void assertTitleResult(String titleExpected, String titleActual);

    void actionEditClick();

    void bookmarkCheckboxClick();

    void back();

    void selectBookmarkedArticle(int numberOfArticle);

    String getBookMarkTitle();

    String clickAndGetArticleTitle();

    List<String> getBookmarkedTitles();


}

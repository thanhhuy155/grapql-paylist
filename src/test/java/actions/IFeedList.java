package actions;

public interface IFeedList {
    String getFeedItemTitle();

    String getFeedItemTopStoryTitle();

    String getArticleAuthorOnFeedList();

    String getArticleDateOnFeedList();

    void bookmarkArticle();

    void feedItemClick();

    void feedItemTopStoryClick();

    void assetResult(String expected, String actual);

    void buttonShareClick();

    void buttonBookmarkClick();

}

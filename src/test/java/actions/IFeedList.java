package actions;

public interface IFeedList {
    String getFeedItemTitle();

    String getFeedItemTopStoryTitle();

    String getArticleAuthorOnFeedList();

    String getArticleDateOnFeedList();

    void feedItemClick();

    void feedItemTopStoryClick();

    void assetResult(String expected, String actual);
}

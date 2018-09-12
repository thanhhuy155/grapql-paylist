package actions;

public interface IFeedList {
    String getFeedItemTitle();

    String getFeedItemTopStoryTitle();

    void feedItemClick();

    void feedItemTopStoryClick();

    void assetResult(String expected, String actual);
}

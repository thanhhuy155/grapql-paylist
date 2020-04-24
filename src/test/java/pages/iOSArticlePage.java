package pages;

import elements.ArticleDetailElements;
import elements.FeedListElements;
import io.appium.java_client.AppiumDriver;
import utils.Utils;

public class iOSArticlePage extends BasePage {
    private ArticleDetailElements articleDetailElements;
    private FeedListElements feedListElements;

    public iOSArticlePage(AppiumDriver driver) {
        super(driver);
        feedListElements = new FeedListElements(driver);
        articleDetailElements = new ArticleDetailElements(driver);
    }


    public void S243_C20438_ART_001_VerifyArticleDisplay() {
        //Step: Open the Philly.com App
        lauchApp();
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);
        Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN,feedListElements.feedItemLayout);
        String title = feedListElements.getFeedItemTitle();
        feedListElements.feedItemClick();

        //feedListElements.feedItemTopStoryClick();
        if (Utils.isAndroidPlatform()){
            articleDetailElements.assertTitleResult(title, articleDetailElements.getTitleArticleDetail());
        }else{
            articleDetailElements.assertTitleResult(title, "Article " + articleDetailElements.getTitleArticleDetail());
        }
    }
}

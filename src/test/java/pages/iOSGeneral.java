package pages;

import elements.*;
import io.appium.java_client.AppiumDriver;
import utils.Constants;
import utils.Utils;

public class iOSGeneral extends BasePage {
    private FeedListElements feedListElements;
    private ArticleDetailElements articleDetailElements;

    public iOSGeneral(AppiumDriver driver) {
        super(driver);
        feedListElements = new FeedListElements(driver);
        articleDetailElements = new ArticleDetailElements(driver);
    }

    public void S239_C20265_GN_ART_001_VerifyAppWorksFineWhenClickingOnArticle() {
        lauchApp();
        Utils.sleep(Constants.SHORTTIME);
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);

        Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN,feedListElements.feedItemLayout);
        openArticle();
        articleDetailElements.back();

        openArticle();
        articleDetailElements.back();

        openArticle();
        articleDetailElements.back();
    }

    private void openArticle() {
        String title = feedListElements.getFeedItemTopStoryTitle();
        feedListElements.feedItemTopStoryClick();

        if (Utils.isAndroidPlatform()){
            articleDetailElements.assertTitleResult(title, articleDetailElements.getTitleArticleDetail());
        }else{
            articleDetailElements.assertTitleResult(title, "Article " + articleDetailElements.getTitleArticleDetail());
        }
    }

}

package pages;

import elements.ArticleDetailElements;
import elements.CommonElements;
import elements.FeedListElements;
import io.appium.java_client.AppiumDriver;
import utils.Constants;
import utils.Utils;

public class HomeTab extends BasePage {
    private FeedListElements feedListElements;
    private ArticleDetailElements articleDetailElements;
    private CommonElements commonElements;

    public HomeTab(AppiumDriver driver) {
        super(driver);
        feedListElements = new FeedListElements(driver);
        articleDetailElements = new ArticleDetailElements(driver);
        commonElements = new CommonElements(driver);
    }

    public void HT_TC_001_VerifyTopCaroulselArticle() {
        lauchApp();

        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);
        String title = feedListElements.getFeedItemTopStoryTitle();
        feedListElements.feedItemTopStoryLayout.click();
        if (Utils.isAndroidPlatform()){
            articleDetailElements.assertTitleResult(title, articleDetailElements.getTitleArticleDetail());
        }else{
            articleDetailElements.assertTitleResult(title, "Article " + articleDetailElements.getTitleArticleDetail());
        }
    }

    public void HT_HF_001_VerifyHomeFeedArticleClick() {
        lauchApp();

        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);

        Utils.scrollScreen(appiumDriver, Utils.DIRECTION.DOWN);

        String title = feedListElements.getFeedItemTitle();

//        Utils.scrollToElement(appiumDriver, Utils.DIRECTION.UP, feedListElements.feedItemTitle);
//        feedListElements.feedItemClick();
        feedListElements.feedItemTitle.click();

        waitForVisibilityOf(articleDetailElements.articleDetailTitle);
        if (Utils.isAndroidPlatform()){
            articleDetailElements.assertTitleResult(title, articleDetailElements.getTitleArticleDetail());
        }else{
            articleDetailElements.assertTitleResult(title, "Article " + articleDetailElements.getTitleArticleDetail());
        }
    }

    public void TestCaseNo8() {
        lauchApp();

        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);

        Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN, feedListElements.btnShareOnFeedArticle);
        String title = feedListElements.getFeedItemTitle();
        feedListElements.buttonShareClick();

        commonElements.selectGmail(appiumDriver,Constants.GOOGLEACCOUNT_USERNAME,Constants.GOOGLEACCOUNT_PASSWORD);
        feedListElements.assetResult(title, feedListElements.getShareGmailTitle());
    }

}

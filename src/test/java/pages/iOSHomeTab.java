package pages;

import elements.ArticleDetailElements;
import elements.CommonElements;
import elements.FeedListElements;
import io.appium.java_client.AppiumDriver;
import utils.Utils;

public class iOSHomeTab extends BasePage {
    private FeedListElements feedListElements;
    private ArticleDetailElements articleDetailElements;
    private CommonElements commonElements;

    public iOSHomeTab(AppiumDriver driver) {
        super(driver);
        feedListElements = new FeedListElements(driver);
        articleDetailElements = new ArticleDetailElements(driver);
        commonElements = new CommonElements(driver);
    }

    public void S240_C20266_HT_TC_001_VerifyTopCarouselArticle() {
        lauchApp();

        //Step: Turn off notification alert
        if(Utils.checkElementExist(commonElements.notificationAlert)){
            commonElements.turnOffNotification.click();
        }

        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);
        String title = feedListElements.getFeedItemTopStoryTitle();
        feedListElements.feedItemTopStoryLayout.click();
        if (Utils.isAndroidPlatform()){
            articleDetailElements.assertTitleResult(title, articleDetailElements.getTitleArticleDetail());
        }else{
            articleDetailElements.assertTitleResult(title, "Article " + articleDetailElements.getTitleArticleDetail());
        }
    }

    public void S240_C20267_HT_HF_001_VerifyHomeFeedArticleClick() {
        lauchApp();
        //Step: Turn off notification alert
        if(Utils.checkElementExist(commonElements.notificationAlert)){
            commonElements.turnOffNotification.click();
        }

        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);

        Utils.scrollScreen(appiumDriver, Utils.DIRECTION.DOWN);

        String title = feedListElements.getFeedItemTitle();

//        Utils.scrollToElement(appiumDriver, Utils.DIRECTION.UP, feedListElements.feedItemTitle);
//        feedListElements.feedItemClick();
        feedListElements.feedItemTitle.click();
        Utils.sleep(5000);
        articleDetailElements = new ArticleDetailElements(appiumDriver);

        waitForVisibilityOf(articleDetailElements.articledetailHeadline);
        if (Utils.isAndroidPlatform()){
            articleDetailElements.assertTitleResult(title, articleDetailElements.getTitleArticleDetail());
        }else{
            articleDetailElements.assertTitleResult(title, "Article " + articleDetailElements.articledetailHeadline.getText());
        }
    }
}

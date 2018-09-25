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

    public void TestCaseNo2() {
        lauchApp();

        String title = feedListElements.getFeedItemTopStoryTitle();
        feedListElements.feedItemTopStoryClick();
        articleDetailElements.assertTitleResult(title, articleDetailElements.getTitleArticleDetail());

        closeApp();
    }

    public void TestCaseNo6() {
        lauchApp();

        String title = feedListElements.getFeedItemTitle();
        feedListElements.feedItemClick();
        articleDetailElements.assertTitleResult(title, articleDetailElements.getTitleArticleDetail());

        closeApp();
    }


    public void TestCaseNo8() {
        lauchApp();

        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);

        if (Utils.isAndroidPlatform()) {
            Utils.scrollByTouchAction(appiumDriver);
        } else {
            Utils.iOSScrollToElement(appiumDriver, feedListElements.btnBookmark, Constants.LABLE.IOS_BOOKMARK_LB);
        }

        String title = feedListElements.getFeedItemTitle();
        feedListElements.buttonShareClick();

        if (Utils.isAndroidPlatform()) {
            if(commonElements.gmailShareBox.isDisplayed()==false){
                Utils.scrollHorizontal(appiumDriver);
            }
            commonElements.gmailShareBoxClick();
            feedListElements.assetResult(title, feedListElements.getShareGmailTitle());
        } else {
            printLog("Need to implement for iOS");
        }

        closeApp();
    }

}

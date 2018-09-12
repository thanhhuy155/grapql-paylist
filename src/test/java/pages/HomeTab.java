package pages;

import elements.ArticleDetailElements;
import elements.FeedListElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.testng.Assert;
import utils.Constants;
import utils.Utils;

public class HomeTab extends BasePage {
    private FeedListElements feedListElements;
    private ArticleDetailElements articleDetailElements;

    public HomeTab(AppiumDriver driver) {
        super(driver);
        feedListElements = new FeedListElements(driver);
        articleDetailElements = new ArticleDetailElements(driver);
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
            Utils.androidScroll(appiumDriver);
        } else {
            Utils.iOSScrollToElement(appiumDriver, feedListElements.btnBookmark, Constants.LABLE.IOS_BOOKMARK_LB);
        }

        String title = feedListElements.getFeedItemTitle();
        feedListElements.buttonShareClick();

        if (Utils.isAndroidPlatform()) {
            feedListElements.gmailShareBoxClick();
            feedListElements.assetResult(title, feedListElements.getShareGmailTitle());
        } else {
            printLog("Need to implement for iOS");
        }

        closeApp();
    }

}

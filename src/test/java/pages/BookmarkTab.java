package pages;


import elements.*;
import io.appium.java_client.AppiumDriver;
import utils.Constants;
import utils.Utils;

public class BookmarkTab extends BasePage{
    private BookMarkElements bookMarkElements;
    private ArticleDetailElements articleDetailElements;
    private CommonElements commonElements;
    private FeedListElements feedListElements;

    public BookmarkTab(AppiumDriver driver) {
        super(driver);
        bookMarkElements = new BookMarkElements(driver);
        articleDetailElements = new ArticleDetailElements(driver);
        commonElements = new CommonElements(driver);
        feedListElements = new FeedListElements(driver);
    }

    public void TestCaseNo2() {
        lauchApp();

        //Step: Scroll to article
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);
        if (Utils.isAndroidPlatform()) {
            Utils.scrollByTouchAction(appiumDriver);

        } else {
            Utils.iOSScrollToElement(appiumDriver, feedListElements.btnBookmark, Constants.LABLE.IOS_BOOKMARK_LB);
        }

        //Step: Bookmark article
        waitForVisibilityOf(commonElements.btnBookmark);
        commonElements.buttonBookmarkClick();

        //Step: Go to Bookmark tab
        commonElements.bookMarkTabClick();

        //Step: Click and Get bookmarked article
        String title= bookMarkElements.clickAndGetArticleTitle();

        //Step: Check respective article is opened
        articleDetailElements.assertTitleResult(title, articleDetailElements.getTitleArticleDetail());

        resetApp();
    }

    public void TestCaseNo3() {
        lauchApp();

        //Step: Go to Bookmark tab
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);
        commonElements.bookMarkTabClick();

        lockDevice();
        unLockDevice();

        resetApp();
    }

    public void TestCaseNo11() {
        lauchApp();

        //Step: Go to Bookmark tab
        commonElements.bookMarkTabClick();

        //Step: Click Edit button
        bookMarkElements.actionEditClick();

        //Step: Click Back button
        bookMarkElements.back();

        resetApp();
    }

    public void TestCaseNo14() {
        lauchApp();

        //Step: Scroll to article
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);
        if (Utils.isAndroidPlatform()) {
            Utils.scrollByTouchAction(appiumDriver);

        } else {
            Utils.iOSScrollToElement(appiumDriver, feedListElements.btnBookmark, Constants.LABLE.IOS_BOOKMARK_LB);
        }

        //Step: Get article title and Bookmark
        String title = feedListElements.getFeedItemTitle();
        commonElements.buttonBookmarkClick();

        //Step: Go to Bookmark tab
        commonElements.bookMarkTabClick();

        //Step: Check bookmarked article display on Bookmark tab
        bookMarkElements.assertTitleResult(title, bookMarkElements.getBookMarkTitle());

        resetApp();
    }
}
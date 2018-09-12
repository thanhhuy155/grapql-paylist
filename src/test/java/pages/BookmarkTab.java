package pages;

import elements.ArticleDetailElements;
import elements.BookMarkElements;
import elements.BottomBarElements;
import elements.FeedListElements;
import io.appium.java_client.AppiumDriver;
import utils.Constants;
import utils.Utils;

public class BookmarkTab extends BasePage {
    private BookMarkElements bookMarkElements;
    private BottomBarElements bottomBarElements;
    private ArticleDetailElements articleDetailElements;
    private FeedListElements feedListElements;

    public BookmarkTab(AppiumDriver driver) {
        super(driver);
        bookMarkElements = new BookMarkElements(driver);
        bottomBarElements = new BottomBarElements(driver);
        articleDetailElements = new ArticleDetailElements(driver);
        feedListElements = new FeedListElements(driver);
    }

    public void TestCaseNo2() {
        lauchApp();

        bottomBarElements.bookMarkTabClick();
        String title = bookMarkElements.getBookMarkTitle();
        bookMarkElements.bookMarkItemClick();

        articleDetailElements.assertTitleResult(title, articleDetailElements.getTitleArticleDetail());

        closeApp();
    }

    public void TestCaseNo3() {
        lauchApp();

        bottomBarElements.bookMarkTabClick();
        lockDevice();
        unLockDevice();

        closeApp();
    }

    public void TestCaseNo11() {
        lauchApp();

        bottomBarElements.bookMarkTabClick();
        bookMarkElements.actionEditClick();
        bookMarkElements.back();

        closeApp();
    }

    public void TestCaseNo14() {
        lauchApp();

        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);

        if (Utils.isAndroidPlatform()) {
            Utils.androidScroll(appiumDriver);
        } else {
            Utils.iOSScrollToElement(appiumDriver, feedListElements.btnBookmark, Constants.LABLE.IOS_BOOKMARK_LB);
        }

        String title = feedListElements.getFeedItemTitle();
        feedListElements.buttonBookmarkClick();
        bottomBarElements.bookMarkTabClick();
        bookMarkElements.assertTitleResult(title, bookMarkElements.getBookMarkTitle());

        closeApp();
    }
}
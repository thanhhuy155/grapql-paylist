package pages;


import elements.*;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
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
            Utils.scrollScreen(appiumDriver, Utils.DIRECTION.UP);

        } else {
            Utils.iOSScrollToElement(appiumDriver, feedListElements.btnBookmark, Constants.LABLE.IOS_BOOKMARK_LB);
        }

        //Step: Bookmark article
        waitForVisibilityOf(commonElements.btnBookmark);
        commonElements.buttonBookmarkClick();

        //Step: Go to Bookmark tab
        commonElements.bookMarkTab.click();

        //Step: Click and Get bookmarked article
        String title= bookMarkElements.clickAndGetArticleTitle();

        //Step: Check respective article is opened
        articleDetailElements.assertTitleResult(title, articleDetailElements.getTitleArticleDetail());
    }

    public void TestCaseNo3() {
        lauchApp();

        //Step: Go to Bookmark tab
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);
        commonElements.bookMarkTabClick();

        lockDevice();
        unLockDevice();
    }

    public void TestCaseNo11() {
        lauchApp();

        //Step: Go to Bookmark tab
        commonElements.bookMarkTabClick();

        //Step: Click Edit button
        //waitForVisibilityOf(bookMarkElements.bookmarkTitle);
        bookMarkElements.actionEditClick();

        //Step: Click Back button
        bookMarkElements.back();
    }

    public void TestCaseNo14() {
        lauchApp();

        //Step: Scroll to article
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);
        if (Utils.isAndroidPlatform()) {
            Utils.scrollScreen(appiumDriver, Utils.DIRECTION.UP);

        } else {
            Utils.iOSScrollToElement(appiumDriver, feedListElements.btnBookmark, Constants.LABLE.IOS_BOOKMARK_LB);
        }

        //Step: Get article title and Bookmark
        String title = feedListElements.getFeedItemTitle();
        commonElements.buttonBookmarkClick();

        //Step: Go to Bookmark tab
        commonElements.bookMarkTab.click();

        //Step: Check bookmarked article display on Bookmark tab
        Assert.assertTrue(bookMarkElements.getBookmarkedTitles().contains(title));
    }

//    public void Draft(){
//        lauchApp();
//
//        //Step: Go to Bookmark tab
//        commonElements.bookMarkTabClick();
//
//        //Step: Click Edit button
//        waitForVisibilityOf(bookMarkElements.bookmarkTitle);
//
//        bookMarkElements.getBookmarkedTitles();
//    }
}
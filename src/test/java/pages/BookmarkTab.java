package pages;

import elements.*;
import io.appium.java_client.AppiumDriver;
import utils.Constants;
import utils.Utils;

public class BookmarkTab extends BasePage {
    private BookMarkElements bookMarkElements;
    private BottomBarElements bottomBarElements;
    private ArticleDetailElements articleDetailElements;
    private CommonElements commonElements;
    private FeedListElements feedListElements;

    public BookmarkTab(AppiumDriver driver) {
        super(driver);
        bookMarkElements = new BookMarkElements(driver);
        bottomBarElements = new BottomBarElements(driver);
        articleDetailElements = new ArticleDetailElements(driver);
        commonElements = new CommonElements(driver);
        feedListElements = new FeedListElements(driver);
    }

    public void TestCaseNo2() {
        lauchApp();

        bottomBarElements.bookMarkTabClick();
        String title;
        if(commonElements.googleClientLogin.isDisplayed()==true){
            commonElements.clickLogin();
            if (bookMarkElements.bookmarkTitle.isDisplayed()==true){
                title = bookMarkElements.getBookMarkTitle();
                bookMarkElements.bookMarkItemClick();
                articleDetailElements.assertTitleResult(title, articleDetailElements.getTitleArticleDetail());
            }
            else {
                bottomBarElements.homeTabClick();
                waitForVisibilityOf(feedListElements.feedItemTitleTopStory);
                if (Utils.isAndroidPlatform()) {
                    Utils.scrollByTouchAction(appiumDriver);
                }
                commonElements.buttonBookmarkClick();
                if (bottomBarElements.bookMarkTab.isDisplayed()==false){
                    commonElements.buttonBookmarkClick();
                }
                bottomBarElements.bookMarkTabClick();
                title = bookMarkElements.getBookMarkTitle();
                bookMarkElements.bookMarkItemClick();
                articleDetailElements.assertTitleResult(title, articleDetailElements.getTitleArticleDetail());
            }

        }

        resetApp();
    }

    public void TestCaseNo3() {
        lauchApp();

        bottomBarElements.bookMarkTabClick();
        lockDevice();
        unLockDevice();

        resetApp();
    }

    public void TestCaseNo11() {
        lauchApp();

        bottomBarElements.bookMarkTabClick();
        if(commonElements.googleClientLogin.isDisplayed()==true) {
            commonElements.clickLogin();
            bookMarkElements.actionEditClick();
            bookMarkElements.back();
        }
        else {
            bookMarkElements.actionEditClick();
            bookMarkElements.back();
        }
        resetApp();
    }

    public void TestCaseNo14() {
        lauchApp();

        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);
        String title = feedListElements.getFeedItemTitle();
        if (Utils.isAndroidPlatform()) {
            Utils.scrollByTouchAction(appiumDriver);
            //Utils.exampleScroll(appiumDriver);
            //Utils.scrollToElement(feedListElements.feedList,feedListElements.getArticleAuthorOnFeedList());
            //Utils.scrollBySwipe(appiumDriver);
        } else {
            Utils.iOSScrollToElement(appiumDriver, feedListElements.btnBookmark, Constants.LABLE.IOS_BOOKMARK_LB);
        }

        waitForVisibilityOf(commonElements.btnBookmark);
        commonElements.buttonBookmarkClick();
        if(commonElements.googleClientLogin.isDisplayed()==true){
            commonElements.clickLogin();
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                System.out.println("got interrupted!");
            }

            bottomBarElements.bookMarkTabClick();
            bookMarkElements.assertTitleResult(title, bookMarkElements.getBookMarkTitle());
        }
        else {
            bottomBarElements.bookMarkTabClick();
            bookMarkElements.assertTitleResult(title, bookMarkElements.getBookMarkTitle());
        }
        resetApp();
    }
}
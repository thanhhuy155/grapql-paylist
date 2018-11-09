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
        Utils.scrollScreen(appiumDriver, Utils.DIRECTION.DOWN);

        //Step: Bookmark article
        waitForVisibilityOf(feedListElements.btnBookmarkOnFeedArticle);
        feedListElements.buttonBookmarkClick();

        //Step: Go to Bookmark tab
        if(!Utils.isAndroidPlatform()){
            Utils.scrollScreen(appiumDriver, Utils.DIRECTION.UP);
        }
        commonElements.bookMarkTabClick();

        //Step: Click and Get bookmarked article
        String title= bookMarkElements.clickAndGetArticleTitle();

        //Verify point: Check respective article is opened
        articleDetailElements.assertTitleResult(title, articleDetailElements.getTitleArticleDetail());

        //Post-condition: Delete added bookmark
        articleDetailElements.back();
        bookMarkElements.deleteBookmark(1);
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
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);
        commonElements.bookMarkTabClick();

        //Step: Click Edit button
        //waitForVisibilityOf(bookMarkElements.bookmarkTitle);
        bookMarkElements.actionEditClick();

        //Step: Click Back button
        bookMarkElements.back();
    }

    public void TestCaseNo12(){
        lauchApp();

        //Pre-condition: Add article to Bookmark tab
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);
        Utils.scrollScreen(appiumDriver, Utils.DIRECTION.DOWN);

        feedListElements.buttonBookmarkClick();

        //Step: Go to Bookmark tab
        if(!Utils.isAndroidPlatform()){
            Utils.scrollScreen(appiumDriver, Utils.DIRECTION.UP);
        }
        commonElements.bookMarkTabClick();

        //Step: Click on Edit button at the top right of the screen
        waitForVisibilityOf(bookMarkElements.bookmarkTitle);
        bookMarkElements.actionEditClick();

        //Step: Click on any checkbox
        bookMarkElements.selectBookmarkedArticle(1);

        //Step: Click on Delete icon
        bookMarkElements.deleteButton.click();

        //Verify point: Bookmark should be deleted
        Assert.assertFalse(bookMarkElements.getBookmarkedTitles().containsAll(Constants.selectedArticleTitleOnBookmark));

    }

    public void TestCaseNo14() {
        lauchApp();

        //Step: Scroll to article
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);
        Utils.scrollScreen(appiumDriver, Utils.DIRECTION.DOWN);


        //Step: Get article title and Bookmark
        String title = feedListElements.getFeedItemTitle();
        feedListElements.buttonBookmarkClick();

        //Step: Go to Bookmark tab
        if(!Utils.isAndroidPlatform()){
            Utils.scrollScreen(appiumDriver, Utils.DIRECTION.UP);
        }
        commonElements.bookMarkTabClick();

        //Verify point: Check bookmarked article display on Bookmark tab
        waitForVisibilityOf(bookMarkElements.bookmarkTitle);
        Assert.assertTrue(bookMarkElements.getBookmarkedTitles().contains(title));

        //Post-condition: Delete added bookmark
        bookMarkElements.deleteBookmark(1);
    }

    public void TestCaseNo16(){
        lauchApp();

        //Pre-condition: Add article to Bookmark tab
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);
        Utils.scrollScreen(appiumDriver, Utils.DIRECTION.DOWN);
        feedListElements.buttonBookmarkClick();

        //Step: Go to Bookmark tab
        commonElements.bookMarkTabClick();

        //Step: Click on article
        waitForVisibilityOf(bookMarkElements.bookmarkTitle);
        bookMarkElements.bookmarkTitle.click();

        //Step: Click on Share button
        articleDetailElements.shareArticleButton.click();

        //Verify point: Share dialog should open
        Assert.assertTrue(Utils.checkElementExist(commonElements.shareDialog));

        //Step: Click a share option
        commonElements.shareArticleOn(appiumDriver, CommonElements.ShareOptions.SKYPE);

        //Verify point: Sharing should accurately appear and fill in respective information (ex: article title)
        waitForVisibilityOf(commonElements.skypeShareScreen);
        Assert.assertTrue(Utils.checkElementExist(commonElements.phillyLinkOnSkype));

    }
}
package pages;


import elements.ArticleDetailElements;
import elements.BookMarkElements;
import elements.CommonElements;
import elements.FeedListElements;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import utils.Constants;
import utils.Utils;

public class iOSBookmarkTab extends BasePage{
    public BookMarkElements bookMarkElements;
    private ArticleDetailElements articleDetailElements;
    private CommonElements commonElements;
    private FeedListElements feedListElements;

    public iOSBookmarkTab(AppiumDriver driver) {
        super(driver);
        bookMarkElements = new BookMarkElements(driver);
        articleDetailElements = new ArticleDetailElements(driver);
        commonElements = new CommonElements(driver);
        feedListElements = new FeedListElements(driver);
    }

    public void S231_C20441_BT_001_VerifyBookMarkTabArticle() {
        lauchApp();

        //Step: Scroll to article
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);
        Utils.scrollScreen(appiumDriver, Utils.DIRECTION.DOWN);

        //Step: Bookmark article
        waitForVisibilityOf(feedListElements.btnBookmarkOnFeedArticle);
        feedListElements.buttonBookmarkClick(appiumDriver);

        //Step: Go to Bookmark tab
        if(!Utils.isAndroidPlatform()){
            Utils.scrollScreen(appiumDriver, Utils.DIRECTION.UP);
            Utils.scrollScreen(appiumDriver, Utils.DIRECTION.DOWN);
            Utils.scrollScreen(appiumDriver, Utils.DIRECTION.UP);
        }
        commonElements.bookMarkTab.click();

        //Step: Click and Get bookmarked article
        waitForVisibilityOf(bookMarkElements.bookmarkTitle);
        String title= bookMarkElements.clickAndGetArticleTitle();

        //Verify point: Check respective article is opened
        articleDetailElements.assertTitleResult(title, articleDetailElements.getTitleArticleDetail());

        //Post-condition: Delete added bookmark
        waitForVisibilityOf(articleDetailElements.backBtn);
        articleDetailElements.back();
        bookMarkElements.deleteBookmark(1);
    }

    public void S231_C20442_BT_002_VerifyBookMarkCancel() {
        lauchApp();

        //Step: Go to Bookmark tab
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);
        commonElements.bookMarkTabClick(appiumDriver);

        //Step: Click Edit button
        waitForVisibilityOf(bookMarkElements.actionEdit);
        bookMarkElements.actionEditClick();

        //Step: Click Back button
        bookMarkElements.back();
    }

    public void S231_C20443_BT_003_VerifyEditAndDeleteBookMark(){
        lauchApp();

        //Pre-condition: Add article to Bookmark tab
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);
        Utils.scrollScreen(appiumDriver, Utils.DIRECTION.DOWN);

        waitForVisibilityOf(feedListElements.btnBookmarkOnFeedArticle);
        feedListElements.buttonBookmarkClick(appiumDriver);

        //Step: Go to Bookmark tab
        if(!Utils.isAndroidPlatform()){
            Utils.scrollScreen(appiumDriver, Utils.DIRECTION.UP);
            Utils.scrollScreen(appiumDriver, Utils.DIRECTION.DOWN);
            Utils.scrollScreen(appiumDriver, Utils.DIRECTION.UP);
        }
        commonElements.bookMarkTab.click();

        //Step: Click on Edit button at the top right of the screen
        Utils.sleep((Constants.SHORTTIME)*5);
        waitForVisibilityOf(bookMarkElements.bookmarkTitle);
        bookMarkElements.actionEditClick();

        //Step: Click on any checkbox
        bookMarkElements.selectBookmarkedArticle(1);

        //Step: Click on Delete icon
        bookMarkElements.deleteButton.click();

        //Verify point: Bookmark should be deleted
        Assert.assertFalse(bookMarkElements.getBookmarkedTitles().containsAll(Constants.selectedArticleTitleOnBookmark));

    }

    public void S231_C20444_BT_004_VerifyBookMarkArticleFeed() {
        lauchApp();

        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);

        //Step: Get article title and Bookmark
        Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN,feedListElements.feedItemLayout);
        String title = feedListElements.getFeedItemTitle();

        Utils.scrollScreen(appiumDriver, Utils.DIRECTION.DOWN);
        feedListElements.buttonBookmarkClick(appiumDriver);

        //Step: Go to Bookmark tab
        if(!Utils.isAndroidPlatform()){
            Utils.scrollScreen(appiumDriver, Utils.DIRECTION.UP);
            Utils.scrollScreen(appiumDriver, Utils.DIRECTION.DOWN);
            Utils.scrollScreen(appiumDriver, Utils.DIRECTION.UP);
        }
        commonElements.bookMarkTab.click();

        //Verify point: Check bookmarked article display on Bookmark tab
        Utils.sleep((Constants.SHORTTIME)*5);
        waitForVisibilityOf(bookMarkElements.bookmarkTitle);

        if (Utils.isAndroidPlatform()){
            Assert.assertTrue(bookMarkElements.getBookmarkedTitles().contains(title));
        }else{
            Assert.assertEquals("Article "+ bookMarkElements.getBookmarkedTitles().get(0), title);
        }

        //Post-condition: Delete added bookmark
        bookMarkElements.deleteBookmark(1);
    }
}
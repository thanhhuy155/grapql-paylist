package pages;

import elements.ArticleDetailElements;
import elements.CommonElements;
import elements.FeedListElements;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import utils.Utils;

public class ArticlePage extends BasePage {
    private ArticleDetailElements articleDetailElements;
    private FeedListElements feedListElements;
    private CommonElements commonElements;

    public ArticlePage(AppiumDriver driver) {
        super(driver);
        feedListElements = new FeedListElements(driver);
        articleDetailElements = new ArticleDetailElements(driver);
        commonElements = new CommonElements(driver);
    }


    public void TestCaseNo1() {
        //Step: Open the Philly.com App
        lauchApp();
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);

        String title = feedListElements.getFeedItemTitle();
        feedListElements.feedItemClick();

        //feedListElements.feedItemTopStoryClick();
        articleDetailElements.assertTitleResult(title, articleDetailElements.getTitleArticleDetail());
    }

    public void TestCaseNo4(){
        //Step: Open the Philly.com App
        lauchApp();
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);

        //Step: Click one feed as a sample test
        feedListElements.feedItemClick();
        String title = articleDetailElements.getTitleArticleDetail();

        //Step: Click share button on any article feed card
        articleDetailElements.shareArticleButton.click();

        //Verify point: Share dialog should open
        Assert.assertTrue(Utils.checkElementExist(commonElements.shareDialog));

        //Step: Click a share option
        commonElements.shareArticleOn(appiumDriver, CommonElements.ShareOptions.GMAIL);

        //Verify point: Sharing should accurately appear and fill in respective information (ex: article title)
        waitForVisibilityOf(commonElements.gmailSubject);
        Assert.assertTrue(commonElements.gmailSubject.getText().contains(title));
    }

    public void TestCaseNo5() {
        lauchApp();

        feedListElements.feedItemTopStoryClick();

        lockDevice();
        unLockDevice();
        activateApp();
        articleDetailElements.back();

        commonElements.settingTabClick();
        commonElements.sectionTabClick();
        commonElements.homeTabClick();
        commonElements.bookMarkTabClick();
    }

    public void TestCaseNo30(){
        lauchApp();
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);

        //Step: Click one feed as a sample test
        feedListElements.feedItemClick();
        String title1 = articleDetailElements.articleDetailTitle.getText();
        Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN,articleDetailElements.readNextLink);

        articleDetailElements.readNextLink.click();
        String title2 = articleDetailElements.articleDetailTitle.getText();

        Assert.assertNotEquals(title1,title2);
    }

}

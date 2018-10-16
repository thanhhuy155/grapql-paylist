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
        lauchApp();
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);

        String title = feedListElements.getFeedItemTitle();
        feedListElements.feedItemClick();

        //feedListElements.feedItemTopStoryClick();
        articleDetailElements.assertTitleResult(title, articleDetailElements.getTitleArticleDetail());
    }

    public void TestCaseNo4(){
        lauchApp();
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);

        feedListElements.feedItemClick();
        String title1 = articleDetailElements.articleDetailTitle.getText();
        Utils.scrollToElement(appiumDriver,articleDetailElements.readNextLink);

        articleDetailElements.readNextLink.click();
        String title2 = articleDetailElements.articleDetailTitle.getText();

        Assert.assertNotEquals(title1,title2);
    }

    public void TestCaseNo5() {
        lauchApp();

        feedListElements.feedItemTopStoryClick();

        lockDevice();
        unLockDevice();
        articleDetailElements.back();

        commonElements.settingTabClick();
        commonElements.sectionTabClick();
        commonElements.homeTabClick();
        commonElements.bookMarkTabClick();
    }

}
